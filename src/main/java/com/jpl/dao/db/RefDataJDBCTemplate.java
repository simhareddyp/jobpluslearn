package com.jpl.dao.db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jpl.dao.RefDataDao;
import com.jpl.dao.db.mapper.BranchMapper;
import com.jpl.dao.db.mapper.CityMapper;
import com.jpl.dao.db.mapper.CollegeMapper;
import com.jpl.dao.db.mapper.CountryMapper;
import com.jpl.dao.db.mapper.FunctionalMapper;
import com.jpl.dao.db.mapper.IndustryDetailsMapper;
import com.jpl.dao.db.mapper.IndustryMapper;
import com.jpl.dao.db.mapper.LandlinenoMapper;
import com.jpl.dao.db.mapper.LevelMapper;
import com.jpl.dao.db.mapper.StateMapper;
import com.jpl.dao.db.mapper.TemplateMapper;
import com.jpl.dao.db.mapper.TitleMapper;
import com.jpl.dao.db.mapper.UniversityMapper;
import com.jpl.dao.db.mapper.UserMapper;
import com.jpl.dao.db.mapper.UserTrainingMapper;
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

@Repository
public class RefDataJDBCTemplate implements RefDataDao {

	@Autowired
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplateObject;

	public RefDataJDBCTemplate() {

	}

	@PostConstruct
	public void setJdbcTemplate() {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public Map<Integer, List<StateDm>> buildStatesMap() {

		Map<Integer, List<StateDm>> statesMap = new HashMap<Integer, List<StateDm>>();
		for (StateDm stateDm : listStates()) {
			List<StateDm> statesList = statesMap.get(stateDm.getCountryId());
			if (statesList == null) {
				statesList = new ArrayList<StateDm>();
			}
			statesList.add(stateDm);
			statesMap.put(stateDm.getCountryId(), statesList);
		}
		return statesMap;

	}

	public Map<Integer, List<FunctionalDm>> buildFunctionalMap() {

		Map<Integer, List<FunctionalDm>> functionalMap = new HashMap<Integer, List<FunctionalDm>>();
		for (FunctionalDm functionalDm : listFunctions()) {
			List<FunctionalDm> functionalList = functionalMap.get(functionalDm.getIndustryDetailsId());
			if (functionalList == null) {
				functionalList = new ArrayList<FunctionalDm>();
			}
			functionalList.add(functionalDm);
			functionalMap.put(functionalDm.getIndustryDetailsId(), functionalList);
		}

		return functionalMap;

	}

	public List<StateDm> listStates() {
		String SQL = "select * from state";
		List<StateDm> statesList = jdbcTemplateObject.query(SQL, new StateMapper());
		return statesList;

	}

	public List<CityDm> listCities() {
		String SQL = "select * from city";
		List<CityDm> cityList = jdbcTemplateObject.query(SQL, new CityMapper());
		return cityList;
	}

	public List<String> listTemplates(int clientid) {
		String SQL = "select template_name from jobposting where client_id=" + clientid;
		List<Map<String, Object>> templateList = jdbcTemplateObject.queryForList(SQL);
		return null;
	}

	public Map<Integer, List<CityDm>> buildCitiesMap() {

		Map<Integer, List<CityDm>> cityMap = new HashMap<Integer, List<CityDm>>();
		for (CityDm cityDm : listCities()) {
			List<CityDm> citiesList = cityMap.get(cityDm.getStateId());
			if (citiesList == null) {
				citiesList = new ArrayList<CityDm>();
			}
			citiesList.add(cityDm);
			cityMap.put(cityDm.getStateId(), citiesList);
		}

		return cityMap;
	}

	public List<LandlinenoDm> listLandlinenos() {
		String SQL = "select * from landlineno";
		List<LandlinenoDm> landlinenoList = jdbcTemplateObject.query(SQL, new LandlinenoMapper());
		return landlinenoList;
	}

	public Map<Integer, List<LandlinenoDm>> buildLandlinenoMap() {
		Map<Integer, List<LandlinenoDm>> landlinenoMap = new HashMap<Integer, List<LandlinenoDm>>();
		for (LandlinenoDm landlinenoDm : listLandlinenos()) {
			List<LandlinenoDm> landlinenosList = landlinenoMap.get(landlinenoDm.getCountryId());
			if (landlinenosList == null) {
				landlinenosList = new ArrayList<LandlinenoDm>();
			}
			landlinenosList.add(landlinenoDm);
			landlinenoMap.put(landlinenoDm.getCountryId(), landlinenosList);
		}

		return landlinenoMap;
	}

	public Map<Integer, List<IndustryDetailsDm>> buildIndustryDetailsMap() {
		Map<Integer, List<IndustryDetailsDm>> industryDetailsMap = new HashMap<Integer, List<IndustryDetailsDm>>();
		for (IndustryDetailsDm industryDetailsDm : listIndustryDetails()) {
			List<IndustryDetailsDm> industryDetailsList = industryDetailsMap
					.get(industryDetailsDm.getIndustryDetailsId());
			if (industryDetailsList == null) {
				industryDetailsList = new ArrayList<IndustryDetailsDm>();
			}
			industryDetailsList.add(industryDetailsDm);
			industryDetailsMap.put(industryDetailsDm.getIndustryDetailsId(), industryDetailsList);
		}
		return industryDetailsMap;
	}

	public List<IndustryDetailsDm> listIndustryDetails() {
		String SQL = "select * from industry_details";
		List<IndustryDetailsDm> industryDetailsList = jdbcTemplateObject.query(SQL, new IndustryDetailsMapper());
		return industryDetailsList;
	}

	public List<CountryDm> listCountries() {
		String SQL = "select * from country";
		List<CountryDm> countriesList = jdbcTemplateObject.query(SQL, new CountryMapper());
		return countriesList;
	}

	public Map<Integer, List<CountryDm>> buildCountriesMap() {
		Map<Integer, List<CountryDm>> countriesMap = new HashMap<Integer, List<CountryDm>>();
		for (CountryDm countryDm : listCountries()) {
			List<CountryDm> countriesList = countriesMap.get(countryDm.getCountryId());
			if (countriesList == null) {
				countriesList = new ArrayList<CountryDm>();
			}
			countriesList.add(countryDm);
			countriesMap.put(countryDm.getCountryId(), countriesList);
		}

		return countriesMap;
	}

	public List<IndustryDm> listIndustries() {
		String SQL = "select * from industry";
		List<IndustryDm> industryList = jdbcTemplateObject.query(SQL, new IndustryMapper());
		return industryList;
	}

	public List<BranchDm> listBranches() {
		String SQL = "select * from edu_branch";
		List<BranchDm> branchesList = jdbcTemplateObject.query(SQL, new BranchMapper());
		return branchesList;
	}

	public List<CollegeDm> listColleges() {
		String SQL = "select * from college";
		List<CollegeDm> collegeList = jdbcTemplateObject.query(SQL, new CollegeMapper());
		return collegeList;
	}

	public List<UniversityDm> listUniversities() {
		String SQL = "select * from university";
		List<UniversityDm> universitiesList = jdbcTemplateObject.query(SQL, new UniversityMapper());
		return universitiesList;
	}

	public List<LevelDm> listLevels() {
		String SQL = "select * from edu_level";
		List<LevelDm> levelList = jdbcTemplateObject.query(SQL, new LevelMapper());
		return levelList;
	}

	public Map<Integer, List<LevelDm>> buildLevelsMap() {

		Map<Integer, List<LevelDm>> levelsMap = new HashMap<Integer, List<LevelDm>>();
		for (LevelDm levelDm : listLevels()) {
			List<LevelDm> levelsList = levelsMap.get(levelDm.getLevelId());
			if (levelsList == null) {
				levelsList = new ArrayList<LevelDm>();
			}
			levelsList.add(levelDm);
			levelsMap.put(levelDm.getLevelId(), levelsList);
		}

		return levelsMap;

	}

	public Map<Integer, List<CollegeDm>> buildCollegesMap() {

		Map<Integer, List<CollegeDm>> collegesMap = new HashMap<Integer, List<CollegeDm>>();
		for (CollegeDm collegeDm : listColleges()) {
			List<CollegeDm> collegesList = collegesMap.get(collegeDm.getUniversityId());
			if (collegesList == null) {
				collegesList = new ArrayList<CollegeDm>();
			}
			collegesList.add(collegeDm);
			collegesMap.put(collegeDm.getUniversityId(), collegesList);
		}

		return collegesMap;

	}

	public Map<Integer, List<UniversityDm>> buildUniversitiesMap() {

		Map<Integer, List<UniversityDm>> universitiesMap = new HashMap<Integer, List<UniversityDm>>();
		for (UniversityDm universityDm : listUniversities()) {
			List<UniversityDm> universitiesList = universitiesMap.get(universityDm.getUniversityId());
			if (universitiesList == null) {
				universitiesList = new ArrayList<UniversityDm>();
			}
			universitiesList.add(universityDm);
			universitiesMap.put(universityDm.getUniversityId(), universitiesList);
		}

		return universitiesMap;

	}

	public List<UserDm> listuserTypes() {
		String SQL = "select * from user";
		List<UserDm> userList = jdbcTemplateObject.query(SQL, new UserMapper());
		return userList;
	}

	/*
	 * public List<UserDm> listUserTypes() { String SQL = "select * from user";
	 * List<UserDm> userList = jdbcTemplateObject.query(SQL, new UserMapper());
	 * return userList; }
	 */

	public List<FunctionalDm> listFunctions() {
		String SQL = "select * from functional_details";
		List<FunctionalDm> functionalList = jdbcTemplateObject.query(SQL, new FunctionalMapper());
		return functionalList;
	}

	public List<TitleDm> listTitles() {
		String SQL = "select * from title";
		List<TitleDm> titleList = jdbcTemplateObject.query(SQL, new TitleMapper());
		return titleList;
	}

	public Map<Integer, List<TitleDm>> buildTitlesMap() {
		Map<Integer, List<TitleDm>> titlesMap = new HashMap<Integer, List<TitleDm>>();
		for (TitleDm titleDm : listTitles()) {
			List<TitleDm> titlesList = titlesMap.get(titleDm.getFunctionalDetailsId());
			if (titlesList == null) {
				titlesList = new ArrayList<TitleDm>();
			}
			titlesList.add(titleDm);
			titlesMap.put(titleDm.getFunctionalDetailsId(), titlesList);
		}

		return titlesMap;

	}

	public Map<Integer, List<BranchDm>> buildBranchesMap() {

		Map<Integer, List<BranchDm>> branchesMap = new HashMap<Integer, List<BranchDm>>();
		for (BranchDm branchDm : listBranches()) {
			List<BranchDm> branchesList = branchesMap.get(branchDm.getLevelId());
			if (branchesList == null) {
				branchesList = new ArrayList<BranchDm>();
			}
			branchesList.add(branchDm);
			branchesMap.put(branchDm.getLevelId(), branchesList);
		}

		return branchesMap;
	}

	@Override
	public String getcountryiso(String countryiso) {
		String SQL = "select countryiso from country" + " where  country_id=" + countryiso;

		List<Map<String, Object>> strLst = this.jdbcTemplateObject.queryForList(SQL);

		return (String) strLst.get(0).get("countryiso");

	}

	/**
	 * public Map<Integer, List<JobPostingDm>> buildTemplatesMap() {
	 * Map<Integer, List<JobPostingDm>> templateMap = new HashMap<Integer, List
	 * <JobPostingDm>>(); for (JobPostingDm jobPostingDm : listTemplates()) {
	 * List<JobPostingDm> templateList = templateMap.get(jobPostingDm
	 * .getTemplateId()); if (templateList == null) { templateList = new
	 * ArrayList<JobPostingDm>(); } templateList.add(jobPostingDm);
	 * templateMap.put(jobPostingDm.getTemplateId(), templateList); }
	 * 
	 * return templateMap;
	 * 
	 * }
	 */

	public List<BranchDm> listBranchesByLevelId(int levelId) {

		String SQL = "select edu_branch.branch_id, edu_branch.branch_code as Branch_code," + "edu_branch.description,"
				+ "edu_branch.level_id as Level_id from edu_branch,edu_level"
				+ " where edu_branch.level_id=edu_level.level_id" + " and edu_level.level_id='" + levelId + "'";
		List<BranchDm> branchListlevelid = jdbcTemplateObject.query(SQL, new BranchMapper());
		return branchListlevelid;
	}

	public List<CityDm> listCitiesBystateId(int stateId) {
		String SQL = "select city.city_id as City_id, city.city_name as City_name, city.state_id as State_id"
				+ " from city,state" + " where city.state_id=state.state_id" + " and state.state_id='" + stateId + "'";
		List<CityDm> cityListstateid = jdbcTemplateObject.query(SQL, new CityMapper());
		return cityListstateid;
	}

	/**public List<String> listTemplates1(int client_id) {
		String SQL = "select template_name from jobposting where client_id='" + client_id + "'";
		List<String> templatelist1 = jdbcTemplateObject.queryForList(SQL, String.class);
		return templatelist1;
	}*/
	public List<String> listTemplates1(int client_id) {
		  String SQL = "select template_name from jobposting where client_id='" + client_id + "'";
		  List<String> templatelist1 = jdbcTemplateObject.queryForList(SQL, String.class);
		  templatelist1.removeAll(Collections.singleton(null));
		  return templatelist1;
		 }
	public List<String> listCompanies(int user_id) {
		String SQL = "select search, employer_name from postloginpro where user_id='" + user_id + "'";
		List<String> companieslist = jdbcTemplateObject.queryForList(SQL, String.class);
		return companieslist;
	}
	public List<String> listEmails(String clientrelated) {
		  String SQL = "select email_id from client where email_id LIKE '%"+clientrelated+"'";
		  List<String> emaillist = jdbcTemplateObject.queryForList(SQL, String.class);
		  emaillist.removeAll(Collections.singleton(null));
		  return emaillist;
		 }
	/**public List<UserTrainingDm> listTraining() {
		String SQL = "select * from training";
		List<UserTrainingDm> trainingList = jdbcTemplateObject.query(SQL, new UserTrainingMapper());
		return trainingList;
	}*/
}