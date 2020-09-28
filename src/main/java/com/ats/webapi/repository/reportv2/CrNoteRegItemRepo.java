package com.ats.webapi.repository.reportv2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.reportv2.CrNoteRegItem;

public interface CrNoteRegItemRepo extends JpaRepository<CrNoteRegItem, Integer> {

	@Query(value = " SELECT t_credit_note_header.crn_id,t_credit_note_header.crn_date,t_bill_header.invoice_no,"
			+ " t_credit_note_details.crnd_id ,"
			+ " t_bill_header.bill_date,m_franchisee.fr_name,t_credit_note_header.crn_no as fr_code,m_franchisee.fr_gst_no,t_credit_note_details.hsn_code,"
			+ "	SUM(t_credit_note_details.grn_gvn_qty)crn_qty,SUM(t_credit_note_details.taxable_amt)crn_taxable,"
			+ " t_credit_note_details.cgst_per,t_credit_note_details.sgst_per,t_credit_note_details.igst_per,SUM(t_credit_note_details.sgst_rs) "
			+ " AS sgst_amt ,SUM(t_credit_note_details.cgst_rs) as cgst_amt,"
			+ " SUM(t_credit_note_details.igst_rs) as igst_amt,"
			+ "	SUM(t_credit_note_details.grn_gvn_amt) as crn_amt, 0 as ttl_taxable, 0 as ttl_tax_amt, 0 as ttl_crn_amt"
			+ "	FROM t_credit_note_header,t_credit_note_details,t_bill_header,m_franchisee"
			+ "	WHERE t_credit_note_header.crn_id=t_credit_note_details.crn_id AND t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate "
			+ "	AND t_credit_note_header.fr_id=m_franchisee.fr_id "
			+ "	AND t_bill_header.bill_no=t_credit_note_header.ex_int1 and t_credit_note_details.del_status=0 and t_bill_header.del_status=0 "
			+ "	GROUP by t_credit_note_details.hsn_code,t_credit_note_details.crn_id  order by t_credit_note_header.crn_no", nativeQuery = true)

	List<CrNoteRegItem> getCrNoteRegItem(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = " SELECT t_credit_note_header.crn_id,t_credit_note_header.crn_date,t_bill_header.invoice_no,"
			+ " t_credit_note_details.crnd_id ,"
			+ " t_bill_header.bill_date,m_franchisee.fr_name,t_credit_note_header.crn_no as fr_code,m_franchisee.fr_gst_no,t_credit_note_details.hsn_code,"
			+ "	SUM(t_credit_note_details.grn_gvn_qty)crn_qty,SUM(t_credit_note_details.taxable_amt)crn_taxable,"
			+ " t_credit_note_details.cgst_per,t_credit_note_details.sgst_per,t_credit_note_details.igst_per,SUM(t_credit_note_details.sgst_rs) "
			+ " AS sgst_amt ,SUM(t_credit_note_details.cgst_rs) as cgst_amt,"
			+ " SUM(t_credit_note_details.igst_rs) as igst_amt,"
			+ "	SUM(t_credit_note_details.grn_gvn_amt) as crn_amt, 0 as ttl_taxable, 0 as ttl_tax_amt, 0 as ttl_crn_amt"
			+ "	FROM t_credit_note_header,t_credit_note_details,t_bill_header,m_franchisee"
			+ "	WHERE t_credit_note_header.crn_id=t_credit_note_details.crn_id AND t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate "
			+ "	AND t_credit_note_header.fr_id=m_franchisee.fr_id "
			+ "	AND t_bill_header.bill_no=t_credit_note_header.ex_int1 AND m_franchisee.fr_id=:frId "
			+ "	GROUP by t_credit_note_details.hsn_code,t_credit_note_details.crn_id  order by t_credit_note_header.crn_no", nativeQuery = true)

	List<CrNoteRegItem> getCrNoteRegItemByFrId(@Param("frId") int frId, @Param("fromDate") String fromDate,
			@Param("toDate") String toDate);
/*---------------------------------------------------------------------------------------------------------------*/
	@Query(value = "SELECT t1.*, COALESCE(t2.crn_taxable, 0) as ttl_taxable, COALESCE((t2.sgst_amt+t2.cgst_amt), 0) as ttl_tax_amt, COALESCE(t2.crn_amt, 0) as ttl_crn_amt\n" + 
			"FROM(\n" + 
			"SELECT\n" + 
			"        t_credit_note_header.crn_id,\n" + 
			"        t_credit_note_header.crn_date,\n" + 
			"        t_bill_header.invoice_no,\n" + 
			"        t_credit_note_details.crnd_id ,\n" + 
			"        t_bill_header.bill_date,\n" + 
			"        m_franchisee.fr_name,\n" + 
			"        t_credit_note_header.crn_no as fr_code,\n" + 
			"        m_franchisee.fr_gst_no,\n" + 
			"        t_credit_note_details.hsn_code,\n" + 
			"        SUM(t_credit_note_details.grn_gvn_qty)crn_qty,\n" + 
			"        SUM(t_credit_note_details.taxable_amt)crn_taxable,\n" + 
			"        t_credit_note_details.cgst_per,\n" + 
			"        t_credit_note_details.sgst_per,\n" + 
			"        t_credit_note_details.igst_per,\n" + 
			"        SUM(t_credit_note_details.sgst_rs)  AS sgst_amt ,\n" + 
			"        SUM(t_credit_note_details.cgst_rs) as cgst_amt,\n" + 
			"        SUM(t_credit_note_details.igst_rs) as igst_amt,\n" + 
			"        SUM(t_credit_note_details.grn_gvn_amt) as crn_amt \n" + 
			"        \n" + 
			"        \n" + 
			"    FROM\n" + 
			"        t_credit_note_header,\n" + 
			"        t_credit_note_details,\n" + 
			"        t_bill_header,\n" + 
			"        m_franchisee \n" + 
			"    WHERE\n" + 
			"        t_credit_note_header.crn_id=t_credit_note_details.crn_id \n" + 
			"        AND t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate  \n" + 
			"        AND t_credit_note_header.fr_id=m_franchisee.fr_id \n" + 
			"        AND t_bill_header.bill_no=t_credit_note_header.ex_int1 \n" + 
			"        and t_credit_note_details.del_status=0 \n" + 
			"        and t_bill_header.del_status=0 \n" + 
			"        and t_credit_note_header.is_grn = :CreditNoteType \n" + 
			"    GROUP BY\n" + 
			"        (t_credit_note_details.cgst_per+t_credit_note_details.sgst_per),\n" + 
			"        t_credit_note_details.crn_id  \n" + 
			"    order by\n" + 
			"        t_credit_note_header.crn_no\n" + 
			"    )t1 \n" + 
			"    LEFT JOIN\n" + 
			"    (SELECT\n" + 
			"        t_credit_note_header.crn_id,\n" + 
			"       \n" + 
			"        SUM(t_credit_note_details.taxable_amt)crn_taxable,       \n" + 
			"        SUM(t_credit_note_details.sgst_rs)  AS sgst_amt ,\n" + 
			"        SUM(t_credit_note_details.cgst_rs) as cgst_amt,\n" + 
			"        SUM(t_credit_note_details.grn_gvn_amt) as crn_amt \n" + 
			"        \n" + 
			"        \n" + 
			"    FROM\n" + 
			"        t_credit_note_header,\n" + 
			"        t_credit_note_details,\n" + 
			"        t_bill_header,\n" + 
			"        m_franchisee \n" + 
			"    WHERE\n" + 
			"        t_credit_note_header.crn_id=t_credit_note_details.crn_id \n" + 
			"        AND t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate  \n" + 
			"        AND t_credit_note_header.fr_id=m_franchisee.fr_id \n" + 
			"        AND t_bill_header.bill_no=t_credit_note_header.ex_int1 \n" + 
			"        and t_credit_note_details.del_status=0 \n" + 
			"        and t_bill_header.del_status=0 \n" + 
			"        and t_credit_note_header.is_grn = :CreditNoteType \n" + 
			"    GROUP BY        \n" + 
			"        t_credit_note_details.crn_id  \n" + 
			" ) t2 on t1.crn_id=t2.crn_id", nativeQuery = true)

	List<CrNoteRegItem> getCrNoteRegItemDone(@Param("fromDate") String fromDate, @Param("toDate") String toDate,@Param("CreditNoteType") String CreditNoteType);

//	SELECT t_credit_note_header.crn_id,t_credit_note_header.crn_date,t_bill_header.invoice_no,"
//			+ " t_credit_note_details.crnd_id ,"
//			+ " t_bill_header.bill_date,m_franchisee.fr_name,t_credit_note_header.crn_no as fr_code,m_franchisee.fr_gst_no,t_credit_note_details.hsn_code,"
//			+ "	SUM(t_credit_note_details.grn_gvn_qty)crn_qty,SUM(t_credit_note_details.taxable_amt)crn_taxable,"
//			+ " t_credit_note_details.cgst_per,t_credit_note_details.sgst_per,t_credit_note_details.igst_per,SUM(t_credit_note_details.sgst_rs) "
//			+ " AS sgst_amt ,SUM(t_credit_note_details.cgst_rs) as cgst_amt,"
//			+ " SUM(t_credit_note_details.igst_rs) as igst_amt,"
//			+ "	SUM(t_credit_note_details.grn_gvn_amt) as crn_amt"
//			+ "	FROM t_credit_note_header,t_credit_note_details,t_bill_header,m_franchisee"
//			+ "	WHERE t_credit_note_header.crn_id=t_credit_note_details.crn_id AND t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate "
//			+ "	AND t_credit_note_header.fr_id=m_franchisee.fr_id"
//			+ "	AND t_bill_header.bill_no=t_credit_note_header.ex_int1 and t_credit_note_details.del_status=0 and t_bill_header.del_status=0 and t_credit_note_header.is_grn = :CreditNoteType"
//			+ "	GROUP BY (t_credit_note_details.cgst_per+t_credit_note_details.sgst_per),t_credit_note_details.crn_id  order by t_credit_note_header.crn_no
	
	//Update By = Mahendra On => 28-09-2020
	//Desc = Add 3 cols in this query, other queries and related bean class (ttl_taxable, ttl_tax_amt, ttl_crn_amt)
	
	/*-------------------------------------------------------------------------------------------------------*/
	
	@Query(value = " SELECT t_credit_note_header.crn_id,t_credit_note_header.crn_date,t_bill_header.invoice_no,"
			+ " t_credit_note_details.crnd_id ,"
			+ " t_bill_header.bill_date,m_franchisee.fr_name,t_credit_note_header.crn_no as fr_code,m_franchisee.fr_gst_no,t_credit_note_details.hsn_code,"
			+ "	SUM(t_credit_note_details.grn_gvn_qty)crn_qty,SUM(t_credit_note_details.taxable_amt)crn_taxable,"
			+ " t_credit_note_details.cgst_per,t_credit_note_details.sgst_per,t_credit_note_details.igst_per,SUM(t_credit_note_details.sgst_rs) "
			+ " AS sgst_amt ,SUM(t_credit_note_details.cgst_rs) as cgst_amt,"
			+ " SUM(t_credit_note_details.igst_rs) as igst_amt,"
			+ "	SUM(t_credit_note_details.grn_gvn_amt) as crn_amt, 0 as ttl_taxable, 0 as ttl_tax_amt, 0 as ttl_crn_amt"
			+ "	FROM t_credit_note_header,t_credit_note_details,t_bill_header,m_franchisee"
			+ "	WHERE t_credit_note_header.crn_id=t_credit_note_details.crn_id AND t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate "
			+ "	AND t_credit_note_header.fr_id=m_franchisee.fr_id "
			+ "	AND t_bill_header.bill_no=t_credit_note_header.ex_int1 AND m_franchisee.fr_id=:frId  "
			+ "	GROUP BY (t_credit_note_details.cgst_per+t_credit_note_details.sgst_per),t_credit_note_details.crn_id  order by t_credit_note_header.crn_no", nativeQuery = true)

	List<CrNoteRegItem> getCrNoteRegItemDoneByFrId(@Param("frId") int frId, @Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

}
