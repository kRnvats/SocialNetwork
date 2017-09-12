package com.niit.Backend.Model;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Entity;
import org.springframework.stereotype.Component;

@Entity
@Component
public class Forum {
	@Id

private int forumId;
private String forumName,forumContent,status,username;
private int likes;
private Date CreateDate;
public int getForumId() {
		return forumId;
	}
public String getForumName() {
	return forumName;
}
public void setForumName(String forumName) {
	this.forumName = forumName;
}
public String getForumContent() {
	return forumContent;
}
public void setForumContent(String forumContent) {
	this.forumContent = forumContent;
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
public int getLikes() {
	return likes;
}
public void setLikes(int likes) {
	this.likes = likes;
}
public Date getCreateDate() {
	return CreateDate;
}
public void setCreateDate(Date createDate) {
	CreateDate = createDate;
}
public void setForumId(int forumId) {
	this.forumId = forumId;
}
}