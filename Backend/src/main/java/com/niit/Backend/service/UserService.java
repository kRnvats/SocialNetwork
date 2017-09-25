package com.niit.Backend.service;

import com.niit.Backend.Model.User;

public interface UserService {

	boolean registerUser(User user);

	boolean isUsernameValid(String firstName);

}
