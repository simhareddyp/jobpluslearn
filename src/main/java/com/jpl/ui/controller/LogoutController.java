package com.jpl.ui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/logout")
public class LogoutController {
	
	String clientsession;
	String usersession;

	@RequestMapping(value = "/clilogoutAction")
	public String logOutHandler(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		if (session != null) {
			clientsession = (String) session.getAttribute("clientemail");
			if (clientsession != null) {

				session.invalidate();
			}
		}
		return "clientLogin";

	}
	
	@RequestMapping(value ="/logoutAction")
	public String logOutHandler1(HttpServletRequest request,HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(true);
		if (session != null){
			usersession = (String) session.getAttribute("useremail");
			if(usersession == null){
				
			session.invalidate();
			}
		}
		return "userLogin";

	}

}
