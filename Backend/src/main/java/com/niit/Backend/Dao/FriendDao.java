package com.niit.Backend.Dao;
import java.util.List;

import com.niit.Backend.Model.Friend;
import com.niit.Backend.Model.User;

import oracle.net.aso.r;

public interface FriendDao {
	List<User> listOfSuggestedUsers(String userName);
	void friendRequest(Friend friend);
	List<r> pendingRequests(String toId);
	void updatePendingRequest(Friend friend);
	List<String> listOfFriends(String userName); 
	
}
