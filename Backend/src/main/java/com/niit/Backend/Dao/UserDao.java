package com.niit.Backend.Dao;
import com.niit.Backend.Model.User;
import java.util.ArrayList;
import java.util.List;


public interface UserDao {
	boolean isUsernameValid(String username);
	public boolean registerUser(User user);
	public boolean isEmailValid(String email);
	
	public User login(User user);
	public void update(User user);
	public User getUserByUserName(String firstName);
	public boolean isUpdatedEmailValid(String email,String username);

}
