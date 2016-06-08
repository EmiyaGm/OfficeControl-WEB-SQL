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
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/datepicker3.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/validateName.js" type="text/javascript"></script>
</head>
<body>
<div class="col-sm-12 col-sm-offset-3 col-lg-12 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">添加新设备</li>
			</ol>
		</div><!--/.row-->
		
		<div class="panel panel-default">
					<div class="panel-heading"></div>
					<div class="panel-body">
						<form class="form-horizontal" action="addGather.action" method="post">
							<fieldset>
								<!-- Name input-->
								<div class="form-group">
									<label class="col-md-3 control-label" for="name">设备名称</label>
									<div class="col-md-9">
									<input id="deviceName" name="name" type="text" placeholder=" " class="form-control">
									</div>
								</div>
							
								<!-- Message body -->
								<div class="form-group">
									<label class="col-md-3 control-label" for="address">所属用户</label>
									<div class="col-md-9">
										<select name="userId">
											<s:iterator value="users" id="user">
												<option value="<s:property value="#user.id"/>"><s:property value="#user.name"/></option>
											</s:iterator>
										</select>
									</div>
								</div>
								
								<!-- Form actions -->
								<div class="form-group">
									<div class="col-md-12 widget-right">
										<button type="submit" class="btn btn-default btn-md pull-right">添加</button>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
					</div>
</body>
</html>