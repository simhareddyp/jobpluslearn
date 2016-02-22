package com.jpl.dao.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jpl.ui.model.CountryDm;

public class CountryMapper implements RowMapper<CountryDm> {

	public CountryDm mapRow(ResultSet rs, int rowNum) throws SQLException {

		CountryDm countryDm = new CountryDm();
		countryDm.setCountryId(rs.getInt("country_id"));
		countryDm.setCountryName(rs.getString("country_name"));
		countryDm.setCountryCode(rs.getString("country_code"));

		return countryDm;

	}

}
