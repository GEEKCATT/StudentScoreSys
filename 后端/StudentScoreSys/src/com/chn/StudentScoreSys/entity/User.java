package com.chn.StudentScoreSys.entity;

/**
 * @author Administrator
 *
 */
public class User {
	private int userId;
	private String username;
	private String password;
	
	//alt+shift+s
	//generate getters and setters
	//generate constructors using fields
	//(select all) 有参构造
	//(deselect all) 无参构造
	//generate toString()
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public User(int userId, String username, String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + "]";
	}
	

	
	
	
	
	
}
