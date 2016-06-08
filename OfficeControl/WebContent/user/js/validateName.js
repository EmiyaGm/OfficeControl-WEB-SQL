/**
 * 验证设备名
 */

$(document).ready(function(){
$("form").submit(function(){ 
	 if($("#deviceName").val()==""){
	     alert("设备名不能为空");
	     return false;
	  }
  return true;
	});
});