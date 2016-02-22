package com.jpl.ui.model;

public class IndustryDetailsDm {

	private int industryId;
	private int industryDetailsId;
	private int functionalDetailsId;

	
	public int getFunctionalDetailsId() {
		return functionalDetailsId;
	}

	public void setFunctionalDetailsId(int functionalDetailsId) {
		this.functionalDetailsId = functionalDetailsId;
	}

	public int getIndustryDetailsId() {
		return industryDetailsId;
	}

	public void setIndustryDetailsId(int industryDetailsId) {
		this.industryDetailsId = industryDetailsId;
	}

	private int userId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	private String industryType;

	public String getIndustryType() {
		return industryType;
	}

	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}

	public int getIndustryId() {
		return industryId;
	}

	public void setIndustryId(int industryId) {
		this.industryId = industryId;
	}

	

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\nIndustryDetailsDm : [");
		sb.append("\nindustry id : " + this.industryId);
		sb.append("\nindustry details id : " + this.industryDetailsId);
		sb.append("\nuser id : " + this.userId);
		sb.append("\nindustry type : " + this.industryType);
		sb.append("]");
		return sb.toString();
	}
}
