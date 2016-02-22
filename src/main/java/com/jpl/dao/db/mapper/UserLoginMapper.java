package com.jpl.dao.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jpl.ui.model.UserLoginDm;

public class UserLoginMapper implements RowMapper<UserLoginDm> {

	public UserLoginDm mapRow(ResultSet rs, int rowNum) throws SQLException {

		UserLoginDm userLoginDm = new UserLoginDm();
		userLoginDm.setEmailId(rs.getString("email_Id"));
		userLoginDm.setPassword(rs.getString("password"));
		userLoginDm.setUser1Id(rs.getInt("user1Id"));
		return userLoginDm;
	}

}
