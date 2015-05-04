package com.sgms.bean;

import java.sql.ResultSet;

public class Teacher {
	private String id;
	private String name;
	private String password;
	private String title;
	public Teacher(){
		id = null;
		name = null;
		password = null;
		title = null;
	}
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title = title;
	}
}
