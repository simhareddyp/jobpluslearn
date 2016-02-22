package com.jpl.ui.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jpl.dao.AjaxvalidatorsDao;
import com.jpl.dao.ClientDao;
import com.jpl.ui.model.ClientDm;
import com.jpl.ui.model.CompanyDetailsDm;
import com.jpl.util.RefDataBo;
import com.jpl.util.event.OnRegistrationCompleteEvent;

@Controller
@RequestMapping(value = "/client")
public class ClientController {

	@Autowired
	private RefDataBo refDataBo;

	@Autowired
	private ClientDao clientDao;

	@Autowired
	private AjaxvalidatorsDao ajx;

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@RequestMapping(value = "/clinew", method = RequestMethod.GET)
	public ModelAndView showRegistration() {

		ModelAndView mv = new ModelAndView("newClient", "clientForm",
				new ClientDm());

		// mv.addObject("statesList",
		// refDataBo.getStatesMap().get(new Integer("1")));
		mv.addObject("industryDetailsList", refDataBo.getIndustryDetailsList());
		// mv.addObject("statesList", refDataBo.getStatesList());
		mv.addObject("countriesList", refDataBo.getCountriesList());
		return mv;
	}

	@RequestMapping(value = "/cliforgotPassword", method = RequestMethod.GET)
	public ModelAndView forgotPassword() {
		ModelAndView mv = new ModelAndView("cliForgotPassword",
				"cliforgotPasswordForm", new ClientDm());
		return mv;
	}

	@RequestMapping(value = "/OTP", method = RequestMethod.GET)
	public ModelAndView getOTP() {
		ModelAndView mv = new ModelAndView("cliOTP", "cliforgotPasswordForm",
				new ClientDm());
		return mv;
	}

	@RequestMapping(value = "/cliregister", method = RequestMethod.POST)
	public String addClient(
			@ModelAttribute("clientForm") ClientDm objClientDm,

			final HttpServletRequest request, BindingResult result,
			ModelMap model) {

		System.out.println("company name in client controller is "
				+ objClientDm.getCompanyDetailsDm().getCompanyName());

		validateClientForm(objClientDm, result);

		if (result.hasErrors()) {
			System.out.println("inside if" + result.getAllErrors());

			model.addAttribute("statesList", refDataBo.getStatesList());
			model.addAttribute("countriesList", refDataBo.getCountriesList());
			return "newClient";
		} else {

			objClientDm.setCityId(refDataBo.getCityByName(
					objClientDm.getCityName()).getCityId());
			model.addAttribute("emailId", objClientDm.getEmailId());
			model.addAttribute("name", objClientDm.getClientName());
			model.addAttribute("clientType", objClientDm.getClientType());
			model.addAttribute("cityId", objClientDm.getCityId());

			objClientDm.setEmailId(objClientDm.getEmailId().toLowerCase()
					.trim());

			clientDao.insertClient(objClientDm);

			int clientid = clientDao.getClientIddb(objClientDm.getEmailId());
System.out.println("client id in client controller sfter insertClkient method is "+clientid);
objClientDm.getCompanyDetailsDm().setClientId(clientid);
			clientDao.insertCompany(objClientDm.getCompanyDetailsDm());

			final String appUrl = "http://" + request.getServerName() + ":"
					+ request.getServerPort() + request.getContextPath();
			eventPublisher.publishEvent(new OnRegistrationCompleteEvent(
					objClientDm, null, Locale.ENGLISH, appUrl));
			clientDao.updateToken(objClientDm.getTokenId(),
					objClientDm.getEmailId());

			return "clientSuccess";
		}

	}

	@RequestMapping(value = "/clidelete", method = RequestMethod.GET)
	public String delClient() {
		return "result";
	}

	private void validateClientForm(ClientDm objClientDm, BindingResult result) {

		if (objClientDm.getEmailId() == null
				|| objClientDm.getEmailId().trim().equalsIgnoreCase("")) {
			result.addError(new FieldError("clientForm", "emailId",
					"<b>Email Id</b> cannot be blank"));
		}
		if (objClientDm.getClientName() == null
				|| objClientDm.getClientName().trim().equalsIgnoreCase("")) {
			result.addError(new FieldError("clientForm", "clientName",
					"<b>Client Name</b> cannot be blank"));
		}
		if (!(objClientDm.getClientName() == null)
				|| !objClientDm.getClientName().trim().equalsIgnoreCase("")) {
			if (objClientDm.getClientName().length() > 30) {
				result.addError(new FieldError("clientForm", "clientName",
						"<b>Client Name</b> up to 30 characters only"));
			}
		}

		if (objClientDm.getContactPerson() == null
				|| objClientDm.getContactPerson().trim().equalsIgnoreCase("")) {
			result.addError(new FieldError("clientForm", "contactPerson",
					"<b>Contact Person</b> cannot be blank"));
		}

		if (!(objClientDm.getContactPerson() == null)
				|| !objClientDm.getContactPerson().trim().equalsIgnoreCase("")) {
			if (objClientDm.getContactPerson().length() > 30) {
				result.addError(new FieldError("clientForm", "contactPerson",
						"<b>Contact Person</b> up to 30 characters only"));
			}
		}

		if (objClientDm.getContactNumber() == null
				|| objClientDm.getContactNumber().trim().equalsIgnoreCase("")) {
			result.addError(new FieldError("clientForm", "contactNumber",
					"<b>Mobile Number</b> cannot be blank"));
		}
		if (!(objClientDm.getContactNumber().length() != 10)
				|| !objClientDm.getContactNumber().trim().equalsIgnoreCase("")) {
			if (objClientDm.getContactNumber().length() != 10) {
				result.addError(new FieldError("clientForm", "contactNumber",
						"<b>Mobile Number</b> up to 10 digits only"));
			}
		}
		if (isMobileexists(objClientDm.getContactNumber())) {
			result.addError(new FieldError("clientForm", "contactNumber",
					"<b> Mobile Number</b> already exists"));
		}
		if (!ismobiledigits(objClientDm.getContactNumber()))
			result.addError(new FieldError("clientForm", "contactNumber",
					"<b> Mobile Number</b> must be digits only"));

		if (objClientDm.getPincode() == null
				|| objClientDm.getPincode().trim().equalsIgnoreCase("")) {
			result.addError(new FieldError("clientForm", "pincode",
					"<b>Pincode</b> cannot be blank"));
		}

		if (objClientDm.getCountryId() == -1) {
			result.addError(new FieldError("userForm", "countryId",
					"<b>Country</b> cannot be blank"));
		}

		if (objClientDm.getStateId() == -1) {
			result.addError(new FieldError("clientForm", "stateId",
					"<b>State</b> cannot be blank"));
		}
		if (objClientDm.getIndustryDetailsId() == -1) {
			result.addError(new FieldError("clientForm", "industryDetailsId",
					"<b>Industry Type</b> cannot be blank"));
		}
		if (objClientDm.getCityName() == null
				|| objClientDm.getCityName().trim().equalsIgnoreCase("")) {
			result.addError(new FieldError("clientForm", "cityName",
					"<b>City</b> cannot be blank"));
		}

		if (objClientDm.getPassword() == null
				|| objClientDm.getPassword().trim().equalsIgnoreCase("")) {
			result.addError(new FieldError("clientForm", "password",
					"<b>Password</b> cannot be blank"));
		}
		if (objClientDm.getMatchingPassword() == null
				|| objClientDm.getMatchingPassword().trim()
						.equalsIgnoreCase("")) {
			result.addError(new FieldError("clientForm", "matchingPassword",
					"<b> Confirm password</b> cannot be blank"));
		} else {
			if (!objClientDm.getPassword().equals(
					objClientDm.getMatchingPassword())) {
				result.addError(new FieldError("clientForm", "password",
						"<b>Confirm Password</b> should match the <b>Password</b>"));
			}
			if (objClientDm.getPassword().length() > 20
					|| objClientDm.getPassword().trim().equalsIgnoreCase("")) {
				result.addError(new FieldError("clientForm", "password",
						"<b>Password</b> cannot be blank"));
			}
			if (objClientDm.getMatchingPassword().length() > 20
					|| objClientDm.getMatchingPassword().trim()
							.equalsIgnoreCase("")) {
				result.addError(new FieldError("clientForm",
						"matchingPassword",
						"<b> Confirm password</b> cannot be blank"));
			}
		}

		if (isEmailexists(objClientDm.getEmailId())) {
			result.addError(new FieldError("clientForm", "emailId",
					"<b> Email ID</b> already exists"));
		}

		if (objClientDm.getPincode().equals(null)) {
			result.addError(new FieldError("clientForm", "pincode",
					"<b> Pincode</b> cannot be blank"));
		}
		if (!(objClientDm.getPincode().length() != 6)
				|| !objClientDm.getPincode().trim().equalsIgnoreCase("")) {
			if (objClientDm.getPincode().length() != 6) {
				result.addError(new FieldError("clientForm", "contactPerson",
						"<b>Pincode</b> up to 6 digits only"));
			}
		}
		if (!ispincodedigits(objClientDm.getPincode()))
			result.addError(new FieldError("clientForm", "pincode",
					"<b> Pincode</b> must be digits only"));

	}

	public boolean isEmailexists(String email) {
		return ajx.IsEmailexist(email, "client");
	}

	public boolean isMobileexists(String mobile) {
		return clientDao.IsMobileexist(mobile);
	}

	private boolean ismobiledigits(String contactno) {

		for (int i = 0; i < contactno.length(); i++)
			if (!Character.isDigit((contactno.charAt(i))))
				return false;
		return true;
	}

	private boolean ispincodedigits(String pincode) {

		for (int i = 0; i < pincode.length(); i++)
			if (!Character.isDigit((pincode.charAt(i))))
				return false;
		return true;
	}

}