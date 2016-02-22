package com.jpl.dao.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jpl.ui.model.CityDm;

public class CityMapper implements RowMapper<CityDm> {

	public CityDm mapRow(ResultSet rs, int rowNum) throws SQLException {

		CityDm cityDm = new CityDm();
		cityDm.setCityId(rs.getInt("city_id"));
		cityDm.setStateId(rs.getInt("state_id"));
		cityDm.setCityNm(rs.getString("city_name"));

		return cityDm;
	}
}
