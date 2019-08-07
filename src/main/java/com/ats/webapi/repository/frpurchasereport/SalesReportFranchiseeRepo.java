package com.ats.webapi.repository.frpurchasereport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.report.frpurchase.SalesReportFranchisee;

public interface SalesReportFranchiseeRepo extends JpaRepository<SalesReportFranchisee, Integer> {

	/*@Query(value = " SELECT\n" + 
			"         UUID() as id,\n" + 
			"        'RET' as type,\n" + 
			"        ch.crn_id as bill_no,\n" + 
			"        ch.crn_date as bill_date,\n" + 
			"        ch.crn_no as invoice_no,\n" + 
			"        ch.fr_id as fr_id,\n" + 
			"        ch.crn_taxable_amt as taxable_amt,\n" + 
			"        ch.crn_total_tax as total_tax,\n" + 
			"        ch.crn_grand_total as grand_total,\n" + 
			"        fr.fr_name as fr_name,\n" + 
			"        '--' as order_ref\n" + 
			"    FROM\n" + 
			"        m_franchisee fr,\n" + 
			"        t_credit_note_header ch\n" + 
			"    WHERE\n" + 
			"        ch.crn_date    BETWEEN :fromDate AND :toDate  and\n" + 
			"        ch.is_grn in(1)\n" + 
			"        AND fr.fr_id=ch.fr_id\n" + 
			" \n" + 
			"          UNION ALL\n" + 
			"       \n" + 
			"        SELECT\n" + 
			"         UUID() as id,\n" + 
			"        'VER' as type,\n" + 
			"        ch.crn_id as bill_no,\n" + 
			"        ch.crn_date as bill_date,\n" + 
			"        ch.crn_no as invoice_no,\n" + 
			"        ch.fr_id as fr_id,\n" + 
			"        ch.crn_taxable_amt as taxable_amt,\n" + 
			"        ch.crn_total_tax as total_tax,\n" + 
			"        ch.crn_grand_total as grand_total,\n" + 
			"        fr.fr_name as fr_name,\n" + 
			"        '--' as order_ref\n" + 
			"    FROM\n" + 
			"        m_franchisee fr,\n" + 
			"        t_credit_note_header ch\n" + 
			"    WHERE\n" + 
			"        ch.crn_date    BETWEEN :fromDate AND :toDate and\n" + 
			"        ch.is_grn in(0,2)\n" + 
			"        AND fr.fr_id=ch.fr_id\n" + 
			"UNION ALL\n" + 
			"SELECT\n" + 
			"        UUID() as id,\n" + 
			"        'INV' as type,\n" + 
			"        t_bill_header.bill_no,\n" + 
			"        t_bill_header.bill_date,\n" + 
			"        t_bill_header.invoice_no,\n" + 
			"        t_bill_header.fr_id,\n" + 
			"        sum(t_bill_detail.taxable_amt) as taxable_amt,\n" + 
			"        sum(t_bill_detail.total_tax) as total_tax,\n" + 
			"        SUM(t_bill_detail.grand_total) AS grand_total,\n" + 
			"         t_bill_header.party_name as fr_name,\n" + 
			"        '--' as order_ref\n" + 
			"    FROM\n" + 
			"        t_bill_header ,\n" + 
			"        t_bill_detail    \n" + 
			"    WHERE\n" + 
			"         t_bill_header.fr_id IN(:frIdList)  \n" + 
			"        AND t_bill_header.bill_date BETWEEN :fromDate AND :toDate     \n" + 
			"        AND t_bill_detail.bill_no=t_bill_header.bill_no                \n" + 
			"        AND t_bill_header.del_status=0\n" + 
			"        AND t_bill_detail.del_status=0    \n" + 
			"    GROUP BY\n" + 
			"        t_bill_header.bill_no", nativeQuery = true)*/

	@Query(value = "select id,type,bill_no,bill_date,invoice_no,fr_id,taxable_amt,total_tax,grand_total,fr_name,order_ref from (SELECT\n" + 
			"        UUID() as id,\n" + 
			"        'RET' as type,\n" + 
			"        ch.crn_id as bill_no,\n" + 
			"        ch.crn_date as bill_date,\n" + 
			"        ch.crn_no as invoice_no,\n" + 
			"        ch.fr_id as fr_id,\n" + 
			"        ch.crn_taxable_amt as taxable_amt,\n" + 
			"        ch.crn_total_tax as total_tax,\n" + 
			"        ch.crn_grand_total as grand_total,\n" + 
			"        fr.fr_name as fr_name,\n" + 
			"        '--' as order_ref     \n" + 
			"    FROM\n" + 
			"        m_franchisee fr,\n" + 
			"        t_credit_note_header ch     \n" + 
			"    WHERE\n" + 
			"        ch.crn_date    BETWEEN '2019-01-01' AND '2019-09-01'   \n" + 
			"        and         ch.is_grn in(\n" + 
			"            1\n" + 
			"        )         \n" + 
			"        AND fr.fr_id=ch.fr_id             \n" + 
			"    UNION  ALL \n" + 
			"    SELECT\n" + 
			"        UUID() as id,\n" + 
			"        'VER' as type,\n" + 
			"        ch.crn_id as bill_no,\n" + 
			"        ch.crn_date as bill_date,\n" + 
			"        ch.crn_no as invoice_no,\n" + 
			"        ch.fr_id as fr_id,\n" + 
			"        ch.crn_taxable_amt as taxable_amt,\n" + 
			"        ch.crn_total_tax as total_tax,\n" + 
			"        ch.crn_grand_total as grand_total,\n" + 
			"        fr.fr_name as fr_name,\n" + 
			"        '--' as order_ref     \n" + 
			"    FROM\n" + 
			"        m_franchisee fr,\n" + 
			"        t_credit_note_header ch     \n" + 
			"    WHERE\n" + 
			"        ch.crn_date    BETWEEN :fromDate AND :toDate  \n" + 
			"        and         ch.is_grn in(\n" + 
			"            0,2\n" + 
			"        )         \n" + 
			"        AND fr.fr_id=ch.fr_id \n" + 
			"    UNION ALL \n" + 
			"    SELECT\n" + 
			"        UUID() as id,\n" + 
			"        'INV' as type,\n" + 
			"        t_bill_header.bill_no,\n" + 
			"        t_bill_header.bill_date,\n" + 
			"        t_bill_header.invoice_no,\n" + 
			"        t_bill_header.fr_id,\n" + 
			"        sum(t_bill_detail.taxable_amt) as taxable_amt,\n" + 
			"        sum(t_bill_detail.total_tax) as total_tax,\n" + 
			"        SUM(t_bill_detail.grand_total) AS grand_total,\n" + 
			"        t_bill_header.party_name as fr_name,\n" + 
			"        '--' as order_ref     \n" + 
			"    FROM\n" + 
			"        t_bill_header ,\n" + 
			"        t_bill_detail         \n" + 
			"    WHERE\n" + 
			"        t_bill_header.fr_id IN(\n" + 
			"            :frIdList \n" + 
			"        )           \n" + 
			"        AND t_bill_header.bill_date BETWEEN :fromDate AND :toDate                \n" + 
			"        AND t_bill_detail.bill_no=t_bill_header.bill_no                         \n" + 
			"        AND t_bill_header.del_status=0         \n" + 
			"        AND t_bill_detail.del_status=0         \n" + 
			"    GROUP BY\n" + 
			"        t_bill_header.bill_no) a order by a.bill_date", nativeQuery = true)
	List<SalesReportFranchisee> getSaleReportBillwise(@Param("frIdList") List<String> frIdList,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
