package com.niit.Middle.RestController;
import java.util.ArrayList;
import java.util.Date;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.niit.Backend.Dao.BlogDao;
import com.niit.Backend.Model.Blog;

@RestController

public class BlogController {
		
	@Autowired
	BlogDao blogDao;
	
	
	@GetMapping(value="/getAllBlogs")
	public ResponseEntity<ArrayList<Blog>> getAllBlogs()
	{
		ArrayList<Blog> listBlogs = new ArrayList<Blog>();
		listBlogs = (ArrayList<Blog>)blogDao.getAllBlogs();
		return new  ResponseEntity<ArrayList<Blog>>(listBlogs,HttpStatus.ACCEPTED);
	}
	

	@PostMapping(value="/createBlog")
	public ResponseEntity<String> createBlog(@RequestBody Blog blog)
	{				
		blog.setCreateDate(new Date());
	if(blogDao.createBlog(blog))
	{
		
		
		return new ResponseEntity<String> ("Blog Created",HttpStatus.ACCEPTED);

	}
	else {
		return new ResponseEntity<String> ("Blog Problem",HttpStatus.METHOD_FAILURE);

	}
	
		
	}
	
	@PutMapping("/approveBlog/{blogId}")
	public ResponseEntity<String> approveBlog (@PathVariable("blogId")Integer blogId)
	{
		Blog blog = blogDao.getBlog(blogId);
		
		if(blogDao.approveBlog(blog))
		{
			return new ResponseEntity<String> ("Blog Approved",HttpStatus.ACCEPTED);

		}
		else
		{
			return new ResponseEntity<String> ("Blog Not Approved",HttpStatus.BAD_GATEWAY);

		}

	}
	
	@DeleteMapping("/deleteBlog/{blogId}")
	public ResponseEntity<String> deleteBlog (@PathVariable("blogId")Integer blogId,@RequestBody Blog blog)
	{
		blogDao.deleteBlog(blogId);
		return new ResponseEntity<String> ("Blog Deleted",HttpStatus.ACCEPTED);

	}
	
	@GetMapping("/getBlog")
	public Blog getBlog (@RequestParam("blogId") int blogId)
	{
		
		return blogDao.getBlog(blogId);

	}
	
	@PutMapping("/editBlog/{blogId}")
	public ResponseEntity<String> editBlog (@PathVariable("blogId")Integer blogId)
	{
		
		Blog blog = blogDao.getBlog(blogId);
		blogDao.editBlog(blog);
		return new ResponseEntity<String> ("Blog Edited",HttpStatus.ACCEPTED);
	}

}



