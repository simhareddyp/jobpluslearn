package com.jpl.dao.db;

import java.sql.Types;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jpl.dao.UserLoginDao;
import com.jpl.dao.db.mapper.UserLoginMapper;
import com.jpl.ui.model.UserLoginDm;

@Repository
public class UserLoginJDBCTemplate implements UserLoginDao {

	@Autowired
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplateObject;

	private static final String selectSql = "SELECT EMAIL_ID, PASSWORD, USER1_ID user1id FROM User1";

	@PostConstruct
	public void setJdbcTemplate() {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public List<UserLoginDm> listLoginTypes() {
		String SQL = "select EMAIL_ID, PASSWORD, USER1_ID user1id  from user1";
		List<UserLoginDm> userLoginList = jdbcTemplateObject.query(SQL,
				new UserLoginMapper());
		return userLoginList;
	}

	public void selectUserLogin(UserLoginDm userLoginDm) {
		saveRecord(userLoginDm.getEmailId(), userLoginDm.getPassword(),
				userLoginDm.getUser1Id());
	}

	private void saveRecord(String email_Id, String password, Integer user1Id) {
		Object[] params = new Object[] { email_Id, password, user1Id };

		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.INTEGER };

		int row = jdbcTemplateObject.update(selectSql, params, types);
	}

}
