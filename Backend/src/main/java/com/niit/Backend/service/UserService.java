package com.niit.Backend.service;

import com.niit.Backend.Model.User;

public interface UserService {
	User login(User user);
	
	boolean registerUser(User user);

	boolean isUsernameValid(String firstName);
	boolean isEmailValid(String email);

	 void update(User validUser);



	

	

}
