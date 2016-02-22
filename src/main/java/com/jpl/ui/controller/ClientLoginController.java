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

import com.jpl.dao.ClientDao;
import com.jpl.dao.ClientLoginDao;
import com.jpl.ui.model.ClientLoginDm;

@Controller
@RequestMapping(value = "/client")
public class ClientLoginController {

	@Autowired
	private ClientDao clientDao;

	@Autowired
	private ClientLoginDao clientLoginDao;


	HttpSession clientSession;

	@RequestMapping(value = "/clientloginpage", method = RequestMethod.GET)
	public String loginClient(
			@Valid @ModelAttribute("clientloginForm") ClientLoginDm clientloginDm,
			final HttpServletRequest request, BindingResult result,
			ModelMap model) {

		return "clientLogin";

	}

	@RequestMapping(value = "/cliauthenticate", method = RequestMethod.POST)
	public String authenticateClient(
			@Valid @ModelAttribute("clientloginForm") ClientLoginDm clientloginDm,
			final HttpServletRequest request, BindingResult result,
			ModelMap model) {

		validateClientLoginForm(clientloginDm, result);
		{

			if (result.hasErrors()) {

				return "clientLogin";
			} else {
				clientSession = request.getSession();
				clientSession.setAttribute("clientemail",clientloginDm.getEmailId());
				clientSession.setAttribute("clientid",clientloginDm.getClientId());
					return "clientLoginSuccess";
			}
		}
	}

	private void validateClientLoginForm(ClientLoginDm clientloginDm,
			BindingResult result) {
   int isemptyfield=0;
		if (clientloginDm.getEmailId() == null
				|| clientloginDm.getEmailId().trim().equalsIgnoreCase("")) {
			result.addError(new FieldError("clientloginForm", "emailId",
					"<b>Email Id</b> can not be blank"));
			isemptyfield=-1;
		}
		if (clientloginDm.getPassword() == null
				|| clientloginDm.getPassword().trim().equalsIgnoreCase("")) {
			result.addError(new FieldError("clientloginForm", "password",
					"<b>Password</b> can not be blank"));
			isemptyfield=-1;
		} 
		if(isemptyfield==0)
		{
		int x = clientLoginDao.IsPasswordMatches(clientloginDm.getEmailId(),
				clientloginDm.getPassword());

		if (x == 0)
			;
		else if (x == -1) {
			result.addError(new FieldError("clientloginForm", "emailId",
					"User doesn't exists"));
		} else if (x == -2) {
			result.addError(new FieldError("clientloginForm", "emailId",
					"Email Id or Password is InCorrect"));
		} else if (x == -3) {
			result.addError(new FieldError("clientloginForm", "emailId",
					"You are not authorised, Please check mail"));
		} else
			clientloginDm.setClientId(x);
		}

	}

	public int isPasswordMatches(String email, String password) {

		return clientLoginDao.IsPasswordMatches(email, password);
	}



}
