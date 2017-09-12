package com.niit.Backend.Dao;

import com.niit.Backend.Model.Friend;

import java.util.List;

public interface FriendDao {

	public  boolean addFriend(Friend friend);
	public Friend getFriend(int friendId);
	public List <Friend>getFriend();
	public boolean approverFriend(Friend friend);
	public boolean editFriend(int friendId);
	public boolean deleteFriend(int friendId);
	
}
