package com.niit.Backend.service;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.niit.Backend.Dao.JobDao;
	import com.niit.Backend.Model.Job;

	@Service
	public class JobServiceImpl implements JobService {

		@Autowired
		JobDao jobDao;
		public void addJob(Job job) {
			jobDao.addJob(job);

		}
		public List<Job> getAllJobs() {
			return jobDao.getAllJobs();
		}
		public Job deleteJob(int delete) {
			return jobDao.deleteJob(delete);
			
		}


	}

