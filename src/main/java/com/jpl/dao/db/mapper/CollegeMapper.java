package com.jpl.dao.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jpl.ui.model.CollegeDm;

public class CollegeMapper implements RowMapper<CollegeDm> {

	public CollegeDm mapRow(ResultSet rs, int rowNum) throws SQLException {

		CollegeDm collegeDm = new CollegeDm();
		collegeDm.setCollegeId(rs.getInt("college_id"));
		collegeDm.setCollegeCode(rs.getString("college_code"));
		collegeDm.setDescription(rs.getString("description"));
		collegeDm.setUniversityId(rs.getInt("university_id"));

		return collegeDm;
}
}
