package com.jpl.util;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpl.dao.LoginDao;
import com.jpl.ui.model.LoginDm;

@Service
public class LoginBo {

	@Autowired
	private LoginDao loginDao;

	private List<LoginDm> loginList;

	private void initLogin() {
		

		loginList = loginDao.listLoginTypes();
	}

	@PostConstruct
	public void init() {
			initLogin();
	}

	public List<LoginDm> getLoginList() {
		return loginList;
	}

	public void insertLogin(LoginDm loginDm) {

		loginDao.insertLogin(loginDm);
	}
}
