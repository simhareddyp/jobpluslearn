package com.jpl.dao.db;

import java.sql.Types;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jpl.dao.PostLoginDao;
import com.jpl.dao.UserDao;
import com.jpl.ui.model.JobPostingDm;
import com.jpl.ui.model.PostLoginDm;
import com.jpl.ui.model.PostLoginProDm;
import com.jpl.ui.model.UserDm;

@Repository
public class PostLoginJDBCTemplate implements PostLoginDao {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	PostLoginDm postLoginDm = new PostLoginDm();
	PostLoginProDm postLoginproDm = new PostLoginProDm();

	@Autowired
	private UserDao userDao;
	String usersession;
	HttpServletRequest request;
	private static final String insertSQL = "INSERT INTO POSTLOGIN ("
			+ "RESUME_HEADLINE, PREFFERED_LOCATION,"
			+ "TOTAL_EXP_YEARS, TOTAL_EXP_MONTHS, ANNUAL_SALARY, LANDLINENO_ID,"
			+ "DATE_OF_BIRTH, ADDRESS, PINCODE, "
			+ "MARITAL_STATUS, USER1_ID, LEVEL_ID, BRANCH_ID, UNIVERSITY_ID, "
			+ "START_DATE1, END_DATE1, UG_STUDYTYPE, PG_STUDYTYPE)"
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String insertSQL1 = "UPDATE POSTLOGIN SET "
			+ "RESUME_HEADLINE = ?, PREFFERED_LOCATION = ?, TOTAL_EXP_YEARS = ?, "
			+ "TOTAL_EXP_MONTHS = ?,"
			+ "ANNUAL_SALARY = ?, LANDLINENO_ID = ?,"
			+ "DATE_OF_BIRTH = ?, ADDRESS = ?,"
			+ " PINCODE = ?,"
			+ " MARITAL_STATUS = ?, USER1_ID = ?, LEVEL_ID = ?, BRANCH_ID = ?, UNIVERSITY_ID = ?, START_DATE1 = ?, "
			+ " END_DATE1 = ?, UG_STUDYTYPE = ?, PG_STUDYTYPE = ?  WHERE USER1_ID ='";

	@PostConstruct
	public void setJdbcTemplate() {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void insertPostLogin(PostLoginDm postLoginDm) {
		if (postloginuserexist(postLoginDm.getUserDm().getUser1Id())) {
			postUpdate(postLoginDm);
		} else {

			saveRecord(postLoginDm.getResumeHeadline(),
					postLoginDm.getPrefferedLocation(),
					postLoginDm.getTotalExpYears(),
					postLoginDm.getTotalExpMonths(),
					postLoginDm.getAnnualSalary(),
					postLoginDm.getLandlinenoId(),
					postLoginDm.getDateOfBirth(), postLoginDm.getAddress(),
					postLoginDm.getPincode(), postLoginDm.getMaritalStatus(),
					postLoginDm.getUserDm().getUser1Id(),
					postLoginDm.getLevelId(), postLoginDm.getBranchId(),
					postLoginDm.getUniversityId(), postLoginDm.getStartDate1(),
					postLoginDm.getEndDate1(), postLoginDm.getUgStudytype(),
					postLoginDm.getPgStudytype());
		}
	}

	private void saveRecord(String resumeHeadline, String prefferedLocation,
			String totalExpYears, String totalExpMonths, String annualSalary,
			Integer landlinenoId, String dateOfBirth, String address,
			Integer pincode, String maritalStatus, Integer user1Id,
			Integer uglevelId, Integer ugbranchId, Integer uguniversityId,
			String startDate1, String endDate1, Integer ugStudytype,
			Integer pgStudytype) {

		Object[] params = new Object[] { resumeHeadline, prefferedLocation,
				totalExpYears, totalExpMonths, annualSalary, landlinenoId,
				dateOfBirth, address, pincode, maritalStatus, user1Id,
				uglevelId, ugbranchId, uguniversityId, startDate1, endDate1,
				ugStudytype, pgStudytype };

		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
				Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.VARCHAR,
				Types.VARCHAR, Types.INTEGER, Types.VARCHAR, Types.INTEGER,
				Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.VARCHAR,
				Types.VARCHAR, Types.INTEGER, Types.INTEGER };

		int row = 0;

		row = jdbcTemplateObject.update(insertSQL, params, types);
			}

	private boolean postloginuserexist(int user1id) {

		String insertSQL2 = "SELECT USER1_ID FROM POSTLOGIN WHERE USER1_ID = '"
				+ user1id + "'";
		List<Map<String, Object>> strLst = this.jdbcTemplateObject
				.queryForList(insertSQL2);
		if (strLst.size() == 0)
			return false;
		return true;
	}

	public UserDm getUserDm(String emailId) {
		UserDm userdm = new UserDm();
		String getuserdmdb = "SELECT FIRST_NAME, LAST_NAME,"
				+ " USER1_ID, STATE_ID, CITY_ID,"
				// + " INDUSTRY_DETAILS_ID, FUNCTIONAL_DETAILS_ID, "
				+ "MOBILE_NUMBER, GENDER_ID, SKILLS, LEVEL_ID, BRANCH_ID, UNIVERSITY_ID, "
				+ "START_DATE, END_DATE FROM USER1 WHERE EMAIL_ID= '" + emailId
				+ "'";
		List<Map<String, Object>> strLst = this.jdbcTemplateObject
				.queryForList(getuserdmdb);
		userdm.setFirstName(strLst.get(0).get("FIRST_NAME").toString());
		return null;
	}

	@Override
	public String getUserCity(Integer cityId) {
		String citysql = "SELECT CITY_NAME, CITY_ID FROM CITY WHERE CITY_ID = '"
				+ cityId + "'";
		List<Map<String, Object>> strLst = this.jdbcTemplateObject
				.queryForList(citysql);
		return strLst.get(0).get("CITY_NAME").toString();
	}

	private static final String insertSQL2 = "INSERT INTO POSTLOGINPRO ("
			+ "DOMAIN, ADD_DOMAIN,"
			+ "NOTICE_PERIOD, AVAILABLE_DATE, OFFERS, CTCOFFERED_LAKHS, "
			+ "CTCOFFERED_THOUSANDS, EXPECTEDCTC_LAKHS, EXPECTEDCTC_THOUSANDS, "
			+ "TITLE_ID, EMPLOYER_NAME, EMPLOYER_TYPE, "
			+ "DURATIONMONTHS_FROM, DURATIONYEARS_FROM, DURATIONMONTHS_TO, DURATIONYEARS_TO, "
			+ "DESIGNATION, ACHIEVEMENTS, SMS,"
			//+ " EMAIL, AUTOMATIC, EXP, KEY, KEY_TYPE,"
			//+ " CHEDOMAIN, ROLE, "
			+ "VISIBILITY_TYPE, SEARCH)"
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			//+ " ?, ?, ?, ?, ?, ?, ?)";

	@Override
	public void insertPostLoginPro(PostLoginProDm postloginproDm) {

		saveRecord(postloginproDm.getDomain(), postloginproDm.getAddDomain(),
				postloginproDm.getNoticePeriod(),
				postloginproDm.getAvailableDate(), postloginproDm.getOffers(),
				postloginproDm.getCtcOfferedLakhs(),
				postloginproDm.getCtcOfferedThousands(),
				postloginproDm.getExpectedCtcLakhs(),
				postloginproDm.getExpectedCtcThousands(),
				postloginproDm.getTitleId(), postloginproDm.getEmployerName(),
				postloginproDm.getEmployerType(),
				postloginproDm.getDurationMonthsFrom(),
				postloginproDm.getDurationYearsFrom(),
				postloginproDm.getDurationMonthsTo(),
				postloginproDm.getDurationYearsTo(),
				postloginproDm.getDesignation(),
				postloginproDm.getAchievements(),
				postloginproDm.getSms(),
				/**postloginproDm.getEmail(), postloginproDm.getAutomatic(),
				postloginproDm.getExp(), postloginproDm.getKey(),
				postloginproDm.getKeyType(), postloginproDm.getChedomain(),
				postloginproDm.getRole(),*/ 
				postloginproDm.getVisibilityType(), postloginproDm.getSearch());

	}

	private void saveRecord(String domain, String addDomain,
			String noticePeriod, String availableDate, Integer offers,
			String ctcOfferedLakhs, String ctcOfferedThousands,
			String expectedCtcLakhs, String expectedCtcThousands,
			Integer titleId, String employerName, String employerType,
			String durationMonthsFrom, String durationYearsFrom,
			String durationMonthsTo, String durationYearsTo,
			String designation, String achievements,
			String sms,
			/**String email,
			String automatic, String exp, String key, String keyType,
			String chedomain, String role,*/
			String visibilityType, String search) {

		Object[] params = new Object[] { domain, addDomain, noticePeriod,
				availableDate, offers, ctcOfferedLakhs, ctcOfferedThousands,
				expectedCtcLakhs, expectedCtcThousands, titleId, employerName,
				employerType, durationMonthsFrom, durationYearsFrom,
				durationMonthsTo, durationYearsTo, designation, achievements, sms, 
				//email, automatic, exp, key, keyType, chedomain, role,
				visibilityType, search };

		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
				Types.VARCHAR, Types.INTEGER, Types.VARCHAR, Types.VARCHAR,
				Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.VARCHAR,
				Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
				Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
				//Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
				//Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, 
				Types.VARCHAR, Types.VARCHAR };
		
		int row = jdbcTemplateObject.update(insertSQL2, params, types);
		
	}

	public void postUpdate(PostLoginDm postloginDm) {
		saveRecord1(postloginDm.getResumeHeadline(),
				postloginDm.getPrefferedLocation(),
				postloginDm.getTotalExpYears(),
				postloginDm.getTotalExpMonths(), postloginDm.getAnnualSalary(),
				postloginDm.getLandlinenoId(), postloginDm.getDateOfBirth(),
				postloginDm.getAddress(), postloginDm.getPincode(),
				postloginDm.getMaritalStatus(), postloginDm.getUserDm()
						.getUser1Id(), postloginDm.getLevelId(),
				postloginDm.getBranchId(), postloginDm.getUniversityId(),
				postloginDm.getStartDate1(), postloginDm.getEndDate1(),
				postloginDm.getUgStudytype(), postloginDm.getPgStudytype());

	}

	private void saveRecord1(String resumeHeadline, String prefferedLocation,
			String totalExpYears, String totalExpMonths, String annualSalary,
			Integer landlinenoId, String dateOfBirth, String address,
			Integer pincode, String maritalStatus, Integer user1Id,
			Integer uglevelId, Integer ugbranchId, Integer uguniversityId,
			String startDate1, String endDate1, Integer ugStudytype,
			Integer pgStudytype) {

		Object[] params = new Object[] { resumeHeadline, prefferedLocation,
				totalExpYears, totalExpMonths, annualSalary, landlinenoId,
				dateOfBirth, address, pincode, maritalStatus, user1Id,
				uglevelId, ugbranchId, uguniversityId, startDate1, endDate1,
				ugStudytype, pgStudytype };

		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
				Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.VARCHAR,
				Types.VARCHAR, Types.INTEGER, Types.VARCHAR, Types.INTEGER,
				Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.VARCHAR,
				Types.VARCHAR, Types.INTEGER, Types.INTEGER };

		int row1 = jdbcTemplateObject.update(insertSQL1 + user1Id + "'",
				params, types);
	
	}
	
	private static final String selectcompany = "select "
			+ "search, company_name, employer_name from postloginpro where search='";

	@Override
	public PostLoginProDm getcompany(String search) {
		PostLoginProDm pldm = new PostLoginProDm();
		String SQL = selectcompany + search + "'";
		List<Map<String, Object>> strLst = this.jdbcTemplateObject.queryForList(SQL);
		pldm.getCompanyDetailsDm().setCompanyName(strLst.get(0).get("COMPANY_NAME").toString());
		pldm.setSearch(strLst.get(0).get("SEARCH").toString());
		pldm.setEmployerName(strLst.get(0).get("EMPLOYER_NAME").toString());
		return pldm;
	}

}
