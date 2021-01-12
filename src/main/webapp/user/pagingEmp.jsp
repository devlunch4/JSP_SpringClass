<%@page import="kr.or.ddit.common.model.PageVo"%>
<%@page import="kr.or.ddit.user.model.EmpVo"%>
<%@page import="java.util.List"%>
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

<title>전체EMP페이징리스트</title>

<%--common_lib.jsp == 공통 라이브러리 --%>
<%@ include file="/common/common_lib.jsp"%>
<link href="<%=request.getContextPath()%>/css/dashboard.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/blog.css" rel="stylesheet">

<script type="text/javascript">
	//문서 로딩이 완료되고 나서 실행되는 영역
	$(function() {
		$(".emp").on("click", function() {
			//this : 클릭 이벤트가 발생한 element
			//data-속성명 >> data-userid >> $(this).data("userid"),
			//속성명은 대소문자를 무시하고 소문자로 인식
			//console.log($(this).data("userid"))
			var empno = $(this).data("empno");
			$("#empno").val(empno);
			$("#frm").submit();
		});
	});
</script>
</head>

<body>
	<form id="frm" action="<%=request.getContextPath()%>/emp">
		<input type="hidden" id="empno" name="empno" value="">
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
						<h2 class="sub-header">전체EMP페이징리스트</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>사번</th>
									<th>사원이름</th>
									<th>담당역할</th>
									<th>매니저사번</th>
									<th>입사일</th>
									<th>연봉</th>
									<th>성과급</th>
									<th>소속부서번호</th>
								</tr>
								<%
								for (EmpVo vo : (List<EmpVo>) request.getAttribute("empList")) {
								%>
								<tr class="emp" data-empno="<%=vo.getEmpno()%>">
									<td><%=vo.getEmpno()%></td>
									<td><%=vo.getEname()%></td>
									<td><%=vo.getJob()%></td>
									<td><%=vo.getMgr()%></td>
									<td><%=vo.getHiredate_fmt()%></td>
									<td><%=vo.getSal()%></td>
									<td><%=vo.getComm()%></td>
									<td><%=vo.getDeptno()%></td>
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
								<li class="prev"><a
									href="<%=request.getContextPath()%>/pagingEmp?page=1&pageSize=<%=pageVo.getPageSize()%>">«</a>
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
									href="<%=request.getContextPath()%>/pagingEmp?page=<%=i%>&pageSize=<%=pageVo.getPageSize()%>"><%=i%>
								</a></li>
								<%
								}
								}
								%>
								<li class="next"><a
									href="<%=request.getContextPath()%>/pagingEmp?page=<%=pagination%>&pageSize=<%=pageVo.getPageSize()%>">»</a>
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