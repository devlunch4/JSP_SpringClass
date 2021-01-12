
<%@page import="kr.or.ddit.user.model.EmpVo"%>
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

<title>EmpModify</title>

<%--common_lib.jsp == 공통 라이브러리 --%>
<%@ include file="/common/common_lib.jsp"%>
<link href="<%=request.getContextPath()%>/css/dashboard.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/blog.css" rel="stylesheet">

<!-- 주소 입력 부분 다음 API 활용 -->
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	new daum.Postcode({
		oncomplete : function(data) {
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
			// 예제를 참고하여 다양한 활용법을 확인해 보세요.
			$("#addr1").val(data.roadAddress); // 도로명 주소
			$("#zipcode").val(data.zonecode); // 우편주소
		}
	}).open();
</script>

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
				<h2 class="sub-header">사용자 상세 조회</h2>
				<form class="form-horizontal" role="form"
					action="<%=request.getContextPath()%>/empModify">
					<input type="hidden" name="empno" value="<%=emp.getEmpno()%>" />

					<div class="form-group">
						<label for="empNo" class="col-sm-2 control-label">사번</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="empNo" name="empNo"
								placeholder="사번" value="<%=emp.getEmpno()%>" readonly />
						</div>
					</div>

					<div class="form-group">
						<label for="ename" class="col-sm-2 control-label">사원이름</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="ename" name="ename"
								placeholder="사원이름 이름" value="<%=emp.getEname()%>" />
						</div>
					</div>

					<div class="form-group">
						<label for="job" class="col-sm-2 control-label">담당역할</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="job" name="job"
								placeholder="담당역할" value="<%=emp.getJob()%>" />
						</div>
					</div>

					<div class="form-group">
						<label for="mgr" class="col-sm-2 control-label">매니저사번</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="mgr" name="mgr"
								placeholder="매니저사번" value="<%=emp.getMgr()%>" readonly />
						</div>
					</div>
					<div class="form-group">
						<label for="hiredate" class="col-sm-2 control-label">입사일></label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="hiredate"
								name="hiredate" placeholder="입사일"
								value="<%=emp.getHiredate_fmt()%>" readonly />
						</div>
					</div>

					<div class="form-group">
						<label for="sal" class="col-sm-2 control-label">연봉</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="sal" name="sal"
								placeholder="연봉" value="<%=emp.getSal()%>" />
						</div>
					</div>

					<div class="form-group">
						<label for="comm" class="col-sm-2 control-label">성과급</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="comm" name="comm"
								placeholder="성과급" value="<%=emp.getComm()%>" />
						</div>
					</div>

					<div class="form-group">
						<label for="deptno" class="col-sm-2 control-label">소속부서번호</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="deptno" name="deptno"
								placeholder="소속부서번호" value="<%=emp.getDeptno()%>" />
						</div>
					</div>


					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">수정 완료</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
