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
	
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/teacher/teacherIndex.css" type="text/css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/bootstrap_css/bootstrap.min.css" type="text/css">
	<script src="<%=request.getContextPath()%>/resource/script/jquery-1.11.1.min.js"></script>
	<script src="<%=request.getContextPath()%>/resource/script/teacher/teacherIndex.js"></script>
	<script src="<%=request.getContextPath()%>/resource/script/bootstrap_js/bootstrap.min.js"></script>
	</head>
  
  <body>
 	
  	<!-- header 标签开始  <div id="haha" >ssssssssssssssssssss</div>-->
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
		<div class="sidebar">
			<ul class="list-group list-unstyled">
				<li class="active list-group-item ">授课课程</li>
				<c:forEach items="${courseList}" var="clist">
					<li class="list-group-item" onclick="document.getElementById('item${clist.courseNo}').scrollIntoView();">
						<span class="course-id">[${clist.id }]</span>
						<span class="course-name">${clist.name }</span>					
					</li>
				</c:forEach>
			</ul>
		</div>
		<div class="content">
			<c:forEach items="${courseList}" var="clist">
				<div class="item" id="item${clist.courseNo}">
					<h1>[<span>${clist.id }</span>]${clist.name }</h1>			  			
					<table class="table table-hover">
						<thead>
							<tr> 
							   <th>课程号</th>
							   <th>课程名</th>
							   <th>学分</th>
							   <th>上课时间</th>
							   <th>教室</th>  
							</tr>
						</thead>
						<tbody>
			  				<tr class="success">  			  					 	 
								<td>${clist.id }</td>
								<td>${clist.name }</td>
								<td>${clist.credit }</td>
								<td>${clist.time }</td>
								<td>${clist.address }</td>					    
							</tr>	 			        
						</tbody>
					</table>	
					<a href="teacher/getCourseStudent?courseId=${clist.id }" class="btn btn-success btn-lg search-btn">查看该课学生信息</a>					  		
				</div>
			</c:forEach>
		</div>
  	</div>
  	<!-- mainbody 标签结束 -->
  	
  	<!-- footer 标签开始 -->
  	<div id="footer">
  	
  	</div>
  	<!-- footer 标签结束 -->
  	</body>
</html>
