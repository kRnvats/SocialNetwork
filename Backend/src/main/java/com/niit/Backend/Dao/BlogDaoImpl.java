package com.niit.Backend.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.Backend.Model.Blog;

public class BlogDaoImpl implements BlogDao {

	@Autowired
	SessionFactory sessionFactory;
	{this.sessionFactory = sessionFactory;
	
	}
	
	@Transactional
	public boolean createBlog(Blog blog) 
	{
		try
		{
			blog.setStatus("A");
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
			}
			
	}
	public boolean editBlog(int blogId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteBlog(int blogId) {
		// TODO Auto-generated method stub
		return false;
	}

	public Blog getBlog(int blogId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Blog> getAllBlogs() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean approveBlog(Blog blog) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Blog> getBlog() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean approverBlog(Blog blog) {
		// TODO Auto-generated method stub
		return false;
	}

}