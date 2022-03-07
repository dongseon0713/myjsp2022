<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>액션태그로 자바bean을 사용</h2>
<jsp:useBean id="user" class="com.bean.User" scope="request" />
전달 받은 아이디 : <jsp:getProperty property="id" name="user"/> <br>
전달 받은 이름 : <jsp:getProperty property="name" name="user"/>
</body>
</html>