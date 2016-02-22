package com.jpl.ui.controller;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jpl.dao.PostLoginDao;
import com.jpl.dao.RefDataDao;
import com.jpl.dao.UserDao;
import com.jpl.dao.db.RefDataJDBCTemplate;
import com.jpl.ui.model.BranchDm;
import com.jpl.ui.model.ClientDm;
import com.jpl.ui.model.JobPostingDm;
import com.jpl.ui.model.PostLoginDm;
import com.jpl.ui.model.PostLoginProDm;
import com.jpl.ui.model.UserDm;
import com.jpl.ui.model.UserLoginDm;
import com.jpl.ui.model.UserTrainingDm;
import com.jpl.util.RefDataBo;

@Controller
@RequestMapping(value = "/user")
public class PostLoginController {

	@Autowired(required = true)
	private PostLoginDao postLoginDao;

	@Autowired
	private RefDataBo refDataBo;

	@Autowired
	private RefDataDao refDataDao;

	@Autowired
	private PostLoginDao postloginDao;

	@Autowired
	private UserDao userDao;
	
	/**@Autowired
	private RefDataJDBCTemplate refDataJDBCTemplate;*/
	
	String usersession;
	Integer userid;

	@RequestMapping(value = "/userpostlogin")
	public ModelAndView displayRegistration(final HttpServletRequest request) {

		PostLoginDm pnew = new PostLoginDm();
		usersession = (String) request.getSession().getAttribute("useremail");
		userid = (Integer) request.getSession().getAttribute("userId");
		UserDm userdmbyemail = userDao.getuserdmbyemail(usersession);
		pnew.setUserDm(userdmbyemail);
		pnew.setUser1Id(userid);
		ModelAndView mv = new ModelAndView("postLoginPage",
				"userpostloginForm", pnew);
		mv.addObject("statesList", refDataBo.getStatesList());
		mv.addObject("levelsList", refDataBo.getLevelsList());
		String cityName = postloginDao.getUserCity(userdmbyemail.getCityId());

		String Description = null;
		Iterator<BranchDm> iter = refDataDao.listBranchesByLevelId(
				userdmbyemail.getLevelId()).listIterator();
		while (iter.hasNext()) {
			if (iter.next().getBranchId() == userdmbyemail.getBranchId()) {
				Description = iter.next().getDescription();
				iter.remove();
			}

		}
		mv.addObject("brachdescription", Description);
		mv.addObject("branchListlevelid",
				refDataDao.listBranchesByLevelId(userdmbyemail.getLevelId()));

		mv.addObject("cityName",
				postloginDao.getUserCity(userdmbyemail.getCityId()));
		mv.addObject("startDate", userdmbyemail.getStartDate());
		mv.addObject("endDate", userdmbyemail.getEndDate());
		mv.addObject("universitiesList", refDataBo.getUniversitiesList());
		mv.addObject("industryDetailsList", refDataBo.getIndustryDetailsList());

		return mv;
	}

	@RequestMapping(value = "/postlogin", method = RequestMethod.POST)
	public String addPost(
			@ModelAttribute("userpostloginForm") PostLoginDm postloginDm,
			final HttpServletRequest request, BindingResult result,
			ModelMap model) {
		postLoginDao.insertPostLogin(postloginDm);
		postloginDm.getUserDm().getUser1Id();
		postLoginDao.postUpdate(postloginDm);

		userDao.userUpdate(postloginDm.getUserDm());
		return "postLoginSuccess";

	}

	@RequestMapping(value = "/postloginproemp")
	public ModelAndView displayPro(final HttpServletRequest request) {
		usersession = (String) request.getSession().getAttribute("useremail");

		ModelAndView mv = new ModelAndView("postLoginPro", "postloginproForm",
				new PostLoginProDm());
		mv.addObject("titlesList", refDataBo.getTitlesList());

		return mv;
	}

	@RequestMapping(value = "/postloginpro", method = RequestMethod.POST)
	public String addPostPro(
			@ModelAttribute("postloginproForm") PostLoginProDm postloginproDm,
			final HttpServletRequest request, BindingResult result,
			ModelMap model) {
		usersession = (String) request.getSession().getAttribute("useremail");
		String newcompany = request.getParameter("jobname");
		String selectedcompany = request.getParameter("search");
		if (postloginproDm.getEmployerName() == null && newcompany != null && !newcompany.equalsIgnoreCase("")) {
			postloginproDm.setSearch(newcompany);
			postLoginDao.insertPostLoginPro(postloginproDm);
		} else if (postloginproDm.getEmployerName() == null && newcompany != null) {
			if (selectedcompany.contains("-1"))
				postloginproDm.setSearch(null);
			postLoginDao.insertPostLoginPro(postloginproDm);
		}else if(postloginproDm.getEmployerName() != null &&  (newcompany == null || newcompany.equalsIgnoreCase("")))
		{
			postLoginDao.insertPostLoginPro(postloginproDm);
		}else if(postloginproDm.getEmployerName() != null &&  !(newcompany == null || newcompany.equalsIgnoreCase("")))
		{
			postloginproDm.setSearch(newcompany);
				postLoginDao.insertPostLoginPro(postloginproDm);
		}
		return "postLoginProSuccess";

	}
	
	@RequestMapping(value = "/search")
	public ModelAndView template(final HttpServletRequest request) {

		PostLoginProDm pnew = postLoginDao.getcompany(request.getParameter("search"));

		usersession = (String) request.getSession().getAttribute("useremail");
		userid = (Integer) request.getSession().getAttribute("userid");
		UserDm userdmbyemail = userDao.getuserdmbyemail(usersession);
		ModelAndView mv = new ModelAndView("postlogin", "postloginproForm", pnew);
		//mv.addObject("companiesList", refDataJDBCTemplate.listCompanies(usersession));
		return mv;

	}
	@RequestMapping(value = "/training", method = RequestMethod.GET)
	public String loginUser(
			@Valid @ModelAttribute("trainingForm") UserTrainingDm userTrainingDm,
			final HttpServletRequest request, BindingResult result,
			ModelMap model) {

		return "postLoginTraining";

	}
	@RequestMapping(value = "/trainingcom", method = RequestMethod.POST)
	public String authenticate(
			@Valid @ModelAttribute("trainingForm") UserLoginDm userLoginDm,
			final HttpServletRequest request, BindingResult result,
			ModelMap model) {

			if (result.hasErrors()) {

				return "postLoginTraining";
			} else {
				
				return "trainingSuccess";
			}
	}
}