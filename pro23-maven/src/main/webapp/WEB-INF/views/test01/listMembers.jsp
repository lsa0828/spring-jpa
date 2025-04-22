<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
</head>
<body>
	<c:if test="${not empty alertMsg }">
		<script>
			alert("${alertMsg}");
		</script>
	</c:if>
	<table align="center" border="1" width="80%">
		<tr align="center" bgcolor="yellow">
			<td width="7%"><b>아이디</b></td>
			<td width="7%"><b>비밀번호</b></td>
			<td width="7%"><b>이름</b></td>
			<td width="7%"><b>이메일</b></td>
			<td width="7%"><b>가입일</b></td>
			<td width="7%"><b>삭제</b></td>
		</tr>
		<c:choose>
			<c:when test="${membersList==null }">
				<tr>
					<td colspan=5>
						<b>등록된 회원이 없습니다.</b>
					</td>
				</tr>
			</c:when>
			<c:when test="${membersList!=null }">
				<c:forEach var="member" items="${membersList }">
					<tr align="center">
						<td><a href="${contextPath }/modMember?id=${member.id}">${member.id }</a></td>
						<td>${member.pwd }</td>
						<td>${member.name }</td>
						<td>${member.email }</td>
						<td>${member.joinDate }</td>
						<td><a href="${contextPath }/deleteMem?id=${member.id }">삭제하기</a></td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
	<a href="${contextPath }/memberForm" text-align="center"><h1 style="text-align:center">회원가입하기</h1></a>
</body>
</html>