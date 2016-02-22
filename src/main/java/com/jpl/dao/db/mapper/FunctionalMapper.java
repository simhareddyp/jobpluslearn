package com.jpl.dao.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jpl.ui.model.FunctionalDm;

public class FunctionalMapper implements RowMapper<FunctionalDm> {
	public FunctionalDm mapRow(ResultSet rs, int rowNum) throws SQLException {

		FunctionalDm functionalDm = new FunctionalDm();
		functionalDm.setFunctionalDetailsId(rs.getInt("functional_details_id"));
		functionalDm.setFunctionalId(rs.getInt("functional_id"));
		functionalDm.setIndustryDetailsId(rs.getInt("industry_details_id"));
		functionalDm.setFunctionalName(rs.getString("functional_name"));
		functionalDm.setUserId(rs.getInt("user_id"));

		return functionalDm;

	}
}
