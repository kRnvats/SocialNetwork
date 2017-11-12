package com.niit.Middle.RestController;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.Backend.Model.Job;
import com.niit.Backend.Model.User;
import com.niit.Backend.service.JobService;
import com.niit.Backend.service.UserService;

@Controller

public class JobController {

	@Autowired
	JobService jobService;
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/addJob",method=RequestMethod.POST)
	public ResponseEntity<?> addJob(@RequestBody Job job,HttpSession httpSession)
{
	String userName = (String)httpSession.getAttribute("firstName");
	if(userName==null)
	{
		Error error = new Error("Unauthorized Access");
		return new ResponseEntity<Error>(error,HttpStatus.NOT_ACCEPTABLE);
		
	}
	User user = userService.getUserByUserName(userName);
	if(!user.getRole().equals("ADMIN")){
		Error error = new Error("Unauthorized Access");
		return new ResponseEntity<Error>(error,HttpStatus.NOT_ACCEPTABLE);
		
	}
	try{
		jobService.addJob(job);
	}
	catch(Exception e){}
	return new ResponseEntity<Job>(job,HttpStatus.OK);

	
}
	@GetMapping(value="/getAllJobs")
	public ResponseEntity<?> getAllJobs(HttpSession httpSession)
	{
		String userName = (String)httpSession.getAttribute("firstName");
		if(userName==null)
		{
			Error error = new Error("Unauthorized Access");
			return new ResponseEntity<Error>(error,HttpStatus.ACCEPTED);
			
		}
		ArrayList<Job> listJob = new ArrayList<Job>();
		listJob = (ArrayList<Job>)jobService.getAllJobs();
		return new ResponseEntity<ArrayList<Job>>(listJob,HttpStatus.ACCEPTED);
		
	}
	@DeleteMapping(value="/deleteJob/{delete}")
	public ResponseEntity<?> deleteJob(@PathVariable int delete,HttpSession httpSession)
	{
		String userName = (String)httpSession.getAttribute("firstName");
		if(userName==null)
		{
			Error error = new Error("Unauthorized Access");
			return new ResponseEntity<Error>(error,HttpStatus.NOT_ACCEPTABLE);
		}
		Job job= jobService.deleteJob(delete);
		return new ResponseEntity<Job>(job,HttpStatus.OK);
		
		
		}
	}


















