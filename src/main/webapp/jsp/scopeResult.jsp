<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>scopeResult.jsp 실습</title>
</head>
<body>
	<!-- 스코프객체, getAttribute("속성명"),반환타입 : Object -->
	request :
	<%=request.getAttribute("request")%><br> session :
	<%=session.getAttribute("session")%><br> application :
	<%=application.getAttribute("application")%><br>
</body>
</html>