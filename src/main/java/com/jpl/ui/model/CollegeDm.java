package com.jpl.ui.model;

public class CollegeDm {

	private int collegeId;
	private String collegeCode;
	private String description;
	private int universityId;

	public int getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeCode() {
		return collegeCode;
	}

	public void setCollegeCode(String collegeCode) {
		this.collegeCode = collegeCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUniversityId() {
		return universityId;
	}

	public void setUniversityId(int universityId) {
		this.universityId = universityId;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\nCollegeDm : [");
		sb.append("\ncollege id : " + this.collegeId);
		sb.append("\ncollege code : " + this.collegeCode);
		sb.append("\ndescription : " + this.description);
		sb.append("\nuniversity id : " + this.universityId);
		sb.append("]");
		return sb.toString();
	}
}
