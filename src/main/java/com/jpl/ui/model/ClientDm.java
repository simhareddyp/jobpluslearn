package com.jpl.ui.model;

public class ClientDm {

	private String emailId;
	private String password;
	private String matchingPassword;
	private String clientName;
	private String newCountry;
	private int clientType;
	private Integer industryDetailsId;
	private Integer landlinenoId;
	private Integer cityId;
	private String cityName;
	private String tokenId;
	private String isAuth;
	private Integer stateId;
	private Integer countryId;
	private String pincode;
	private String website;
	private String contactPerson;
	private String contactNumber;
	private String newIndustry;
	private String OTP;
	private Integer clientId;
	
	CompanyDetailsDm companyDetailsDm;

	public CompanyDetailsDm getCompanyDetailsDm() {
		return companyDetailsDm;
	}

	public void setCompanyDetailsDm(CompanyDetailsDm companyDetailsDm) {
		this.companyDetailsDm = companyDetailsDm;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getNewCountry() {
		return newCountry;
	}

	public void setNewCountry(String newCountry) {
		this.newCountry = newCountry;
	}

	public Integer getLandlinenoId() {
		return landlinenoId;
	}

	public void setLandlinenoId(Integer landlinenoId) {
		this.landlinenoId = landlinenoId;
	}

	public Integer getIndustryDetailsId() {
		return industryDetailsId;
	}

	public void setIndustryDetailsId(Integer industryDetailsId) {
		this.industryDetailsId = industryDetailsId;
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

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * private String landlineNo;
	 * 
	 * public String getLandlineNo() { return landlineNo; }
	 * 
	 * public void setLandlineNo(String landlineNo) { this.landlineNo =
	 * landlineNo; }
	 */
	public ClientDm() {
		clientType = 1;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public int getClientType() {
		return clientType;
	}

	public void setClientType(int clientType) {
		this.clientType = clientType;
	}
	
	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getNewIndustry() {
		return newIndustry;
	}

	public void setNewIndustry(String newIndustry) {
		this.newIndustry = newIndustry;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public boolean checkemail() {
		return false;
	}

	public String getOTP() {
		return OTP;
	}

	public void setOTP(String oTP) {
		OTP = oTP;
	}
}
