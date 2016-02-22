package com.jpl.ui.model;

import java.util.ArrayList;
import java.util.List;

public class JobPostingDm {

	private Integer jobid;

	public Integer getJobid() {
		return jobid;
	}

	public void setJobid(Integer jobid) {
		this.jobid = jobid;
	};

	private Integer branchId;
	private Integer levelId;
	public String isResponse = "N";
	private String templateFlag = "N";
	private String email;
	private String subUser;
	private String template;
	private String venue;
	private String time;
	private String date;
	private String description;
	private String contactPerson1;
	private String autofill;
	private String jobTitle;
	private String numberofvacancies;
	private String jobDescription;
	private String keywords;
	private String workExpmin;
	private String workExpmax;
	private String ctcmin;
	private String ctcmax;
	private String ctccurrency;
	private String workExperience;
	private String ctc;
	private String clientemailid;
	private Integer clientId;
	private String jobname;
	private String otherSalaryDetails;
	private String locationOfJob;
	private Integer industryDetailsId;
	private Integer functionalDetailsId;
	private List<String> listofmails =new ArrayList<String>();
	private String companyName;
	private String aboutCompany;
	private String companyWebsite;
	private String contactPerson;
	private String address;
	private String contactNumber;
	private String receiveResponseson;
	private String responseCode;
	private byte[] photo;
	private String presentation;
	private String logo;
	private String refreshPeriod;
	private String ugqulification;
	private String pgqualification;
	private String emailId;
	private ClientDm clientDm;
	private Integer cityId;

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public ClientDm getClientDm() {
		return clientDm;
	}

	public void setClientDm(ClientDm clientDm) {
		this.clientDm = clientDm;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUgqulification() {
		return ugqulification;
	}

	public void setUgqulification(String ugqulification) {
		this.ugqulification = ugqulification;
	}

	public String getPgqualification() {
		return pgqualification;
	}

	public void setPgqualification(String pgqualification) {
		this.pgqualification = pgqualification;
	}

	public String getJobname() {
		return jobname;
	}

	public void setJobname(String jobname) {
		this.jobname = jobname;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getContactPerson1() {
		return contactPerson1;
	}

	public void setContactPerson1(String contactPerson1) {
		this.contactPerson1 = contactPerson1;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getSubUser() {
		return subUser;
	}

	public void setSubUser(String subUser) {
		this.subUser = subUser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIsResponse() {
		return isResponse;
	}

	public void setIsResponse(String isResponse) {
		this.isResponse = isResponse;
	}

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public Integer getLevelId() {
		return levelId;
	}

	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	public String getAutofill() {
		return autofill;
	}

	public void setAutofill(String autofill) {
		this.autofill = autofill;
	}

	public String getWorkExpmin() {
		return workExpmin;
	}

	public void setWorkExpmin(String workExpmin) {
		this.workExpmin = workExpmin;
	}

	public String getWorkExpmax() {
		return workExpmax;
	}

	public void setWorkExpmax(String workExpmax) {
		this.workExpmax = workExpmax;
	}

	public String getCtcmin() {
		return ctcmin;
	}

	public void setCtcmin(String ctcmin) {
		this.ctcmin = ctcmin;
	}

	public String getCtcmax() {
		return ctcmax;
	}

	public void setCtcmax(String ctcmax) {
		this.ctcmax = ctcmax;
	}

	public String getCtccurrency() {
		return ctccurrency;
	}

	public void setCtccurrency(String ctccurrency) {
		this.ctccurrency = ctccurrency;
	}

	// private String cityName;

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getClientemailid() {
		return clientemailid;
	}

	public void setClientemailid(String clientemailid) {
		this.clientemailid = clientemailid;
	}

	/*
	 * public String getCityName() { return cityName; } public void
	 * setCityName(String cityName) { this.cityName = cityName; }
	 */
	public String getCtc() {
		return ctc;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCtc(String ctc) {
		this.ctc = ctc;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public String getRefreshPeriod() {
		return refreshPeriod;
	}

	public void setRefreshPeriod(String refreshPeriod) {
		this.refreshPeriod = refreshPeriod;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getNumberofvacancies() {
		return numberofvacancies;
	}

	public void setNumberofvacancies(String numberofvacancies) {
		this.numberofvacancies = numberofvacancies;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getWorkExperience() {
		return workExperience;
	}

	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience;
	}

	public String getOtherSalaryDetails() {
		return otherSalaryDetails;
	}

	public void setOtherSalaryDetails(String otherSalaryDetails) {
		this.otherSalaryDetails = otherSalaryDetails;
	}

	public String getLocationOfJob() {
		return locationOfJob;
	}

	public void setLocationOfJob(String locationOfJob) {
		this.locationOfJob = locationOfJob;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAboutCompany() {
		return aboutCompany;
	}

	public void setAboutCompany(String aboutCompany) {
		this.aboutCompany = aboutCompany;
	}

	public String getCompanyWebsite() {
		return companyWebsite;
	}

	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getReceiveResponseson() {
		return receiveResponseson;
	}

	public void setReceiveResponseson(String receiveResponseson) {
		this.receiveResponseson = receiveResponseson;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getPresentation() {
		return presentation;
	}

	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Integer getIndustryDetailsId() {
		return industryDetailsId;
	}

	public void setIndustryDetailsId(Integer industryDetailsId) {
		this.industryDetailsId = industryDetailsId;
	}

	public Integer getFunctionalDetailsId() {
		return functionalDetailsId;
	}

	public void setFunctionalDetailsId(Integer functionalDetailsId) {
		this.functionalDetailsId = functionalDetailsId;
	}

	public String getTemplateFlag() {
		return templateFlag;
	}

	public void setTemplateFlag(String templateFlag) {
		this.templateFlag = templateFlag;
	}

	public List<String> getListofmails() {
		return listofmails;
	}

	public void setListofmails(List<String> listofmails) {
		this.listofmails = listofmails;
	}

	

}
