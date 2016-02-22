package com.jpl.ui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class UserLogoutController {

	String usersession;

	@RequestMapping(value = "/logoutAction")
	public String logOutHandler1(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
				HttpSession session = request.getSession(true);
		if (session != null) {
			usersession = (String) session.getAttribute("useremail");
			session.invalidate();

		}

		return "../index";

	}

}
