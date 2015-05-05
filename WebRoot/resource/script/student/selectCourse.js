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
	
	//表格显示
	displayTable();
	
	//全选框,二次失效？？prop解决
	$("#selectAll").click(function(){
		if ($("#selectAll")[0].checked){
			$("#mainbody input[name='box']").each(function(){
				$(this).prop("checked",true);
			});
		} 
		else{
			$("#mainbody input[name='box']").each(function(){
			     $(this).prop("checked",false);
			});
		}
	});
	
	//删除课程
	$("#select-btn").click(function(){
		var idList=[];
		idList=getSelectIdList();
		if(idList.length == 0){
			$("#mymodal .modal-body p").html("未选中任何课程！");	
			$("#mymodal").modal();
			return;
		}
		$("#mymodal2 .modal-body p").html("确认要选中这" + idList.length + "门课程吗？");	
		$("#mymodal2").modal();	
	});
	$("#confirm-btn").click(function(){
		var idList=[];
		idList=getSelectIdList();
		ajaxSelectCourseList(idList);
	});
			
});

//取得要删除课程的id
function getSelectIdList(){
	var idList=[];
	$("#mainbody input[name='box']").each(function() {
		if ($(this)[0].checked) {
			var tr = $(this).closest("tr");
			var idStr = $(tr).children("td").eq(1).html();
			idList.push(idStr);
		}
	});
	return idList;
}
//ajax 请求，删除课程--数据库
function ajaxSelectCourseList(idList) {
	$.ajax({
		type : "post",
		url : "student/doSelectCourse",
		dataType : "json",
		data : {
			idList : idList
		},
		success : function(result) {
			if(result["resultFlag"] == "SS"){
				$("#mymodal .modal-body p").html("选课成功");	
				$("#mymodal").modal();
			}
			else{
				$("#mymodal .modal-body p").html("选课失败");	
				$("#mymodal").modal();
			}
		}
	});
}
function displayTable(){
	var trs = $("#mainbody .table tbody tr");
	var trClass = new Array();
	trClass[0] = "warning";
	trClass[1] = "info";
	var pos = 0;
	trs.each(function(){
		$(this).addClass(trClass[pos%2]);
		pos++;
	});
}

