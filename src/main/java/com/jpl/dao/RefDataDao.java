package com.jpl.dao;

import java.util.List;
import java.util.Map;

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
import com.jpl.ui.model.UserTrainingDm;

public interface RefDataDao {

	/**
	 * This is the method to be used to list down all the records from the state
	 * table.
	 *

	/**
	 * This is the method to be used to create a map of states for each country
	 * id
	 */
	public Map<Integer, List<StateDm>> buildStatesMap();
	/**
	 * This is the method to be used to list down all the records from the City
	 * table.
	 */
	public List<CityDm> listCities();
	public List<StateDm> listStates();
	//public List<UserTrainingDm> listTraining();
	
	public Map<Integer, List<CityDm>> buildCitiesMap();

	public List<LandlinenoDm> listLandlinenos();
	
	public Map<Integer, List<LandlinenoDm>> buildLandlinenoMap();


	/**
	 * This is the method to be used to list down all the records from the
	 * Industry table.
	 */
	public List<IndustryDm> listIndustries();
	
	public List<UserDm> listuserTypes();
	
	public List<BranchDm> listBranches();
	
	public List<CollegeDm> listColleges();
	
	public List<LevelDm> listLevels();
	
	public List<CountryDm> listCountries();
	
	public List<IndustryDetailsDm> listIndustryDetails();
	
	public Map<Integer, List<IndustryDetailsDm>> buildIndustryDetailsMap();
	
	public List<UniversityDm> listUniversities();
	
	public List<FunctionalDm> listFunctions();
	
	public List<TitleDm> listTitles();
	
	public Map<Integer, List<TitleDm>> buildTitlesMap();
	
	public Map<Integer, List<LevelDm>> buildLevelsMap();

	public Map<Integer, List<CountryDm>> buildCountriesMap();

	public Map<Integer, List<BranchDm>> buildBranchesMap();
	
    public Map<Integer, List<CollegeDm>> buildCollegesMap();
	
	public Map<Integer, List<UniversityDm>> buildUniversitiesMap();
	
	public Map<Integer, List<FunctionalDm>> buildFunctionalMap();
	public String getcountryiso(String countryiso);
	public List<String> listTemplates(int clientid);
	public List<String> listTemplates1(int client_id);

	public List<BranchDm> listBranchesByLevelId(int levelId);
	public List<CityDm> listCitiesBystateId(int stateId);

}
