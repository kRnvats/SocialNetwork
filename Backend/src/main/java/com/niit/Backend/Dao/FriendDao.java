package com.niit.Backend.Dao;

import java.util.List;

import com.niit.Backend.Model.Friend;
import com.niit.Backend.Model.User;

public interface FriendDao {
	List<User> listOfSuggestedUsers(String userName);
	void friendRequest(Friend friend);
	List<Friend> pendingRequests(String toId);
	void updatePendingRequest(Friend friend);
	List<String> listOfFriends(String userName); 
		
	}
