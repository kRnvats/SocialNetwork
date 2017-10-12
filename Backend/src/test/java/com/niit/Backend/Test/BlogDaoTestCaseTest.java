package com.niit.Backend.Test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Backend.Dao.BlogDao;
import com.niit.Backend.Model.Blog;

public class BlogDaoTestCaseTest {
	
	static BlogDao blogDao;
	
@BeforeClass
	public static void initialize()
	{
	AnnotationConfigApplicationContext annotationConfigAppContext = new AnnotationConfigApplicationContext();
	annotationConfigAppContext.scan("com.niit.Backend");
	annotationConfigAppContext.refresh();
	
	blogDao=(BlogDao)annotationConfigAppContext.getBean("BlogDao");
	
	}

	@Test
	public void createBlogTest()
		{
		Blog blog= new Blog();
		blog.setBlogId(1996);
		blog.setBlogName("Karan");
		blog.setBlogContent("Karan is a Testing Tool");
		blog.setCreateDate(new java.util.Date());
		blog.setBlogStatus(true);
		blog.setLikes(0);
		blogDao.createBlog(blog);
		assertTrue("Problem in Blog Creation",blogDao.createBlog(blog));
		}
@Ignore
@Test
public void editBlogTest()
	{
	Blog blog= new Blog();
	blog.setBlogId(1995);
	blog.setBlogName("Karan_Vats");
	blog.setBlogContent(" is a Testing Tool");
	blog.setCreateDate(new java.util.Date());
	blog.setBlogStatus(true);
	blog.setLikes(0);
	assertTrue("Problem in Blog Creation",blogDao.createBlog(blog));
	}
@Ignore
@Test
public void approveBlogTest()
{
	Blog blog = new Blog();
	blog.setBlogId(1994);
	blog.setBlogStatus(true);
	blog.setLikes(2);
	assertTrue("Problem in Blog Creation",blogDao.approveBlog(blog));
	
}
@Ignore
@Test
	public void getAllApprovedBlogTest()
	{
	List<Blog>listBlog=blogDao.getAllBlogs();
	assertTrue("NoApprovedBlogs",listBlog.size()>0);
	}



@Test
public void deleteBlogTest()
{
	assertTrue("No approved Blogs",blogDao.deleteBlog(4));
}

}
	

	
	