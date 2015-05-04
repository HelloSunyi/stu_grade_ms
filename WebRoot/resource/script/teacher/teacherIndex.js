$(function(){
	//下拉菜单
	$("#header .dropdown-toggle").mouseenter(function(){
		$("#header .dropdown").css("background-color","#232931");
		$("#header .dropdown").addClass("open");	
	});
	$("#header .dropdown-menu").mouseleave(function(){
		$("#header .dropdown").css("background-color","#39424E");
		$("#header .dropdown").removeClass("open");
	});
	
	//查看该科学生信息ajax请求
	/*
	$("#mainbody .item .search-btn").click(function(){
		alert("hello1");
		var courseId = $("#mainbody .item h1 span").html();	
		alert("hello2");
		$.ajax({
			type : "post",
			url : "teacher/getCourseStudent",
			dataType : "json",
			data : {
				"courseId":courseId		
			}
		}); 
	});
	*/
});

