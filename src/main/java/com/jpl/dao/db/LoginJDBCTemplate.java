package com.jpl.dao.db;

import java.sql.Types;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jpl.dao.LoginDao;
import com.jpl.dao.db.mapper.LoginMapper;
import com.jpl.ui.model.LoginDm;

@Repository
public class LoginJDBCTemplate implements LoginDao {

	@Autowired
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplateObject;

	private static final String insertSql = "INSERT INTO LOGIN ("
			+ "LOGIN_ID, EMAIL_ID, PASSWORD)" + "VALUES (?, ?, ?)";

	@PostConstruct
	public void setJdbcTemplate() {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public List<LoginDm> listLoginTypes() {
		String SQL = "select * from login";
		List<LoginDm> loginList = jdbcTemplateObject.query(SQL,
				new LoginMapper());
		return loginList;
	}

	public void insertLogin(LoginDm LoginDm) {
		saveRecord(LoginDm.getEmailId(), LoginDm.getPassword());
	}

	private void saveRecord(String email_Id, String password) {
		Object[] params = new Object[] { email_Id, password };

		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR };

		int row = jdbcTemplateObject.update(insertSql, params, types);

	}

}
