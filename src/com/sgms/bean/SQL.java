package com.sgms.bean;

import java.sql.*;

import org.apache.log4j.Logger;

public class SQL {
	public Connection conn = null;
	public ResultSet rs = null;
	public Statement st = null;
	final Logger logger = Logger.getLogger(SQL.class);
	public SQL(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/stu_grade_ms";
			conn = DriverManager.getConnection(url, "root", "123456");
			st = conn.createStatement(1004,1008);
		}
		catch(java.lang.ClassNotFoundException e){
			e.printStackTrace();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
		}
	}
	
	//插入操作
	public Boolean executeInsert(String sql){
		int num = 0;
		try{
			num = st.executeUpdate(sql);
		}
		catch(SQLException e){
			System.err.println("执行插入有错误:" + e.getMessage());
			System.out.print("执行插入有错误:" + e.getMessage());
		}
		if(num > 0)return true;
		else return false;
	}
	//查询操作
	public ResultSet executeQuery(String sql){
		rs = null;
		try{
			rs = st.executeQuery(sql);
		}
		catch(SQLException e){
			System.err.println("执行查询有错误:" + e.getMessage());
			System.out.print("执行查询有错误:" + e.getMessage());//输出到客户端
		}
		return rs;
	}
	//修改操作
	public int executeUpdate(String sql){
		int num = 0;
		try{
			num = st.executeUpdate(sql);
		}catch(SQLException e){
			System.err.println("执行修改有错误：" + e.getMessage());
			System.out.print("执行修改有错误：" + e.getMessage());//输出到客户端
		}
		return num;
	}
	//删除操作
	public int executeDelete(String sql){
		int num = 0;
		try{
			num = st.executeUpdate(sql);
		}
		catch(SQLException e){
			System.err.println("执行删除有错误:" + e.getMessage());
			System.out.print("执行删除有错误:" + e.getMessage());
		}
		return num;
	}
	//关闭数据库
	public void CloseDataBase(){
		try{
			conn.close();
			st.close();
		}
		catch(Exception e){
			System.err.println("执行关闭Connection对象有错误:" + e.getMessage());
			System.out.print("执行关闭Connection对象有错误:" + e.getMessage());
		}
	}
}
