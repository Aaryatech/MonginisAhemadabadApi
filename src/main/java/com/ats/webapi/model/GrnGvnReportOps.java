package com.ats.webapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GrnGvnReportOps {

	@Id
	private int grnGvnId;
	private Date grnGvnDate;
	private int itemId;
	private String itemName;
	private float taxRate;
	private float taxableAmt;
	private float totalTax;
	private float grnGvnAmt;
	private float aprTaxableAmt;
	private float aprSgstRs;
	private float aprCgstRs;
	private float aprIgstRs;
	private float aprGrandTotal;
	private int grnGvnQty;
	private int aprQtyGate;
	private int aprQtyStore;
	private int aprQtyAcc;
	public int getGrnGvnId() {
		return grnGvnId;
	}
	public void setGrnGvnId(int grnGvnId) {
		this.grnGvnId = grnGvnId;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getGrnGvnDate() {
		return grnGvnDate;
	}
	public void setGrnGvnDate(Date grnGvnDate) {
		this.grnGvnDate = grnGvnDate;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public float getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(float taxRate) {
		this.taxRate = taxRate;
	}
	public float getTaxableAmt() {
		return taxableAmt;
	}
	public void setTaxableAmt(float taxableAmt) {
		this.taxableAmt = taxableAmt;
	}
	public float getTotalTax() {
		return totalTax;
	}
	public void setTotalTax(float totalTax) {
		this.totalTax = totalTax;
	}
	public float getGrnGvnAmt() {
		return grnGvnAmt;
	}
	public void setGrnGvnAmt(float grnGvnAmt) {
		this.grnGvnAmt = grnGvnAmt;
	}
	public float getAprTaxableAmt() {
		return aprTaxableAmt;
	}
	public void setAprTaxableAmt(float aprTaxableAmt) {
		this.aprTaxableAmt = aprTaxableAmt;
	}
	public float getAprSgstRs() {
		return aprSgstRs;
	}
	public void setAprSgstRs(float aprSgstRs) {
		this.aprSgstRs = aprSgstRs;
	}
	public float getAprCgstRs() {
		return aprCgstRs;
	}
	public void setAprCgstRs(float aprCgstRs) {
		this.aprCgstRs = aprCgstRs;
	}
	public float getAprIgstRs() {
		return aprIgstRs;
	}
	public void setAprIgstRs(float aprIgstRs) {
		this.aprIgstRs = aprIgstRs;
	}
	public float getAprGrandTotal() {
		return aprGrandTotal;
	}
	public void setAprGrandTotal(float aprGrandTotal) {
		this.aprGrandTotal = aprGrandTotal;
	}
	public int getGrnGvnQty() {
		return grnGvnQty;
	}
	public void setGrnGvnQty(int grnGvnQty) {
		this.grnGvnQty = grnGvnQty;
	}
	public int getAprQtyGate() {
		return aprQtyGate;
	}
	public void setAprQtyGate(int aprQtyGate) {
		this.aprQtyGate = aprQtyGate;
	}
	public int getAprQtyStore() {
		return aprQtyStore;
	}
	public void setAprQtyStore(int aprQtyStore) {
		this.aprQtyStore = aprQtyStore;
	}
	public int getAprQtyAcc() {
		return aprQtyAcc;
	}
	public void setAprQtyAcc(int aprQtyAcc) {
		this.aprQtyAcc = aprQtyAcc;
	}
	@Override
	public String toString() {
		return "GrnGvnReportOps [grnGvnId=" + grnGvnId + ", grnGvnDate=" + grnGvnDate + ", itemId=" + itemId
				+ ", itemName=" + itemName + ", taxRate=" + taxRate + ", taxableAmt=" + taxableAmt + ", totalTax="
				+ totalTax + ", grnGvnAmt=" + grnGvnAmt + ", aprTaxableAmt=" + aprTaxableAmt + ", aprSgstRs="
				+ aprSgstRs + ", aprCgstRs=" + aprCgstRs + ", aprIgstRs=" + aprIgstRs + ", aprGrandTotal="
				+ aprGrandTotal + ", grnGvnQty=" + grnGvnQty + ", aprQtyGate=" + aprQtyGate + ", aprQtyStore="
				+ aprQtyStore + ", aprQtyAcc=" + aprQtyAcc + "]";
	}
	
	
	
	
	
}
