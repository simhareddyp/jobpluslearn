package com.jpl.dao.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jpl.ui.model.CityDm;
import com.jpl.ui.model.LandlinenoDm;

public class LandlinenoMapper implements RowMapper<LandlinenoDm> {

	public LandlinenoDm mapRow(ResultSet rs, int rowNum) throws SQLException {

		LandlinenoDm landlinenoDm = new LandlinenoDm();
		landlinenoDm.setLandlinenoId(rs.getInt("landlineno_id"));
		landlinenoDm.setCountryId(rs.getInt("country_id"));
		landlinenoDm.setCountrystdcode(rs.getString("Country_stdcode"));

		return landlinenoDm;
	}
}
