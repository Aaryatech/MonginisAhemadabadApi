package com.ats.webapi.repository.reportv2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.reportv2.FrTcsBillReport;

public interface FrTcsBillReportRepo extends JpaRepository<FrTcsBillReport, Integer> {

	@Query(value="SELECT\n" + 
			"    t1.*,\n" + 
			"    t2.fr_name,\n" + 
			"    t2.fr_code\n" + 
			"FROM\n" + 
			"(SELECT\n" + 
			"    h.bill_no,\n" + 
			"    h.invoice_no,\n" + 
			"    h.bill_date,\n" + 
			"    h.fr_id,\n" + 
			"    h.taxable_amt,\n" + 
			"    h.total_tax,\n" + 
			"    h.grand_total,\n" + 
			"    h.sgst_sum,\n" + 
			"    h.cgst_sum,\n" + 
			"    h.igst_sum,\n" + 
			"    REPLACE(h.veh_no,'-','0') as veh_no\n" + 
			"FROM\n" + 
			"    t_bill_header h\n" + 
			"WHERE\n" + 
			"    h.bill_date BETWEEN :fromDate AND :toDate AND\n" + 
			"    h.del_status=0 AND\n" + 
			"    h.fr_id IN (:frIdList) ORDER BY bill_date  DESC)t1\n" + 
			"    LEFT JOIN\n" + 
			"    (SELECT\n" + 
			"        f.fr_id,\n" + 
			"        f.fr_name,\n" + 
			"        f.fr_code\n" + 
			"    FROM\n" + 
			"        m_franchisee f \n" + 
			"    WHERE\n" + 
			"        f.del_status=0 AND\n" + 
			"         f.fr_id IN (:frIdList))t2\n" + 
			"         ON t1.fr_id=t2.fr_id",nativeQuery=true)
	
	public List<FrTcsBillReport> getFrTcsReportByFrId(@Param("fromDate") String fromDate, 
			@Param("toDate") String toDate, @Param("frIdList") List<String> frIdList);
}
