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
	/*
	public ResultSet  getTeacher(){
		String sql="select * from teacher";
		SQL db= new SQL();
		ResultSet rs = db.executeQuery(sql);
		return rs;
	}	
	public ResultSet  getTeaOne(String t_id){
		String sql="select * from teacher where id ='"+t_id+"'";
		SQL db= new SQL();
		ResultSet rs = db.executeQuery(sql);
		return rs;
	}	
	public boolean hasRegister(String id){   
		boolean isRegister = true;
		String sql = "select id from teacher where id ='"+id+"'";
		SQL db = new SQL();
		try{
		    ResultSet rs = db.executeQuery(sql);
		  	if(rs.next()){
		  		isRegister=true;
		  	}
		  	else{
		  		isRegister=false;
		  	}
	    }
		catch(Exception e){
			e.getMessage();
		}
		return isRegister;
	}
	public Boolean addTeacher(){		  
		String sql = "insert into teacher(id,tname,password) VALUES ('"+id+"','"+name+"','"+password+"')";
		SQL db = new SQL();		          
		if(db.executeInsert(sql))return true;
		else return false;
    }
	public int deleteTeacher(String id){
	    int num=0;
	    String sql="delete  from teacher where id ='"+id+"' ";
	    SQL db= new SQL();
	    num=db.executeDelete(sql);
	    return num;
	}  
	public void updateTeacher(){	
	    String sql="update teacher "+" set tname='"+name+"',"+" password='"+password+"' "+" where id='"+id+"'";
	    SQL db= new SQL();
	    db.executeInsert(sql);
    }
    */
}
