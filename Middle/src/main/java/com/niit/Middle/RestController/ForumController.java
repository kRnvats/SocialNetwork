package com.niit.Middle.RestController;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.niit.Backend.Dao.ForumDao;
import com.niit.Backend.Model.Forum;

@RestController

public class ForumController {
		
 @Autowired
 
	ForumDao forumDao;
	
	
	@GetMapping(value="/getAllForums")
	public ResponseEntity<ArrayList<Forum>> getAllForums()
	{
		ArrayList<Forum> listForums = new ArrayList<Forum>();
		listForums = (ArrayList<Forum>)forumDao.getAllForums();
		return new  ResponseEntity<ArrayList<Forum>>(listForums,HttpStatus.ACCEPTED);
	}
	

	@PostMapping(value="/createForum")
	public ResponseEntity<String> createForum(@RequestBody Forum forum)
	{				
		forum.setCreateDate(new Date());
	if(forumDao.createForum(forum))
	{
		
		
		return new ResponseEntity<String> ("Forum Created",HttpStatus.ACCEPTED);

	}
	else {
		return new ResponseEntity<String> ("Forum Problem",HttpStatus.METHOD_FAILURE);

	}
	
		
	}
	
	@PutMapping("/approveForum/{forumId}")
	public ResponseEntity<String> approveForum (@PathVariable("forumId")Integer forumId)
	{
		Forum forum= forumDao.getForum(forumId);
		
		if(forumDao.approveForum(forum))
		{
			return new ResponseEntity<String> ("Forum Approved",HttpStatus.ACCEPTED);

		}
		else
		{
			return new ResponseEntity<String> ("Forum Not Approved",HttpStatus.BAD_GATEWAY);

		}

	}
	
	@DeleteMapping("/deleteForum/{forumId}")
	public ResponseEntity<String> deleteForum (@PathVariable("forumId")Integer forumId,@RequestBody Forum forum)
	{
		forumDao.deleteForum(forumId);
		return new ResponseEntity<String> ("Forum Deleted",HttpStatus.ACCEPTED);

	}
	
	@GetMapping("/getForum")
	public Forum getForum (@RequestParam("forumId") int forumId)
	{
		
		return forumDao.getForum(forumId);

	}
	
	@PutMapping("/editForum/{forumId}")
	public ResponseEntity<String> editForum (@PathVariable("forumId")Integer forumId)
	{
		
		Forum forum= forumDao.getForum(forumId);
		forumDao.editForum(forum);
		return new ResponseEntity<String> ("Forum Edited",HttpStatus.ACCEPTED);
	}

}



