package com.jpl.dao.db;

import java.sql.Types;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jpl.dao.UserDao;
import com.jpl.ui.model.UserDm;

@Repository
public class UserJDBCTemplate implements UserDao {
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	private static final String insertSQL = "INSERT INTO USER1 ("
			+ "FIRST_NAME, LAST_NAME, EMAIL_ID, USER_NAME, PASSWORD, "
			+ "MOBILE_NUMBER, GENDER_ID, NATIONALITY_ID,"
			// COUNTRY_ID, "
			+ "STATE_ID, CITY_ID, LEVEL_ID, BRANCH_ID, UNIVERSITY_ID, "
			+ "COLLEGE_ID, START_DATE, END_DATE, MARKS, SKILLS, EXPERIENCE, "
			+ "INDUSTRY_DETAILS_ID, FUNCTIONAL_DETAILS_ID, TITLE_ID, TOKEN_ID, ISAUTH)"
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	public UserJDBCTemplate() {

	}

	@PostConstruct
	public void setJdbcTemplate() {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void insertUser(UserDm userDm) {
		saveRecord(
				userDm.getFirstName(),
				userDm.getLastName(),
				userDm.getEmailId(),
				userDm.getUserName(),
				userDm.getPassword(),
				userDm.getMobileNumber(),
				userDm.getGenderId(),
				userDm.getNationalityId(),
				// userDm.getCountryId(),
				userDm.getStateId(), userDm.getCityId(), userDm.getLevelId(),
				userDm.getBranchId(), userDm.getUniversityId(),
				userDm.getCollegeId(), userDm.getStartDate(),
				userDm.getEndDate(), userDm.getMarks(), userDm.getSkills(),
				userDm.getExperience(), userDm.getIndustryDetailsId(),
				userDm.getFunctionalDetailsId(), userDm.getTitleId(),
				userDm.getTokenId(), userDm.getIsAuth());
	}

	private void saveRecord(String firstName, String lastName, String email_Id,
			String userName,
			String password,
			String mobileNumber,
			Integer genderId,
			Integer nationalityId,
			// Integer countryId,
			Integer stateId, Integer cityId, Integer levelId, Integer branchId,
			Integer universityId, Integer collegeId, String startDate,
			String endDate, String marks, String skills, String experience,
			Integer industryDetailsId, Integer functionalDetailsId,
			Integer titleId, String tokenId, String isAuth) {

		Object[] params = new Object[] { firstName, lastName, email_Id,
				userName, password, mobileNumber,
				genderId,
				nationalityId,
				// countryId,
				stateId, cityId, levelId, branchId, universityId, collegeId,
				startDate, endDate, marks, skills, experience,
				industryDetailsId, functionalDetailsId, titleId, tokenId,
				isAuth };

		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
				Types.VARCHAR, Types.VARCHAR,
				Types.VARCHAR,
				Types.INTEGER,
				Types.INTEGER,
				// Types.INTEGER,
				Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER,
				Types.INTEGER, Types.INTEGER, Types.VARCHAR, Types.VARCHAR,
				Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER,
				Types.INTEGER, Types.INTEGER, Types.VARCHAR, Types.VARCHAR };

		int row = jdbcTemplateObject.update(insertSQL, params, types);

	}

	public List<UserDm> listUserTypes() {
		return null;
	}

	public boolean IsEmailexist(String email) {
		String SQL = "select email_id from user1" + " where email_id='" + email
				+ "'";
		List<Map<String, Object>> strLst = this.jdbcTemplateObject
				.queryForList(SQL);
		if (strLst.isEmpty())
			return false;
		return true;

	}

	public boolean IsEmailexistinDB(String email) {
		String SQL = "select email_id from user1" + " where email_id='" + email
				+ "'";
		List<Map<String, Object>> strLst = this.jdbcTemplateObject
				.queryForList(SQL);
		if (strLst.isEmpty())
			return true;
		return false;

	}

	public boolean IsMobileexist(String mobile) {
		String SQL = "select mobile_Number from user1"
				+ " where mobile_Number='" + mobile + "'";
		List<Map<String, Object>> strLst = this.jdbcTemplateObject
				.queryForList(SQL);
		if (strLst.isEmpty())
			return false;
		return true;

	}

	public int updateToken(String token, String email_id) {
		String SQL = "update user1 set token_id='" + token + "'"
				+ " where email_id='" + email_id + "'";
		this.jdbcTemplateObject.update(SQL);
		return 0;
	}

	public int updateIsAuth(String token_id) {
		String SQL = "update user1 set isAuth='Y'" + " where token_id='"
				+ token_id + "'";
		this.jdbcTemplateObject.update(SQL);

		return 0;
	}

	public int IsPasswordMatches(String email, String password) {
		List<Map<String, Object>> strLst = null;
		if (email.length() != 0) {

			String SQL = "select password,isAuth,user1_id from user1"
					+ " where email_id='" + email + "'";

			strLst = this.jdbcTemplateObject.queryForList(SQL);
			if (strLst.size() == 0)

			{

				return -1;
			}

			else if (!password.equals(strLst.get(0).get("password"))) {
				return -2;
			} else if (strLst.get(0).get("isAuth") == null
					|| !strLst.get(0).get("isAuth").toString()
							.equalsIgnoreCase("Y")) {

				return -3;
			}
		}
		return Integer.parseInt(strLst.get(0).get("user1_id").toString());
	}

	public boolean IsUsernameexist(String userName) {
		String SQL = "select user_name from user1" + " where user_name='"
				+ userName + "'";
		List<Map<String, Object>> strLst = this.jdbcTemplateObject
				.queryForList(SQL);
		if (strLst.isEmpty())
			return false;
		return true;

	}

	private static final String insertSQL1 = "UPDATE USER1 SET "
			+ "FIRST_NAME = ?, LAST_NAME = ?, STATE_ID = ?, " + "CITY_ID = ?,"
			+ "MOBILE_NUMBER = ?, GENDER_ID = ?," + "SKILLS = ?, LEVEL_ID = ?,"
			+ " BRANCH_ID = ?, UNIVERSITY_ID = ?, START_DATE = ?,"
			+ " END_DATE = ?  WHERE EMAIL_ID ='";

	@Override
	public void userUpdate(UserDm userDm) {
				saveRecord(
				userDm.getFirstName(),
				userDm.getLastName(),
				userDm.getStateId(),
				userDm.getCityId(),
				// userDm.getIndustryDetailsId(),
				// userDm.getFunctionalDetailsId(),
				userDm.getMobileNumber(), userDm.getGenderId(),
				userDm.getSkills(), userDm.getLevelId(), userDm.getBranchId(),
				userDm.getUniversityId(), userDm.getStartDate(),
				userDm.getEndDate(), userDm.getEmailId());
	}

	private void saveRecord(String firstName, String lastName,
			Integer stateId,
			Integer cityId,
			// Integer industryDetailsId, Integer functionalDetailsId,
			String mobileNumber, Integer genderId, String skills,
			Integer levelId, Integer branchId, Integer universityId,
			String startDate, String endDate, String emailId) {
		Object[] params = new Object[] { firstName, lastName, stateId, cityId,
				// industryDetailsId, functionalDetailsId,
				mobileNumber, genderId, skills, levelId, branchId,
				universityId, startDate, endDate };
		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.INTEGER,
				Types.INTEGER,
				// Types.INTEGER, Types.INTEGER,
				Types.VARCHAR, Types.INTEGER, Types.VARCHAR, Types.INTEGER,
				Types.INTEGER, Types.INTEGER, Types.VARCHAR, Types.VARCHAR };

		int row = jdbcTemplateObject.update(insertSQL1 + emailId + "'", params,
				types);
		
	}

	@Override
	public UserDm getuserdmbyemail(String email) {
		String getuserdmdb = "SELECT FIRST_NAME, LAST_NAME,"
				+ "USER1_ID, EMAIL_ID, STATE_ID, CITY_ID,"
				// + " INDUSTRY_DETAILS_ID, FUNCTIONAL_DETAILS_ID, "
				+ "MOBILE_NUMBER, GENDER_ID, SKILLS, LEVEL_ID, BRANCH_ID, UNIVERSITY_ID, "
				+ "START_DATE, END_DATE FROM USER1 WHERE EMAIL_ID= '" + email
				+ "'";
		List<Map<String, Object>> strLst = this.jdbcTemplateObject
				.queryForList(getuserdmdb);
				UserDm usdm = new UserDm();
		usdm.setUser1Id((Integer) strLst.get(0).get("USER1_ID"));

		usdm.setFirstName(strLst.get(0).get("FIRST_NAME").toString());
		usdm.setLastName(strLst.get(0).get("LAST_NAME").toString());

		usdm.setStateId((Integer) strLst.get(0).get("STATE_ID"));
		usdm.setCityId((Integer) strLst.get(0).get("CITY_ID"));
		usdm.setEmailId(strLst.get(0).get("EMAIL_ID").toString());
		/**
		 * usdm.setIndustryDetailsId((Integer) strLst.get(0).get(
		 * "INDUSTRY_DETAILS_ID")); usdm.setFunctionalDetailsId((Integer)
		 * strLst.get(0).get( "FUNCTIONAL_DETAILS_ID"));
		 */
		usdm.setMobileNumber(strLst.get(0).get("MOBILE_NUMBER").toString());
		usdm.setGenderId((Integer) strLst.get(0).get("GENDER_ID"));
		usdm.setSkills(strLst.get(0).get("SKILLS").toString());
		usdm.setLevelId((Integer) strLst.get(0).get("LEVEL_ID"));
		usdm.setBranchId((Integer) strLst.get(0).get("BRANCH_ID"));
		usdm.setUniversityId((Integer) strLst.get(0).get("UNIVERSITY_ID"));
		usdm.setStartDate(strLst.get(0).get("START_DATE").toString());
		usdm.setEndDate(strLst.get(0).get("END_DATE").toString());

		return usdm;
	}
}