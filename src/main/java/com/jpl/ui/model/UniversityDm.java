package com.jpl.ui.model;

public class UniversityDm {
	private int universityId;
	private String universityCode;
	private String description;
	private int stateId;

	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public int getUniversityId() {
		return universityId;
	}
	public void setUniversityId(int universityId) {
		this.universityId = universityId;
	}
	public String getUniversityCode() {
		return universityCode;
	}
	public void setUniversityCode(String universityCode) {
		this.universityCode = universityCode;
	}
	public String getdescription() {
		return description;
	}
	public void setdescription(String description) {
		this.description = description;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\nUniversityDm : [");
		sb.append("\nuniversity id : " + this.universityId);
		sb.append("\nuniversity code : " + this.universityCode);
		sb.append("\ndescription : " + this.description);
		//sb.append("\nstate id : " + this.stateId);
		sb.append("]");
		return sb.toString();
	}
	}


