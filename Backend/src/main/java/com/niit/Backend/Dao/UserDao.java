package com.niit.Backend.Dao;
import com.niit.Backend.Model.User;
import java.util.ArrayList;
import java.util.List;


public interface UserDao {
	public boolean registerUser(User user);
	boolean isEmailValid(String email);
	boolean isUsernameValid(String username);
	User login(User user);

}
