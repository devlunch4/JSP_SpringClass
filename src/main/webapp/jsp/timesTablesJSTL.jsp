<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TimeTableServlet.jsp</title>
<style type="text/css">
table, tr, td {
	border: 1px solid black;
}

table {
	width: 100%;
	text-align: center;
}
</style>
</head>
<body>
	<h1>구구단 출력하기 JSP >>> JSTL</h1>
	<table>
		<c:forEach begin="1" end="9" var="i" varStatus="loop">
			<tr>
				<c:forEach begin="2" end="9" var="j" varStatus="loop2">
					<td>${j }* ${i } = ${j * i }</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
	<br>


	<hr>


	<h1>구구단 출력하기2 JSP >>> JSTL >>> varStatus= loop 변수</h1>
	<table>
		<c:forEach begin="1" end="9" var="i" varStatus="loop">
			<tr>
				<c:forEach begin="2" end="9" var="j" varStatus="loop2">
					<td>loop index : ${loop.index } <br>loop end : ${loop.end }
						<br>loop count : ${loop.count } <br>------ <br>${j }*${i }=${j * i }
					</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>


</body>
</html>