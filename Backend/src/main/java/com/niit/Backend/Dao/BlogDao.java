package com.niit.Backend.Dao;

import com.niit.Backend.Model.Blog;

import java.util.List;

public interface BlogDao {

	public  boolean createBlog(Blog blog);
	public Blog getBlog(int blogId);
	public List <Blog>getBlog();
	public boolean approverBlog(Blog blog);
	public boolean editBlog(int blogId);
	public boolean deleteBlog(int blogId);
	
}
