package com.ats.webapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.CreditNoteReport;

public interface CreditNoteReportRepo extends JpaRepository<CreditNoteReport, Integer>{

	@Query(value="select\n" + 
			"        cd.*,\n" + 
			"        ch.crn_date,\n" + 
			"        ch.crn_no,\n" + 
			"        i.item_name,\n" + 
			"        f.fr_name,\n" + 
			"        ch.fr_id,\n" + 
			"        coalesce((select item_uom from m_item_sup where  m_item_sup.item_id=i.id ),'-') as item_uom\n" + 
			"    from\n" + 
			"        t_credit_note_details cd,\n" + 
			"        t_credit_note_header ch,\n" + 
			"        t_grn_gvn g,\n" + 
			"        m_item i,\n" + 
			"        m_franchisee f \n" + 
			"    where\n" + 
			"        ch.crn_date between :fromDate and :toDate \n" + 
			"        and cd.crn_id=ch.crn_id \n" + 
			"        and cd.grn_gvn_id=g.grn_gvn_id \n" + 
			"        and cd.item_id=i.id \n" + 
			"        and f.fr_id = ch.fr_id\n" + 
			"    order by\n" + 
			"        f.fr_name,\n" + 
			"        ch.crn_id\n" + 
			"",nativeQuery=true)
	List<CreditNoteReport> creditNoteReportBetweenDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value="select\n" + 
			"        cd.*,\n" + 
			"        ch.crn_date,\n" + 
			"        ch.crn_no,\n" + 
			"        i.item_name,\n" + 
			"        f.fr_name,\n" + 
			"        ch.fr_id,\n" + 
			"        coalesce((select item_uom from m_item_sup where  m_item_sup.item_id=i.id ),'-') as item_uom\n" + 
			"    from\n" + 
			"        t_credit_note_details cd,\n" + 
			"        t_credit_note_header ch,\n" + 
			"        t_grn_gvn g,\n" + 
			"        m_item i,\n" + 
			"        m_franchisee f \n" + 
			"    where\n" + 
			"        ch.crn_date between :fromDate and :toDate \n" + 
			"        and cd.crn_id=ch.crn_id \n" + 
			"        and cd.grn_gvn_id=g.grn_gvn_id \n" + 
			"        and cd.item_id=i.id \n" + 
			"        and f.fr_id = ch.fr_id\n" + 
			"        and ch.fr_id=:frId\n" + 
			"    order by\n" + 
			"        f.fr_name,\n" + 
			"        ch.crn_id\n" + 
			"",nativeQuery=true)
	List<CreditNoteReport> creditNoteReportBetweenDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("frId") int frId);

}
