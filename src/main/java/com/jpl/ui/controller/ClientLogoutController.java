package com.jpl.ui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/client")
public class ClientLogoutController {

	String clientsession;

	@RequestMapping(value = "/clilogoutAction")
	public String logOutHandler(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession(true);
		if (session != null) {
			clientsession = (String) session.getAttribute("clientemail");
			session.invalidate();

		}

		return "../index";
	}
}
