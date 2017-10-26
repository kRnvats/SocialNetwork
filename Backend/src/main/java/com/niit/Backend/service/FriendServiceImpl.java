package com.niit.Backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.Backend.Dao.FriendDao;
import com.niit.Backend.Model.Friend;
import com.niit.Backend.Model.User;

@Service
public class FriendServiceImpl implements FriendService{
	@Autowired
	private FriendDao friendDao;
	public List<User> listOfSuggestedUsers(String UserName){
		return friendDao.listOfSuggestedUsers(UserName);
		
	}

	public void friendRequest(Friend friend) {
		// TODO Auto-generated method stub
		
	}
	public List<Friend> pendingRequests(String username) {
		
		return friendDao.pendingRequests(username);
		
	}
	

}
