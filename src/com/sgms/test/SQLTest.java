package com.sgms.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sgms.bean.SQL;
import com.sgms.bean.Student;
import com.sgms.common.LoginResponse;

public class SQLTest {
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testExecuteQuery(){
		SQL db = new SQL();
		Student stu = new Student();
		stu.setId("s001");
		String sql = "select id,name,credit,time,address from course,student_course where sid='"+stu.getId()+"' and cid=id";
		ResultSet rs = db.executeQuery(sql);
		try {
			while (rs.next()){//依次输出每列的值
				for (int i = 0 ; i < 5 ; i++ ) {
				    System.out.print(rs.getString(i + 1) + "	");
				}
				System.out.print("/n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
	}
}
