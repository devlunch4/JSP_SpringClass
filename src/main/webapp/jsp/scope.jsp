<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>scope.jsp 실습</title>

<script type="text/javascript">
var test = <%=application.getAttribute("application")%>
var test = "sally_application";
<%-- jsp 주석. 서버에서 에러 미발생 실행 안하기 떄문<%String a %> = test; --%>
<%-- 클라이언트에서는 서버 사이드 변수 값을 활용할수 있으나 
서버 사이드 변수에 클라이언트 사이드 변수 값을 대입할수 없다--%>
</script>
</head>
<body>

	<form action="<%=request.getContextPath()%>/scope" method="post">
		<input type="text" id="name-scope" name="name-scope"><br>
		<input type="submit" id=btnsubmit value="전송">
	</form>
</body>
</html>