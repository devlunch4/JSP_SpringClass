<%@page import="java.sql.Connection"%>
<%@page import="org.apache.commons.dbcp2.BasicDataSource"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DBCP</title>
</head>
<body>
<h1>DBCP TIME TEST</h1>
	<%
	BasicDataSource bs = (BasicDataSource) application.getAttribute("bs");
	
	
	//시작
	long startTime = System.currentTimeMillis();
	//커넥션을 데이터 소스로 부터 얻고 반환 하는 반복작업
	for (int i = 0; i < 30; i++) {
			Connection conn = bs.getConnection();
			conn.close();
	}
	//종료(작업시간 확인)
	long endTime = System.currentTimeMillis();
	out.print("duration :" + (endTime - startTime));
	%>

</body>
</html>