package com.niit.Backend.service;

import java.util.List;

import com.niit.Backend.Model.Blog;
import com.niit.Backend.Model.BlogComment;

public interface BlogService {
	
	public boolean createBlog(Blog blog);
	public List<Blog> getAllBlogs(int approved);
	public void approve(Blog blog);
	Blog getBlog(int id);
//	public List<Blog> getAllBlogsRejected(int rejected);
}
