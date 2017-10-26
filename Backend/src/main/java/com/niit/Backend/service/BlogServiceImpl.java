package com.niit.Backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.Backend.Dao.BlogDao;
import com.niit.Backend.Model.Blog;
import com.niit.Backend.Model.BlogComment;

@Service
public class BlogServiceImpl implements BlogService {
@Autowired
BlogDao blogDao;
	public boolean createBlog(Blog blog) {
		return blogDao.createBlog(blog);
	}

	public List<Blog> getAllBlogs(int approved) {
		return blogDao.getAllBlogs(approved);
	}

	public void approve(Blog blog) {
		 blogDao.approveBlog(blog);
	}

	public Blog getBlog(int id) {
		return blogDao.getBlog(id);
	}
	
//	public List<Blog> getAllBlogsRejected(int rejected) {
//		return blogDao.getAllBlogsRejected(rejected);
//	}
}