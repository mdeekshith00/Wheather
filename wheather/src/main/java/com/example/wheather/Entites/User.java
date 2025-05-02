package com.example.wheather.Entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_details")
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	@Column
	private String name;
	@Column
	private String phno;
	@Column(name = "home_Location")
	private String homeLocation;
	@Column(name = "office_Location")
	private String officeLocation;
	private String otherLocation;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String name, String phno, String homeLocation, String officeLocation, String otherLocation) {
		super();
		this.id = id;
		this.name = name;
		this.phno = phno;
		this.homeLocation = homeLocation;
		this.officeLocation = officeLocation;
		this.otherLocation = otherLocation;
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

	public String getHomeLocation() {
		return homeLocation;
	}

	public void setHomeLocation(String homeLocation) {
		this.homeLocation = homeLocation;
	}

	public String getOfficeLocation() {
		return officeLocation;
	}

	public void setOfficeLocation(String officeLocation) {
		this.officeLocation = officeLocation;
	}

	public String getOtherLocation() {
		return otherLocation;
	}

	public void setOtherLocation(String otherLocation) {
		this.otherLocation = otherLocation;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phno=" + phno + ", homeLocation=" + homeLocation
				+ ", officeLocation=" + officeLocation + ", otherLocation=" + otherLocation + "]";
	}
	
	
	
}
