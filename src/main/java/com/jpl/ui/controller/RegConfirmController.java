package com.jpl.ui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jpl.dao.ClientDao;
import com.jpl.dao.UserDao;
import com.jpl.ui.model.ClientDm;

@Controller
@RequestMapping(value = "/regconfirm")
public class RegConfirmController {
	
	@Autowired
	private ClientDao clientDao;
	
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value = "/registrationConfirm", method = RequestMethod.GET)
	public String authClient(
			final HttpServletRequest request) {


String acttoken=request.getParameter("token");
if(acttoken.startsWith("client"))
{acttoken.replace("client", "");
clientDao.updateIsAuth(acttoken);
}
else{


acttoken.replace("user", "");
userDao.updateIsAuth(acttoken);
}

		return "tokenConfirm";

	}
}
