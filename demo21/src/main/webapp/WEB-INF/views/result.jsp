<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과창</title>
</head>
<body>
	<table border="1" width="50%" align="center" >
	   <tr align="center">
	      <td>아이디</td>
	      <td>비밀번호</td>
	   </tr>
	   <tr align="center">
	      <td>${userID}</td>
	      <td>${passwd}</td>
	   </tr>
	</table>
</body>
</html>