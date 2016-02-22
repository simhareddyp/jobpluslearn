package com.jpl.dao.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jpl.ui.model.UserDm;

public class UserMapper implements RowMapper<UserDm> {

	public UserDm mapRow(ResultSet rs, int rowNum) throws SQLException {

		UserDm userDm = new UserDm();
		userDm.setFirstName(rs.getString("firstName"));
		userDm.setLastName(rs.getString("lastName"));
		userDm.setEmailId(rs.getString("emailId"));
		userDm.setUserName(rs.getString("userName"));
		userDm.setPassword(rs.getString("password"));
		userDm.setReEnterPassword(rs.getString("reEnterPassword"));

		userDm.setMobileNumber(rs.getString("mobileNumber"));
		userDm.setGenderId(rs.getInt("genderId"));
		userDm.setNationalityId(rs.getInt("nationalityId"));
		userDm.setStateId(rs.getInt("stateId"));
		// userDm.setCityName(rs.getString("cityName"));
		userDm.setCityId(rs.getInt("cityId"));

		userDm.setLevelId(rs.getInt("levelId"));
		userDm.setBranchId(rs.getInt("branchId"));
		userDm.setUniversityId(rs.getInt("universityId"));
		userDm.setCollegeId(rs.getInt("collegeId"));

		userDm.setStartDate(rs.getString("startDate"));
		userDm.setEndDate(rs.getString("endDate"));
		// userDm.setMarks(rs.getString("marks"));

		userDm.setSkills(rs.getString("skills"));
		userDm.setExperience(rs.getString("experience"));
		userDm.setIndustryDetailsId(rs.getInt("industryDetailsId"));
		userDm.setFunctionalDetailsId(rs.getInt("functionalDetailsId"));
		userDm.setTitleId(rs.getInt("titleId"));

		return userDm;

	}
}
