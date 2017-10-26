package com.niit.Backend.Dao;
import java.util.List;

import com.niit.Backend.Model.BlogComment;
public interface BlogCommentDao {

	public boolean addBlogComment(BlogComment blogComment);
	public boolean editBlogComment(BlogComment  blogComment);
	public boolean deleteBlogComment(Integer blogCommentId);
	public BlogComment getBlogComment(Integer blogCommentId);
	public List<BlogComment> getALLBlogComments();
	public List<BlogComment> getBlogComments(int blogId);
}