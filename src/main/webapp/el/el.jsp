<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	//컨트롤러에서 조회된 데이터를 request에 저장했다라는 가정
	//원래라면 서블릿에 넘긴 상태
	UserVo userVo = new UserVo();
	userVo.setUserid("brown");
	userVo.setUsernm("브라운");
	userVo.setAlias("곰");

	request.setAttribute("userVo", userVo);
	%>


	<%--view --%>
	<h1>표현식 - userVo</h1>
	userVo :
	<%=request.getAttribute("userVo")%><br> userVo.getUserid() :
	<%=((UserVo) request.getAttribute("userVo")).getUserid()%><br>

	<h1>EL - userVo</h1>
	userVo : ${userVo}
	<br> userVo.getUserid() : ${userVo.userid} / ${userVo.getUserid()}
	<br>
	<br>
	<hr>
	<%
	//맵 객체 생성
	Map<String, String> map = new HashMap<String, String>();

	map.put("userid", "brown");
	map.put("usernm", "브라운");
	map.put("alias", "곰");

	request.setAttribute("map", map);
	%>
	<h1>표현식 - map</h1>
	map :
	<%=request.getAttribute("map")%><br> map.get("userid") :
	<%=map.get("userid")%>

	<h1>EL - userVo</h1>
	map : ${map}
	<br> map.get("userid") : ${map.userid} / ${map.get("userid")}
	<br>


<h1> 산술연산</h1>
${ 5+5}
</body>
</html>
