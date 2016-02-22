package com.jpl.dao;

public interface AjaxvalidatorsDao {
	
	
	boolean IsEmailexist(String email,String typeofuser);
	boolean IsMobileexist(String mobile,String typeofuser);

}
