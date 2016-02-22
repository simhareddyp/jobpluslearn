package com.jpl.util;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpl.dao.UserLoginDao;
import com.jpl.ui.model.UserLoginDm;

@Service
public class UserLoginBo {

	@Autowired
	private UserLoginDao loginDao;

	private List<UserLoginDm> loginList;

	private void initLogin() {
		

		loginList = loginDao.listLoginTypes();
	}

	@PostConstruct
	public void init() {
			initLogin();
	}

	public List<UserLoginDm> getLoginList() {
		return loginList;
	}

	public void insertLogin(UserLoginDm loginDm) {

		loginDao.selectUserLogin(loginDm);
	}
}
