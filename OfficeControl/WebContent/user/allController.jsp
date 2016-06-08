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
<script src="js/jquery-1.11.1.min.js"></script>
<script>
 	
	//点击取消按钮，不保存取消的数据。
	function editAccess(target) {
		if(target==="1"){
			alert('yes');
		}
			$(".temp" + target).val($(".t" + target).text());
			$(".kind" + target).val($(".k" + target).text());
			$(".status" + target).val($(".s" + target).text());
	}
	//判断数据是否有更改再跳转
	function updateController(target){
		if($(".temp" + target).val()==$(".t" + target).text()&&
				$(".kind" + target).val()==$(".k" + target).text()&& $(".status" + target).val()==$(".s" + target).text())
		{alert("未修改任何数据");}
		else{
			document.forms["form"+target].submit();
		}
	}
</script>
</head>
<body>

	<div class="col-sm-12 col-sm-offset-3 col-lg-12 main">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">数据列表</li>
			</ol>
		</div>
	</div>
	<table style="width: 100%; text-align: center;">
		<tr class="panel panel-blue" style="height: 40px;">
			<td>序号</td>
			<td>设备名</td>
			<td>温度</td>
			<td>冷热模式</td>
			<td>开关状态</td>
			<td>数据操作</td>
			<s:if test="#session.user.isSuper() == true">
				<td>设备操作</td>
			</s:if>
		</tr>
		<s:iterator value="page.list" id="controller" status="index">
			<form id="form<s:property value="#index.index+1" />" action="updateController.action" method="post">
				<tr style="height: 35px; border: 1px solid #30a5ff;">
					<!-- 保存数据，在取消时调用 -->
					<span class="hidden t<s:property value="#index.index+1" />"><s:property
							value="#controller.temp" /></span> 
					<span class="hidden k<s:property value="#index.index+1" />"><s:property
							value='#controller.kind' /></span>
					<span class="hidden s<s:property value="#index.index+1" />"><s:property
							value="#controller.status" /></span>
					
					<input type="hidden" name="id"
						value="<s:property value="#controller.id"/>" />
				    <input type="hidden" name="name"
						value="<s:property value="#controller.name" />" />
					<td><s:property
							value="#index.index+1+page.everyPage*(page.beginPage-1)" /></td>
					<td><s:property value="#controller.name" /></td>
					<td>
						<!-- 指定class,用来获取需要编辑的一行标签 --> 
						<s:select
							class="temp%{#index.index+1}" name="temp"
							list="{20,21,22,23,24,25,26,27}" value="#controller.temp" ></s:select>
					</td>
					<td><s:select class="kind%{#index.index+1}"
							name="kind" list="#{'0':'制冷','1':'制热'}" value="#controller.kind" listKey="key" listValue="value"></s:select>
					</td>
					<td><s:select
							class="status%{#index.index+1}" name="status"
							list="#{'0':'关闭','1':'开启'}" value="#controller.status" listKey="key" listValue="value"></s:select>
					</td>

					<td>
						<!-- js传递需要编辑的一行的class --> 
					<a href="javascript:updateController('<s:property value="#index.index+1" />')"> 
							<span
							class="glyphicon glyphicon-ok">确定</span>
					</a>&nbsp; 
					<a
						href="javascript:editAccess('<s:property value="#index.index+1" />')">
							<span
							class="glyphicon glyphicon-remove">取消</span>
					</a>
					</td>

					<td><s:if test="#session.user.isSuper() == true">
						<a
							href="editController.jsp?id=<s:property value="#controller.id"/>&name=<s:property value="#controller.name"/>"><span
							class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;
						<a
							href="deleteController.action?id=<s:property value="#controller.id"/>"
							class="trash"><span class="glyphicon glyphicon-trash"></span></a>
						</s:if></td>
				</tr>
			</form>
		</s:iterator>
	</table>
<div style="width:100%; text-align:center;margin-top:20px;">
	<s:if test="beginPage==1">
		<!-- <input type="button" value=" 首 页  " />&nbsp;&nbsp;&nbsp;
		<input type="button" value="上一页" /> -->
		<input type="button" class="className" value="首 页" />&nbsp;&nbsp;&nbsp;
		<input type="button" class="className" value="上一页" />&nbsp;&nbsp;&nbsp;
	</s:if>
	<s:else>
		<a href="showAllController.action?beginPage=1"><input type="button" class="className" value="首 页" />
			&nbsp;&nbsp;&nbsp;</a>
		<a
			href="showAllController.action?beginPage=<s:property value="beginPage-1" />">
			<input type="button" class="className" value="上一页" /> </a>
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
		<!-- <input type="button" value="下一页" /> -->
		<input type="button" class="className" value="下一页" />&nbsp;&nbsp;&nbsp;
		<input type="button" class="className" value="尾页" />&nbsp;&nbsp;&nbsp;
	</s:if>
	<s:else>
		<a
			href="showAllController.action?beginPage=<s:property value="beginPage+1"/>">
			<input type="button" class="className" value="下一页" />
		</a>
		<a
			href="showAllController.action?beginPage=<s:property value="page.totalPage"/> ">&nbsp;&nbsp;&nbsp;
			<input type="button" class="className" value="尾 页" />
		</a>
	</s:else>
</div>
	<br />
	<s:if test="#session.user.isSuper() == true">
		<a href="showAddController.action"><button
				class="btn btn-primary btn-md" id="btn-todo">添加新数据控制设备</button></a>
	</s:if>
</body>
</html>