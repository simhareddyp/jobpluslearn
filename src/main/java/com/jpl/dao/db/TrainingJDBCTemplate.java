package com.jpl.dao.db;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jpl.dao.TrainingDao;
import com.jpl.ui.model.TrainingDm;

@Repository
public class TrainingJDBCTemplate implements TrainingDao {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	private static final String insertSQL = "INSERT INTO TRAININGREQUIREMENT("
			+ "TRAINING, TRAINING_NAME, TRAINING_DESCRIPTION, STARTDATE, ENDDATE, "
			+ "KEYWORDS, CITY_NAME, INSTITUTE_NAME, ABOUT_INSTITUTE, WEBSITE, CONTACT_PERSON, ADDRESS, "
			+ "CONTACT_NUMBER, MANAGE_RESPONSE, REFERENCE_ID, COST, CLIENT_ID)"
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	@PostConstruct
	public void setJdbcTemplate() {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void insertTrainingrequirement(TrainingDm trainingDm) {
		this.jdbcTemplateObject.update(insertSQL, trainingDm.getTraining(),
				trainingDm.getTrainingName(),
				trainingDm.getTrainingDescription(), trainingDm.getStartdate(),
				trainingDm.getEnddate(), trainingDm.getKeywords(), trainingDm.getCityName(),
				trainingDm.getInstituteName(), trainingDm.getAboutInstitute(),
				trainingDm.getWebsite(), trainingDm.getContactPerson(),
				trainingDm.getAddress(), trainingDm.getContactNumber(),
				trainingDm.getManageResponse(), trainingDm.getReferenceId(),
				trainingDm.getCost(), trainingDm.getClientId());
	}

}
