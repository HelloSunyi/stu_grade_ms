package com.sgms.database.student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.sgms.bean.Course;
import com.sgms.bean.CourseGrade;
import com.sgms.bean.SQL;
import com.sgms.bean.Student;

public class StudentOperateWithDB {
	/*
	public ResultSet getPasswordById(String id){
		SQL db = new SQL();
		String sql = "select password from student where id='" + id + "'";
		ResultSet rs = db.executeQuery(sql);
		return rs;
	}
	*/
	
	final Logger logger = Logger.getLogger(StudentOperateWithDB.class);
	
	//判断用户名是否注册
	public boolean hasRegister(Student stu){
		boolean isRegister = false;
		String sql = "select id from student where id='" + stu.getId() + "'";
		SQL db = new SQL();
		try{
			ResultSet rs = db.executeQuery(sql);
			if(rs.next())
				isRegister = true;
			else
				isRegister = false;			
		}
		catch(Exception e){
			e.getMessage();
		}
		return isRegister;
	}
	
	//添加学生
	public boolean addStudent(Student stu){
		String sql = "insert into student(id,name,password,class,major) values ('"
				+ stu.getId() + "','" + stu.getName() + "','" + stu.getPassword() + "','" 
				+ stu.getClassNo() + "','" + stu.getMajor() + "')";
		SQL db = new SQL();
		if(db.executeInsert(sql))return true;
		else return false;
	}
	//取得已选课程以及成绩信息
	public List<CourseGrade> getCourseGrade(Student stu){
		List<CourseGrade> courseGradeList = new ArrayList<CourseGrade>();
		//String sql = "select id,name,credit,time,address from course,student_course" +
		//		"where sid=" + stu.getId() + " and cid=id";
		String sql = "select id,name,credit,time,address,grade from course,student_course where sid='"+stu.getId()+"' and cid=id";
		SQL db = new SQL();
		ResultSet rs = db.executeQuery(sql);
		courseGradeList = assignCourseGrade(rs);
		return courseGradeList;
	}
	
	//取得学士基本信息
	public Student getStuBasicInfo(Student stu){
		String sql = "select id,name,password,class,major from student where id='"+stu.getId()+"'";
		SQL db = new SQL();
		ResultSet rs = db.executeQuery(sql);
		stu = assignStudent(rs);
		return stu;
	}
	//设置学生基本信息
	public boolean setStuBasicInfo(Student stu){
		String sql="update student "+" set name='"+stu.getName()+"',"+" class='"+stu.getClassNo()
				+"',"+"major='"+stu.getMajor()+"' "+" where id='"+stu.getId()+"'";
		SQL db = new SQL();
		if(db.executeUpdate(sql) > 0)return true;
		else return false;
	}
	//设置学生密码
	public boolean setStuPassword(Student stu){
		String sql="update student "+" set password='"+stu.getPassword()
				+"' "+" where id='"+stu.getId()+"'";
		SQL db = new SQL();
		if(db.executeUpdate(sql) > 0)return true;
		else return false;
	}
	//删除学生已选课程
	public boolean deleteStuCourse(Student stu,String[] idList){
		SQL db = new SQL();
		boolean isDelete = true;
		for(int i = 0;i <idList.length;i++){
			String sql="delete from student_course where sid='"+stu.getId()+"' and cid='"+idList[i]+"'";
			if(db.executeDelete(sql) != 1)isDelete = false;
		}
		return isDelete;
	}
	//取得未选课程
	public List<Course> getUnSelectCourse(Student stu){
		List<Course> courseList = new ArrayList<Course>();	
		courseList = getAllCourse();
		List<CourseGrade> courseGradeList = new ArrayList<CourseGrade>();
		courseGradeList = getCourseGrade(stu);
		for(CourseGrade cg:courseGradeList){
			for(Iterator<Course>iter = courseList.iterator();iter.hasNext();){
				String id = iter.next().getId();
				logger.info("sss:::"+cg.getId()+"   "+id);
				if(cg.getId().equals(id)){
					iter.remove();
				}
			}
		}
		return courseList;
	}
	//取得所有课程信息
	public List<Course> getAllCourse(){
		List<Course> courseList = new ArrayList<Course>();		
		String sql = "select * from course";
		SQL db = new SQL();
		ResultSet rs = db.executeQuery(sql);
		courseList = assignCourse(rs);
		return courseList;
	}
	//添加--学生选课
	public boolean selectStuCourse(Student stu,String[] idList){
		SQL db = new SQL();
		boolean isInsert = true;
		String grade = "待定";
		for(int i = 0;i <idList.length;i++){
			String sql = "insert into student_course(sid,cid,grade) values ('"
					+ stu.getId() + "','" + idList[i] + "','" + grade + "')";
			if(!db.executeInsert(sql))isInsert = false;
		}
		return isInsert;
	}
	private Student assignStudent(ResultSet rs){
		Student stu = new Student();
		try {
			while(rs.next()){
				stu.setId(rs.getString("id"));
				stu.setName(rs.getString("name"));
				stu.setPassword(rs.getString("password"));
				stu.setClassNo(rs.getString("class"));
				stu.setMajor(rs.getString("major"));
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stu;
	}
	private List<CourseGrade> assignCourseGrade(ResultSet rs){
		List<CourseGrade> courseGradeList = new ArrayList<CourseGrade>();
		try {
			while(rs.next()){
				CourseGrade courseGrade = new CourseGrade();
				courseGrade.setId(rs.getString("id"));
				courseGrade.setName(rs.getString("name"));
				courseGrade.setCredit(Double.parseDouble(rs.getString("credit")));
				courseGrade.setTime(rs.getString("time"));
				courseGrade.setAddress(rs.getString("address"));
				courseGrade.setGrade(rs.getString("grade"));
				courseGradeList.add(courseGrade);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courseGradeList;
	}
	
	private List<Course> assignCourse(ResultSet rs){
		List<Course> courseList = new ArrayList<Course>();
		try {
			while(rs.next()){
				Course course = new Course();
				course.setId(rs.getString("id"));
				course.setName(rs.getString("name"));
				course.setCredit(Double.parseDouble(rs.getString("credit")));
				course.setTime(rs.getString("time"));
				course.setAddress(rs.getString("address"));
				courseList.add(course);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courseList;
	}
}
