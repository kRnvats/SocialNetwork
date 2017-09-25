package com.niit.Middle.RestController;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.Backend.Dao.ForumCommentDao;
import com.niit.Backend.Model.ForumComment;

@RestController
public class ForumCommentController {
	
	@Autowired
	ForumCommentDao forumCommentDao;
	
	@GetMapping(value="/getALLForumComments()")
	public ResponseEntity<ArrayList<ForumComment>> getAllForumComments()
	{
		ArrayList<ForumComment> listForums = new ArrayList<ForumComment>();
		listForums = (ArrayList<ForumComment>)forumCommentDao.getAllForumComments();
		return new  ResponseEntity<ArrayList<ForumComment>>(listForums,HttpStatus.ACCEPTED);
	}
	@PostMapping(value="/addForumComment")
	public ResponseEntity<String> createForumComment(@RequestBody ForumComment forumComment)
	{				
		forumComment.setForumCommentDate(new Date());
	if(forumCommentDao.addForumComment(forumComment))
	{
		
		return new ResponseEntity<String> ("Forum Created",HttpStatus.ACCEPTED);

	}
	else {
		return new ResponseEntity<String> ("Forum Problem",HttpStatus.METHOD_FAILURE);

	}
	
		
	}

	@PutMapping("/editForumComment/{forumCommentId}")
	public ResponseEntity<String> editForum (@PathVariable("forumCommentId")Integer forumId)
	{
		
		ForumComment forumComment = forumCommentDao.getForumComment(forumId);
		forumCommentDao.editForumComment(forumComment);
		return new ResponseEntity<String> ("Forum Edited",HttpStatus.ACCEPTED);
	}
	@GetMapping("/getForumComment/{forumId}")
	public ForumComment getforum (@PathVariable("forumId") int forumId)
	{
		
		return forumCommentDao.getForumComment(forumId);

	}
	
	@DeleteMapping("/deleteForumComment/{forumId}")
	public ResponseEntity<String> deleteForumComment (@PathVariable("forumId")Integer forumId,@RequestBody ForumComment forumComment)
	{
		forumCommentDao.deleteForumComment(forumId);
		return new ResponseEntity<String> ("Forum Deleted",HttpStatus.ACCEPTED);

	}
	
	
}