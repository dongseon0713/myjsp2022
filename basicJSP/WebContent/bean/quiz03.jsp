<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 자바코드로 작성 
<%@ page import="com.bean.User2" %>
<%
	User2 user = (User2)request.getAttribute("user");
%>

	<%= user.getId() %>(<%= user.getName() %>)님 회원가입을 축하합니다. <br>
	비밀번호는 <%= user.getPw() %> 입니다.  --%>
	
	<%-- 액션태그로 작성 --%>
	<jsp:useBean id="user" class="com.bean.User2" scope="request" />
	<jsp:getProperty property="id" name="user"/>(<jsp:getProperty property="name" name="user"/>)님
	회원가입을 축하합니다.<br>
	비밀번호는 <jsp:getProperty property="pw" name="user"/> 입니다.<br>
	<a href="quiz01.jsp">돌아가기</a>
	
</body>
</html>