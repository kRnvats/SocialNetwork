package com.niit.Backend.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.niit.Backend.Dao.BlogCommentDao;
import com.niit.Backend.Model.Blog;
import com.niit.Backend.Model.BlogComment;

@Service
public class BlogCommentServiceImpl implements BlogCommentService {

	@Autowired
	BlogCommentDao blogCommentDao;
	public boolean addBlogComment(BlogComment blogComment) {
		return blogCommentDao.addBlogComment(blogComment);
	}
	public List<BlogComment> getBlogComments(int blogId) {
		return  blogCommentDao.getBlogComments(blogId);
	}
	public BlogComment getBlogComment(int blogCommentId) {
		return blogCommentDao.getBlogComment(blogCommentId);
	}
}
