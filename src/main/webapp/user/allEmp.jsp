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
<title>allEmp</title>
<%--common_lib.jsp == 공통 라이브러리 --%>
<%@ include file="/common/common_lib.jsp"%>
<link href="<%=request.getContextPath()%>/css/dashboard.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/blog.css" rel="stylesheet">
</head>
<body>
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
						<h2 class="sub-header">EMP</h2>
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
								List<EmpVo> empList = (List<EmpVo>) request.getAttribute("empList");
								if (empList != null) {
									for (int i = 0; i < empList.size(); i++) {
										EmpVo vo = empList.get(i);
								%>
								<tr>
									<td><%=vo.getEmpno()%></td>
									<td><%=vo.getEname()%></td>
									<td><%=vo.getJob()%></td>
									<td><%=vo.getMgr()%></td>
									<td><%=vo.getHiredate()%></td>
									<td><%=vo.getSal()%></td>
									<td><%=vo.getComm()%></td>
									<td><%=vo.getDeptno()%></td>
								</tr>
								<%
								}
								}
								%>
							</table>
						</div>
						<a class="btn btn-default pull-right">사용자 등록</a>
						<div class="text-center">
							<ul class="pagination">
								<li><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>