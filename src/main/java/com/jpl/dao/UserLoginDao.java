package com.jpl.dao;

import java.util.List;

import com.jpl.ui.model.UserLoginDm;

public interface UserLoginDao {
	public List<UserLoginDm> listLoginTypes();

	public void selectUserLogin(UserLoginDm userLoginDm);
}
