<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sumView2.jsp</title>

</head>
<body>
	<h1>sumView2.jsp</h1>
	더하기 시작숫자는 끝숫자보다 작습니다.
	<br>
	<form action="<%=request.getContextPath()%>/sumCalculationt"
		method="post">
 <input
			type="submit" id=btnsubmit value="전송">
	</form>
</body>
</html>