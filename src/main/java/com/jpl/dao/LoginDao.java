package com.jpl.dao;

import java.util.List;

import com.jpl.ui.model.LoginDm;

public interface LoginDao {
	public List<LoginDm> listLoginTypes();

	public void insertLogin(LoginDm loginDm);
}
