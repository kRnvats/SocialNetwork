package com.niit.Backend.service;

import java.util.List;

import com.niit.Backend.Model.Friend;
import com.niit.Backend.Model.User;

import oracle.net.aso.r;

public interface FriendService {

List<User> listOfSuggestedUsers(String userName);
void friendRequest(Friend friend);
List<r> pendingRequests(String toId);
void updatePendingRequests(Friend friend);
List<String> listOfFriends(String userName);
}