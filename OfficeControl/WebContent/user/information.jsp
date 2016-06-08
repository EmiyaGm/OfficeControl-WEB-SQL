<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/datepicker3.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/validate.js" type="text/javascript"></script>
</head>
<body>
<div class="col-sm-12 col-sm-offset-3 col-lg-12 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">账户信息</li>
			</ol>
		</div><!--/.row-->
		
		<div class="panel panel-default">
			<div class="panel-heading"></div>
					<div class="panel-body">
						<form class="form-horizontal" action="updateUser.action" method="post">
						<input type="hidden" name="id" value=<s:property value="#session.user.id"/> />
							<fieldset>
								<!-- Name input-->
								<div class="form-group">
									<label class="col-md-3 control-label" for="userName">登录名</label>
									<div class="col-md-9">
									<input id="userName" name="userName" type="text" value="<s:property value="#session.user.userName"/>" class="form-control">
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-3 control-label" for="name">姓名</label>
									<div class="col-md-9">
									<input id="name" name="name" type="text" value="<s:property value="#session.user.name"/>" class="form-control">
									</div>
								</div>
																
								<div class="form-group">
									<label class="col-md-3 control-label" for="phone">手机</label>
									<div class="col-md-9">
									<input id="phone" name="phone" type="text" value="<s:property value="#session.user.phone"/>" class="form-control">
									</div>
								</div>
							
								<!-- Message body -->
								<div class="form-group">
									<label class="col-md-3 control-label" for="address">地址</label>
									<div class="col-md-9">
										<textarea class="form-control" id="address" name="address" rows="5"><s:property value="#session.user.address"/></textarea>
									</div>
								</div>
								
								<!-- Form actions -->
								<div class="form-group">
									<div class="col-md-12 widget-right">
										<button type="submit" class="btn btn-default btn-md pull-right">submit</button>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
					</div>
					</div>

</body>
</html>