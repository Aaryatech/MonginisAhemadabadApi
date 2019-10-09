package com.ats.webapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.CreditNoteReport;

public interface CreditNoteReportRepo extends JpaRepository<CreditNoteReport, Integer>{

	@Query(value="select cd.*,ch.crn_date,ch.crn_no,i.item_name,f.fr_name, ch.fr_id from t_credit_note_details cd, t_credit_note_header ch, t_grn_gvn g,m_item i,"
			+ "m_franchisee f where ch.crn_date between :fromDate and :toDate and cd.crn_id=ch.crn_id and cd.grn_gvn_id=g.grn_gvn_id and cd.item_id=i.id "
			+ "and f.fr_id = ch.fr_id  ",nativeQuery=true)
	List<CreditNoteReport> creditNoteReportBetweenDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value="select cd.*,ch.crn_date,ch.crn_no,i.item_name,f.fr_name, ch.fr_id from t_credit_note_details cd, t_credit_note_header ch, t_grn_gvn g,m_item i,"
			+ "m_franchisee f where ch.crn_date between :fromDate and :toDate and cd.crn_id=ch.crn_id and cd.grn_gvn_id=g.grn_gvn_id and cd.item_id=i.id "
			+ "and f.fr_id = ch.fr_id  and ch.fr_id =:frId ",nativeQuery=true)
	List<CreditNoteReport> creditNoteReportBetweenDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("frId") int frId);

}
