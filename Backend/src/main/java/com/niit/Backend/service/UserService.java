package com.niit.Backend.service;

import java.util.List;

import com.niit.Backend.Model.User;

public interface UserService {
	
	boolean isUsernameValid(String firstName);

	boolean registerUser(User user);

	boolean isEmailValid(String email);

	 void update(User validUser);

	User getUserByUserName(String firstName);
	User login(User user);

	List<User> getAllUser();

	public boolean isUpdatedEmailValid(String emailId, String userName);
	
	


	

	

}
