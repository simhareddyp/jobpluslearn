package com.jpl.dao.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jpl.ui.model.BranchDm;

public class BranchMapper implements RowMapper<BranchDm> {
	
	public BranchDm mapRow(ResultSet rs, int rowNum) throws SQLException {

		BranchDm branchDm = new BranchDm();
		branchDm.setBranchId(rs.getInt("branch_id"));
		branchDm.setBranchCode(rs.getString("branch_code"));
		branchDm.setDescription(rs.getString("description"));
		branchDm.setLevelId(rs.getInt("level_id"));

		return branchDm;

}
}
