package com.jpl.ui.model;

public class FunctionalDm {
	
	private int functionalId;
	private int functionalDetailsId;
	private int userId;
	private int industryDetailsId;
	private String functionalName;
	
	public int getFunctionalId() {
		return functionalId;
	}
	public void setFunctionalId(int functionalId) {
		this.functionalId = functionalId;
	}
	public int getFunctionalDetailsId() {
		return functionalDetailsId;
	}
	public void setFunctionalDetailsId(int functionalDetailsId) {
		this.functionalDetailsId = functionalDetailsId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getIndustryDetailsId() {
		return industryDetailsId;
	}
	public void setIndustryDetailsId(int industryDetailsId) {
		this.industryDetailsId = industryDetailsId;
	}
	public String getFunctionalName() {
		return functionalName;
	}
	public void setFunctionalName(String functionalName) {
		this.functionalName = functionalName;
	}
	
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\nfunctionalDestailDm : [");
		sb.append("\nfunctional id : " + this.functionalId);
		sb.append("\nfunctional details id : " + this.functionalDetailsId);
		sb.append("\nindustry details id : " + this.industryDetailsId);
		sb.append("\nfunctional name : " + this.functionalName);
		sb.append("]");
		return sb.toString();
	}	
	
	
	
	
	}


