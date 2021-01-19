<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%--page scope에 속성이름 price, 값은 100000 추가 --%>
	<%
	pageContext.setAttribute("price", 100000);
	%>

	<c:set var="price" value="100000" />
	<%--100000숫자 ===> 100,000문자 --%>
	<c:set var="priceStr" value="100,000" />
	<%--100,000문자 ===> 100000숫자 --%>

	<br> price : ${price }
	<br> price fmt :
	<fmt:formatNumber value="${price }" />
	<br> price fmt type number :
	<fmt:formatNumber value="${price }" type="number" />
	<br> price fmt type currency :
	<fmt:formatNumber value="${price }" type="currency" />
	<br> price fmt type percentage :
	<fmt:formatNumber value="${price }" type="percent" />

	<br> price fmt type pattern :
	<fmt:formatNumber value="${price }" pattern="0000000000.00" />
	<br>
	<br> priceStr original : ${priceStr }
	<br> priceStr parse :
	<fmt:parseNumber value="${priceStr }" />

	<hr>


	<h3>de-germany</h3>
	<fmt:setLocale value="de" />
	price : ${price }
	<br> price fmt :
	<fmt:formatNumber value="${price }" />
	<br> price fmt type number :
	<fmt:formatNumber value="${price }" type="number" />
	<br> price fmt type currency :
	<fmt:formatNumber value="${price }" type="currency" />
	<br> price fmt type percentage :
	<fmt:formatNumber value="${price }" type="percent" />

	<br> price fmt type pattern :
	<fmt:formatNumber value="${price }" pattern="0000000000.00" />

</body>
</html>