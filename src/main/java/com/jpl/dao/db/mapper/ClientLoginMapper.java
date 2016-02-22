package com.jpl.dao.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jpl.ui.model.ClientLoginDm;

public class ClientLoginMapper implements RowMapper<ClientLoginDm> {
	public ClientLoginDm mapRow(ResultSet rs, int rowNum) throws SQLException {

		ClientLoginDm clientloginDm = new ClientLoginDm();
		clientloginDm.setEmailId(rs.getString("email_Id"));
		clientloginDm.setPassword(rs.getString("password"));
		clientloginDm.setClientId(rs.getInt("client_Id"));

		
		return clientloginDm;
	}


}
