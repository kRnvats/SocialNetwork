package com.niit.Backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.Backend.Dao.UserDao;
import com.niit.Backend.Model.User;
@Service("UserService")
public class UserServiceImpl implements UserService{



@Autowired
private UserDao userDao;

	public boolean registerUser(User user) {
		return userDao.registerUser(user);
	}

	public boolean isUsernameValid(String username) {
		return userDao.isUsernameValid(username);
	}

	public boolean isEmailValid(String email) {
		return userDao.isEmailValid(email);
	}

	public User login(User user) {
		
		return userDao.login(user);
	}

	public void update(User user)
	{
		userDao.update(user);
	}

	public User getUserByUserName(String firstName) {
		return userDao.getUserByUserName(firstName);
	}

	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userDao.getAllUser();
	}

	public boolean isUpdatedEmailValid(String email, String username) {
		return userDao.isUpdatedEmailValid(email, username);
	}

}