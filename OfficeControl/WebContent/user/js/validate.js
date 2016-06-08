/**
 * 验证表单
 */
$(document).ready(function(){
	$("form").submit(function(){ 
	var isMobile=/(1[3-9]\d{9})$/;  
	var tel=$("#phone").val();
	  if($("#userName").val()==""){
	     alert("用户名不能为空");
	     return false;
	  }
	  if($("#name").val()==""){
	     alert("姓名不能为空");
	     return false;
	  }
	  if(!isMobile.test(tel)){
		     alert("请输入正确的手机号码");
		     return false;
		  }
	  if($("#address").val()==""){
		     alert("地址不能为空");
		     return false;
	  }
	  return true;
	});
});