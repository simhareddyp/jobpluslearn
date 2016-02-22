package com.jpl.dao.db;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jpl.dao.ClientDao;
import com.jpl.ui.model.ClientDm;
import com.jpl.ui.model.CompanyDetailsDm;

@Repository
public class ClientJDBCTemplate implements ClientDao {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	private static final String insertSQL = "INSERT INTO CLIENT ("
			+ "EMAIL_ID, PASSWORD, CLIENT_TYPE,INDUSTRY_DETAILS_ID, CLIENT_NAME, "
			+ "WEBSITE, ADDRESS1, ADDRESS2, ADDRESS3, CITY_ID, STATE_ID, "
			+ "COUNTRY_ID, PINCODE, CONTACT_PERSON, CONTACT_NUMBER, LANDLINENO_ID, TOKEN_ID, ISAUTH, STATUS, CREATED_BY, COMPANY_NAME )"
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

	private static final String insertcompany = "INSERT INTO COMPANY_DETAILS ("
			+ "CLIENT_TYPE, COMPANY_NAME, "
			+ "ADDRESS1, ADDRESS2, ADDRESS3, CLIENT_ID )"
			+ "VALUES (?, ?, ?, ?, ?, ?)";

	@PostConstruct
	public void setJdbcTemplate() {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void insertClient(ClientDm clientDm) {
		this.jdbcTemplateObject.update(insertSQL, clientDm.getEmailId(),
				clientDm.getPassword(), clientDm.getClientType(),
				clientDm.getIndustryDetailsId(), clientDm.getClientName(),
				clientDm.getWebsite(), clientDm.getCompanyDetailsDm().getAddrLine1(),
				clientDm.getCompanyDetailsDm().getAddrLine2(), clientDm.getCompanyDetailsDm().getAddrLine3(),
				clientDm.getCityId(), clientDm.getStateId(), 1,
				clientDm.getPincode(), clientDm.getContactPerson(),

				clientDm.getContactNumber(), clientDm.getLandlinenoId(),
				clientDm.getTokenId(), clientDm.getIsAuth(),

				"N", "JPL_WEB", clientDm.getCompanyDetailsDm().getCompanyName());

	}

	public boolean IsEmailexist(String email) {
		String SQL = "select email_id from client" + " where email_id='"
				+ email + "'";
		List<Map<String, Object>> strLst = this.jdbcTemplateObject
				.queryForList(SQL);
		if (strLst.isEmpty())
			return false;
		return true;

	}

	public boolean IsMobileexist(String mobile) {
		String SQL = "select contact_Number from client"
				+ " where contact_Number='" + mobile + "'";
		List<Map<String, Object>> strLst = this.jdbcTemplateObject
				.queryForList(SQL);
		if (strLst.isEmpty())
			return false;
		return true;

	}

	public int updateToken(String token, String email_id) {
		String SQL = "update client set token_id='" + token + "'"
				+ " where email_id='" + email_id + "'";
		this.jdbcTemplateObject.update(SQL);
		return 0;
	}

	public int updateIsAuth(String token_id) {
		String SQL = "update client set isAuth='Y'" + " where token_id='"
				+ token_id + "'";
		this.jdbcTemplateObject.update(SQL);
		return 0;
	}

	public boolean IsEmailexistinDB(String email) {
		String SQL = "select email_id from client" + " where email_id='"
				+ email + "'";
		List<Map<String, Object>> strLst = this.jdbcTemplateObject
				.queryForList(SQL);
		if (strLst.isEmpty())
			return true;
		return false;

	}

	@Override
	public boolean IsMobileexistinDB(String mobile) {
		String SQL = "select contact_number from client"
				+ " where mobile_number='" + mobile + "'";
		List<Map<String, Object>> strLst = this.jdbcTemplateObject
				.queryForList(SQL);
		if (strLst.isEmpty())
			return true;
		return false;
	}

	@Override
	public ClientDm getclientdmbyname(String clientName) {
		String getclientdmdb = "SELECT EMAIL_ID FROM CLIENT WHERE CLIENT_NAME= '"
				+ clientName + "'";
		List<Map<String, Object>> strLst = this.jdbcTemplateObject
				.queryForList(getclientdmdb);
		ClientDm cldm = new ClientDm();
		return cldm;
	}

	@Override
	public void insertCompany(CompanyDetailsDm companyDetailsDm) {
		this.jdbcTemplateObject
				.update(insertcompany, companyDetailsDm.getClientType(),
						companyDetailsDm.getCompanyName(), companyDetailsDm.getAddrLine1(),
						companyDetailsDm.getAddrLine2(), companyDetailsDm.getAddrLine3(),
						companyDetailsDm.getClientId());
	}

	@Override
	public int getClientIddb(String emailId) {
		String getclientdb = "SELECT CLIENT_ID, EMAIL_ID "
				+ "FROM CLIENT WHERE EMAIL_ID= '" + emailId + "'";
		List<Map<String, Object>> strLst = this.jdbcTemplateObject
				.queryForList(getclientdb);
		System.out.println("client id in CJDBCTmplate is "
				+ Integer.parseInt(strLst.get(0).get("CLIENT_ID").toString()));
		return Integer.parseInt(strLst.get(0).get("CLIENT_ID").toString());

	}

}