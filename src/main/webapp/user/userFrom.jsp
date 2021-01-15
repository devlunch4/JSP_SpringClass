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

<title>UserFrom</title>

<%--common_lib.jsp == 공통 라이브러리 --%>
<%@ include file="/common/common_lib.jsp"%>
<link href="<%=request.getContextPath()%>/css/dashboard.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/blog.css" rel="stylesheet">
<script type="text/javascript">
	//문서 로딩이 완료 되었을때
		//사용자 수정 : method : get, action = /userModify
		//사용자 수정 : method : get, action = /userDelete
		//파라미터는 둘다 userid 하나만 있으면 가능
		$(function () {
			$("#modifyBtn").on("click", function () {
				$("#frm").attr("method","get");
				$("#frm").attr("action","<%=request.getContextPath()%>/userModify");
				$("#frm").submit();
			});
			
			$("#deleteBtn").on("click", function () {
				$("#frm").attr("method","post");
				$("#frm").attr("action","<%=request.getContextPath()%>
	/userDelete");
					$("#frm").submit();
				});
	});
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
		UserVo user = (UserVo) request.getAttribute("user");
		%>
		<div class="row">
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h2 class="sub-header">사용자 상세 조회</h2>
				<form class="form-horizontal" role="form" id="frm">
					<input type="hidden" name="userid" value="<%=user.getUserid()%>" />

					<div class="form-group">
						<label class="col-sm-2 control-label">사용자 사진</label>
						<div class="col-sm-10">
							<img
								src="<%=request.getContextPath()%>/profile/<%=user.getUserid()%>.png">
						</div>
					</div>



					<div class="form-group">
						<label for="userId" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<label class="control-label"><%=user.getUserid()%></label>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
						<div class="col-sm-10">
							<label class="control-label"><%=user.getUsernm()%></label>
						</div>
					</div>

					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">비밀번호</label>
						<div class="col-sm-10">
							<label class="control-label"><%=user.getPass()%></label>
						</div>
					</div>

					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">사용자등록일</label>
						<div class="col-sm-10">
							<label class="control-label"><%=user.getReg_dt_fmt()%></label>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">별명</label>
						<div class="col-sm-10">
							<label class="control-label"><%=user.getAlias()%></label>
						</div>
					</div>

					<div class="form-group">
						<label for="addr1" class="col-sm-2 control-label">주소</label>
						<div class="col-sm-10">
							<label class="control-label"><%=user.getAddr1()%></label>
						</div>
					</div>

					<div class="form-group">
						<label for="addr2" class="col-sm-2 control-label">상세주소</label>
						<div class="col-sm-10">
							<label class="control-label"><%=user.getAddr2()%></label>
						</div>
					</div>

					<div class="form-group">
						<label for="zipcode" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<label class="control-label"><%=user.getZipcode()%></label>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" id="modifyBtn" class="btn btn-default">사용자
								수정</button>
							<button type="button" id="deleteBtn" class="btn btn-default">사용자
								삭제</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>