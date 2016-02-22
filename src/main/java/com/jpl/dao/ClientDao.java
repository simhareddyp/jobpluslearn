package com.jpl.dao;

import com.jpl.ui.model.ClientDm;
import com.jpl.ui.model.CompanyDetailsDm;

public interface ClientDao {

	/**
	 * This is the method to be used to insert a new record in client table
	 */
	public void insertClient(ClientDm objClientDm);

	public boolean IsMobileexist(String mobile);

	public int updateToken(String token, String email_id);

	public int updateIsAuth(String token_id);

	public boolean IsEmailexistinDB(String email);

	boolean IsMobileexistinDB(String mobile);

	public ClientDm getclientdmbyname(String clientName);

	public void insertCompany(CompanyDetailsDm companyDetailsDm);

	public int getClientIddb(String emailId);

}
