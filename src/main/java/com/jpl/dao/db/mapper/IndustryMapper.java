package com.jpl.dao.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jpl.ui.model.IndustryDm;

public class IndustryMapper implements RowMapper<IndustryDm> {

	public IndustryDm mapRow(ResultSet rs, int rowNum) throws SQLException {

		IndustryDm industryDm = new IndustryDm();
		industryDm.setIndustryId(rs.getInt("industry_id"));
		industryDm.setIndustryType(rs.getString("industry_type"));

		return industryDm;
	}
}
