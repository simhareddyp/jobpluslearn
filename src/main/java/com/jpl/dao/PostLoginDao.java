package com.jpl.dao;

import com.jpl.ui.model.PostLoginDm;
import com.jpl.ui.model.PostLoginProDm;
import com.jpl.ui.model.UserDm;

public interface PostLoginDao {
	public void insertPostLogin(PostLoginDm postloginDm);

	public UserDm getUserDm(String emailId);

	public String getUserCity(Integer cityId);

	public void insertPostLoginPro(PostLoginProDm postloginproDm);

	public void postUpdate(PostLoginDm postloginDm);

	public PostLoginProDm getcompany(String search);

}
