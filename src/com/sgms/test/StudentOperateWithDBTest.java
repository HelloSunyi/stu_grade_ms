package com.sgms.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sgms.bean.Course;
import com.sgms.bean.CourseGrade;
import com.sgms.bean.Student;
import com.sgms.user.databaseOperate.StudentOperateWithDB;

public class StudentOperateWithDBTest {
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	//@Test
	public void testGetCourseGrade(){
		Student stu = new Student();
		stu.setId("s001");
		StudentOperateWithDB operate = new StudentOperateWithDB();
		List<CourseGrade> courseGradeList = new ArrayList<CourseGrade>();
		courseGradeList = operate.getCourseGrade(stu);
		for(CourseGrade cg:courseGradeList){
			System.out.println(cg.getId() + "   " + cg.getGrade());
		}
	}
	
	//@Test
	public void testGetStuBasicInfo(){
		Student stu = new Student();
		stu.setId("s001");
		StudentOperateWithDB operate = new StudentOperateWithDB();		
		stu = operate.getStuBasicInfo(stu);
		System.out.println(stu.getId());
		System.out.println(stu.getName());
		System.out.println(stu.getPassword());
		System.out.println(stu.getClassNo());
		System.out.println(stu.getMajor());
		
	}
	//@Test
	public void testSetStuBasicInfo(){
		Student stu = new Student();
		stu.setId("s001");
		stu.setName("sun");
		stu.setClassNo("101");
		stu.setMajor("ee");
		StudentOperateWithDB operate = new StudentOperateWithDB();		
		operate.setStuBasicInfo(stu);
		stu = operate.getStuBasicInfo(stu);
		System.out.println(stu.getId());
		System.out.println(stu.getName());
		System.out.println(stu.getPassword());
		System.out.println(stu.getClassNo());
		System.out.println(stu.getMajor());
		
	}
	//@Test
	public void testDeleteStuCourse(){
		Student stu = new Student();
		stu.setId("s001");
		StudentOperateWithDB operate = new StudentOperateWithDB();	
		String[] idList = {"c001"};
		operate.deleteStuCourse(stu,idList);		
	}
	//@Test
	public void testGetAllCourse(){
		StudentOperateWithDB operate = new StudentOperateWithDB();	
		List<Course> courseList = new ArrayList<Course>();
		courseList = operate.getAllCourse();
		for(Course c:courseList){
			System.out.println(c.getId());
		}
			
	}
	//@Test
	public void testGetUnSelectCourse(){
		Student stu = new Student();
		stu.setId("s001");
		StudentOperateWithDB operate = new StudentOperateWithDB();	
		List<Course> courseList = new ArrayList<Course>();
		courseList = operate.getUnSelectCourse(stu);
		for(Course c:courseList){
			System.out.println(c.getId());
		}
			
	}
	//@Test
	public void testSelectStuCourse(){
		Student stu = new Student();
		stu.setId("s001");
		StudentOperateWithDB operate = new StudentOperateWithDB();	
		String[] idList = {"c001"};
		operate.selectStuCourse(stu,idList);
		List<CourseGrade> courseGradeList = new ArrayList<CourseGrade>();
		courseGradeList = operate.getCourseGrade(stu);
		for(CourseGrade cg:courseGradeList){
			System.out.println(cg.getId() + "   " + cg.getGrade());
		}
	}
}
