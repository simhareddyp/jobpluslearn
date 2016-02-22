package com.jpl.dao.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jpl.ui.model.StateDm;

public class StateMapper implements RowMapper<StateDm> {

	public StateDm mapRow(ResultSet rs, int rowNum) throws SQLException {

		StateDm stateDm = new StateDm();
		stateDm.setStateId(rs.getInt("state_id"));
		stateDm.setCountryId(rs.getInt("country_id"));
		stateDm.setStateCd(rs.getString("state_cd"));
		stateDm.setStateNm(rs.getString("state_name"));

		return stateDm;
	}
}
