package org.fkit.domain;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	private String username;
	private String sex;
	private String age;
	
	public User() { super(); }

	// Getters and Setters;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	
	
	
	
}
