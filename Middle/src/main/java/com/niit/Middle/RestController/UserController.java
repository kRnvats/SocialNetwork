package com.niit.Middle.RestController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.Backend.Model.User;
import com.niit.Backend.service.UserService;
import com.niit.Backend.Model.Error;
@Controller
public class UserController {
	
	
@Autowired
private UserService userService;



@RequestMapping(value="/RegisterUser",method=RequestMethod.POST)
public ResponseEntity<?> registerUser(@RequestBody User user)
{
	if(!userService.isUsernameValid(user.getFirstName())) {//duplicate result
		
		Error error = new Error(2,"Username Already there");
		return new ResponseEntity<Error>(error,HttpStatus.NOT_ACCEPTABLE);
	}
	if(!userService.isEmailValid(user.getEmailId())) {
		//duplicate result
		
		Error error = new Error(3,"Email Already exists");
		return new ResponseEntity<Error>(error,HttpStatus.NOT_ACCEPTABLE);
	}
	boolean result = userService.registerUser(user);
	if(result)
	{
		return new ResponseEntity<User>(user,HttpStatus.ACCEPTED);
	}
	else
	{
		Error error = new Error(1,"Unable To Register");
		return new ResponseEntity<Error>(error,HttpStatus.NOT_ACCEPTABLE);

	}
}
@RequestMapping(value="/Login",method=RequestMethod.POST)
public ResponseEntity<?> login(@RequestBody User user,HttpSession session)
{
	User u=userService.login(user);
	if(u==null) {
		Error error = new Error(4,"Invalid Username Or Password");
		return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
	}
		u.setOnline(true);
		try {
		userService.update(u);
		}catch(Exception e){
			Error error = new Error(6,"Unable to update online status");
			return new ResponseEntity<Error>(error,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		System.out.println(u.getFirstName());
		session.setAttribute("firstName",u.getFirstName());
		return new ResponseEntity<User>(u,HttpStatus.ACCEPTED);
	
}
@RequestMapping(value="/Logout",method=RequestMethod.PUT)
public ResponseEntity<?> logout(HttpSession session)
{
	String firstName=session.getAttribute("firstName").toString();
	if(firstName==null) {
		Error error = new Error(7,"UNAUTHORIZED");
		return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
	}
	User user = userService.getUserByUserName(firstName);
	user.setOnline(false);
	userService.update(user);
	session.removeAttribute("firstName");
	session.invalidate();
	return new ResponseEntity<String>("Logout",HttpStatus.ACCEPTED);
}
@RequestMapping(value="/GetUser",method=RequestMethod.GET)

public ResponseEntity<?> getUser(HttpSession session)
{
	String userName = (String)session.getAttribute("firstName");
	if(userName==null)
	{
		Error error = new Error(7,"UNAUTHORIZED");
		return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
	
	}
	User user = userService.getUserByUserName(userName);
	return new ResponseEntity<User>(user,HttpStatus.OK);

}

@RequestMapping(value="/updateUser",method=RequestMethod.PUT)
public ResponseEntity<?> updateUser(@RequestBody User user,HttpSession httpSession)
{
	String userName = (String) httpSession.getAttribute("firstName");
	if(userName==null)
	{
		Error error = new Error(7,"UNAUTHORIZED");
		return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
	
	}
if(!userService.isUpdatedEmailValid(user.getEmailId(),user.getFirstName())) {//duplicate result
		
		Error error = new Error(2,"Email Already there");
	
		return new ResponseEntity<Error>(error,HttpStatus.NOT_ACCEPTABLE);
	}
	try {
		userService.update(user);
		return new ResponseEntity<User>(user,HttpStatus.OK);

	}catch(Exception e) {
		Error error = new Error(10,"Unable To Update");
		return new ResponseEntity<Error>(error,HttpStatus.BAD_GATEWAY);

	}
}
@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
public ResponseEntity<List<User>> getAllUsers() {
	System.out.println("-----Starting getAllUsers method in Controller");
	List<User> users = userService.getAllUser();
	System.out.println("------Ending getAllUsers method in Controller");
	return new ResponseEntity<List<User>>(users, HttpStatus.OK);

}


}





















	