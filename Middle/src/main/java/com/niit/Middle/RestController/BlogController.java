package com.niit.Middle.RestController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.niit.Backend.Dao.BlogDao;
import com.niit.Backend.Model.Blog;
import com.niit.Backend.Model.Error;
import com.niit.Backend.Model.User;
import com.niit.Backend.service.BlogService;
import com.niit.Backend.service.UserService;

@RestController

public class BlogController {
		
	@Autowired
	BlogDao blogDao;
	@Autowired
	UserService userService;
	@Autowired
	BlogService blogservice;
	
	

//	
//	@GetMapping(value="/getAllBlogs")
//	public ResponseEntity<ArrayList<Blog>> getAllBlogs()
//	{
//		ArrayList<Blog> listBlogs = new ArrayList<Blog>();
//		listBlogs = (ArrayList<Blog>)blogDAO.getAllBlogs();
//		return new  ResponseEntity<ArrayList<Blog>>(listBlogs,HttpStatus.ACCEPTED);
//	}
	
	@RequestMapping(value="/createBlog",method=RequestMethod.POST)
	public ResponseEntity<?> createBlog(@RequestBody Blog blog,HttpSession httpSession)
	{				
		String userName=(String)httpSession.getAttribute("firstName");
		Error error= new Error(13,"Unauthroized Access");
		if(userName==null)
		{
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		blog.setCreateDate(new Date());
		User postedBy=userService.getUserByUserName(userName);
		blog.setPostedBy(postedBy);
					try 
					{
		
						blogDao.createBlog(blog);
						System.out.println("name"+blog.getBlogName());
						return new ResponseEntity<Blog> (blog,HttpStatus.OK);
					}
					catch(Exception e)
					{
						return new ResponseEntity<Error> (error,HttpStatus.UNAUTHORIZED);
					}
	
		
	}
	
//	@PutMapping("/getBlogById/{blogId}")
//	public ResponseEntity<String> approve (@PathVariable("blogId")Integer blogId)
//	{
//		Blog blog = blogDao.getBlog(blogId);
//		
//		if(blogDao.approveBlog(blog))
//		{
//			return new ResponseEntity<String> ("Blog Approved",HttpStatus.ACCEPTED);
//
//		}
//		else
//		{
//			return new ResponseEntity<String> ("Blog Not Approved",HttpStatus.BAD_GATEWAY);
//
//		}
//
//	}
	
	@DeleteMapping("/deleteBlog/{blogId}")
	public ResponseEntity<String> deleteBlog (@PathVariable("blogId")Integer blogId,@RequestBody Blog blog)
	{
		blogDao.deleteBlog(blogId);
		return new ResponseEntity<String> ("Blog Deleted",HttpStatus.ACCEPTED);

	}
	
	@GetMapping("/getBlog/{blogId}")
	public ResponseEntity<?> getBlog (@PathVariable int blogId,HttpSession httpSession)
	{		String userName=(String)httpSession.getAttribute("firstName");
	Error error= new Error(13,"Unauthroized Access");

		if(userName==null)
		{
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		Blog blog = blogservice.getBlog(blogId);
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);

	}
	
	@PutMapping("/editBlog/{blogId}")
	public ResponseEntity<String> editBlog (@PathVariable("blogId")Integer blogId)
	{
		
		Blog blog = blogDao.getBlog(blogId);
		blogDao.editBlog(blog);
		return new ResponseEntity<String> ("Blog Edited",HttpStatus.ACCEPTED);
	}

	@RequestMapping(value="/getAllBlogs/{approved}",method=RequestMethod.GET)
	public ResponseEntity<?> getAllBlogs (@PathVariable int approved,HttpSession httpSession)
	{
		String userName=(String)httpSession.getAttribute("firstName");
		Error error= new Error(11,"Unauthroized Access");
		
		if(userName==null)
		{
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		List<Blog> blog=blogDao.getAllBlogs(approved);
		return new ResponseEntity<List<Blog>>(blog,HttpStatus.ACCEPTED);
	}
	

	@RequestMapping(value="/approveBlog",method=RequestMethod.PUT)

	public ResponseEntity<?> approveBlog(@RequestBody Blog blog,HttpSession httpSession)
	{
		String userName=(String)httpSession.getAttribute("firstName");
		
		System.out.println("hello buddy");
		if(userName==null)
		{
			Error error= new Error(11,"Unauthroized Access");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
	//	if(!blog.isBlogStatus() && blog.getRejectionReason()==null)
		//{
			//blog.setRejectionReason("Not Mentioned");
		//}
		blogservice.approve(blog);
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}

}

























