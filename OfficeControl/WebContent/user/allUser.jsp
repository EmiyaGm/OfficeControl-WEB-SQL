<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/datepicker3.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
<script>
	function edit(n){
		window.location.href="editUser.action?id="+n;
	} 
	
	function delete(n){
		window.location.href="deleteUser.action?id="+n;
	}  
</script>
</head>
<body>

	<div class="col-sm-12 col-sm-offset-3 col-lg-12 main">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">用户列表</li>
			</ol>
		</div>
		<!--/.row-->
	</div>
	<table style="width: 100%; text-align: center;">
		<tr class="panel panel-blue" style="height: 40px;">
			<td>序号</td>
			<td>登录名</td>
			<td>姓名</td>
			<td>手机</td>
			<td>地址</td>
			<td>操作</td>
		</tr>
		<s:iterator value="page.list" id="user" status="index">
			<tr style="height: 35px; border: 1px solid #30a5ff;">
				<td><s:property
						value="#index.index+1+page.everyPage*(page.beginPage-1)" /></td>
				<td><s:property value="#user.userName" /></td>
				<td><s:property value="#user.name" /></td>
				<td><s:property value="#user.phone" /></td>
				<td><s:property value="#user.address" /></td>
				<td><a
					href="showSaveUser.action?id=<s:property value="#user.id"/>"><span
						class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp; <a
					href="deleteUser.action?id=<s:property value="#user.id"/>"
					class="trash"><span class="glyphicon glyphicon-trash"></span></a></td>
			</tr>
		</s:iterator>
	</table>
	<div style="width:100%; text-align:center;margin-top:20px;">
	<s:if test="beginPage==1">
		<!-- <input type="button" class="className"
			style="width: 55px; margin-top: 2px;" value="上一页" /> -->
		<input type="button" class="className" value="首 页" />&nbsp;&nbsp;&nbsp;
		<input type="button" class="className" value="上一页" />&nbsp;&nbsp;&nbsp;
	</s:if>
	<s:else>
		<a href="showAllUser.action?beginPage=1">
		<input type="button" class="className" value="首 页" />&nbsp;&nbsp;&nbsp;</a>
		<a
			href="showAllUser.action?beginPage=<s:property value="beginPage-1" />">
			<input type="button" class="className" value="上一页" /></a>
	</s:else>
	&nbsp;共
	<s:property value="page.getTotalCount()" />
	条记录, 每页
	<s:property value="page.getEveryPage()" />
	条
	<s:property value="beginPage" />
	/
	<s:property value="page.getTotalPage()" />
	&nbsp;
	<s:if test="beginPage>=page.totalPage">
		<!-- <input type="button" class="className"
			style="width: 55px; margin-top: 2px;" value="下一页" /> -->
		<input type="button" class="className" value="下一页" />&nbsp;&nbsp;&nbsp;
		<input type="button" class="className" value="尾页" />&nbsp;&nbsp;&nbsp;
	</s:if>
	<s:else>
		<a
			href="showAllUser.action?beginPage=<s:property value="beginPage+1"/>"><input type="button" class="className" value="下一页" /></a>
		<a
			href="showAllUser.action?beginPage=<s:property value="page.totalPage"/> ">&nbsp;&nbsp;&nbsp;<input type="button" class="className" value="尾 页" /></a>
	</s:else>
	</div>

	<br />
	<a href="addUser.jsp"><button class="btn btn-primary btn-md"
			id="btn-todo">添加新用户</button></a>

</body>
</html>