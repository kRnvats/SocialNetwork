package com.niit.Backend.Test;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Backend.Dao.ForumDao;
import com.niit.Backend.Model.Forum;

public class ForumDaoTestCase {
	static ForumDao forumDao;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.niit.Backend");
		annotationConfigApplicationContext.refresh();
		forumDao=(ForumDao)annotationConfigApplicationContext.getBean("ForumDao");
		
	}

	
	@Test
	public void createForumtest() 
	{
	Forum forum = new Forum();
	forum.setForumId(1996);
	forum.setForumName("Karan");
	forum.setForumContent("Karan is a Testing Tool");
	forum.setUsername("vatskaran5@gmail.com");
	forum.setCreateDate(new java.util.Date());
	forum.setStatus("NA");
	forum.setLikes(0);
	forumDao.createForum(forum);
	assertTrue("Problem in Forum Creation",forumDao.createForum(forum));
	}
	@Ignore
	@Test
	public void editForumTest()
		{
		Forum forum = new Forum();
		forum.setForumId(1995);
		forum.setForumName("Karan_Vats");
		forum.setForumContent(" is a Testing Tool");
		forum.setUsername("vatskaran5@gmail.com");
		forum.setCreateDate(new java.util.Date());
		forum.setStatus("NA");
		forum.setLikes(0);
		assertTrue("Problem in Forum Creation",forumDao.createForum(forum));
		}
	@Ignore
	@Test
	public void approveBlogTest()
	{
		Forum forum = new Forum();
		forum.setForumId(1994);
		forum.setStatus("A");
		forum.setLikes(2);
		assertTrue("Problem in Forum Creation",forumDao.approveForum(forum));
		
	}
	@Ignore
	@Test
		public void getAllApprovedForumTest()
		{
		List<Forum>listForum=forumDao.getForum();
		assertTrue("NoApprovedForums",listForum.size()>0);
		}

		

	@Test
	public void deleteForumTest()
	{
		assertTrue("No approved Forums",forumDao.deleteForum(4));
	}

	}
		

