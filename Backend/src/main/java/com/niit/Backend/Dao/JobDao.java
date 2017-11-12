package com.niit.Backend.Dao;

import java.util.List;

import com.niit.Backend.Model.Job;

public interface JobDao {

	void addJob(Job job);
	public List<Job> getAllJobs();
	Job deleteJob(int delete);
	
	
}
