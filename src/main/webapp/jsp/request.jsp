<%@page import="ch.qos.logback.core.joran.action.ContextPropertyAction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request.jsp</title>
</head>
<body>
	request.getContentType() :
	<%=request.getContentType()%>
	<br> request.getMethod() :
	<%=request.getMethod()%>
	<br> request.getRequestURI() :
	<%=request.getRequestURI()%>
	<br> request.getContextPath() :
	<%=request.getContextPath()%>
	<br> request.getServerPort() :
	<%=request.getServerPort()%>
</body>
</html>