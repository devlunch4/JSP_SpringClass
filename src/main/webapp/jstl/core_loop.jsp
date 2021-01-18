<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- for(1.초기화; 2.조건체크; 4.증감식){
		3.반복문장
		}
		
		1234 2345 345
		
		begin : 시작 인덱스 값
		end : 종료 인덱스 값
		step : 증감 값 (default 1)
		var : 인덱스 변수 or 향상된 for문에서 사용될 경우 collection 객체에서 꺼낸 값 설정
		varStatus : 루프변수
			index - 현재 인덱스 값
			count - 루프실행수
			end - 루프의 end 값
			begin, end - 루프의 begin, end 값
		
--%>
	<h3>일반 for 문 형태</h3>
	<c:forEach begin="0" end="10" var="i" varStatus="loop">
		${i } : 반복시킬 문장 ${loop.index } / ${loop.count } <br>
	</c:forEach>

</body>
</html>