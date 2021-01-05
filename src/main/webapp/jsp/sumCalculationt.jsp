<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sumCalculationt.jsp</title>

</head>
<body>
	<h1>sumCalculationt.jsp</h1>
	더하기 시작숫자는 끝숫자보다 작습니다.
	<br>
	<form action="<%=request.getContextPath()%>/sumCalculationt"
		method="post">

		시작 숫자 입력 : <input type="text" id="start" name="start"><br>
		끝 숫자 입력 : <input type="text" id="end" name="end"><br> <input
			type="submit" id=btnsubmit value="전송">
	</form>
</body>
</html>