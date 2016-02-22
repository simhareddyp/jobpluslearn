package com.jpl.ui.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jpl.dao.ClientDao;
import com.jpl.dao.TrainingDao;
import com.jpl.ui.model.ClientDm;
import com.jpl.ui.model.TrainingDm;
import com.jpl.util.RefDataBo;

@Controller
@RequestMapping(value = "/client")
public class TrainingController {

	@Autowired(required = true)
	private TrainingDao trainingDao;

	@Autowired(required = true)
	private ClientDao clientDao;

	@Autowired
	private RefDataBo refDataBo;
	String clientsession;

	@RequestMapping(value = "/newtraining")
	public ModelAndView showRegistration(final HttpServletRequest request) {
		clientsession = (String) request.getSession().getAttribute(
				"clientemail");
		ClientDm clientdmbyname = clientDao.getclientdmbyname(clientsession);
		ModelAndView mv = new ModelAndView("training", "trainingForm",
				new TrainingDm());
		mv.addObject("citiesList", refDataBo.getCitiesList());

		return mv;

	}

	@RequestMapping(value = "/training", method = RequestMethod.POST)
	public String addPost(
			@ModelAttribute("trainingForm") TrainingDm trainingDm,
			final HttpServletRequest request, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {

			return "training";
		} else {

			trainingDao.insertTrainingrequirement(trainingDm);

			return "trainingSuccess";

		}
	}

}