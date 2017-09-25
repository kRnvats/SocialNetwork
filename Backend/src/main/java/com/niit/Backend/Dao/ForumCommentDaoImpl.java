package com.niit.Backend.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Backend.Model.ForumComment;

@Repository("forumCommentDao")
@Transactional
public class ForumCommentDaoImpl implements ForumCommentDao {

	
	@Autowired
	SessionFactory sessionFactory; 
	
	public boolean addForumComment(ForumComment forumComment) 
	{
		Session s = sessionFactory.getCurrentSession();
		s.saveOrUpdate(forumComment);
		return true;
	}

	public boolean editForumComment(ForumComment forumCommentId)
	{
		Session s = sessionFactory.getCurrentSession();
		s.update(forumCommentId);
		return true;
	}

	public boolean deleteForumComment(Integer forumCommentId) 
	{
		Session s1= sessionFactory.getCurrentSession();
		ForumComment b =(ForumComment)s1.load(ForumComment.class, forumCommentId);
		s1.delete(b);
		return true;
	}

	public ForumComment getForumComment(Integer forumCommentId)
	{
		Session s1 =sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		Query q = s1.createQuery("from ForumComment where forumCommentId="+forumCommentId);
	    ForumComment b = (ForumComment)q.getSingleResult();
	    return b;
	}

	public List<ForumComment> getAllForumComments() 
	{
		Session session =sessionFactory.openSession();
		Query query = session.createQuery("from ForumComment");
		List<ForumComment> list=query.getResultList();
		return list;
	}

}
