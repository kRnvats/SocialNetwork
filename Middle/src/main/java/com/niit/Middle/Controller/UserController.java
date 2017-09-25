package com.niit.Middle.Controller;

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
	public ResponseEntity<?> registerUser(@RequestBody User user){
		boolean result=userService.registerUser(user);
		if(result){
			return new ResponseEntity<User>(user,HttpStatus.OK);//200-299
			
		}
		else{
			Error error=new Error(1, "Unable to register user details");
		
	return new ResponseEntity<Error>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	
	

}
	}
}
