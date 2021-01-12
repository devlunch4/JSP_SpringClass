<%@ page language="java"
	contentType="application/vnd.ms-excel; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// Content-Disposition header : 파일 다운로드, 업로드시 사용하는 파일과 관련된 헤더
response.setHeader("Content-Disposition", "attachment; filename=excel.xls");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>excel-Download</title>
</head>
<body>
	<table>
		<tr>
			<th>userid</th>
			<th>이름</th>
		</tr>
		<tr>
			<th>test1</th>
			<th>test1</th>
		</tr>
		<tr>
			<th>test2</th>
			<th>test2</th>
		</tr>
		<tr>
			<th>test3</th>
			<th>test4</th>
		</tr>
	</table>
</body>
</html>