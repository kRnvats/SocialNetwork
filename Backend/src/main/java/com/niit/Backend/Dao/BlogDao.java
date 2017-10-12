package com.niit.Backend.Dao;

import com.niit.Backend.Model.Blog;

import java.util.ArrayList;
import java.util.List;

public interface BlogDao {

	public boolean createBlog(Blog blog);
	public boolean editBlog(Blog blog);
	public boolean deleteBlog(Integer blogId);
	public Blog getBlog(Integer blogId);
	public List<Blog> getAllBlogs(int approved);
	public void approveBlog(Blog blog);
}

