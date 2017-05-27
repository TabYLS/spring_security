package com.spring.study.domain;

public class Role {
	
	/*id*/
	private Integer id;
	/*角色名*/
	private String name;
	/*角色描述*/
	private String descn;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescn() {
		return descn;
	}
	public void setDescn(String descn) {
		this.descn = descn;
	}
	
}
