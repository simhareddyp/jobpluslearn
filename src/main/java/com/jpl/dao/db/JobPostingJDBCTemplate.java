package com.jpl.dao.db;

import java.sql.Blob;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jpl.dao.JobPostingDao;
import com.jpl.ui.model.ClientDm;
import com.jpl.ui.model.JobPostingDm;

@Repository
public class JobPostingJDBCTemplate implements JobPostingDao {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	private static final String insertSQL = "INSERT INTO JOBPOSTING ("
			+ " JOB_TITLE, NUMBEROF_VACANCIES, JOB_DESCRIPTION, JOB_KEYWORDS, WORK_EXP_MIN, WORK_EXP_MAX, CTC_CURRENCY, CTC_MIN, CTC_MAX, "
			+ "OTH_SAL_DETAILS, lOCATION_OF_JOB, CITY_ID, INDUSTRY_DETAILS_ID, FUNCTIONAL_DETAILS_ID,"
			+ "LEVEL_ID, BRANCH_ID, " + "COMPANY_NAME, ABOUT_COMPANY, COMPANY_WEBSITE, CONTACT_PERSON, " + "ADDRESS, "
			+ "CONTACT_NUMBER, RECEIVE_RESPONSES_ON, RESPONSE_CODE, "
			+ "REFRESH_PERIOD, CLIENT_ID,CREATED_BY,DATE, TIME, VENUE, CONTACTPERSON1,TEMPLATE_NAME)"
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String selectjoposting = "select "
			+ " JOBPOSTING_ID,JOB_TITLE, NUMBEROF_VACANCIES, JOB_DESCRIPTION, JOB_KEYWORDS, WORK_EXP_MIN, WORK_EXP_MAX, CTC_CURRENCY, CTC_MIN, CTC_MAX, "
			+ "OTH_SAL_DETAILS, lOCATION_OF_JOB, CITY_ID, INDUSTRY_DETAILS_ID, FUNCTIONAL_DETAILS_ID,"
			+ "LEVEL_ID, BRANCH_ID, " + "COMPANY_NAME, ABOUT_COMPANY, COMPANY_WEBSITE, CONTACT_PERSON, " + "ADDRESS, "
			+ "CONTACT_NUMBER, RECEIVE_RESPONSES_ON, RESPONSE_CODE, lOCATION_OF_JOB,"
			+ "REFRESH_PERIOD, CLIENT_ID,CREATED_BY,DATE, TIME, VENUE, CONTACTPERSON1, TEMPLATE_NAME from jobposting where template_name='";
	private static String updatejoposting = "update jobposting set ";
			/*+ " JOB_TITLE=?, NUMBEROF_VACANCIES=?, JOB_DESCRIPTION=?, JOB_KEYWORDS=?, WORK_EXP_MIN=?, WORK_EXP_MAX=?, CTC_CURRENCY=?, CTC_MIN=?, CTC_MAX=?, "
			+ "OTH_SAL_DETAILS=?, lOCATION_OF_JOB=?, CITY_ID=?, INDUSTRY_DETAILS_ID=?, FUNCTIONAL_DETAILS_ID=?,"
			+ "LEVEL_ID, BRANCH_ID=?, " + "COMPANY_NAME=?, ABOUT_COMPANY=?, COMPANY_WEBSITE=?, CONTACT_PERSON=?, " + "ADDRESS=?, "
			+ "CONTACT_NUMBER=?, RECEIVE_RESPONSES_ON=?, RESPONSE_CODE=?, "
			+ "REFRESH_PERIOD=?, ,DATE=?, TIME=?, VENUE=?, CONTACTPERSON1=? where JOBPOSTING_ID=?";
*/
	@PostConstruct
	public void setJdbcTemplate() {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void insertJobposting(JobPostingDm jobpostingDm) {
	
		saveRecord(jobpostingDm.getJobTitle(), jobpostingDm.getNumberofvacancies(), jobpostingDm.getJobDescription(),
				jobpostingDm.getKeywords(), jobpostingDm.getWorkExpmin(), jobpostingDm.getWorkExpmax(),
				jobpostingDm.getCtccurrency(), jobpostingDm.getCtcmin(), jobpostingDm.getCtcmax(),
				jobpostingDm.getOtherSalaryDetails(), jobpostingDm.getLocationOfJob(), jobpostingDm.getCityId(),
				jobpostingDm.getIndustryDetailsId(), jobpostingDm.getFunctionalDetailsId(), jobpostingDm.getLevelId(),
				jobpostingDm.getBranchId(), jobpostingDm.getCompanyName(), jobpostingDm.getAboutCompany(),
				jobpostingDm.getCompanyWebsite(), jobpostingDm.getContactPerson(), jobpostingDm.getAddress(),
				jobpostingDm.getContactNumber(), jobpostingDm.getReceiveResponseson(), jobpostingDm.getResponseCode(),
				jobpostingDm.getRefreshPeriod(), jobpostingDm.getClientId(), "JPL_WEB", jobpostingDm.getDate(),
				jobpostingDm.getTime(), jobpostingDm.getVenue(), jobpostingDm.getContactPerson1(),
				jobpostingDm.getTemplate());

	}

	private void saveRecord(String jobTitle, String numberofvacancies, String jobDescription, String keywords,
			String workExpmin, String workExpmax, String ctccurrency, String ctcmin, String ctcmax,
			String otherSalaryDetails, String locationOfJob,

			Integer cityId, Integer industryDetailsId, Integer functionalDetailsId, Integer levelId, Integer branchId,

			String companyName, String aboutCompany, String companyWebsite, String contactPerson, String Address,
			String contactNumber, String receiveResponseson, String refreshPeriod, String responseCode,
			Integer clientId, String createdBy, String date, String time, String venue, String contactPerson1,
			String templatename) {

		Object[] params = new Object[] { jobTitle, numberofvacancies, jobDescription, keywords, workExpmin, workExpmax,
				ctccurrency, ctcmin, ctcmax, otherSalaryDetails, locationOfJob, cityId, industryDetailsId,
				functionalDetailsId, levelId, branchId, companyName, aboutCompany, companyWebsite,
				// countryId,
				contactPerson, Address, contactNumber, receiveResponseson, responseCode,

				refreshPeriod, clientId, createdBy, date, time, venue, contactPerson1, templatename };

		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
				Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,

				Types.VARCHAR,

				Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.VARCHAR, Types.VARCHAR,
				Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
				Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR

		};

		int row = jdbcTemplateObject.update(insertSQL, params, types);

	}

	public int getTemplateId(String templatename) {

		String SQL = "select template_id from template where template_name='" + templatename.trim() + "'";
		List<Map<String, Object>> templateid = this.jdbcTemplateObject.queryForList(SQL);
		return (Integer) templateid.get(0).get("template_id");
	}

	public ClientDm getClientDm(String clientName) {

		ClientDm clientDm = new ClientDm();
		String getclientdmdb = "SELECT EMAIL_ID FROM CLIENT WHERE CLIENT_NAME= '" + clientName + "'";
		List<Map<String, Object>> strLst = this.jdbcTemplateObject.queryForList(getclientdmdb);
		clientDm.setEmailId(strLst.get(0).get("EMAIL_ID").toString());
		return null;
	}

	@Override
	public void insertTemplate(JobPostingDm jobpostingDm) {
		// TODO Auto-generated method stub

	}

	@Override
	public JobPostingDm getJobpostingDM(String templatename) {
		JobPostingDm jbpdm = new JobPostingDm();
		String SQL = selectjoposting + templatename + "'";
		
		List<Map<String, Object>> strLst = this.jdbcTemplateObject.queryForList(SQL);
		
		String vacn=strLst.get(0).get("NUMBEROF_VACANCIES")!= null?strLst.get(0).get("NUMBEROF_VACANCIES").
				toString():null;
		
		jbpdm.setNumberofvacancies(vacn);
	
		jbpdm.setJobTitle(strLst.get(0).get("JOB_TITLE")!=null?strLst.get(0).get("JOB_TITLE").toString():null);
		
		jbpdm.setLocationOfJob(strLst.get(0).get("lOCATION_OF_JOB")!=null?strLst.get(0).get("lOCATION_OF_JOB").toString():null);
		jbpdm.setJobDescription(strLst.get(0).get("JOB_DESCRIPTION")!=null?strLst.get(0).get("JOB_DESCRIPTION").toString():null);
		jbpdm.setKeywords(strLst.get(0).get("JOB_KEYWORDS")!=null?strLst.get(0).get("JOB_KEYWORDS").toString():null);
		jbpdm.setWorkExpmin(strLst.get(0).get("WORK_EXP_MIN")!=null?strLst.get(0).get("WORK_EXP_MIN").toString():null);
		jbpdm.setWorkExpmax(strLst.get(0).get("WORK_EXP_MAX")!=null?strLst.get(0).get("WORK_EXP_MAX").toString():null);
		jbpdm.setCtccurrency(strLst.get(0).get("CTC_CURRENCY")!=null?strLst.get(0).get("CTC_CURRENCY").toString():null);
		jbpdm.setCtcmin(strLst.get(0).get("CTC_MIN")!=null?strLst.get(0).get("CTC_MIN").toString():null);
		jbpdm.setCtcmax(strLst.get(0).get("CTC_MAX")!=null?strLst.get(0).get("CTC_MAX").toString():null);
		jbpdm.setOtherSalaryDetails(strLst.get(0).get("OTH_SAL_DETAILS")!=null?strLst.get(0).get("OTH_SAL_DETAILS").toString():null);
		jbpdm.setCompanyName(strLst.get(0).get("COMPANY_NAME")!=null?strLst.get(0).get("COMPANY_NAME").toString():null);
		jbpdm.setAboutCompany(strLst.get(0).get("ABOUT_COMPANY")!=null?strLst.get(0).get("ABOUT_COMPANY").toString():null);
		jbpdm.setCompanyWebsite(strLst.get(0).get("COMPANY_WEBSITE")!=null?strLst.get(0).get("COMPANY_WEBSITE").toString():null);
		jbpdm.setContactPerson(strLst.get(0).get("CONTACT_PERSON")!=null?strLst.get(0).get("CONTACT_PERSON").toString():null);
		jbpdm.setAddress(strLst.get(0).get("ADDRESS")!=null?strLst.get(0).get("ADDRESS").toString():null);
		jbpdm.setContactNumber(strLst.get(0).get("CONTACT_NUMBER")!=null?strLst.get(0).get("CONTACT_NUMBER").toString():null);
		jbpdm.setVenue(strLst.get(0).get("VENUE")!=null?strLst.get(0).get("VENUE").toString():null);
		jbpdm.setContactPerson1(strLst.get(0).get("CONTACTPERSON1")!=null?strLst.get(0).get("CONTACTPERSON1").toString():null);
		jbpdm.setResponseCode(strLst.get(0).get("RESPONSE_CODE")!=null?strLst.get(0).get("RESPONSE_CODE").toString():null);
		jbpdm.setTime(strLst.get(0).get("TIME")!=null?strLst.get(0).get("TIME").toString():null);
		jbpdm.setRefreshPeriod(strLst.get(0).get("REFRESH_PERIOD")!=null?strLst.get(0).get("REFRESH_PERIOD").toString():null);


        jbpdm.setTemplate(strLst.get(0).get("template_name")!=null?strLst.get(0).get("template_name").toString():null);
		jbpdm.setIndustryDetailsId(strLst.get(0).get("INDUSTRY_DETAILS_ID")!=null?Integer.parseInt(strLst.get(0).get("INDUSTRY_DETAILS_ID").toString()):null);
		jbpdm.setFunctionalDetailsId(strLst.get(0).get("FUNCTIONAL_DETAILS_ID")!=null?Integer.parseInt(strLst.get(0).get("FUNCTIONAL_DETAILS_ID").toString()):null);

		jbpdm.setJobid(strLst.get(0).get("JOBPOSTING_ID")!=null?Integer.parseInt(strLst.get(0).get("JOBPOSTING_ID").toString()):null);

		return jbpdm;
	}
	private String upda="update jobposting set job_title =? , numberof_vacancies=?,job_description=?,job_keywords=?,work_exp_min=?," +
			"work_exp_max=?,ctc_currency=?,ctc_min=?,ctc_max=?,oth_sal_details=?,location_of_job=?,city_id=?,industry_details_id=?,"+
			"functional_details_id=?,level_id=?,branch_id=?,ug_qualification=?,pg_qualification=?,company_name=?, about_company=?,"+
			"company_website=?,contact_person=?,address=?,contact_number=?,receive_responses_on=?,response_code=?,"
			+ "refresh_period=?,client_id=?, "+
			"date=?,time=?,venue=?,contactperson1=?,template_name=? where JOBPOSTING_ID=?";
	@Override
	public int updateJobposting(JobPostingDm jobpostingDm)
	{
		
	Object obj[]={jobpostingDm.getJobTitle(), jobpostingDm.getNumberofvacancies(), jobpostingDm.getJobDescription(),
			jobpostingDm.getKeywords(), jobpostingDm.getWorkExpmin(), jobpostingDm.getWorkExpmax(),
			jobpostingDm.getCtccurrency(), jobpostingDm.getCtcmin(), jobpostingDm.getCtcmax(),
			jobpostingDm.getOtherSalaryDetails(), jobpostingDm.getLocationOfJob(), jobpostingDm.getCityId(),
			jobpostingDm.getIndustryDetailsId(), jobpostingDm.getFunctionalDetailsId(), jobpostingDm.getLevelId(),
			jobpostingDm.getBranchId(), jobpostingDm.getUgqulification(),jobpostingDm.getPgqualification(),
			jobpostingDm.getCompanyName(), jobpostingDm.getAboutCompany(),
			jobpostingDm.getCompanyWebsite(), jobpostingDm.getContactPerson(), jobpostingDm.getAddress(),
			jobpostingDm.getContactNumber(), 
			jobpostingDm.getReceiveResponseson(), jobpostingDm.getResponseCode(),
			jobpostingDm.getRefreshPeriod(), jobpostingDm.getClientId(), jobpostingDm.getDate(),
			jobpostingDm.getTime(), jobpostingDm.getVenue(), jobpostingDm.getContactPerson1(),
			jobpostingDm.getTemplate(),jobpostingDm.getJobid()
			
	};
	int types[]={
			Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,
			Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,
			Types.INTEGER,Types.INTEGER,Types.INTEGER,Types.INTEGER,Types.INTEGER,
			Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,
			Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,
			Types.INTEGER,
			Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.INTEGER
	};
	
	for(int k=0;k<obj.length;k++ )
	{if(obj[k]!=null)
		if(obj[k].toString().equalsIgnoreCase("-1")|| obj[k].toString().equalsIgnoreCase(""))
			obj[k]=null;
		
	}
	
	int row = jdbcTemplateObject.update(upda,obj,types);
		return 0;
		
	}

}
