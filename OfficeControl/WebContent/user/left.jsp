<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html style="height:100%;">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>基于Arduino的办公室节能控制系统</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/datepicker3.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">

<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<script src="js/respond.min.js"></script>
<![endif]-->
<script>
	function showAllUser(){
		window.location.href="showAllUser.action";
	}  
	</script>
</head>
<body style="height:100%;">
<div id="sidebar-collapse" class=" sidebar" style="height:100%;">
		<form role="search">
			<div class="attribution"></div>
		</form>
		<ul class="nav menu">
			<li class="parent ">
				<a href="#">
					<span class="glyphicon glyphicon-dashboard"></span> 用户管理 <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus"></em></span> 
				</a>
				<ul class="children collapse" id="sub-item-1">
					<li>
						<a class="" href="information.jsp" target="main">
							<span class="glyphicon glyphicon-share-alt"></span> 账户信息
						</a>
					</li>
					<s:if test="#session.user.isSuper() == true">
						<li>
							<a class="" href="showAllUser.action" target="main">
								<span class="glyphicon glyphicon-share-alt"></span> 用户列表
							</a>
						</li>
					</s:if>
				</ul>
			</li>
			<li class="parent ">
				<a href="#">
					<span class="glyphicon glyphicon-list-alt"></span> 采集模块<span data-toggle="collapse" href="#sub-item-2" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus"></em></span> 
				</a>
				<ul class="children collapse" id="sub-item-2">
					<li>
						<s:if test="#session.user.isSuper() == true">
							<a class="" href="showAllGather.action" target="main">
								<span class="glyphicon glyphicon-share-alt"></span> 设备列表
							</a>
						</s:if>
						<s:else>
							<a class="" href="showUserGather.action" target="main">
								<span class="glyphicon glyphicon-share-alt"></span> 设备列表
							</a>
						</s:else>
					</li>
				</ul>
			</li>
			<li class="parent ">
				<a href="#">
					<span class="glyphicon glyphicon-stats"></span> 控制模块 <span data-toggle="collapse" href="#sub-item-3" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus"></em></span> 
				</a>
				<ul class="children collapse" id="sub-item-3">
					<li>
						<s:if test="#session.user.isSuper() == true">
							<a class="" href="showAllController.action" target="main">
								<span class="glyphicon glyphicon-share-alt"></span> 设备列表
							</a>
						</s:if>
						<s:else>
							<a class="" href="showUserController.action" target="main">
								<span class="glyphicon glyphicon-share-alt"></span> 设备列表
							</a>
						</s:else>
					</li>
				</ul>
			</li>
			<li role="presentation" class="divider"></li>
		</ul>
		<div class="attribution"></div>
	</div><!--/.sidebar-->
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script>
		$('#calendar').datepicker({
		});

		!function ($) {
		    $(document).on("click","ul.nav li.parent > a > span.icon", function(){          
		        $(this).find('em:first').toggleClass("glyphicon-minus");      
		    }); 
		    $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
		}(window.jQuery);

		$(window).on('resize', function () {
		  if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
		})
		$(window).on('resize', function () {
		  if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
		})
	</script>	
</body>
</html>