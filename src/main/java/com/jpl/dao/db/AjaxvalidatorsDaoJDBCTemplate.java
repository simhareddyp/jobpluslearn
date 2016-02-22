package com.jpl.dao.db;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jpl.dao.AjaxvalidatorsDao;
@Repository
public class AjaxvalidatorsDaoJDBCTemplate implements AjaxvalidatorsDao {
	
	
	@Autowired
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplateObject;
	@PostConstruct
	public void setJdbcTemplate() {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	@Override
	public boolean IsMobileexist(String mobile,String typeofuser) {
		String SQL = null;
		if(typeofuser.equalsIgnoreCase("client" ))
		 SQL = "select contact_Number from client"
				+ " where contact_Number='" + mobile + "'";
		else
			SQL = "select mobile_number from user"
					+ " where mobile_number='" + mobile + "'";
		List<Map<String, Object>> strLst = this.jdbcTemplateObject
				.queryForList(SQL);
				if (strLst.isEmpty())
			return false;
		return true;

	}
	
@Override
public boolean IsEmailexist(String email, String typeofuser) {
	String SQL = null;
	
	if(typeofuser.equalsIgnoreCase("client" ))
	SQL = "select email_id from client" + " where email_id='"
			+ email + "'";
	else
		SQL = "select email_id from user" + " where email_id='"
				+ email + "'";
	
	List<Map<String, Object>> strLst = this.jdbcTemplateObject
			.queryForList(SQL);
	if (strLst.isEmpty())
		return false;
	return true;

}
}
