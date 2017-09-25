package com.niit.Backend.Dao;

import com.niit.Backend.Model.Blog;

import java.util.ArrayList;
import java.util.List;

public interface BlogDao {

	public  boolean createBlog(Blog blog);
	public Blog getBlog(int blogId);
	public List <Blog>getBlog();
	public boolean approveBlog(Blog blog);
	public boolean editBlog(Blog blog);
	public boolean deleteBlog(int blogId);
	public ArrayList<Blog> getAllBlogs();
	
}
