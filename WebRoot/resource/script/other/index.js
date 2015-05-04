$(function(){
	
	//nav中添加划过时，下拉菜单显示功能
	$("#nav .dropdown-toggle").mouseenter(function(){
		$("#nav .dropdown").addClass("open");
	});
	
	$("#nav .dropdown-menu").mouseleave(function(){
		$("#nav .dropdown").removeClass("open");
	});
	
	//背景图片定时器
	setInterval(changeImg,3000);
	
});

//背景图片定时器
function changeImg(){
	var imgLis = $("#mainbody .img-carousel li");
	var onNum;
	for(var i = 0; i < imgLis.length; i++){
		if(imgLis[i].className == "on"){
			onNum = i;
			break;
		}
	}
	imgLis[onNum].className = "";
	if(onNum < imgLis.length - 1)onNum++;
	else onNum = 0;
	imgLis[onNum].className = "on";
}


