package com.niit.Backend.Dao;

import com.niit.Backend.Model.Forum;

import java.util.List;

public interface ForumDao {

	public  boolean createForum(Forum forum);
	public Forum getForum(int forumId);
	public List <Forum>getForum();
	public boolean approverForum(Forum forum);
	public boolean editForum(int forumId);
	public boolean deleteForum(int forumId);
	
}
