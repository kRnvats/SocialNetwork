package com.niit.Backend.Dao;

import com.niit.Backend.Model.Forum;

import java.util.ArrayList;
import java.util.List;

public interface ForumDao {

	public  boolean createForum(Forum forum);
	public Forum getForum(int forumId);
	public List <Forum>getForum();
	public boolean approveForum(Forum forum);
	public boolean editForum(Forum forum);
	public boolean deleteForum(int forumId);
	public ArrayList<Forum> getAllForums();
	
}
