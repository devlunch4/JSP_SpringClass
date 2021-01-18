<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sumCalculation.jsp</title>
</head>
<body>
	<h1>sumCalculation.jsp</h1>
	두 파라미터의 곱
	<br>
	<form action="${pageContext.request.contextPath}/mulCalculationt"
		method="post">
		시작 숫자 입력 : <input type="text" id="start" name="start"><br>
		끝 숫자 입력 : <input type="text" id="end" name="end"><br> <input
			type="submit" id=btnsubmit value="전송">
	</form>
</body>
</html>