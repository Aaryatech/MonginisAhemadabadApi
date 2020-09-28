package com.ats.webapi.model.reportv2;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class FranchiseSalesReport {

	
	@Id
	private int frId;
	private	String frName;
	private	String frCode;
	private	String frCity;
	
	private float saleValue;
	private float taxableAmt;
	private float totalTax;
	
	private float grnValue;
	private float grnTotalTax;
	private float grnTaxableAmt;
	
	
	private float gvnValue;
	private float gvnTotalTax;
	private float gvnTaxableAmt;
	
	
	
	public int getFrId() {
		return frId;
	}
	public void setFrId(int frId) {
		this.frId = frId;
	}
	public String getFrName() {
		return frName;
	}
	public void setFrName(String frName) {
		this.frName = frName;
	}
	public String getFrCode() {
		return frCode;
	}
	public void setFrCode(String frCode) {
		this.frCode = frCode;
	}
	public String getFrCity() {
		return frCity;
	}
	public void setFrCity(String frCity) {
		this.frCity = frCity;
	}
	public float getSaleValue() {
		return saleValue;
	}
	public void setSaleValue(float saleValue) {
		this.saleValue = saleValue;
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
	public float getGrnValue() {
		return grnValue;
	}
	public void setGrnValue(float grnValue) {
		this.grnValue = grnValue;
	}
	public float getGrnTotalTax() {
		return grnTotalTax;
	}
	public void setGrnTotalTax(float grnTotalTax) {
		this.grnTotalTax = grnTotalTax;
	}
	public float getGrnTaxableAmt() {
		return grnTaxableAmt;
	}
	public void setGrnTaxableAmt(float grnTaxableAmt) {
		this.grnTaxableAmt = grnTaxableAmt;
	}
	public float getGvnValue() {
		return gvnValue;
	}
	public void setGvnValue(float gvnValue) {
		this.gvnValue = gvnValue;
	}
	public float getGvnTotalTax() {
		return gvnTotalTax;
	}
	public void setGvnTotalTax(float gvnTotalTax) {
		this.gvnTotalTax = gvnTotalTax;
	}
	public float getGvnTaxableAmt() {
		return gvnTaxableAmt;
	}
	public void setGvnTaxableAmt(float gvnTaxableAmt) {
		this.gvnTaxableAmt = gvnTaxableAmt;
	}
	@Override
	public String toString() {
		return "FranchiseSalesReport [frId=" + frId + ", frName=" + frName + ", frCode=" + frCode + ", frCity=" + frCity
				+ ", saleValue=" + saleValue + ", taxableAmt=" + taxableAmt + ", totalTax=" + totalTax + ", grnValue="
				+ grnValue + ", grnTotalTax=" + grnTotalTax + ", grnTaxableAmt=" + grnTaxableAmt + ", gvnValue="
				+ gvnValue + ", gvnTotalTax=" + gvnTotalTax + ", gvnTaxableAmt=" + gvnTaxableAmt + "]";
	}
	

}
