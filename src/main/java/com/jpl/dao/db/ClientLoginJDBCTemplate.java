package com.jpl.dao.db;

import java.sql.Types;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jpl.dao.ClientLoginDao;
import com.jpl.dao.db.mapper.ClientLoginMapper;
import com.jpl.ui.model.ClientLoginDm;

@Repository
public class ClientLoginJDBCTemplate implements ClientLoginDao {

	@Autowired
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplateObject;

	private static final String selectSql = "SELECT EMAIL_ID, PASSWORD, CLIENT_ID FROM CLIENT"
			+ " WHERE EMAIL_ID ='";
		@PostConstruct
	public void setJdbcTemplate() {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public List<ClientLoginDm> listLoginTypes() {
		String SQL = "select * from client";
		List<ClientLoginDm> loginList = jdbcTemplateObject.query(SQL,
				new ClientLoginMapper());
		return loginList;
	}

	

	public void selectClient(ClientLoginDm clientLoginDm) {
		
		
	}

	
	  public void insertLogin(ClientLoginDm clientLoginDm) {
	 saveRecord(clientLoginDm.getEmailId(), clientLoginDm.getPassword(), clientLoginDm.getClientId());
	 
	 }
	  public int IsPasswordMatches(String email, String password) {
			List<Map<String, Object>> strLst =null;
			if (email.length() != 0) {

				String SQL = "select password,isAuth,client_Id from client"
						+ " where email_id='" + email + "'";

				 strLst = this.jdbcTemplateObject
						.queryForList(SQL);
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
			return Integer.parseInt(strLst.get(0).get("client_Id").toString());
		}
	

	
	 private void saveRecord(String email_Id, String password, Integer client_Id) { Object[]
	 params = new Object[] { email_Id, password, client_Id };
	 
	 int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.INTEGER };
	 
	 int row = jdbcTemplateObject.update(selectSql, params, types);
	
	  
	  }
	

}
