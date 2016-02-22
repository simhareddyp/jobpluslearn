package com.jpl.dao;

import com.jpl.ui.model.ClientDm;
import com.jpl.ui.model.JobPostingDm;

public interface JobPostingDao {
	public void insertJobposting(JobPostingDm jobpostingDm);

	public void insertTemplate(JobPostingDm jobpostingDm);

	public int getTemplateId(String templatename);

	public ClientDm getClientDm(String clientName);
	public JobPostingDm getJobpostingDM(String templatename);
	public int updateJobposting(JobPostingDm jobpostingDm);

}
