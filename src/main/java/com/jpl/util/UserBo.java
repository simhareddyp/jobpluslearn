package com.jpl.util;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpl.dao.UserLoginDao;
import com.jpl.dao.UserDao;
import com.jpl.ui.model.UserLoginDm;
import com.jpl.ui.model.UserDm;

@Service
public class UserBo {
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserLoginDao loginDao;

	private List<UserDm> userList;

	private void initUser() {
		
		

		userList = userDao.listUserTypes();
	}

	@PostConstruct
	public void init() {
	
		initUser();
	}

	public List<UserDm> getUserList() {
		return userList;
	}

	public void insertUser(UserDm userDm) {
		userDao.insertUser(userDm);
	}

	public void insertLogin(UserLoginDm loginDm) {

		loginDao.selectUserLogin(loginDm);
	}

}
