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

<title>userRegist</title>

<%--common_lib.jsp == 공통 라이브러리 --%>
<%@ include file="/common/common_lib.jsp"%>
<link href="${cp }/css/dashboard.css"
	rel="stylesheet">
<link href="${cp }/css/blog.css" rel="stylesheet">

<!-- 주소 입력 부분 다음 API 활용 -->
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<%
UserVo userVo = (UserVo) request.getAttribute("userVo");
%>
<script>
	$(function() {

		//주소 검색 버튼이 클릭 되었을 때 다음주소API 팝업을 연다			
		$("#addrBtn").on("click", function() {
			new daum.Postcode({
				oncomplete : function(data) {
					// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
					// 예제를 참고하여 다양한 활용법을 확인해 보세요.
					$("#addr1").val(data.roadAddress); // 도로명 주소
					$("#zipcode").val(data.zonecode); // 우편주소

					//사용자 편의성을 위해 상세주소 입력 input 태그로 focus 설정
					$("#addr2").focus();
				}
			}).open();
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

		<div class="row">
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h2 class="sub-header">사용자 등록</h2>
				<form class="form-horizontal" role="form"
					action="${cp }/userRegist" method="post">
					<input type="hidden" name="userid" value="" />

					<%
					String userId = request.getParameter("userId");
					userId = userId == null ? "" : userId;
					%>
					<div class="form-group">
						<label for="userId" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userId" name="userId"
								placeholder="사용자 아이디" value="<%=userId%>">
						</div>
					</div>

					<%
					String userNm = request.getParameter("userNm");
					userNm = userNm == null ? "" : userNm;
					%>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userNm" name="userNm"
								placeholder="사용자 이름" value="<%=userNm%>">
						</div>
					</div>

					<%
					String pass = request.getParameter("pass");
					pass = pass == null ? "" : pass;
					%>
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">비밀번호</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="pass" name="pass"
								placeholder="Password" value="<%=pass%>">
						</div>
					</div>

					<%
					String reg_dt = request.getParameter("reg_dt");
					reg_dt = reg_dt == null ? "" : reg_dt;
					%>
					<div class="form-group">
						<label for="reg_dt" class="col-sm-2 control-label">사용자등록일</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="reg_dt" name="reg_dt"
								placeholder="사용자 등록일" value="<%=reg_dt%>" />
						</div>
					</div>

					<%
					String userAlias = request.getParameter("userAlias");
					userAlias = userAlias == null ? "" : userAlias;
					%>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">별명</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userAlias"
								name="userAlias" placeholder="별명" value="<%=userAlias%>" />
						</div>
					</div>

					<%
					String addr1 = request.getParameter("addr1");
					addr1 = addr1 == null ? "" : addr1;
					%>
					<div class="form-group">
						<label for="addr1" class="col-sm-2 control-label">도로주소</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="addr1" name="addr1"
								placeholder="주소 검색 버튼 클릭" value="<%=addr1%>" readonly />
						</div>
						<div class="col-sm-2">
							<button type="button" id="addrBtn" class="btn btn-default">주소
								검색</button>
						</div>
					</div>

					<%
					String addr2 = request.getParameter("addr2");
					addr2 = addr2 == null ? "" : addr2;
					%>
					<div class="form-group">
						<label for="addr2" class="col-sm-2 control-label">상세주소</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="addr2" name="addr2"
								placeholder="상세주소" value="<%=addr2%>" />
						</div>
					</div>

					<%
					String zipcode = request.getParameter("zipcode");
					zipcode = zipcode == null ? "" : zipcode;
					%>
					<div class="form-group">
						<label for="zipcode" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="zipcode"
								name="zipcode" placeholder="우편번호" value="" value="<%=zipcode%>"
								readonly />
						</div>
					</div>


					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">등록 완료</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
