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

import com.jpl.dao.UserDao;
import com.jpl.ui.model.UserLoginDm;
import com.jpl.ui.model.UserDm;
import com.jpl.util.UserLoginBo;
import com.jpl.util.RefDataBo;
import com.jpl.util.UserBo;
import com.jpl.util.event.OnRegistrationCompleteEvent;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private RefDataBo refDataBo;

	@Autowired
	private UserBo userBo;

	@Autowired
	private UserLoginBo loginBo;

	@Autowired
	private UserDao userDao;

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView displayLogin() {

		ModelAndView mv = new ModelAndView("login", "loginForm",
				new UserLoginDm());

		return mv;
	}
	
	@RequestMapping(value = "/userforgotPassword", method = RequestMethod.GET)
	public ModelAndView forgotPassword() {
		ModelAndView mv = new ModelAndView("userForgotPassword", "forgotPasswordForm",
				new UserDm());
		return mv;
	}
	
	@RequestMapping(value = "/OTP", method = RequestMethod.GET)
	public ModelAndView getOTP() {
		ModelAndView mv = new ModelAndView("userOTP", "forgotPasswordForm",
				new UserDm());
		return mv;
	}

	@RequestMapping(value = "/usernew", method = RequestMethod.GET)
	public ModelAndView displayRegistration() {

		ModelAndView mv = new ModelAndView("newUser", "userForm",
				new UserDm());
		
		mv.addObject("levelsList", refDataBo.getLevelsList());
		mv.addObject("industryDetailsList", refDataBo.getIndustryDetailsList());
		mv.addObject("functionalList",refDataBo.getFunctionalList());
		mv.addObject("countriesList", refDataBo.getCountriesList());

		return mv;
	}

	@RequestMapping(value = "/userlogin", method = RequestMethod.POST)
	public String loginUser(
			@Valid @ModelAttribute("loginForm") UserLoginDm userLoginDm,
			BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "login";
		} else {
			model.addAttribute("emailId", userLoginDm.getEmailId());
			model.addAttribute("password", userLoginDm.getPassword());
			return "loginSuccess";
		}
	}

	@RequestMapping(value = "/userregister", method = RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("userForm") UserDm userDm,
			final HttpServletRequest request, BindingResult result,
			ModelMap model) {
		validateUserForm(userDm, result);
		{

			if (result.hasErrors()) {
				
				model.addAttribute("statesList",
						refDataBo.getStatesMap().get(new Integer("1")));
				model.addAttribute("levelsList", refDataBo.getLevelsList());
				model.addAttribute("industryDetailsList",
						refDataBo.getIndustryDetailsList());
				model.addAttribute("functionalList",
						refDataBo.getFunctionalList());

				return "newUser";
			} else {
				
				userDm.setCityId(refDataBo.getCityByName(userDm.getCityName())
						.getCityId());
				userDm.setCollegeId(refDataBo.getCollegeByDescription(
						userDm.getDescription()).getCollegeId());
				model.addAttribute("firstName", userDm.getFirstName());
				model.addAttribute("lastName", userDm.getLastName());
				model.addAttribute("userName", userDm.getUserName());
				model.addAttribute("cityId", userDm.getCityId());
				model.addAttribute("collegeId", userDm.getCollegeId());
				
				userDao.insertUser(userDm);

				
			 final String appUrl = "http://" + request.getServerName() +
				 ":" + request.getServerPort() + request.getContextPath();
				 eventPublisher.publishEvent(new OnRegistrationCompleteEvent(
				  null, userDm, Locale.ENGLISH, appUrl));
				
				  userDao.updateToken(userDm.getTokenId(), userDm.getEmailId());
				 

				return "userSuccess";
			}
		}
	}

	private void validateUserForm(UserDm userDm, BindingResult result) {
		if (userDm.getFirstName() == null
				|| userDm.getFirstName().trim().equalsIgnoreCase("")) {
			result.addError(new FieldError("userForm", "firstName",
					"<b>First Name</b> cannot be blank"));
		}
		if (userDm.getLastName() == null
				|| userDm.getLastName().trim().equalsIgnoreCase("")) {
			result.addError(new FieldError("userForm", "lastName",
					"<b>Last Name</b> cannot be blank"));
		}
		if (userDm.getEmailId() == null
				|| userDm.getEmailId().trim().equalsIgnoreCase("")) {
			result.addError(new FieldError("userForm", "emailId",
					"<b>Email Id</b> cannot be blank"));
		}
		if (isEmailexists(userDm.getEmailId())) {
			result.addError(new FieldError("userForm", "emailId",
					"<b> Email ID</b> already exists"));
		}
		if (isUsernameexists(userDm.getUserName())) {
			result.addError(new FieldError("userForm", "userName",
					"<b> User Name</b> already exists"));
		}

		if (userDm.getUserName() == null
				|| userDm.getUserName().trim().equalsIgnoreCase("")) {
			result.addError(new FieldError("userForm", "userName",
					"<b>User Name</b> cannot be blank"));
		}
		if (userDm.getPassword() == null
				|| userDm.getPassword().trim().equalsIgnoreCase("")) {
			result.addError(new FieldError("userForm", "password",
					"<b>Password</b> cannot be blank"));
		}
		if (userDm.getReEnterPassword() == null
				|| userDm.getReEnterPassword().trim().equalsIgnoreCase("")) {
			result.addError(new FieldError("userForm", "reEnterPassword",
					"<b> Re Enter password</b> cannot be blank"));
		} else {
			if (!userDm.getPassword().equals(userDm.getReEnterPassword())) {
				result.addError(new FieldError("userForm", "password",
						"<b>Re Enter Password</b> should match the <b>Password</b>"));
			}
		}
		if (userDm.getMobileNumber() == null
				|| userDm.getMobileNumber().trim().equalsIgnoreCase("")) {
			result.addError(new FieldError("userForm", "mobileNumber",
					"<b>Mobile Number</b> cannot be blank"));
		}
		if (!(userDm.getMobileNumber().length()!=10)
				||!userDm.getMobileNumber().trim().equalsIgnoreCase("")){
		if (userDm.getMobileNumber().length()!=10) {
			result.addError(new FieldError("userForm", "mobileNumber",
					"<b>Mobile Number</b> up to 10 digits only"));
		}
		}

		if (isMobileexist(userDm.getMobileNumber())) {
			result.addError(new FieldError("userForm", "mobileNumber",
					"<b> Mobile Number</b> already exists"));
		}
		if(!ismobiledigits(userDm.getMobileNumber()))
			result.addError(new FieldError("userForm", "mobileNumber",
					"<b> Mobile Number</b> must be digits only"));
		if (userDm.getGenderId() == -1) {
			result.addError(new FieldError("userForm", "genderId",
					"<b>Gender</b> cannot be blank"));
		}
		if (userDm.getNationalityId() == -1) {
			result.addError(new FieldError("userForm", "nationalityId",
					"<b>Nationality</b> cannot be blank"));
		}
		if (userDm.getCountryId() == -1) {
			result.addError(new FieldError("userForm", "countryId",
					"<b>Country</b> cannot be blank"));
		}
		if (userDm.getStateId() == -1) {
			result.addError(new FieldError("userForm", "stateId",
					"<b>State</b> cannot be blank"));
		}
		
		if (userDm.getCityName() == null
				|| userDm.getCityName().trim().equalsIgnoreCase("")) {
			result.addError(new FieldError("userForm", "cityName",
					"<b>City</b> cannot be blank"));
		}
		if (userDm.getCollegeName() == null
				|| userDm.getCollegeName().trim().equalsIgnoreCase("")) {
			result.addError(new FieldError("userForm", "collegeName",
					"<b>College</b> cannot be blank"));
		}
		 
		if (userDm.getLevelId() == -1) {
			result.addError(new FieldError("userForm", "levelId",
					"<b>Level</b> cannot be blank"));
		}
		if (userDm.getBranchId() == -1) {
			result.addError(new FieldError("userForm", "branchId",
					"<b>Branch</b> cannot be blank"));
		}
		if (userDm.getUniversityId() == -1) {
			result.addError(new FieldError("userForm", "universityId",
					"<b>University</b> cannot be blank"));
		}
		if (userDm.isFresher.equalsIgnoreCase("N")) {
			if (userDm.getIndustryDetailsId() == -1) {
				result.addError(new FieldError("userForm", "industryDetailsId",
						"<b>Industry</b> cannot be blank"));
			}
			if (userDm.getFunctionalDetailsId() == -1) {
				result.addError(new FieldError("userForm",
						"functionalDetailsId",
						"<b>Functional Area</b> cannot be blank"));
			}
			if (userDm.getTitleId() == -1) {
				result.addError(new FieldError("userForm", "titleId",
						"<b>Title</b> cannot be blank"));
			}
		}
		
		if (!(userDm.getFirstName() == null)
				||!userDm.getFirstName().trim().equalsIgnoreCase("")){
		if (userDm.getFirstName().length() > 30) {
			result.addError(new FieldError("userForm", "firstName",
					"<b>first Name</b> up to 30 characters only"));
		}
		}

		if (!(userDm.getLastName() == null)
				||!userDm.getLastName().trim().equalsIgnoreCase("")){
		if (userDm.getLastName().length() > 30) {
			result.addError(new FieldError("userForm", "lastName",
					"<b>Last Name</b> up to 30 characters only"));
		}
		}
		if (!(userDm.getUserName() == null)
				||!userDm.getUserName().trim().equalsIgnoreCase("")){
		if (userDm.getUserName().length() > 30) {
			result.addError(new FieldError("userForm", "userName",
					"<b>User Name</b> up to 30 characters only"));
		}
		}

		if (userDm.getPassword().length() > 20
				|| userDm.getPassword().trim().equalsIgnoreCase("")) {
			result.addError(new FieldError("userForm", "password",
					"<b>Password</b> must be within 20 characters"));
		}
		if (userDm.getReEnterPassword().length() > 20
				|| userDm.getReEnterPassword().trim().equalsIgnoreCase("")) {
			result.addError(new FieldError("userForm", "reEnterPassword",
					"<b>Confirm Password</b> must be within 20 characters"));
		}
	}

	public boolean isEmailexists(String email) {

		return userDao.IsEmailexist(email);
	}
	public boolean isUsernameexists(String userName) {

		return userDao.IsUsernameexist(userName);
	}
	public boolean isMobileexist(String mobile) {

		return userDao.IsMobileexist(mobile);
	}
	
	private boolean ismobiledigits (String contactno)
	{ 
		
		for (int i=0; i<contactno.length();i++)
		if(!Character.isDigit((contactno.charAt(i) )) )
			return false;
		return true;
	}

}
