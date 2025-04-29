package com.example.wheather.Entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "user_details")
public class User {
	@Id
	private int id;
	@Column
	private String name;
	@Column
	private String phno;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String name, String phno) {
		super();
		this.id = id;
		this.name = name;
		this.phno = phno;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phno=" + phno + "]";
	}
	


	
	
	
	

}
