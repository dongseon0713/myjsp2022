<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");	//request로 받아온 함수를 String변수로 변환
	String number = request.getParameter("number");	//tomcat이 내장되어있는 내장객체에서 전달
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	전달 받은 값<br>
	이름 : <%= name %><br>
	번호 : <%= number %><br>
</body>
</html>