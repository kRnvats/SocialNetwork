package com.niit.Backend.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Backend.Model.Blog;

@Repository("BlogDao")
@Transactional
public class BlogDaoImpl implements BlogDao {

	@Autowired
	SessionFactory sessionFactory;
	@Transactional
	public boolean createBlog(Blog blog) 
	{
		try
		{
			blog.setBlogStatus(false);
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
			}
			
	}
	public boolean editBlog(Blog blog) {
		Session s = sessionFactory.getCurrentSession();
		blog.setBlogName("ABCD");
		s.update(blog);
		return false;
	}
	
	public boolean deleteBlog(Integer blogId) {
		Session s1= sessionFactory.getCurrentSession();
		Blog b =(Blog)s1.load(Blog.class, blogId);
		s1.delete(b);
		return false;
	}
	public Blog getBlog(Integer blogId) {
		Session session = sessionFactory.getCurrentSession();
		Blog blog=(Blog)session.get(Blog.class,blogId);
		return blog;
	}
	public List<Blog> getAllBlogs(int approved) {
		Session session =sessionFactory.openSession();
		String querys="";
		if(approved==1)
				querys="from Blog where blogStatus="+approved;
		else
			querys="from Blog where  rejectionReason is null and blogStatus="+approved;
		Query query = session.createQuery(querys);
		List<Blog> list=query.list();
		return list;
	}
	public void approveBlog(Blog blog) {
		Session s = sessionFactory.getCurrentSession();
		blog.setBlogStatus(true);
		s.update(blog);
	}

//	public List<Blog> getAllBlogsRejected(int rejected) {
//		Session session =sessionFactory.openSession();
//		
//		Query query = session.createQuery("from Blog where rejectionReason!=null and blogStatus="+rejected);
//		List<Blog> list=query.list();
//		return null;
//	}
}