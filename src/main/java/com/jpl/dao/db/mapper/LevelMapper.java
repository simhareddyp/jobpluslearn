package com.jpl.dao.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jpl.ui.model.LevelDm;

public class LevelMapper implements RowMapper<LevelDm> {

	public LevelDm mapRow(ResultSet rs, int rowNum) throws SQLException {

		LevelDm levelDm = new LevelDm();
		levelDm.setLevelId(rs.getInt("level_id"));
		levelDm.setLevelCode(rs.getString("level_code"));
		levelDm.setDescription(rs.getString("description"));

		return levelDm;
	}
}
