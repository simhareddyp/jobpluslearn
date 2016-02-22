package com.jpl.util;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpl.dao.RefDataDao;
import com.jpl.ui.model.BranchDm;
import com.jpl.ui.model.CityDm;
import com.jpl.ui.model.CollegeDm;
import com.jpl.ui.model.CountryDm;
import com.jpl.ui.model.FunctionalDm;
import com.jpl.ui.model.IndustryDetailsDm;
import com.jpl.ui.model.IndustryDm;
import com.jpl.ui.model.JobPostingDm;
import com.jpl.ui.model.LandlinenoDm;
import com.jpl.ui.model.LevelDm;
import com.jpl.ui.model.StateDm;
import com.jpl.ui.model.TitleDm;
import com.jpl.ui.model.UniversityDm;
import com.jpl.ui.model.UserDm;

@Service
public class RefDataBo {

	@Autowired
	private RefDataDao refDataDao;

	private Map<Integer, List<StateDm>> statesMap;
	private List<CityDm> citiesList;
	private List<IndustryDm> industriesList;
	private List<BranchDm> branchesList;
	private List<BranchDm> branchListlevelid;
	private List<IndustryDetailsDm> industryDetailsList;
	private List<CollegeDm> collegesList;
	private List<LevelDm> levelsList;
	private List<CountryDm> countriesList;
	private List<UniversityDm> universitiesList;
	private List<FunctionalDm> functionalList;
	private List<TitleDm> titlesList;
	private List<StateDm> statesList;
	private Map<Integer, List<TitleDm>> titlesMap;
	private Map<Integer, List<BranchDm>> branchesMap;
	private Map<Integer, List<LevelDm>> levelsMap;
	private Map<Integer, List<CountryDm>> countriesMap;
	private Map<Integer, List<UniversityDm>> universitiesMap;
	private Map<Integer, List<CollegeDm>> collegesMap;
	private Map<Integer, List<IndustryDetailsDm>> industryDetailsMap;
	private Map<Integer, List<FunctionalDm>> functionalMap;
	private Map<Integer, List<CityDm>> cityMap;
	private Map<Integer, List<UserDm>> emailIdMap;
	private List<LandlinenoDm> landlinenosList;
	private Map<Integer, List<LandlinenoDm>> landlinenoMap;
	private List<JobPostingDm> templateList;
	private List<JobPostingDm> templateList1;

	@PostConstruct
	public void init() {

		initStates();
		initCities();
		initIndustries();
		initIndustryDetails();
		initBranches();
		initColleges();
		initLevels();
		initUniversities();
		initFunctions();
		initLandlineno();
		initCountries();
		initTitles();
	}
	
	public List<JobPostingDm> getTemplateList(int clientid) {
		return templateList;
	}

	public List<JobPostingDm> getTemplateList() {
		return templateList;
	}
	public List<JobPostingDm> getTemplateList1() {
		return templateList1;
	}
	

	private void initColleges() {

		collegesMap = refDataDao.buildCollegesMap();
		collegesList = refDataDao.listColleges();
	}

	public List<CollegeDm> getCollegesList() {
		return collegesList;
	}

	private void initLandlineno() {

		landlinenoMap = refDataDao.buildLandlinenoMap();
		landlinenosList = refDataDao.listLandlinenos();
	}

	public List<LandlinenoDm> getLandlinenosList() {
		return landlinenosList;
	}

	private void initCountries() {

		countriesMap = refDataDao.buildCountriesMap();
		countriesList = refDataDao.listCountries();
	}

	public List<CountryDm> getCountriesList() {
		return countriesList;
	}

	private void initTitles() {

		titlesMap = refDataDao.buildTitlesMap();
		titlesList = refDataDao.listTitles();
	}

	public List<TitleDm> getTitlesList() {
		return titlesList;
	}

	private void initFunctions() {

		functionalMap = refDataDao.buildFunctionalMap();
		functionalList = refDataDao.listFunctions();
	}

	public List<FunctionalDm> getFunctionalList() {
		return functionalList;
	}

	public List<UniversityDm> getUniversitiesList() {
		return universitiesList;
	}

	private void initLevels() {

		levelsMap = refDataDao.buildLevelsMap();
		levelsList = refDataDao.listLevels();
	}

	public List<LevelDm> getLevelsList() {
		return levelsList;
	}

	private void initStates() {

		statesList = refDataDao.listStates();
		statesMap = refDataDao.buildStatesMap();
	}

	private void initBranches() {

		branchesMap = refDataDao.buildBranchesMap();
		branchesList = refDataDao.listBranches();
	}

	private void initUniversities() {

		universitiesMap = refDataDao.buildUniversitiesMap();
		universitiesList = refDataDao.listUniversities();
	}

	private void initCities() {

		cityMap = refDataDao.buildCitiesMap();

		citiesList = refDataDao.listCities();
	}

	private void initIndustries() {

		industriesList = refDataDao.listIndustries();
	}

	private void initIndustryDetails() {

		industryDetailsList = refDataDao.listIndustryDetails();
		industryDetailsMap = refDataDao.buildIndustryDetailsMap();
	}

	public Map<Integer, List<IndustryDetailsDm>> getIndustryDetailsMap() {
		return industryDetailsMap;
	}

	public Map<Integer, List<UserDm>> getEmailIdMap() {
		return emailIdMap;
	}

	public Map<Integer, List<LandlinenoDm>> getLandlinenoMap() {
		return landlinenoMap;
	}

	public Map<Integer, List<TitleDm>> getTitlesMap() {
		return titlesMap;
	}

	public Map<Integer, List<StateDm>> getStatesMap() {
		return statesMap;
	}

	public Map<Integer, List<BranchDm>> getBranchesMap() {
		return branchesMap;
	}

	public Map<Integer, List<CityDm>> getCitiesMap() {
		return cityMap;
	}

	public Map<Integer, List<LevelDm>> getLevelsMap() {
		return levelsMap;
	}

	public Map<Integer, List<UniversityDm>> getUniversitiesMap() {
		return universitiesMap;
	}

	public Map<Integer, List<CollegeDm>> getCollegesMap() {
		return collegesMap;
	}

	public Map<Integer, List<FunctionalDm>> getFunctionalMap() {
		return functionalMap;
	}

	public List<IndustryDetailsDm> getIndustryDetailsList() {
		return industryDetailsList;
	}

	public List<CityDm> getCitiesList() {
		return citiesList;
	}

	public List<IndustryDm> getIndustriesList() {
		return industriesList;

	}

	public List<StateDm> getStatesList() {
		return statesList;

	}

	public List<BranchDm> getBranchesList() {

		return branchesList;
	}

	public CityDm getCityByName(String cityNm) {

		for (CityDm cityDm : getCitiesList()) {

			if (cityDm.getCityNm().equalsIgnoreCase(cityNm)) {
				return cityDm;
			}
		}
		return null;
	}

	public CollegeDm getCollegeByDescription(String description) {

		for (CollegeDm collegeDm : getCollegesList()) {

			if (collegeDm.getDescription().equalsIgnoreCase(description)) {
				return collegeDm;
			}
		}
		return null;
	}
	
	public List<BranchDm> listBranchesByLevelId(int levelId)
	{
		return branchListlevelid;
		
	}
}
