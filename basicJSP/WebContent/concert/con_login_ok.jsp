<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String id = request.getParameter("id");	//id 값 받아오기
    	String ps = request.getParameter("pw");	//pw 값 받아오기
    	
    	String auth = (String)session.getAttribute("auth");	//보안문자를 세션에서 설정된값 받아오기
    	String code = request.getParameter("code");
    	
    	if(id.equals(ps) && !auth.equals(code)) {	//아이디와 비번이 같지만 보안문자가 다른경우
    		response.sendRedirect("con_login.jsp");	//로그인 페이지로 이동
    	} else if(id.equals(ps) && auth.equals(code)){	//아이디와 비번 보안문자까지 같은경우
    		response.sendRedirect("reserve.jsp");	//예약 페이지로 이동
    	}
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>