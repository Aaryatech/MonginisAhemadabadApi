package com.ats.webapi.repo.salesreport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.salesreport.SubCatFrRepBill;

public interface SubCatFrRepBillRepo extends JpaRepository<SubCatFrRepBill, Integer> {

	@Query(value = "SELECT td.bill_detail_no,SUM(tb.grand_total) AS sold_amt, SUM(td.bill_qty) AS sold_qty ,f.fr_name,"
			+ "sc.sub_cat_id,sc.sub_cat_name ,f.fr_id FROM t_bill_header tb, t_bill_detail td,"
			+ "m_franchisee f ,m_cat_sub sc ,m_item WHERE tb.del_status=0 AND tb.fr_id IN(:frIdList) "
			+ "AND tb.bill_no=td.bill_no AND tb.bill_date BETWEEN :fromDate AND :toDate  "
			+ "AND f.fr_id=tb.fr_id AND m_item.id=td.item_id AND m_item.item_grp2=sc.sub_cat_id AND sc.sub_cat_id IN(:subCatIdList)  "
			+ "GROUP BY tb.fr_id,m_item.item_grp1,m_item.item_grp2", nativeQuery = true)
	List<SubCatFrRepBill> getData(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("frIdList") List<Integer> frIdList, @Param("subCatIdList") List<Integer> subCatIdList);

}
