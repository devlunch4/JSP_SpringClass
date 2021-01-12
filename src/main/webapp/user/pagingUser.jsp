<%@page import="kr.or.ddit.common.model.PageVo"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>전체사용자페이징리스트</title>

<%--common_lib.jsp == 공통 라이브러리 --%>
<%@ include file="/common/common_lib.jsp"%>
<link href="<%=request.getContextPath()%>/css/dashboard.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/blog.css" rel="stylesheet">

<script type="text/javascript">
	//문서 로딩이 완료되고 나서 실행되는 영역
	$(function() {
		$(".user").on("click", function() {
			//this : 클릭 이벤트가 발생한 element
			//data-속성명 >> data-userid >> $(this).data("userid"),
			//속성명은 대소문자를 무시하고 소문자로 인식
			//console.log($(this).data("userid"))
			var userid = $(this).data("userid");
			$("#userid").val(userid);
			$("#frm").submit();
		});
	});
</script>
</head>

<body>
	<form id="frm" action="<%=request.getContextPath()%>/user">
		<input type="hidden" id="userid" name="userid" value="">
	</form>
	<!-- 헤더부분 include -->
	<%@ include file="/common/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file="/common/left.jsp"%>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">전체사용자페이징리스트</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>사용자 아이디</th>
									<th>사용자 이름</th>
									<th>사용자 비밀번호</th>
									<th>등록일시</th>
									<th>사용자 별명</th>
								</tr>
								<%
								for (UserVo user : (List<UserVo>) request.getAttribute("userList")) {
								%>
								<tr class="user" data-userid="<%=user.getUserid()%>">
									<td><%=user.getUserid()%></td>
									<td><%=user.getUsernm()%></td>
									<td><%=user.getPass()%></td>
									<td><%=user.getReg_dt_fmt()%></td>
									<td><%=user.getAlias()%></td>
								</tr>
								<%
								}
								%>
							</table>
						</div>
						<a class="btn btn-default pull-right">사용자 등록</a>
						<div class="text-center">
							<%
							PageVo pageVo = (PageVo) request.getAttribute("pagevo");
							int pagination = (int) request.getAttribute("pagination");
							%>
							<ul class="pagination">
								<%--pagination 값이 4이므로 1부터 4까지 4번 반복된다
							전체 사용자수 16명
							페이지사이즈수 5
							전체 페이지수 4 --%>
								<li class="prev"><a
									href="<%=request.getContextPath()%>/pagingUser?page=1&pageSize=<%=pageVo.getPageSize()%>">«</a>
								</li>
								<%
								for (int i = 1; i <= pagination; i++) {
									if (pageVo.getPage() == i) {
								%>
								<li class="active"><span><%=i%></span></li>
								<%
								} else {
								%>
								<li><a
									href="<%=request.getContextPath()%>/pagingUser?page=<%=i%>&pageSize=<%=pageVo.getPageSize()%>"><%=i%>
								</a></li>
								<%
								}
								}
								%>
								<li class="next"><a
									href="<%=request.getContextPath()%>/pagingUser?page=<%=pagination%>&pageSize=<%=pageVo.getPageSize()%>">»</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
