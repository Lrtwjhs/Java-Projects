package com.personalinfo.dto;

public class User {

	// 用户UID U_id int
	// 用户名 U_username VARCHAR (25)
	// 密码 U_password VARCHAR (25)
	// 电子邮件 U_email VARCHAR (50)

	private int id;
	private String username;
	private String password;
	private String email;

	public User() {
	}

	public User(int id, String username, String password, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
