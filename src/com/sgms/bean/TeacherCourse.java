package com.sgms.bean;

public class TeacherCourse {
	private String tid;
	private String cid;
	public TeacherCourse(){
		tid = null;
		cid = null;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
}
