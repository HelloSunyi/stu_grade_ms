package com.sgms.bean;

import java.sql.ResultSet;

public class Student {	
	private String id;
	private String name;
	private String password;
	private String classNo;
	private String major;
	private String course;
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public Student(){
		name = null;
		id = null;
		password = null;
		classNo = null;
		major = null;
	}
	public String getName(){
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getClassNo() {
		return classNo;
	}
	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}	
	
	/*
	//取得所有学生
	public ResultSet getAllStudent(){
		String sql = "select * from student";
		SQL db = new SQL();
		ResultSet rs = db.executeQuery(sql);
		return rs;		
	}
	//根据sid取得sname
	public ResultSet getSnameById(String id){
		String sql = "select name from student where id='" + id + "'";
		SQL db = new SQL();
		ResultSet rs = db.executeQuery(sql);
		return rs;
	}
	//根据sid取得smajor
	public ResultSet getMajorById(String id){
		String sql = "select major from student where id='" + id + "'";
		SQL db = new SQL();
		ResultSet rs = db.executeQuery(sql);
		return rs;
	}
	//根据sclass取得sname 和 sid
	public ResultSet getNameAndIdByClass(String classNo){
		String sql = "select id,name from student where classNo='" + classNo + "'";
		SQL db = new SQL();
		ResultSet rs = db.executeQuery(sql);
		return rs;
	}
	
	//根据id删除学生
	public int deleteStudent(String id){
	    int num = 0;
	    String sql = "delete  from student where id ='" + id + "' ";
	    SQL db = new SQL();
	    num = db.executeDelete(sql);
	    return num;
	}  
	//更新学生信息
	public void updateStudent(){
		String sql = "update student " + " set name='" + name + "'," + " password='" + password
		 + "' " + " where id='" + id + "'";
		SQL db = new SQL();
		db.executeInsert(sql);
	}
	*/
}
