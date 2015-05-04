package com.sgms.database.student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sgms.bean.Course;
import com.sgms.bean.CourseGrade;
import com.sgms.bean.SQL;
import com.sgms.bean.Student;
import com.sgms.bean.Teacher;

public class TeacherOperateWithDB {
	
		final Logger logger = Logger.getLogger(TeacherOperateWithDB.class);
		//判断用户名是否注册
		public boolean hasRegister(Teacher teacher){
			boolean isRegister = false;
			String sql = "select id from teacher where id='" + teacher.getId() + "'";
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
		
		//添加教师
		public boolean addTeacher(Teacher teacher){
			String sql="insert into teacher(id,name,password,title) values ('"
					+ teacher.getId() + "','" + teacher.getName() + "','" + teacher.getPassword() 
					+ "','" + teacher.getTitle() + "')";
			SQL db = new SQL();
			if(db.executeInsert(sql))return true;
			else return false;
		}
		//取得授课信息
		public List<Course> getAllCourse(Teacher teacher){
			String sql = "select id,name,credit,time,address from course,teacher_course where tid='" + teacher.getId()
					      + "' and cid=id";
			SQL db = new SQL();
			ResultSet rs = db.executeQuery(sql);
			List<Course> courseList = new ArrayList<Course>();
			courseList = assignCourse(rs);
			return courseList;
		}
		
		//取得教师基本信息
		public Teacher getTeacherBasicInfo(Teacher teacher){
			String sql = "select * from teacher where id='"+teacher.getId()+"'";
			SQL db = new SQL();
			ResultSet rs = db.executeQuery(sql);
			teacher = assignTeacher(rs);
			return teacher;
		}
		//设置教师基本信息
		public boolean setTeacherBasicInfo(Teacher teacher){
			String sql="update teacher "+" set name='"+teacher.getName()+"',"+" title='"+teacher.getTitle()
					+"' "+" where id='"+teacher.getId()+"'";
			SQL db = new SQL();
			if(db.executeUpdate(sql) > 0)return true;
			else return false;
		}
		private Teacher assignTeacher(ResultSet rs){
			Teacher teacher = new Teacher();
			try {
				while(rs.next()){
					teacher.setId(rs.getString("id"));
					logger.info(rs.getString("id"));
					teacher.setName(rs.getString("name"));
					logger.info(rs.getString("name"));
					teacher.setPassword(rs.getString("password"));
					logger.info(rs.getString("password"));
					teacher.setTitle(rs.getString("title"));
					logger.info(rs.getString("title"));
					break;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return teacher;
		}
		/*
		//取得每门课同学信息
		public List<Student> getStudentByCourse(List<Course> courseList){
			List<Student> studentList = new ArrayList<Student>();
			List<Student> stuList = new ArrayList<Student>();
			for(Course course:courseList){
				String sql = "select id,name,password,class,major,cid from student," +
						"student_course where cid='"+course.getId()+"' and sid=id";
				SQL db = new SQL();
				ResultSet rs = db.executeQuery(sql);
				stuList = assignStudent(rs);
				for(Student stu:stuList){
					studentList.add(stu);
				}
			}
			return studentList;
		}
		*/
		/*
		private List<Student> assignStudent(ResultSet rs){
			List<Student> studentList = new ArrayList<Student>();
			try {
				while(rs.next()){
					Student stu = new Student();
					stu.setId(rs.getString("id"));
					stu.setName(rs.getString("name"));
					stu.setPassword(rs.getString("password"));
					stu.setClassNo(rs.getString("class"));
					stu.setMajor(rs.getString("major"));
					stu.setCourse(rs.getString("cid"));
					studentList.add(stu);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return studentList;
		}
		*/
		private List<Course> assignCourse(ResultSet rs){
			List<Course> courseList = new ArrayList<Course>();
			int courseNo = 1;
			try {
				while(rs.next()){
					Course course = new Course();
					course.setId(rs.getString("id"));
					course.setName(rs.getString("name"));
					course.setCredit(Double.parseDouble(rs.getString("credit")));
					course.setTime(rs.getString("time"));
					course.setAddress(rs.getString("address"));
					course.setCourseNo(courseNo);
					courseList.add(course);
					courseNo++;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return courseList;
		}
}
