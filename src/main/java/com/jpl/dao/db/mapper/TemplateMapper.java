package com.jpl.dao.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jpl.ui.model.JobPostingDm;

public class TemplateMapper implements RowMapper<JobPostingDm> {
	public JobPostingDm mapRow(ResultSet rs, int rowNum) throws SQLException {

		JobPostingDm jobPostingDm = new JobPostingDm();
		return jobPostingDm;

	}
}
