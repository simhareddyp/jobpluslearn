package com.jpl.ui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jpl.dao.UserDao;
//import com.jpl.dao.UserLoginDao;
import com.jpl.ui.model.UserLoginDm;

@Controller
@RequestMapping(value = "/user")
public class UserLoginController {

	@Autowired
	private UserDao userDao;

	/*@Autowired
	private UserLoginDao userLoginDao;*/

	HttpSession userSession;

	@RequestMapping(value = "/userloginpage", method = RequestMethod.GET)
	public String loginUser(@Valid @ModelAttribute("userloginForm") UserLoginDm loginDm,
			final HttpServletRequest request, BindingResult result, ModelMap model) {

		return "userLogin";

	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public String authenticate(@Valid @ModelAttribute("userloginForm") UserLoginDm userLoginDm,
			final HttpServletRequest request, BindingResult result, ModelMap model) {

		validateUserLoginForm(userLoginDm, result);
		{

			if (result.hasErrors()) {

				return "userLogin";
			} else {
				userSession = request.getSession();
				userSession.setAttribute("useremail", userLoginDm.getEmailId());
				userSession.setAttribute("userId", userLoginDm.getUser1Id());
				return "userLoginSuccess";
			}
		}
	}

	private void validateUserLoginForm(UserLoginDm userLoginDm, BindingResult result) {
		int isemptyfield = 0;
		if (userLoginDm.getEmailId() == null || userLoginDm.getEmailId().trim().equalsIgnoreCase("")) {
			result.addError(new FieldError("userloginForm", "emailId", "<b>Email Id</b> can not be blank"));
			isemptyfield = -1;
		}
		if (userLoginDm.getPassword() == null || userLoginDm.getPassword().trim().equalsIgnoreCase("")) {
			result.addError(new FieldError("userloginForm", "password", "<b>Password</b> can not be blank"));
			isemptyfield = -1;
		}
		if (isemptyfield == 0) {

			int x = userDao.IsPasswordMatches(userLoginDm.getEmailId(), userLoginDm.getPassword());

			if (x == 0)
				;
			else if (x == -1) {
				result.addError(new FieldError("userloginForm", "emailId", "User doesn't exists"));
			} else if (x == -2) {
				result.addError(new FieldError("userloginForm", "emailId", "Email Id or Password is InCorrect"));
			} else if (x == -3) {
				result.addError(
						new FieldError("userloginForm", "emailId", "You are not authorised, Please check mail"));
			} else
				userLoginDm.setUser1Id(x);
		}
	}

	public int isPasswordMatches(String email, String password) {

		return userDao.IsPasswordMatches(email, password);
	}

}
