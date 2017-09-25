package com.niit.Backend.Dao;

import java.util.ArrayList;
import java.util.List;

import com.niit.Backend.Model.ForumComment;

public interface ForumCommentDao
{

	public boolean addForumComment(ForumComment forumComment);
	public boolean editForumComment(ForumComment forumComment);
	public boolean deleteForumComment(Integer forumCommentId);
	public ForumComment getForumComment(Integer forumCommentId);
	public List<ForumComment> getAllForumComments();
}