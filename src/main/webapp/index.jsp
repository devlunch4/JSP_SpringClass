
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	webapp/index.jsp ==> localhost/index.jsp
	<br> webapp/image/brown.png
	<br>
	<img src="/image/brown.png" />
	<img src="${pageContext.request.contextPath}/image/brown.png" />
</body>
</html>