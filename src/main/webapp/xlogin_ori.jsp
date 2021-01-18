<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

	<%--개인 정보를 전송하므로 url에 노출되지 않도록 request body 영역에 파라미터를 전송 >> method="POST" --%>
	<form class="test1"
		action="${pageContext.request.contextPath }/loginController" method="post">
		<label>user id : </label><input type="text" name="userid"
			value="xtest1" /><br>
		<label>user id : </label><input type="text" name="userid"
			value="xtest2" /><br>
		<label>password : </label><input type="password" name="pass"
			value="xtest3" /><br>
		<input type="submit" name="btnsend" value="send" />
	</form>

</body>
</html>