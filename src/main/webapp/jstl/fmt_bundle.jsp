<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<fmt:bundle basename="kr.or.ddit.msg.msg">
		<fmt:message key="LANG" />
		<br>
		<fmt:message key="GREETING">
			<fmt:param value="brown" />
		</fmt:message>
	</fmt:bundle>


	<h3>ENGLISH</h3>
	<!-- 로케일 설정 변경 -->
	<fmt:setLocale value="en" />
	<fmt:bundle basename="kr.or.ddit.msg.msg">
		<fmt:message key="LANG" />
		<br>
		<fmt:message key="GREETING">
			<fmt:param value="brown" />
		</fmt:message>
	</fmt:bundle>

	<h3>JAPAN</h3>
	<!-- 로케일 설정 변경 -->
	<fmt:setLocale value="ja" />
	<fmt:bundle basename="kr.or.ddit.msg.msg">
		<fmt:message key="LANG" />
		<br>
		<fmt:message key="GREETING">
			<fmt:param value="brown" />
		</fmt:message>
	</fmt:bundle>
	<br>
	<hr>
	<h3>
		setbundle : 번들값을 속성에 저장<br> message 태그를 사용할떄 번들을 지정 ==> bundle 태그
		없이 사용 가능
	</h3>
	<fmt:setBundle basename="kr.or.ddit.msg.msg" var="msg" />
	<fmt:message key="LANG" bundle="${msg }" />
	<br>
	<fmt:message key="GREETING" bundle="${msg }">
		<fmt:param value="brown2" />
	</fmt:message>
	<br>
	<br>
	<hr>
	<fmt:message key="LANG" bundle="${msg }" var="lang2" />
	lang2 : ${lang2 }

</body>
</html>