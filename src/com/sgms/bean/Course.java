package com.sgms.bean;

import java.sql.ResultSet;

public class Course {
	private String id;
	private String name;
	private double credit;
	private String time;
	private String address;
	private boolean select;
	private int courseNo;
	public int getCourseNo() {
		return courseNo;
	}
	public void setCourseNo(int courseNo) {
		this.courseNo = courseNo;
	}
	public int getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}
	private int studentNo;
	public boolean isSelect() {
		return select;
	}
	public void setSelect(boolean select) {
		this.select = select;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	/*
	public ResultSet getCourse(){
		String sql="select * from course";
		SQL db=new SQL();
		ResultSet rs=db.executeQuery(sql);
		return rs;
	}
	public ResultSet getCinfo(String cid){
	    String sql="select * from course where cid='"+cid+"'";
	    SQL db=new SQL();
	    ResultSet rs=db.executeQuery(sql);
	    return rs;
	}
	public boolean isValid(String cno){
		boolean f=true;
		String sql="select cid from course where cid='"+cno+"'";
		SQL db=new SQL();
		try{
			ResultSet rs=db.executeQuery(sql);
			if(rs.next()){
				f=true;
			}
			else{
				f=false;
				}
		}
		catch(Exception e){
			e.getMessage();
		}
		return f;
		
	}
	public void addCourse(){
		String sql="insert into course(cid,clnum,cname,credit,capacity) values ('"+cid+"','"+clnum+"','"+cname+"',"+credit+","+capacity+")";
		SQL db=new SQL();
		db.executeInsert(sql);
	}
	public int delcourse(String cno){
		int num=0;
		String sql="delete from course where cid='"+cno+"'";
		SQL db=new SQL();
		num=db.executeDelete(sql);
		return num;
	}
	public void updateCourse(){
		String sql="update course set cid='"+cid+"',clnum='"+clnum+"',cname='"+cname+"',credit="+credit+",capacity="+capacity
		+" where cid='"+cid+"'";
		SQL db=new SQL();
		db.Update(sql);
	}
	*/
}
