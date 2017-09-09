package com.niit.Backend.Test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Backend.Dao.BlogDao;
import com.niit.Backend.Model.Blog;

public class BlogDaoTestCase {
	
	static BlogDao blogDao;
	
@BeforeClass
	public static void initialize()
	{
	AnnotationConfigApplicationContext annotationConfigAppContext = new AnnotationConfigApplicationContext();
	annotationConfigAppContext.scan("com.niit.Collaborate");
	annotationConfigAppContext.refresh();
	
	blogDao=(BlogDao)annotationConfigAppContext.getBean("blogDao");
	
	}

	@Test
	public void createBlogTest()
		{
		Blog blog= new Blog();
		blog.setBlogId(1996);
		blog.setBlogName("Karan");
		blog.setBlogContent("Karan is a Testing Tool");
		blog.setUsername("vatskaran5@gmail.com");
		blog.setCreateDate(new java.util.Date());
		blog.setStatus("NA");
		blog.setLikes(0);
		assertTrue("Problem in Blog Creation",blogDao.createBlog(blog));
		}

@Test
public void approveBlogTest()
	{
	Blog blog= new Blog();
	blog.setBlogId(1996);
	blog.setBlogName("Karan");
	blog.setBlogContent("Karan is a Testing Tool");
	blog.setUsername("vatskaran5@gmail.com");
	blog.setCreateDate(new java.util.Date());
	blog.setStatus("NA");
	blog.setLikes(0);
	assertTrue("Problem in Blog Creation",blogDao.createBlog(blog));
	}
@Test
	public void getAllApprovedBlogTest()
	{
	List<Blog>listBlog=blogDao.getBlog();
	assertTrue("NoApprovedBlogs",listBlog.size()>0);
	}

	}
	
		