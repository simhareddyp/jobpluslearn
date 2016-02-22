package com.jpl.ui.model;

public class UserDm {
	public String newIndustry;
	public String newBranch;
	public String OTP;
	public String tokenId;
	public String isAuth;
	public String userType;
	public String isFresher = "N";
	private String description;
	private String firstName;
	private String lastName;
	private String emailId;
	private String userName;
	private String password;
	private String reEnterPassword;
	private String mobileNumber;
	private Integer genderId;
	private Integer nationalityId;
	private Integer stateId;
	public Integer cityId;
	private Integer universityId;
	private String cityName;
	private String startDate;
	private String endDate;
	private String marks;
	private String uploadResume;
	private Integer countryId;
	private String skills;
	private String experience;
	private Integer branchId;
	private Integer collegeId;
	private Integer levelId;
	private String collegeName;

	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public UserDm()
	{
		
	}
	public UserDm(String emailid)
	{
		;
	}
	public String getNewIndustry() {
		return newIndustry;
	}

	public void setNewIndustry(String newIndustry) {
		this.newIndustry = newIndustry;
	}

	public String getNewBranch() {
		return newBranch;
	}

	public void setNewBranch(String newBranch) {
		this.newBranch = newBranch;
	}

	public String getOTP() {
		return OTP;
	}

	public void setOTP(String oTP) {
		OTP = oTP;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public String getIsAuth() {
		return isAuth;
	}

	public void setIsAuth(String isAuth) {
		this.isAuth = isAuth;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getIsFresher() {
		return isFresher;
	}

	public void setIsFresher(String isFresher) {
		this.isFresher = isFresher;
	}

	public Integer getGenderId() {
		return genderId;
	}

	public void setGenderId(Integer genderId) {
		this.genderId = genderId;
	}

	public Integer getNationalityId() {
		return nationalityId;
	}

	public void setNationalityId(Integer nationalityId) {
		this.nationalityId = nationalityId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getUniversityId() {
		return universityId;
	}

	public void setUniversityId(Integer universityId) {
		this.universityId = universityId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public Integer getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(Integer collegeId) {
		this.collegeId = collegeId;
	}

	public Integer getLevelId() {
		return levelId;
	}

	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getReEnterPassword() {
		return reEnterPassword;
	}

	public void setReEnterPassword(String reEnterPassword) {
		this.reEnterPassword = reEnterPassword;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getMarks() {
		return marks;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}

	public String getUploadResume() {
		return uploadResume;
	}

	public void setUploadResume(String uploadResume) {
		this.uploadResume = uploadResume;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	private Integer industryDetailsId;

	public Integer getIndustryDetailsId() {
		return industryDetailsId;
	}

	public void setIndustryDetailsId(Integer industryDetailsId) {
		this.industryDetailsId = industryDetailsId;
	}

	private Integer titleId;

	public Integer getTitleId() {
		return titleId;
	}

	public void setTitleId(Integer titleId) {
		this.titleId = titleId;
	}

	private Integer functionalDetailsId;

	public Integer getFunctionalDetailsId() {
		return functionalDetailsId;
	}

	public void setFunctionalDetailsId(Integer functionalDetailsId) {
		this.functionalDetailsId = functionalDetailsId;
	}

	public boolean checkemail() {
		return false;
	}

	public String resumeHeadline;
	public String annualSalary;
	private Integer landlinenoId;
	public String dateOfBirth;
	public String address;
	private String pincode;
	private String maritalStatus;
	public String startDate1;
	public String endDate1;

	public String getResumeHeadline() {
		return resumeHeadline;
	}

	public void setResumeHeadline(String resumeHeadline) {
		this.resumeHeadline = resumeHeadline;
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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
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
	
	public int User1Id;

	public int getUser1Id() {
		return User1Id;
	}
	public void setUser1Id(int user1Id) {
		User1Id = user1Id;
	}


}