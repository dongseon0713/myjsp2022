<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
	세션에 있는 값을 한번에 얻을 때는 sessionScope.이름.이름
	
	어플리케이션에 있는 값을 한번에 얻을 때는 applicationScope.이름.이름
	 -->
	아이디 : ${sessionScope.id}<br>
	이메일 : ${sessionScope.vo.email}<br>
	관리자 : ${applicationScope.admin}<br>
</body>
</html>