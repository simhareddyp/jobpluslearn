package com.jpl.ui.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jpl.dao.ClientDao;
import com.jpl.dao.JobPostingDao;
import com.jpl.dao.db.RefDataJDBCTemplate;
import com.jpl.ui.model.ClientDm;
import com.jpl.ui.model.FunctionalDm;
import com.jpl.ui.model.JobPostingDm;
import com.jpl.util.RefDataBo;

@Controller
@RequestMapping(value = "/client")
public class JobPostingController {

	@Autowired(required = true)
	private JobPostingDao jobPostingDao;

	@Autowired(required = true)
	private ClientDao clientDao;

	@Autowired
	private RefDataBo refDataBo;

	@Autowired
	private RefDataJDBCTemplate refDataJDBCTemplate;

	String clientsession;
	HttpSession clientSession1;

	Integer clisession;

	@RequestMapping(value = "/newposting")
	public ModelAndView showRegistration(final HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("jobPosting", "postForm", new JobPostingDm());
		JobPostingDm pnew = new JobPostingDm();
		clientsession = (String) request.getSession().getAttribute("clientemail");
		clisession = (Integer) request.getSession().getAttribute("clientid");
		pnew.setClientemailid(clientsession.trim());
		pnew.setClientId(clisession);
		mv.addObject("industryDetailsList", refDataBo.getIndustryDetailsList());
		mv.addObject("levelList",refDataBo.getLevelsList());
		List<String> templates = refDataJDBCTemplate.listTemplates1(clisession);
		List<String> emails = refDataJDBCTemplate.listEmails((clientsession.split("@"))[1]);
		mv.addObject("emaillist", emails);
		System.out.println(">>>"+emails);

		mv.addObject("templateList", templates);
		return mv;

	}

	@RequestMapping(value = "/postingjob", method = RequestMethod.POST)
	public String addPost(@ModelAttribute("postForm") JobPostingDm jobpostingDm, final HttpServletRequest request,
			BindingResult result, ModelMap model) {
		
		System.out.println("emaillist"+ jobpostingDm.getListofmails());
		jobpostingDm.setTemplate(request.getParameter("template"));
		
		if (result.hasErrors()) {

			return "jobPosting";
		} else {
			
				clientSession1 = request.getSession();
				clisession = (Integer) request.getSession().getAttribute("clientid");
				jobpostingDm.setClientId(clisession);
				String newjob = request.getParameter("jobname");
				String selectedtemplate = request.getParameter("template");
				if (jobpostingDm.getJobid() == null && newjob != null && !newjob.equalsIgnoreCase("")) {
					jobpostingDm.setTemplate(newjob);
					jobPostingDao.insertJobposting(jobpostingDm);
				} else if (jobpostingDm.getJobid() == null && newjob != null) {
					if (selectedtemplate.contains("-1"))
						jobpostingDm.setTemplate(null);
					jobPostingDao.insertJobposting(jobpostingDm);
				}else if(jobpostingDm.getJobid() != null &&  (newjob == null || newjob.equalsIgnoreCase("")))
				{
					jobPostingDao.updateJobposting(jobpostingDm);
					//System.out.println("hefhewfhewiohwiohiohiohwifhw"+jobpostingDm.getJobid());
				}else if(jobpostingDm.getJobid() != null &&  !(newjob == null || newjob.equalsIgnoreCase("")))
				{
					jobpostingDm.setTemplate(newjob);
					jobPostingDao.insertJobposting(jobpostingDm);
				}
			
			return "clientLoginSuccess";
		}
	}

	@RequestMapping(value = "/template")
	public ModelAndView template(final HttpServletRequest request) {

		JobPostingDm pnew = jobPostingDao.getJobpostingDM(request.getParameter("template"));
		System.out.println(">>>numberof veac"+pnew.getNumberofvacancies());
		clientsession = (String) request.getSession().getAttribute("clientemail");
		clisession = (Integer) request.getSession().getAttribute("clientid");
		ClientDm clientdmbyname = clientDao.getclientdmbyname(clientsession);
		pnew.setClientemailid(clientsession.trim());
		pnew.setClientId(clisession);
		ModelAndView mv = new ModelAndView("jobPosting", "postForm", pnew);
		mv.addObject("industryDetailsList", refDataBo.getIndustryDetailsList());
		mv.addObject("functionalList", refDataBo.getFunctionalList());
		
		mv.addObject("templateList", refDataJDBCTemplate.listTemplates1(clisession));
		return mv;

	}
	
	@RequestMapping(value = "/natatest")
	public String naratest(final HttpServletRequest request) {

		
		return "naraTest";

	}
	
	@RequestMapping(value = "/jobPostingPreview")
	public ModelAndView jobPostingPreview(@ModelAttribute("postForm") JobPostingDm jobpostingDm, final HttpServletRequest request,
			BindingResult result, ModelMap model) {
		ModelAndView mv = new ModelAndView("jobPostPreview", "postForm", jobpostingDm);
			mv.setViewName("jobPostPreview");
		return mv;

	}

	}