package com.niit.Backend.service;

import java.util.List;

import com.niit.Backend.Model.BlogComment;

public interface BlogCommentService {

		public boolean addBlogComment(com.niit.Backend.Model.BlogComment blogComment);
		public List<BlogComment> getBlogComments(int blogId);
		BlogComment getBlogComment(int blogId);
}

