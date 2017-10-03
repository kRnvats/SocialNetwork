package com.niit.Middle.Controller;

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
@RequestMapping(value="/requestuser",method=RequestMethod.POST)
	public ResponseEntity<?> registerUser(@RequestBody User username){
	//validate username - unique
	if (userService.isUsernameValid(username.getFirstName())){//username is duplicate
		Error error=new Error(2,"User already exists.. please enter different user");
			}
		boolean result=userService.registerUser(username);
		if(result){
			return new ResponseEntity<User>(username,HttpStatus.OK);//200-299		
		}
		else{
			Error error=new Error(1, "Unable to register user details");
		
	return new ResponseEntity<Error>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
@RequestMapping(value="/login",method=RequestMethod.POST)
public ResponseEntity<?> login (@RequestBody User user){
	User validUser=userService.login(user);
	
	if (validUser==null){
		Error error=new Error(4,"Invalid Username/Password...");
		return new ResponseEntity<Error>(error,HttpStatus.OK);
		}
	@RequestMapping(value="/logout",method=RequestMethod.PUT)
	public.ResponseEntity<?>logout(HttpSession session);{
		String username=(String)session.getAttribute("username");
		System.out.println("Name of the user is"+ username);
		if (username==null){
			Error error = new Error(5,"Unauthorised access..please login..");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
			}
		User user=userService.getUserByUsername(username);
		user.setOnline(false);
		userService.update(user);
		session.removeAttribute(username);
		session.invalidate();
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	public ResponseEntity<?>getUser(HttpSession.session){
		String username=(String)session.getAttribute("username");
		if(username==null){
			Error error =new Error(5,"Unauthorized access..please login..");
			return new ResponseEntity<Error>(error,HttpStatus.OK);
			
		}
		
	}
	
System.out.println("ONLINE STATUS BEFORE UPDATE"+ validUser.isOnline());
validUser.setOnline(true);
try{
	userService.update(validUser);
}catch(Exception e){
	Error error=new Error(6,"Unable to update online status");

return new ResponseEntity<User>(validUser,HttpStatus.INTERNAL_SERVER_ERROR);
}
System.out.println("ONLINE STATUS AFTER UPDATE"+ validUser.isOnline());
session.setAttribute("username", validUser.getFirstName());
return new ResponseEntity<User>(validUser,HttpStatus.OK);



}


}