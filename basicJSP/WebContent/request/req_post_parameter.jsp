<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("UTF-8");
    	String id = request.getParameter("id");
    	String pw = request.getParameter("pw");
    	String name = request.getParameter("name");
    	String addr = request.getParameter("address");
    	//Checkbox는 getParameterValues메서드를 사용하여 처리함.
    	String[] arr = request.getParameterValues("intro"); //arr는 주소값
    	String major = request.getParameter("major");
    	String phone = request.getParameter("phone");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>req_get_parameter</title>
</head>
<body>
	아이디 : <%= id %><br>
	비밀번호 : <%= pw %><br>
	이름 : <%= name %><br>
	주소 : <%= addr %><br>
	관심분야 : <%= Arrays.toString(arr) %> <!-- arr에 해당하는 내용을 불러옴[배열의 처리] -->
		<br>
	전공 : <%= major %><br>
	통신사 : <%= phone %><br>
</body>
</html>