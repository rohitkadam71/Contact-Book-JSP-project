package com.entity;

public class contact {
	private int id;
	private String name;
	private String email;
	private String phone;
	private String about;
	private int userId;
	
	public contact() {}
	
	public contact(String name, String email, String phone, String about,int userId) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.about = about;
		this.userId = userId;
		
		System.out.println(getName());
	}
	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public String getAbout() {
		return about;
	}
	public int getUserId() {
		return userId;
	}
}
