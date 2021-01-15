<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JNDI TEST</title>
</head>
<body>
<h1>JNDI TIME TEST</h1>
	<%
		//서버에 등록된 자원을 요청할 떄 사용하는 객체
		InitialContext context = new InitialContext();

		// 해당 server.xml 에서의 name="jdbc/oracleDB" 확인 >> 자원을 가져오기위해서

		//서버에 등록된 커넥션 풀 자원 요청
		DataSource ds  = (DataSource) context.lookup("java:comp/env/jdbc/oracleDB");
	
		//시작
		long startTime = System.currentTimeMillis();
		//커넥션을 데이터 소스로 부터 얻고 반환 하는 반복작업
		for (int i = 0; i < 30; i++) {
				Connection conn = ds.getConnection();
				conn.close();
		}
		//종료(작업시간 확인)
		long endTime = System.currentTimeMillis();
		out.print("duration :" + (endTime - startTime));
		
	%>
</body>
</html>