<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<h1>구구단 출력하기 JSP</h1>
	<h1>URL 설정 >> http://localhost/contextPath/TimsTable.jsp</h1>
	<table>
		<%
		for (int i = 1; i < 10; i++) {
		%><tr>
			<%
			for (int j = 2; j < 10; j++) {
			%>
			<td><%=j + " * " + i + " = " + (j * i)%></td>
			<%
			}
			%>
		</tr>
		<%
		}
		%>
	</table>
	<hr>
	<h1>구구단 출력하기2 JSP</h1>
	<h1>out.write(""); 사용</h1>
	<table>
		<%
		for (int i = 1; i < 10; i++) {
			out.write("<tr>");
			for (int j = 2; j < 10; j++) {
				out.write("<td> " + j + " * " + i + " = " + (j * i) + "</td>");
			}
			out.write("</tr>");
		}
		%>
	</table>
</body>
</html>