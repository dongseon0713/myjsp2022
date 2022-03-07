<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    if(session.getAttribute("user_id")==null){
    	response.sendRedirect("login.jsp");
    }
	
    String id = (String)session.getAttribute("user_id");
	String name = (String)session.getAttribute("name");
	
	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 페이지 정보</title>
</head>
<body>
	
	<h2><%= id %>님 환영합니다.</h2>
	<a href="logout.jsp">로그아웃</a>
	<a href="modify_ok">회원정보 수정</a>
	<a href="delete_ok">회원 탈퇴</a>
	
</body>
</html>