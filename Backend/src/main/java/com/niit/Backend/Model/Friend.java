package com.niit.Backend.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Friend")

public class Friend {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	private String FromId;
	private String ToId;
	private char Status;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getFromId() {
		return FromId;
	}
	public void setFromId(String fromId) {
		FromId = fromId;
	}
	public String getToId() {
		return ToId;
	}
	public void setToId(String toId) {
		ToId = toId;
	}
	public char getStatus() {
		return Status;
	}
	public void setStatus(char status) {
		Status = status;
	}
}