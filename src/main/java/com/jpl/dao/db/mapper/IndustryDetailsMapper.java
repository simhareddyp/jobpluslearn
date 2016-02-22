package com.jpl.dao.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jpl.ui.model.IndustryDetailsDm;

public class IndustryDetailsMapper implements RowMapper<IndustryDetailsDm> {

	public IndustryDetailsDm mapRow(ResultSet rs, int rowNum)
			throws SQLException {

		IndustryDetailsDm industryDetailsDm = new IndustryDetailsDm();
		industryDetailsDm.setIndustryId(rs.getInt("industry_id"));
		industryDetailsDm.setIndustryDetailsId(rs.getInt("industry_details_id"));
		industryDetailsDm.setIndustryType(rs.getString("industry_type"));
		industryDetailsDm.setUserId(rs.getInt("user_id"));

		return industryDetailsDm;
	}
}
