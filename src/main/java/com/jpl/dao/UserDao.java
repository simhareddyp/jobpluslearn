package com.jpl.dao;

import java.util.List;

import com.jpl.ui.model.UserDm;

public interface UserDao {
	public List<UserDm> listUserTypes();

	public void insertUser(UserDm userDm);

	public boolean IsEmailexist(String email);

	public boolean IsMobileexist(String mobile);

	public int updateToken(String token, String email_id);

	public int updateIsAuth(String token_id);

	public boolean IsEmailexistinDB(String email);

	public int IsPasswordMatches(String email, String password);

	public boolean IsUsernameexist(String userName);

	public void userUpdate(UserDm userDm);

	public UserDm getuserdmbyemail(String email);

}
