<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table align="center" border="1" width="80%">
		<tr align="center" bgcolor="yellow">
			<td width="7%"><b>아이디</b></td>
			<td width="7%"><b>비밀번호</b></td>
			<td width="7%"><b>이름</b></td>
			<td width="7%"><b>이메일</b></td>
			<td width="7%"><b>가입일</b></td>
		</tr>
		<tr align="center">
			<td width="7%"><b>${member.id }</b></td>
			<td width="7%"><b>${member.pwd }</b></td>
			<td width="7%"><b>${member.name }</b></td>
			<td width="7%"><b>${member.email }</b></td>
			<td width="7%"><b>${member.joinDate }</b></td>
		</tr>
</body>
</html>