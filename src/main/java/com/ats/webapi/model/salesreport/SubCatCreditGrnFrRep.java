package com.ats.webapi.model.salesreport;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SubCatCreditGrnFrRep {

	@Id
	private int subCatId;

	private int frId;
	private String frName;
	private String subCatName;
	private float varQty;
	private float varAmt;

	public int getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}

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

	public String getSubCatName() {
		return subCatName;
	}

	public void setSubCatName(String subCatName) {
		this.subCatName = subCatName;
	}

	public float getVarQty() {
		return varQty;
	}

	public void setVarQty(float varQty) {
		this.varQty = varQty;
	}

	public float getVarAmt() {
		return varAmt;
	}

	public void setVarAmt(float varAmt) {
		this.varAmt = varAmt;
	}

	@Override
	public String toString() {
		return "SubCatCreditGrnFrRep [subCatId=" + subCatId + ", frId=" + frId + ", frName=" + frName + ", subCatName="
				+ subCatName + ", varQty=" + varQty + ", varAmt=" + varAmt + "]";
	}

}
