package com.sgms.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sgms.bean.Course;
import com.sgms.bean.CourseGrade;
import com.sgms.bean.Student;
import com.sgms.bean.Teacher;
import com.sgms.database.student.StudentOperateWithDB;
import com.sgms.database.student.TeacherOperateWithDB;

public class TeacherOperateWithDBTest {
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	//@Test
	public void testGetAllCourse(){
		Teacher teacher = new Teacher();
		teacher.setId("t001");
		TeacherOperateWithDB operate = new TeacherOperateWithDB();
		List<Course> courseList = new ArrayList<Course>();
		courseList = operate.getAllCourse(teacher);
		for(Course c:courseList){
			System.out.println(c.getId() + "   " + c.getName());
		}
	}
	@Test
	public void testGetTeacherBasicInfo(){
		Teacher teacher = new Teacher();
		teacher.setId("t001");
		TeacherOperateWithDB operate = new TeacherOperateWithDB();
		teacher = operate.getTeacherBasicInfo(teacher);
		System.out.println(teacher.getId() + "   " + teacher.getName() + "	 " + teacher.getTitle());
	}
}
