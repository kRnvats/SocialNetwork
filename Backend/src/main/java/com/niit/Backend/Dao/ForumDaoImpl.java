package com.niit.Backend.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Backend.Model.Forum;
@Repository("ForumDao")
@Transactional
public class ForumDaoImpl implements ForumDao {
	
	@Autowired
	SessionFactory sessionFactory;
	{this.sessionFactory = sessionFactory;
	
	}
	
	@Transactional
	public boolean createForum(Forum forum) 
	{
		try
		{
			forum.setStatus("A");
			sessionFactory.getCurrentSession().saveOrUpdate(forum);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
			}
			
	}

	

	public Forum getForum(int forumId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Forum> getForum() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean approveForum(Forum forum) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean editForum(Forum forumId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteForum(int forumId) {
		// TODO Auto-generated method stub
		return false;
	}






	public ArrayList<Forum> getAllForums() {
		// TODO Auto-generated method stub
		return null;
	}
}