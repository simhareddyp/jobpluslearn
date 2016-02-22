package com.jpl.ui.model;

public class IndustryDm {

	private int industryId;

	private String industryType;
	
	public int getIndustryId() {
		return industryId;
	}

	public void setIndustryId(int industryId) {
		this.industryId = industryId;
	}

	public String getIndustryType() {
		return industryType;
	}

	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\nIndustryDm : [");
		sb.append("\nindustry Id : " + this.industryId);
		sb.append("\nindustry Type : " + this.industryType);
		sb.append("]");
		return sb.toString();
	}
}
