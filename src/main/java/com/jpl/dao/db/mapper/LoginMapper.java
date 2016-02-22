package com.jpl.dao.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jpl.ui.model.LoginDm;

public class LoginMapper implements RowMapper<LoginDm> {

	public LoginDm mapRow(ResultSet rs, int rowNum) throws SQLException {

		LoginDm loginDm = new LoginDm();
		loginDm.setEmailId(rs.getString("email_Id"));
		loginDm.setPassword(rs.getString("password"));
		return loginDm;
	}

}
