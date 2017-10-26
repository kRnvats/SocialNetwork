package com.niit.Backend.Dao;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Backend.Model.BlogComment;

@Repository("BlogCommentDao")
@Transactional
public class BlogCommentDaoImpl implements BlogCommentDao 
{

	
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addBlogComment(BlogComment blogComment)
	{
		try{
			System.out.println("blogcomment name      "+blogComment.getBlogCommentText());
		Session s = sessionFactory.getCurrentSession();
		s.save(blogComment);
		return true;
		}
		catch(Exception e){
			System.out.println("error is  "+e.getMessage());
			return false;
		}
	}

	public boolean editBlogComment(BlogComment blogComment) 
	{
		Session s = sessionFactory.getCurrentSession();
		s.update(blogComment);
		return true;
	}

	public boolean deleteBlogComment(Integer blogCommentId)
	{
		Session s1= sessionFactory.getCurrentSession();
		BlogComment b =(BlogComment)s1.load(BlogComment.class, blogCommentId);
		s1.delete(b);
		return true;
	}

	public BlogComment getBlogComment(Integer blogCommentId) 
	{
		Session s1 =sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		Query q = s1.createQuery("from BlogComment where blogCommentID="+blogCommentId);
	    BlogComment b = (BlogComment)q.uniqueResult();
	    return b;
	}

	public List<BlogComment> getALLBlogComments()
	{
		Session session =sessionFactory.openSession();
		Query query = session.createQuery("from BlogComment");
		List<BlogComment> list=query.list();
		return list;
	}

	

	public List<BlogComment> getBlogComments(int BlogId) {
		try{Session session =sessionFactory.openSession();
		Query query = session.createQuery("from BlogComment where blog.blogId="+BlogId);
		List<BlogComment> list=query.list();
		return list;}
		catch(Exception e ){
			System.out.println("erron in getting comments "+e.getMessage() );
			return null;
		}
	}
}




