package com.niit.Backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.Backend.Dao.FriendDao;
import com.niit.Backend.Model.Friend;
import com.niit.Backend.Model.User;

@Service
public class FriendServiceImpl implements FriendService {
	
	@Autowired
	private FriendDao friendDao;
	public List<User> listOfSuggestedUsers(String userName) {
		return friendDao.listOfSuggestedUsers(userName);
	}

	public void friendRequest(Friend friend) {
		friendDao.friendRequest(friend);
		
	}

	public List<Friend> pendingRequests(String toId) {
		return friendDao.pendingRequests(toId);
	}

	public void updatePendingRequests(Friend friend) {
		friendDao.updatePendingRequest(friend);
		
	}

	public List<String> listOfFriends(String userName) {
		return friendDao.listOfFriends(userName);
	}
}