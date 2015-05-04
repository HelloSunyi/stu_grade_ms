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
	
});

