<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- jsp 메소드 , 변수 선언부--%>
<%@ page import="kr.or.ddit.servlet.basic.Factorial"%>
<%!//메소드 선언
	//Factorial fac = new Factorial();
	private int calculate(int n) {
		if (n <= 1)
			return 1;
		else
			return n * calculate(n - 1);
		// return n * calculate(--n);
	}%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>factorial</title>
</head>
<body>
	1!:
	<%=calculate(1)%>
	<br> 2!:
	<%=calculate(2)%>
	<br> 3!:
	<%=calculate(3)%>
	<br> 4!:
	<%=calculate(4)%>
	<br> 5!:
	<%=calculate(5)%>
	<br> 6!:
	<%=calculate(6)%>
	<br>
</body>
</html>
