<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@  taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 날짜 (java.util.Date) 객체를 생성하여 속성이름 date로 pageContext에 저장 --%>
	<c:set var="price" value="100000" />
	<c:set var="date" value="<%=new Date()%>" />
	<c:set var="dateStr" value="2021.01.01" />
	date : ${date }
	<br> date fmt :
	<fmt:formatDate value="${date }" />

	<br> date fmt type date full :
	<fmt:formatDate value="${date }" type="date" dateStyle="full" />
	<br> date fmt type date medium :
	<fmt:formatDate value="${date }" type="date" dateStyle="medium" />
	<br> date fmt type date short :
	<fmt:formatDate value="${date }" type="date" dateStyle="short" />
	<br> date fmt type time:
	<fmt:formatDate value="${date }" type="time" />
	<br> date fmt type both:
	<fmt:formatDate value="${date }" type="both" />
	<hr>
	<h2>custom</h2>
	date fmt custom :
	<fmt:formatDate value="${date }" pattern="yyyy-MM-dd" />
	<br>date fmt custom2 :
	<fmt:formatDate value="${date }" pattern="yyyy.MM.dd" />
	<hr>
	<h2>dateStr parseDate</h2>
	parse dateStr :
	<fmt:parseDate value="${dateStr }" pattern="yyyy.MM.dd" />

	<h1>Time Zone</h1>
	<c:set var="now" value="<%=new java.util.Date()%>"></c:set>
	default :
	<fmt:formatDate value="${now }" />
	<br> Korea KST :
	<fmt:formatDate value="${now }" type="both" dateStyle="full"
		timeStyle="full" />
	<fmt:timeZone value="GMT">
		<br> GMT : <fmt:formatDate value="${now }" type="both"
			dateStyle="full" timeStyle="full" />
	</fmt:timeZone>

	<fmt:timeZone value="GMT">
		<br> GMT : <fmt:formatDate value="${now }" type="both"
			dateStyle="full" timeStyle="full" />
	</fmt:timeZone>

	<fmt:timeZone value="US/Hawaii">
	<br> US/Hawaii : <fmt:formatDate value="${now }" type="both"
			dateStyle="full" timeStyle="full" />
	</fmt:timeZone>

	<h2>TIME ZONE LIST</h2>
	<%@page import="java.util.TimeZone"%>
	<c:set var="ts" value="<%=TimeZone.getAvailableIDs()%>" />
	<c:forEach var="t" items="${ts }">
        ${t} <br />
	</c:forEach>

</body>
</html>