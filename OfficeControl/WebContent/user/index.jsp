<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理系统</title>
</head>
    <frameset rows="75,*" cols="*" frameborder="no" border="0" framespacing="0">
		<frame src="user/top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame"/>
		<frameset cols="300,*"  frameborder="0" border="0" >
		<frame src="user/left.jsp" name="leftFrame" noresize="noresize" marginwidth="0" marginheight="0" frameborder="0"border="0" scrolling="no"  />
		<frame src="user/right.jsp" name="main"  noresize="noresize" marginheight="0" marginwidth="0"  frameborder="0" border="0" scrolling="auto" style="overflow-x:hidden;overflow-y: auto;"/>
  	    </frameset>
	</frameset>
	<noframes>
	</noframes>
	<body></body>
</html>
