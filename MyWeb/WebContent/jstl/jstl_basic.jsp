<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	String test = "문자열 변수 입니다.";
	int num = 100;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 출력 태그  -->
	<h3>출력 태그</h3>
	test변수 값1 : <c:out value="<%= test %>" /> <br>
	test변수 값2 : <c:out value="<%= test %>" ></c:out> <br>
	
	<hr>
	<!-- 변수 선언 태그 -->
	<h3>변수 선언 태그</h3>
	<c:set var="var1" value="100" scope="page" />
	var1 변수의 값 : ${var1}<br>
	
	<hr>
	<!-- 변수 제거 태그 -->
	<c:remove var="var1" scope="page" />
	<h3>변수 제거후 결과</h3>
	var1 변수의 값 : ${var1}<br>
	
	
</body>
</html>