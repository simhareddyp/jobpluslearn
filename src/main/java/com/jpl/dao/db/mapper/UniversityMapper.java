package com.jpl.dao.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jpl.ui.model.UniversityDm;

public class UniversityMapper implements RowMapper<UniversityDm> {

	public UniversityDm mapRow(ResultSet rs, int rowNum) throws SQLException {

		UniversityDm universityDm = new UniversityDm();
		universityDm.setUniversityId(rs.getInt("university_id"));
		universityDm.setUniversityCode(rs.getString("university_code"));
		universityDm.setdescription(rs.getString("description"));
		universityDm.setStateId(rs.getInt("state_id"));
		return universityDm;

	}
}