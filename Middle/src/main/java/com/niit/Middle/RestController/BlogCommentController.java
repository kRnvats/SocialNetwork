package com.niit.Middle.RestController;

import java.util.ArrayList;
import java.util.Date;

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
import com.niit.Backend.Model.BlogComment;

@RestController
public class BlogCommentController {
	
	@Autowired
	BlogCommentDao blogCommentDao;
	
	@GetMapping(value="/getAllBlogComments()")
	public ResponseEntity<ArrayList<BlogComment>> getAllBlogComments()
	{
		ArrayList<BlogComment> listBlogs = new ArrayList<BlogComment>();
		listBlogs = (ArrayList<BlogComment>)blogCommentDao.getALLBlogComments();
		return new  ResponseEntity<ArrayList<BlogComment>>(listBlogs,HttpStatus.ACCEPTED);
	}
	@PostMapping(value="/addBlogComment")
	public ResponseEntity<String> createBlogComment(@RequestBody BlogComment blogComment)
	{				
		blogComment.setBlogCommentDate(new Date());
	if(blogCommentDao.addBlogComment(blogComment))
	{
		
		return new ResponseEntity<String> ("Blog Created",HttpStatus.ACCEPTED);

	}
	else {
		return new ResponseEntity<String> ("Blog Problem",HttpStatus.METHOD_FAILURE);

	}
	
		
	}

	@PutMapping("/editBlogComment/{blogCommentId}")
	public ResponseEntity<String> editBlog (@PathVariable("blogCommentId")Integer blogId)
	{
		
		BlogComment blogComment = blogCommentDao.getBlogComment(blogId);
		blogCommentDao.editBlogComment(blogComment);
		return new ResponseEntity<String> ("Blog Edited",HttpStatus.ACCEPTED);
	}
	@GetMapping("/getBlogComment/{blogId}")
	public BlogComment getBlog (@PathVariable("blogId") int blogId)
	{
		
		return blogCommentDao.getBlogComment(blogId);

	}
	
	@DeleteMapping("/deleteBlogComment/{blogId}")
	public ResponseEntity<String> deleteBlogComment (@PathVariable("blogId")Integer blogId,@RequestBody BlogComment blogComment)
	{
		blogCommentDao.deleteBlogComment(blogId);
		return new ResponseEntity<String> ("Blog Deleted",HttpStatus.ACCEPTED);

	}
	
	
}