package com.jpl.dao.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jpl.ui.model.TitleDm;

public class TitleMapper implements RowMapper<TitleDm> {

	public TitleDm mapRow(ResultSet rs, int rowNum) throws SQLException {

		TitleDm titleDm = new TitleDm();
		titleDm.setTitleId(rs.getInt("title_id"));
		titleDm.setTitleName(rs.getString("title_Name"));
		titleDm.setFunctionalDetailsId(rs.getInt("functional_Details_Id"));

		return titleDm;
	}

}
