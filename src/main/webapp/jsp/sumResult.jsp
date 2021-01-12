<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sumRerult.jsp</title>
</head>
<body>
	start =
	<%=request.getAttribute("start")%><br> end =
	<%=request.getAttribute("end")%><br>
	<br> sumResult =
	<%=session.getAttribute("sumResult")%>
</body>
</html>