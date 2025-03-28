<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*, sec02.ex01.*"
	isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:useBean id="m" class="sec02.ex01.MemberBean" />
<jsp:setProperty name="m" property="*" />
<%
MemberDAO memDAO = new MemberDAO();
memDAO.addMember(m);
List membersList = memDAO.listMembers();
request.setAttribute("membersList", membersList);
%>
<title>Insert title here</title>
</head>
<body>
	<jsp:forward page="memberList.jsp" />
</body>
</html>