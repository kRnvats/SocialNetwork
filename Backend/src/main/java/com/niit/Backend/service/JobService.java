package com.niit.Backend.service;

import java.util.List;

import com.niit.Backend.Model.Job;

public interface JobService {
	void addJob(Job job);
	public List<Job> getAllJobs();
	Job deleteJob(int delete);
	

}
