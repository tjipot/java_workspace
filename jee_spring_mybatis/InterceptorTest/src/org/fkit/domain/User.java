package org.fkit.domain;

import java.io.Serializable;

/* 整个项目分为:
 * 1.Model:   User.java, Book.java,
 * 2.View:    main.jsp, loginForm.jsp,
 * 3.Control: UserController.java, BookController.java, FormController.java, AuthorizationInterceptor.java,
 * 以及服务器运行环境配置文件: web.xml和springmvc.xml;
 * */

// 数据类:User;
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;			// id
	private String loginname;	// 登录名
	private String password;	// 密码
	private String username;	// 用户名
	
	public User() {
		super();
	}
	
	// Getter and Setter;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", loginname=" + loginname + ", password="
				+ password + ", username=" + username + "]";
	}
}
