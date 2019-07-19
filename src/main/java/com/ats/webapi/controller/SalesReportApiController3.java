package com.ats.webapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ats.webapi.commons.Common;
import com.ats.webapi.model.salesreport.SubCatCreditGrnFrRep;
import com.ats.webapi.model.salesreport.SubCatFrRepBill;
import com.ats.webapi.model.salesreport.SubCatFrReport;

public class SalesReportApiController3 {

	
	/*@RequestMapping(value = { "/getSubCatFrReportApi" }, method = RequestMethod.POST)
	public @ResponseBody List<SubCatFrReport> getSubCatFrReportApi(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate,	@RequestParam("subCatIdList") List<Integer> subCatIdList) {

		List<SubCatFrReport> catReportList = new ArrayList<>();
		List<SubCatFrRepBill> catReportBill = null;

		List<SubCatCreditGrnFrRep> subCatCreditGrnRep = null;
		List<SubCatCreditGrnFrRep> subCatCreditGvnRep = null;
		try {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);

			// catReportList = subCatReportRepo.getData(fromDate, toDate);

			catReportBill = subCatFrRepBillRepo.getData(fromDate, toDate, frIdList, subCatIdList);

			subCatCreditGrnRep = subCatCreditGrnFrRepRepo.getDataGRN(fromDate, toDate, frIdList, subCatIdList);

			subCatCreditGvnRep = subCatCreditGrnFrRepRepo.getDataGVN(fromDate, toDate, frIdList, subCatIdList);

			System.out.println(catReportBill.toString());
			System.out.println(subCatCreditGrnRep.toString());
			System.out.println(subCatCreditGvnRep.toString());

			for (int i = 0; i < catReportBill.size(); i++) {

				SubCatFrReport subCatReport = new SubCatFrReport();

				subCatReport.setSubCatId(catReportBill.get(i).getSubCatId());
				subCatReport.setSubCatName(catReportBill.get(i).getSubCatName());
				subCatReport.setFrId(catReportBill.get(i).getFrId());
				subCatReport.setFrName(catReportBill.get(i).getFrName());
				subCatReport.setSoldAmt(catReportBill.get(i).getSoldAmt());
				subCatReport.setSoldQty(catReportBill.get(i).getSoldQty());
				subCatReport.setBillDetailNo(catReportBill.get(i).getBillDetailNo());

				catReportList.add(subCatReport);

			}

			for (int i = 0; i < catReportList.size(); i++) {
				for (int j = 0; j < subCatCreditGrnRep.size(); j++) {

					if (catReportList.get(i).getSubCatId() == subCatCreditGrnRep.get(j).getSubCatId()) {

						catReportList.get(i).setVarAmt(subCatCreditGrnRep.get(j).getVarAmt());
						catReportList.get(i).setVarQty(subCatCreditGrnRep.get(j).getVarQty());
						break;

					} else {

						catReportList.get(i).setVarAmt(0);
						catReportList.get(i).setVarQty(0);
					}

				}
			}

			for (int i = 0; i < catReportList.size(); i++) {
				for (int j = 0; j < subCatCreditGvnRep.size(); j++) {

					if (catReportList.get(i).getSubCatId() == subCatCreditGrnRep.get(j).getSubCatId()) {

						catReportList.get(i).setVarAmt(subCatCreditGvnRep.get(j).getVarAmt());
						catReportList.get(i).setVarQty(subCatCreditGvnRep.get(j).getVarQty());
						break;

					} else {

						catReportList.get(i).setVarAmt(0);
						catReportList.get(i).setVarQty(0);
					}

				}
			}

		} catch (Exception e) {
			System.out.println(" Exce in Tax1 Report " + e.getMessage());
			e.printStackTrace();
		}
		return catReportList;
	}*/
	
	
	
	
	
//	select bd.bill_detail_no,bh.fr_id,m_item.id as item_id,m_item.item_grp2 as sub_cat_id,SUM(bd.bill_qty) from t_bill_header bh,t_bill_detail bd,m_item where bd.bill_no=bh.bill_no and m_item.id=bd.item_id and m_item.item_grp2=1 GROUP BY m_item.id,bh.fr_id
	
	
	
/*	 UNION
	    
	    SELECT
	    bd.bill_detail_no,
	    bh.fr_id,
	    sp.sp_id AS item_id,
	    catsub.sub_cat_id AS sub_cat_id,
	    bd.cat_id,
	    SUM(bd.bill_qty) as bill_qty,
	    SUM(bd.grand_total) as bill_total,
	    SUM(bd.taxable_amt) as bill_taxable_amt,
	    SUM(bd.total_tax) as bill_total_tax
	FROM
	    t_bill_header bh,
	    t_bill_detail bd,
	    m_sp_cake sp,
	    m_cat_sub catsub
	WHERE
	    bd.bill_no = bh.bill_no AND sp.sp_id = bd.item_id AND bd.cat_id = catsub.cat_id AND bd.cat_id=5
	GROUP BY
	    sp.sp_id,
	    bh.fr_id
*/	
	
	
	//----------------------UNION--------------------------------------
	
	/*
	
	SELECT
    bd.bill_detail_no,
    bh.fr_id,
    i.id AS item_id,
    i.item_grp2 AS sub_cat_id,
    bd.cat_id,
    SUM(bd.bill_qty) as bill_qty,
    SUM(bd.grand_total) as bill_total,
    SUM(bd.taxable_amt) as bill_taxable_amt,
    SUM(bd.total_tax) as bill_total_tax
FROM
    t_bill_header bh,
    t_bill_detail bd,
    m_item i
WHERE
    bd.bill_no = bh.bill_no AND i.id = bd.item_id AND bd.cat_id!=5
GROUP BY
    i.id,
    bh.fr_id
    
    
    UNION
	    
	    SELECT
	    bd.bill_detail_no,
	    bh.fr_id,
	    sp.sp_id AS item_id,
	    catsub.sub_cat_id AS sub_cat_id,
	    bd.cat_id,
	    SUM(bd.bill_qty) as bill_qty,
	    SUM(bd.grand_total) as bill_total,
	    SUM(bd.taxable_amt) as bill_taxable_amt,
	    SUM(bd.total_tax) as bill_total_tax
	FROM
	    t_bill_header bh,
	    t_bill_detail bd,
	    m_sp_cake sp,
	    m_cat_sub catsub
	WHERE
	    bd.bill_no = bh.bill_no AND sp.sp_id = bd.item_id AND bd.cat_id = catsub.cat_id AND bd.cat_id=5
	GROUP BY
	    sp.sp_id,
	    bh.fr_id
	    */
	
	
	
	
/*	(SELECT  cd.crnd_id,
		    SUM(cd.grn_gvn_amt) AS var_amt,
		    SUM(cd.grn_gvn_qty) AS var_qty,
		    SUM(cd.taxable_amt) as var_taxable_amt,
		    SUM(cd.total_tax) as var_total_tax FROM  t_credit_note_header ch,
		    t_credit_note_details cd WHERE ch.crn_id=cd.crnd_id AND ch.crn_date BETWEEN '2019-07-01' AND '2019-07-30' AND ch.fr_id=bh.fr_id AND cd.item_id=bd.item_id AND cd.cat_id!=5)
	*/
}
