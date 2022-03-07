<%@page import="com.myweb.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%	
	request.setCharacterEncoding("utf-8");
	String id = (String)session.getAttribute("user_id");
	String old_pw = request.getParameter("old_pw");
	String new_pw = request.getParameter("new_pw");
	
	if (session.getAttribute("user_id") == null) {
		response.sendRedirect("user_login.jsp");
	}
	UserDAO dao = UserDAO.getInstance();
	
	int result = dao.login(id, old_pw);
	
	if (result == 1){
		int result2 = dao.changePassword(id,new_pw);
		if(result2 == 1){%>
			<script>
				alert("비밀번호변경이 완료되었습니다.");
				location.href="user_mypage.jsp"
			</script>
		<%} else{ %>
			<script>
				alert("비밀번호 변경에 실패했습니다.");
				location.href="user_mypage.jsp"
			</script>
		<%}
	} else{%>
		<script>
			alert("비밀번호 변경에 실패했습니다.");
			history.go(-1);
		</script>
		<%
	}
%>