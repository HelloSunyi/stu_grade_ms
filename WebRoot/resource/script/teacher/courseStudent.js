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
	
	//侧边栏
	$("#mainbody .mainbody-left").mouseenter(function(){
		$("#mainbody .mainbody-left .list-menu").removeClass("on");
		$("#mainbody .mainbody-left .list-content").addClass("on");
	});
	$("#mainbody .mainbody-left").mouseleave(function(){
		$("#mainbody .mainbody-left .list-content").removeClass("on");
		$("#mainbody .mainbody-left .list-menu").addClass("on");
	});
	
	//input focus:
	$("#mainbody table input").focus(function(){
		$(this).css("color","gray");
	});
	$("#mainbody table input").blur(function(){
		$(this).css("color","black");
	});
	$("#mainbody table input").bind("input propertychange",function() { 
		$(this).css("color","black");
	}); 
	
	//表单提交
	$("#mainbody .mainbody-right .save-btn").click(function(){	
		$("#mymodal2 .modal-body p").html("确认要修改学生成绩吗？");	
		$("#mymodal2").modal();				
	});
	
	$("#confirm-btn").click(function(){
		var gradeList = [];
		gradeList = getGradeList();
		var studentList = [];
		studentList =getStudentList();
		var courseId = $("#mainbody .mainbody-right h1 span").html();
		ajaxModifyGradeList(gradeList,studentList,courseId);
	});
});
//取得要删除课程的id
function getGradeList(){
	var gradeList=[];
	$("#mainbody input[name='grade']").each(function() {
		gradeList.push($(this).val());
	});
	return gradeList;
}
function getStudentList(){
	var studentList=[];
	$("#mainbody input[name='grade']").each(function() {
		var tr = $(this).closest("tr");
		var idStr = $(tr).children("td").eq(0).html();
		studentList.push(idStr);
	});
	return studentList;
}
function ajaxModifyGradeList(gradeList,studentList,courseId){
	$.ajax({
		type : "post",
		url : "teacher/doModifyGrade",
		dataType : "json",
		data : {
			gradeList:gradeList,
			studentList:studentList,
			"courseId":courseId
		},
		success : function(result) {					
			//window.location.href="student/basicInfo";
			$("#mymodal .modal-body p").html(result["resultString"]);	
			$("#mymodal").modal();
		}
	}); 
}


