package com.jpl.ui.model;

public class PostLoginDm {

	public String resumeHeadline;
	public String prefferedLocation;
	public String totalExpYears;
	public String totalExpMonths;
	public String annualSalary;
	private Integer landlinenoId;
	public String dateOfBirth;
	public String address;
	private Integer pincode;
	private String maritalStatus;
	private Integer user1Id;
	private Integer levelId;
	private Integer branchId;
	private Integer universityId;
	private String startDate1;
	private String endDate1;
	private int ugStudytype;
	private int pgStudytype;

	UserDm userDm;

	public UserDm getUserDm() {
		return userDm;
	}

	public void setUserDm(UserDm userDm) {
		this.userDm = userDm;
	}
	
	public PostLoginDm() {
		ugStudytype = 1;
		pgStudytype = 4;

	}
	
	public Integer getLevelId() {
		return levelId;
	}

	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public Integer getUniversityId() {
		return universityId;
	}

	public void setUniversityId(Integer universityId) {
		this.universityId = universityId;
	}

	public Integer getUser1Id() {
		return user1Id;
	}

	public void setUser1Id(Integer user1Id) {
		this.user1Id = user1Id;
	}

	public String getStartDate1() {
		return startDate1;
	}

	public void setStartDate1(String startDate1) {
		this.startDate1 = startDate1;
	}

	public String getEndDate1() {
		return endDate1;
	}

	public void setEndDate1(String endDate1) {
		this.endDate1 = endDate1;
	}

	public int getUgStudytype() {
		return ugStudytype;
	}

	public void setUgStudytype(int ugStudytype) {
		this.ugStudytype = ugStudytype;
	}

	public int getPgStudytype() {
		return pgStudytype;
	}

	public void setPgStudytype(int pgStudytype) {
		this.pgStudytype = pgStudytype;
	}

	/**
	 * public Integer getCityId() { return cityId; }
	 * 
	 * public void setCityId(Integer cityId) { this.cityId = cityId; }
	 */

	public void setPrefferedLocation(String prefferedLocation) {
		this.prefferedLocation = prefferedLocation;
	}

	public String getResumeHeadline() {
		return resumeHeadline;
	}

	public void setResumeHeadline(String resumeHeadline) {
		this.resumeHeadline = resumeHeadline;
	}

	public String getPrefferedLocation() {
		return prefferedLocation;
	}

	public void setPreffered_location(String prefferedLocation) {
		this.prefferedLocation = prefferedLocation;
	}

	public String getTotalExpYears() {
		return totalExpYears;
	}

	public void setTotalExpYears(String totalExpYears) {
		this.totalExpYears = totalExpYears;
	}

	public String getTotalExpMonths() {
		return totalExpMonths;
	}

	public void setTotalExpMonths(String totalExpMonths) {
		this.totalExpMonths = totalExpMonths;
	}

	public String getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(String annualSalary) {
		this.annualSalary = annualSalary;
	}

	public Integer getLandlinenoId() {
		return landlinenoId;
	}

	public void setLandlinenoId(Integer landlinenoId) {
		this.landlinenoId = landlinenoId;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String cityName;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}


}
