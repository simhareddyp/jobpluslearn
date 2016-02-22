package com.jpl.ui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jpl.dao.AjaxvalidatorsDao;
import com.jpl.dao.ClientDao;
import com.jpl.dao.RefDataDao;
import com.jpl.util.RefDataBo;

@Controller
@RequestMapping(value = "/validateData")
public class ValidationController {

	@Autowired
	private AjaxvalidatorsDao emailvalidate ;

	@Autowired
	private RefDataDao ref;

	@RequestMapping(value = "/emailValidate", method = RequestMethod.GET)
	public @ResponseBody String getEmail(@RequestParam("emailId") String emailId,
			@RequestParam("typeofuser") String usertype) {
		
		String type=null;
		if(usertype.contains("client"))
			type="client";
		else
			type="user";
		

		if (emailvalidate.IsEmailexist(emailId.trim(),type.trim()))
			return "Email Id Already exists";
		else

			return "";
	}

	@RequestMapping(value = "/mobileValidate", method = RequestMethod.GET)
	public @ResponseBody String mobilevalidate(@RequestParam("contactNumber") String contactNumber,
			@RequestParam("typeofuser") String usertype) {
		
		String type=null;
		if(usertype.contains("client"))
			type="client";
		else
			type="user";
				if (emailvalidate.IsMobileexist(contactNumber.trim(),type.trim()))
			return "Mobile Id Already exists";
		else

			return "";
	}
	
	@RequestMapping(value = "/countryiso", method = RequestMethod.GET)
	public @ResponseBody String getcountryiso(@RequestParam("countryId") String countryid) {

		return ref.getcountryiso(countryid.trim());
		
	}
}
