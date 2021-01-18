<%@page import="kr.or.ddit.emp.model.EmpVo"%>
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

<title>empRegist</title>

<%--common_lib.jsp == 공통 라이브러리 --%>
<%@ include file="/common/common_lib.jsp"%>
<link href="${pageContext.request.contextPath}/css/dashboard.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/blog.css" rel="stylesheet">

<!-- 주소 입력 부분 다음 API 활용 -->
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<%
EmpVo empVo = (EmpVo) request.getAttribute("userVo");
%>

</head>

<body>
	<!-- 헤더부분 include -->
	<%@ include file="/common/header.jsp"%>
	<div class="col-sm-3 col-md-2 sidebar">
		<!-- left 프레임 부분 include 위아래는 그리드 개념으로 유지보수시 확인을 위해 남김 -->
		<%@ include file="/common/left.jsp"%>
	</div>
	<div class="container-fluid">
		<%
		EmpVo emp = (EmpVo) request.getAttribute("emp");
		%>
		<div class="row">
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h2 class="sub-header">EMP 등록</h2>
				<form class="form-horizontal" role="form"
					action="${pageContext.request.contextPath}/empRegist" method="post">
					<input type="hidden" name="empNo" value="" />

					<%
					String empNo = request.getParameter("empno");
					empNo = empNo == null ? "" : empNo;
					%>
					<div class="form-group">
						<label for="empno" class="col-sm-2 control-label">사번</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="empno" name="empno"
								placeholder="사번" value="<%=empNo%>">
						</div>
					</div>

					<%
					String ename = request.getParameter("ename");
								ename = ename == null ? "" : ename;
					%>
					<div class="form-group">
						<label for="ename" class="col-sm-2 control-label">사원 이름</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="ename" name="ename"
								placeholder="사원 이름" value="<%=ename%>">
						</div>
					</div>

					<%
					String job = request.getParameter("job");
								job = job == null ? "" : job;
					%>
					<div class="form-group">
						<label for="job" class="col-sm-2 control-label">담당역할</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="job" name="job"
								placeholder="담당역할" value="<%=job%>">
						</div>
					</div>

					<%
					String mgr = request.getParameter("mgr");
								mgr = mgr == null ? "" : mgr;
					%>
					<div class="form-group">
						<label for="mgr" class="col-sm-2 control-label">매니저사번</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="mgr" name="mgr"
								placeholder="매니저사번" value="<%=mgr%>" />
						</div>
					</div>

					<%
					String hiredate = request.getParameter("hiredate");
								hiredate = hiredate == null ? "" : hiredate;
					%>
					<div class="form-group">
						<label for="hiredate" class="col-sm-2 control-label">입사일</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="hiredate"
								name="hiredate" placeholder="입사일" value="<%=hiredate%>" />
						</div>
					</div>

					<%
					String sal = request.getParameter("sal");
								sal = sal == null ? "" : sal;
					%>
					<div class="form-group">
						<label for="sal" class="col-sm-2 control-label">연봉</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="sal" name="sal"
								placeholder="연봉" value="<%=sal%>" />
						</div>
					</div>

					<%
					String comm = request.getParameter("comm");
								comm = comm == null ? "" : comm;
					%>
					<div class="form-group">
						<label for="comm" class="col-sm-2 control-label">성과급</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="comm" name="comm"
								placeholder="성과급" value="<%=comm%>" />
						</div>
					</div>

					<%
					String deptno = request.getParameter("deptno");
								deptno = deptno == null ? "" : deptno;
					%>
					<div class="form-group">
						<label for="deptno" class="col-sm-2 control-label">소속부서번호</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="deptno" name="deptno"
								placeholder="소속부서번호" value="" value="<%=deptno%>" />
						</div>
					</div>


					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">EMP 등록 완료</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
