package com.ats.webapi.repository.reportv2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.reportv2.FranchiseSalesReport;

public interface FranchiseSalesReportRepo extends JpaRepository<FranchiseSalesReport, Integer> {

	@Query(value="SELECT t1.*, COALESCE(t2.grn_value,0) as grn_value, COALESCE(t2.grn_total_tax,0) as grn_total_tax, COALESCE(t2.grn_taxable_amt,0) as grn_taxable_amt,\n" + 
			"	COALESCE(t3.gvn_value,0) as gvn_value, COALESCE(t3.gvn_total_tax,0) as gvn_total_tax, COALESCE(t3.gvn_taxable_amt,0) as gvn_taxable_amt,\n" + 
			"	COALESCE(t4.sale_value,0) as sale_value, COALESCE(t4.taxable_amt,0) as taxable_amt, COALESCE(t4.total_tax,0) as total_tax\n" + 
			"FROM\n" + 
			"(SELECT\n" + 
			"    \n" + 
			"        m_franchisee.fr_id,\n" + 
			"        m_franchisee.fr_code,\n" + 
			"        m_franchisee.fr_name,\n" + 
			"        m_franchisee.fr_city\n" + 
			"FROM\n" + 
			"    m_franchisee\n" + 
			"    WHERE\n" + 
			"        m_franchisee.fr_id IN (:frIdList)\n" + 
			"   )t1\n" + 
			"LEFT JOIN(\n" + 
			"    SELECT \n" + 
			"    t_credit_note_header.fr_id,\n" + 
			"   \n" + 
			"            SUM(\n" + 
			"                t_credit_note_header.crn_taxable_amt\n" + 
			"           \n" + 
			"        ) AS grn_taxable_amt,\n" + 
			"        \n" + 
			"            SUM(\n" + 
			"                t_credit_note_header.crn_total_tax\n" + 
			"           \n" + 
			"        ) AS grn_total_tax,\n" + 
			"        \n" + 
			"            SUM(\n" + 
			"                t_credit_note_header.crn_grand_total\n" + 
			"            \n" + 
			"        ) AS grn_value\n" + 
			"    FROM\n" + 
			"        t_credit_note_header\n" + 
			"    WHERE\n" + 
			"        t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate AND t_credit_note_header.is_grn = 1 GROUP BY t_credit_note_header.fr_id\n" + 
			") t2\n" + 
			"ON\n" + 
			"    t1.fr_id = t2.fr_id\n" + 
			"    \n" + 
			"    LEFT JOIN(\n" + 
			"    SELECT \n" + 
			"    t_credit_note_header.fr_id,\n" + 
			"   \n" + 
			"            SUM(\n" + 
			"                t_credit_note_header.crn_taxable_amt\n" + 
			"           \n" + 
			"        ) AS gvn_taxable_amt,\n" + 
			"        \n" + 
			"            SUM(\n" + 
			"                t_credit_note_header.crn_total_tax\n" + 
			"           \n" + 
			"        ) AS gvn_total_tax,\n" + 
			"        \n" + 
			"            SUM(\n" + 
			"                t_credit_note_header.crn_grand_total\n" + 
			"            \n" + 
			"        ) AS gvn_value\n" + 
			"    FROM\n" + 
			"        t_credit_note_header\n" + 
			"    WHERE\n" + 
			"        t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate AND t_credit_note_header.is_grn = 0 GROUP BY t_credit_note_header.fr_id\n" + 
			") t3\n" + 
			"ON\n" + 
			"    t1.fr_id = t3.fr_id\n" + 
			"    \n" + 
			"     LEFT JOIN(\n" + 
			"    SELECT \n" + 
			"    t_bill_header.fr_id,\n" + 
			"   \n" + 
			"            SUM(\n" + 
			"                t_bill_header.taxable_amt\n" + 
			"           \n" + 
			"        ) AS taxable_amt,\n" + 
			"        \n" + 
			"            SUM(\n" + 
			"                t_bill_header.total_tax\n" + 
			"           \n" + 
			"        ) AS total_tax,\n" + 
			"        \n" + 
			"            SUM(\n" + 
			"                t_bill_header.grand_total\n" + 
			"            \n" + 
			"        ) AS sale_value\n" + 
			"    FROM\n" + 
			"        t_bill_header\n" + 
			"    WHERE\n" + 
			"        t_bill_header.bill_date BETWEEN :fromDate AND :toDate AND t_bill_header.del_status=0  GROUP BY t_bill_header.fr_id\n" + 
			") t4\n" + 
			"ON\n" + 
			"    t1.fr_id = t4.fr_id ORDER BY fr_name",nativeQuery=true)
	List<FranchiseSalesReport> getFrSalesReport(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			 @Param("frIdList") List<String> frIdList);
}
