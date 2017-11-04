package com.niit.Middle.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.Backend.Dao.BlogCommentDao;
import com.niit.Backend.Model.Blog;
import com.niit.Backend.Model.BlogComment;
import com.niit.Backend.Model.Error;
import com.niit.Backend.Model.User;
import com.niit.Backend.service.BlogCommentService;
import com.niit.Backend.service.BlogService;
import com.niit.Backend.service.UserService;

@RestController
public class BlogCommentController {
	
	@Autowired
	BlogCommentDao blogCommentDao;
	
	@Autowired
	BlogCommentService blogCommentService;
	@Autowired
	UserService userService;
	@Autowired 
	BlogService blogService;
	
	
	@PostMapping(value="/addBlogComment/{blogId}")
	
	public ResponseEntity<?> createBlogComment(@RequestBody BlogComment blogComment,@PathVariable ("blogId")int blogId, HttpSession httpSession)
	{
		System.out.println("test id    ======="+blogId);
		String userName=(String)httpSession.getAttribute("firstName");
		System.out.println("user name=== "+userName);
		Error error= new Error(13,"Unauthroized Access");
		if(userName==null)
		{
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		Blog blog=blogService.getBlog(blogId);
		System.out.println("blog ======="+blog.getBlogName());
		blogComment.setBlog(blog);
		User postedBy= userService.getUserByUserName(userName);
		blogComment.setPostedBy(postedBy);
		blogComment.setBlogCommentDate(new Date());
		try {
			blogCommentService.addBlogComment(blogComment);
	
		
		return new ResponseEntity<BlogComment> (blogComment,HttpStatus.ACCEPTED);

	}
	catch(Exception e){
		return new ResponseEntity<Error> (error,HttpStatus.BAD_REQUEST);

	}
	
		
	}

	@PutMapping("/editBlogComment/{blogCommentId}")
	public ResponseEntity<String> editBlog (@PathVariable("blogCommentId")Integer blogId)
	{
		
		BlogComment blogComment = blogCommentDao.getBlogComment(blogId);
		blogCommentDao.editBlogComment(blogComment);
		return new ResponseEntity<String> ("Blog Edited",HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getBlogComments/{blogId}")
	public  ResponseEntity<?> getBlogComments  (@PathVariable int blogId,HttpSession httpSession)
	{
		System.out.println("HEY buddy");
		
		String userName=(String)httpSession.getAttribute("firstName");
		
		Error error= new Error(13,"Unauthroized Access");
		if(userName==null)
		{
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		System.out.println("hello test");
		List<BlogComment> blogComments = blogCommentService.getBlogComments(blogId);
		System.out.println("testing string");
		for(BlogComment b:blogComments){
		}
		return new ResponseEntity<List<BlogComment>>(blogComments,HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/deleteBlogComment/{blogId}")
	public ResponseEntity<String> deleteBlogComment (@PathVariable("blogId")Integer blogId,@RequestBody BlogComment blogComment)
	{
		blogCommentDao.deleteBlogComment(blogId);
		return new ResponseEntity<String> ("Blog Deleted",HttpStatus.ACCEPTED);

	}
	
	
}


































	