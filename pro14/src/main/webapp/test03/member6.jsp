<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*"
	isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%
List<String> dataList = new ArrayList<String>();
dataList.add("hello");
dataList.add("world");
dataList.add("안녕하세요");
%>
<c:set var="list" value="${dataList }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반복문 실습</title>
</head>
<body>
	<c:forEach var="i" begin="1" end="10" step="1" varStatus="loop">
		i=${i } &nbsp;&nbsp;&nbsp; 반복횟수: ${loop.count }<br>
	</c:forEach>
	<br>
	<c:forEach var="i" begin="1" end="10" step="2">
		5 * ${i } = ${5*i }<br>
	</c:forEach>
	<br>
	<c:forEach var="data" items="${list }">
		${data }<br>
	</c:forEach>
	<br>
	<c:set var="fruits" value="사과, 파인애플, 바나나, 망고, 귤" />
	<c:forEach var="token" items="${fn:split(fruits, ',')}">
        ${token}<br>
    </c:forEach>
</body>
</html>