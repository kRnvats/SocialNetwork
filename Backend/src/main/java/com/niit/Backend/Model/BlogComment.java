package com.niit.Backend.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class BlogComment implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int blogCommentId;
	private int userId;
	private String blogComment;
	private Date blogCommentDate;
	private int blogId;
	private String userName;
	public int getBlogCommentId() {
		return blogCommentId;
	}
	public void setBlogCommentId(int blogCommentId) {
		this.blogCommentId = blogCommentId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getBlogComment() {
		return blogComment;
	}
	public void setBlogComment(String blogComment) {
		this.blogComment = blogComment;
	}
	public Date getBlogCommentDate() {
		return blogCommentDate;
	}
	public void setBlogCommentDate(Date blogCommentDate) {
		this.blogCommentDate = blogCommentDate;
	}
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}