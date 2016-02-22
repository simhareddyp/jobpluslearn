package com.jpl.dao;

import java.util.List;

import com.jpl.ui.model.ClientLoginDm;

public interface ClientLoginDao {
	public List<ClientLoginDm> listLoginTypes();

	public void selectClient(ClientLoginDm clientLoginDm);

	public int IsPasswordMatches(String email, String password);

}
