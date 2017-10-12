package com.niit.Backend.service;

import com.niit.Backend.Model.User;

public interface UserService {
	
	boolean isUsernameValid(String firstName);

	boolean registerUser(User user);

	boolean isEmailValid(String email);

	 void update(User validUser);

	User getUserByUserName(String firstName);
	User login(User user);
	
	


	

	

}
