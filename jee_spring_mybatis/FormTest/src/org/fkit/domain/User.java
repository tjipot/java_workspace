package org.fkit.domain;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	// 数据, data, 属性;
	private String username;
	private String sex;
	private Integer age;
	
	public User() { super(); }
	
	public User(String username, String sex, Integer age) {
		super();
		this.username = username;
		this.sex = sex;
		this.age = age;
	}
	
	// Getter and Setter;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}
