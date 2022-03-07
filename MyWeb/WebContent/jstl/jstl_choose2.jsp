<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
	choose절을 이용하여 90이상은 A, 80이상은 B, 70이상은 C, 나머지는 F로 출력하세요
	 -->
	 
	<c:choose>
		<c:when test="${param.grade >= 90 }">
		A
		</c:when>
		<c:when test="${param.grade >= 80 }">
		B
		</c:when>
		<c:when test="${param.grade >= 70 }">
		C
		</c:when>
		<c:otherwise>
		F
		</c:otherwise>
	</c:choose>
</body>
</html>