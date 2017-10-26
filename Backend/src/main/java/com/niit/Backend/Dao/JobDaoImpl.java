package com.niit.Backend.Dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Backend.Model.Blog;
import com.niit.Backend.Model.Job;
@Repository("jobDao")
@Transactional
public class JobDaoImpl implements JobDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public void addJob(Job job) {
	Session s = sessionFactory.getCurrentSession();
	job.setPostedOn(new Date());
	s.save(job);

	}

	public List<Job> getAllJobs() {
		Session session =sessionFactory.openSession();
		Query query = session.createQuery("from Job");
		List<Job> list=(List<Job>) query.uniqueResult();
		return list;
	}

	public Job deleteJob(int delete) {
		Session s = sessionFactory.getCurrentSession();
		Job job=(Job)s.get(Job.class,delete);
		s.delete(job);
		return job;
		
	}

	
}

