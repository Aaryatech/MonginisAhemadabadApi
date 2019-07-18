package com.ats.webapi.repo.salesreport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.salesreport.SubCatCreditGrnFrRep;

public interface SubCatCreditGrnFrRepRepo extends JpaRepository<SubCatCreditGrnFrRep, Integer> {

	@Query(value = "SELECT SUM(t_credit_note_details.grn_gvn_amt) AS var_amt, "
			+ "SUM(t_credit_note_details.grn_gvn_qty) AS var_qty ,f.fr_name,sc.sub_cat_id,sc.sub_cat_name,"
			+ "f.fr_id FROM t_credit_note_header,t_credit_note_details, m_franchisee f ,m_cat_sub sc ,"
			+ "m_item WHERE t_credit_note_header.crn_id=t_credit_note_details.crn_id AND "
			+ "t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate "
			+ "AND f.fr_id=t_credit_note_header.fr_id AND m_item.id=t_credit_note_details.item_id "
			+ "AND m_item.item_grp2=sc.sub_cat_id AND t_credit_note_details.cat_id !=5  AND "
			+ "t_credit_note_header.fr_id IN(:frIdList) AND sc.sub_cat_id IN(:subCatIdList) AND t_credit_note_details.is_grn=0 GROUP BY"
			+ " t_credit_note_header.fr_id,m_item.item_grp1,m_item.item_grp2", nativeQuery = true)
	List<SubCatCreditGrnFrRep> getDataGVN(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("frIdList") List<Integer> frIdList, @Param("subCatIdList") List<Integer> subCatIdList);

	@Query(value = "SELECT SUM(t_credit_note_details.grn_gvn_amt) AS var_amt, "
			+ "SUM(t_credit_note_details.grn_gvn_qty) AS var_qty ,f.fr_name,sc.sub_cat_id,sc.sub_cat_name,"
			+ "f.fr_id FROM t_credit_note_header,t_credit_note_details, m_franchisee f ,m_cat_sub sc ,"
			+ "m_item WHERE t_credit_note_header.crn_id=t_credit_note_details.crn_id AND "
			+ "t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate "
			+ "AND f.fr_id=t_credit_note_header.fr_id AND m_item.id=t_credit_note_details.item_id "
			+ "AND m_item.item_grp2=sc.sub_cat_id AND t_credit_note_details.cat_id !=5  AND "
			+ "t_credit_note_header.fr_id IN(:frIdList) AND sc.sub_cat_id IN(:subCatIdList) AND t_credit_note_details.is_grn=1 GROUP BY"
			+ " t_credit_note_header.fr_id,m_item.item_grp1,m_item.item_grp2", nativeQuery = true)
	List<SubCatCreditGrnFrRep> getDataGRN(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("frIdList") List<Integer> frIdList, @Param("subCatIdList") List<Integer> subCatIdList);

}
