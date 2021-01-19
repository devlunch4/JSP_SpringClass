<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/common_lib.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	param.lang : ${param.lang }
	<form
		action="${cp }/jstl/selectLang_button.jsp">
		<select name="lang">
			<option value="ko">한국어</option>
			<option value="en">english</option>
			<option value="ja">日本語</option>
			<option value="etc">기타</option>
		</select> <br> <input type="submit" value="전송">
	</form>

	<br>
	<%-- select box로 설정한 언어로 Greeting, lang 값을 표현 --%>
	<%-- select Box는 사용자가 설정한 언어 값으로 선택이 되어 있게 설정--%>
	<fmt:setLocale value="${param.lang }" />
	<fmt:bundle basename="kr.or.ddit.msg.msg">
		<fmt:message key="LANG" />
		<br>
		<fmt:message key="GREETING">
			<fmt:param value="brown" />
		</fmt:message>
	</fmt:bundle>
</body>
</html>