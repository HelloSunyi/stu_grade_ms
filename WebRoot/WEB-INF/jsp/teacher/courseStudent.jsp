<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/teacher/courseStudent.css" type="text/css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/bootstrap_css/bootstrap.min.css" type="text/css">
	<script src="<%=request.getContextPath()%>/resource/script/jquery-1.11.1.min.js"></script>
	<script src="<%=request.getContextPath()%>/resource/script/teacher/courseStudent.js"></script>
	<script src="<%=request.getContextPath()%>/resource/script/bootstrap_js/bootstrap.min.js"></script>
  </head>
  
  <body>
  	<!-- header 标签开始 -->
  	<div id="header">
  		<div class="container">
  			<h1>成绩管理系统<small>--教师端</small></h1>
  			<div class="dropdown">
  				<a class="dropdown-toggle" data-toggle="dropdown">
  					<i class="glyphicon glyphicon-user"></i>
  					<span class="username"><%=(String)session.getAttribute("username")%></span>
  					<span class="caret"></span>
  				</a>
  				<ul class="dropdown-menu">
  					<li><a href="teacher/basicInfo">基本信息</a></li>
  					<li><a href="teacher/modifyPassword">修改密码</a></li>
  					<li><a href="index.jsp">退出登录</a></li>
  				</ul>
  			</div>			
  		</div>
  	</div>
  	<!-- header 标签结束 -->
  	
  	<!-- mainbody 标签开始 -->
  	<div id="mainbody">
  		<div class="mainbody-left">
			<ul class="list-group list-menu on">
				<i class="glyphicon glyphicon-chevron-right"></i>
				<li class="list-group-item tab"></li>
			</ul>
			<ul class="list-group list-content">
				<i class="glyphicon glyphicon-chevron-left"></i>
				<li class="list-group-item capsule"><a href="teacher/index">教师授课</a></li>
			</ul>	
		</div>
		<div class="mainbody-right">
			<h1>[<span>${course.id }</span>]${course.name }课程学生如下：</h1>	
							  			
					<table class="table table-hover">
						<thead>
							<tr> 
							   <th>学号</th>
							   <th>姓名</th>
							   <th>班级</th>
							   <th>专业</th>
							   <th>成绩</th>  
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${studentList}" var="stu">		
				  				<tr class="success">  			  					 	 
									<td>${stu.id }</td>
									<td>${stu.name }</td>
									<td>${stu.classNo }</td>
									<td>${stu.major }</td>
									<td>
										<input id="grade" type="text"  class="form-control" 
							    			name="grade" value="${stu.grade }" />
							    		<i class="glyphicon glyphicon-pencil"></i>
							    	</td>					    
								</tr>	
							</c:forEach> 			        
						</tbody>
					</table>	
					<a class="btn btn-success btn-lg search-btn">保存成绩</a>	
					<a href="teacher/getCourseStudent" class="btn btn-success btn-lg reset-btn">重置</a>					  				
		</div>
  		<div class="modal" id="mymodal">
			<div class="modal-dialog">
			    <div class="modal-content">
			        <div class="modal-header">
			    		<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
						<h4 class="modal-title">提示信息</h4>
					</div>
					<div class="modal-body">
						<p></p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal" id="confirm-btn">确认</button>
						<button type="button" class="btn btn-default" data-dismiss="modal" id="cancell-btn">取消</button>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal-dialog -->
		</div><!-- /.modal -->	
  	</div>
  	<!-- mainbody 标签结束 -->
  	
  	<!-- footer 标签开始 -->
  	<div id="footer">
  	
  	</div>
  	<!-- footer 标签结束 -->
  </body>
</html>
