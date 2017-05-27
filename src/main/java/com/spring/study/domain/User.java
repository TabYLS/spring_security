package com.spring.study.domain;

import java.util.List;

public class User  {
	
	/*用户id*/
	private Integer id;
	/*用户名（不可重复）*/
	private String userName;
	/*密码*/
	private String password;
	/*用户的状态，激活状态还是非激活状态*/
	private Integer status;
	/*用户的描述，这里的和角色里面的描述不一样*/
	private String descn;
	/*用户所拥有的权限*/
	private List<Role> roles;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getDescn() {
		return descn;
	}
	public void setDescn(String descn) {
		this.descn = descn;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}
