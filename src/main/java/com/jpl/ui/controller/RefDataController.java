package com.jpl.ui.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpl.ui.model.BranchDm;
import com.jpl.ui.model.CityDm;
import com.jpl.ui.model.CollegeDm;
import com.jpl.ui.model.FunctionalDm;
import com.jpl.ui.model.LevelDm;
import com.jpl.ui.model.StateDm;
import com.jpl.ui.model.TitleDm;
import com.jpl.ui.model.UniversityDm;
import com.jpl.ui.model.UserTrainingDm;
import com.jpl.util.RefDataBo;

@RestController
@RequestMapping(value = "/refData")
public class RefDataController {

	@Autowired
	private RefDataBo refDataBo;

	@RequestMapping(value = "/getCities", method = RequestMethod.GET)
	public @ResponseBody List<String> getCitiesInJSON(
			@RequestParam("stateId") Integer stateId,
			@RequestParam("cityName") String cityName) {

		List<String> cityList = new ArrayList<String>();
		for (CityDm cityDm : refDataBo.getCitiesList()) {
			if (cityDm.getStateId() == stateId) {

				if (cityDm.getCityNm().toLowerCase()
						.startsWith(cityName.toLowerCase())) {
					cityList.add(cityDm.getCityNm());
				}
			}
		}
		return cityList;
	}
	
	/**@RequestMapping(value = "/getTraining", method = RequestMethod.GET)
	public @ResponseBody List<String> getTrainingInJSON(
			@RequestParam("trainingId") Integer trainingId,
			@RequestParam("trainingName") String trainingName) {

		List<String> trainingList = new ArrayList<String>();
		for (UserTrainingDm userTrainingDm : refDataBo.getTrainingList()) {
			if (userTrainingDm.getTrainingId() == trainingId) {

				if (userTrainingDm.getTrainingCode().toLowerCase()
						.startsWith(trainingName.toLowerCase())) {
					trainingList.add(userTrainingDm.getTrainingCode());
				}
			}
		}
		return trainingList;
	}*/

	@RequestMapping(value = "/getBranches", method = RequestMethod.GET)
	public @ResponseBody List<BranchDm> getBranchesInJSON(
			@RequestParam("levelId") Integer levelId) {

		List<BranchDm> levelIds = new ArrayList<BranchDm>();

		for (BranchDm branchDm : refDataBo.getBranchesList()) {
			if (branchDm.getLevelId() == levelId) {
				levelIds.add(branchDm);
			}
		}

		return levelIds;
	}

	@RequestMapping(value = "/getBranches1", method = RequestMethod.GET)
	public @ResponseBody List<LevelDm> getlevelsInJSON() {
		
		List<LevelDm> levelsList = new ArrayList<LevelDm>();
		for (LevelDm levelDm : refDataBo.getLevelsList()) {
						levelsList.add(levelDm);
							
		}
		return levelsList;
	}

	@RequestMapping(value = "/getUniversities", method = RequestMethod.GET)
	public @ResponseBody List<UniversityDm> getUniversitiesInJSON(
			@RequestParam("stateId") Integer stateId) {

		List<UniversityDm> stateIds = new ArrayList<UniversityDm>();

		for (UniversityDm universityDm : refDataBo.getUniversitiesList()) {
			if (universityDm.getStateId() == stateId) {
				stateIds.add(universityDm);
			}
		}

		return stateIds;
	}

	@RequestMapping(value = "/getFunctions", method = RequestMethod.GET)
	public @ResponseBody List<FunctionalDm> getFunctionsInJSON(
			@RequestParam("industryDetailsId") Integer industryDetailsId) {

		List<FunctionalDm> industryIds = new ArrayList<FunctionalDm>();

		for (FunctionalDm functionalDm : refDataBo.getFunctionalList()) {
			if (functionalDm.getIndustryDetailsId() == industryDetailsId) {
				industryIds.add(functionalDm);
			}
		}

		return industryIds;
	}

	@RequestMapping(value = "/getStates", method = RequestMethod.GET)
	public @ResponseBody List<StateDm> getStatesInJSON(
			@RequestParam("countryId") Integer countryId) {
		List<StateDm> countryIds = new ArrayList<StateDm>();

		for (StateDm stateDm : refDataBo.getStatesList()) {
			if (stateDm.getCountryId() == countryId) {
				countryIds.add(stateDm);
						}
		}

		return countryIds;
	}

	@RequestMapping(value = "/getTitles", method = RequestMethod.GET)
	public @ResponseBody List<TitleDm> getTitlesInJSON(
			@RequestParam("functionalDetailsId") Integer functionalDetailsId) {

		List<TitleDm> functionIds = new ArrayList<TitleDm>();
				for (TitleDm titleDm : refDataBo.getTitlesList()) {
			if (titleDm.getFunctionalDetailsId() == functionalDetailsId) {
				functionIds.add(titleDm);
			}
		}

		return functionIds;
	}

	@RequestMapping(value = "/getColleges", method = RequestMethod.GET)
	public @ResponseBody List<String> getCollegesInJSON(
			@RequestParam("universityId") Integer universityId,
			@RequestParam("collegeName") String collegeName) {

		List<String> collegeList = new ArrayList<String>();
		for (CollegeDm collegeDm : refDataBo.getCollegesList()) {
			if (collegeDm.getUniversityId() == universityId) {

				if (collegeDm.getDescription().toLowerCase()
						.startsWith(collegeName.toLowerCase())) {
					collegeList.add(collegeDm.getDescription());
				}
			}
		}

		return collegeList;
	}

	@RequestMapping(value = "/getCityNames", method = RequestMethod.GET)
	public @ResponseBody List<String> getCityNamesInJSON(
			@RequestParam("query") String cityName) {

		List<String> cityNames = new ArrayList<String>();

		for (CityDm cityDm : refDataBo.getCitiesList()) {
			if (cityDm.getCityNm().toLowerCase()
					.startsWith(cityName.toLowerCase())) {
				cityNames.add(cityDm.getCityNm());
			}
		}

		return cityNames;
	}

	@RequestMapping(value = "/getCollegeNames", method = RequestMethod.GET)
	public @ResponseBody List<String> getCollegeNamesInJSON(
			@RequestParam("query") String description) {

		List<String> collegeNames = new ArrayList<String>();

		for (CollegeDm collegeDm : refDataBo.getCollegesList()) {
			if (collegeDm.getDescription().toLowerCase()
					.startsWith(description.toLowerCase())) {
				collegeNames.add(collegeDm.getDescription());
			}
		}

		return collegeNames;
	}
	
	@RequestMapping(value = "/getlevelids", method = RequestMethod.GET)
	public @ResponseBody List<String> getlevelidsInJSON(
			@RequestParam("term") String description) {

		List<String> LevelNames = new ArrayList<String>();

		for (LevelDm ld : refDataBo.getLevelsList()) {
			if (ld.getDescription().toLowerCase()
					.startsWith(description.toLowerCase())) {
				LevelNames.add(ld.getDescription());
			}
		}

		return LevelNames;
	}

}