package com.niit.Backend.Dao;
import java.util.List;

import com.niit.Backend.Model.Friend;
import com.niit.Backend.Model.User;

public interface FriendDao {
List<User>listOfSuggestedUsers(String Username);

List<Friend> pendingRequests(String username);

}
