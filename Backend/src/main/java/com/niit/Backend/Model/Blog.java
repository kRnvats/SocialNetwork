package com.niit.Backend.Model;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="Blog")
public class Blog {
	@Id

private int blogId;
private String blogName,blogContent,status,username;
private int likes;
private Date CreateDate;
public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public String getBlogName() {
		return blogName;
	}
	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}
	public String getBlogContent() {
		return blogContent;
	}
	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getCreateDate() {
		return CreateDate;
	}
	public void setCreateDate(Date createDate) {
		this.CreateDate = createDate;
	}
public int getLikes() {
	return likes;
}
public void setLikes(int likes) {
	this.likes = likes;
}


}
