<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.bean.User2" %>
<%--
	1. 전달받은 값을 처리
	2. pw와 pw_check값이 같으면 User객체에 quiz01로부터 받은 값을 저장하여
	   quiz03.jsp로 전달
	   화면 출력 내용 : "id(name)님의 회원 가입을 축하합니다. 비밀번호가 *****입니다."
	3. pw와 pw_check값이 틀린 경우, quiz04.jsp로 넘어가서 "회원가입에 실패했습니다." 출력
 --%>    
    <% 
    	request.setCharacterEncoding("utf-8");
    	String id = request.getParameter("id");
    	String pw = request.getParameter("pw");
    	String pwcheck = request.getParameter("pwcheck");
    	String name = request.getParameter("name");
    	
   		/*
   		java코드로 작성
    	if(pw.equals(pwcheck)){
    		User2 user = new User2();
    		user.setId(id);
    		user.setPw(pw);
    		user.setName(name);
    		
    		request.setAttribute("user", user);
    		
    		request.getRequestDispatcher("quiz03.jsp").forward(request, response);
    	}else {
    		response.sendRedirect("quiz04.jsp");
    	}
   		*/
   		
   		/*
   		액션태그로 작성
   		*/
   		
   		if(pw.equals(pwcheck)){ %>
   			<jsp:useBean id="user" class="com.bean.User2" scope="request" />
   			<jsp:setProperty property="id" name="user" value="<%=id %>" />
   			<jsp:setProperty property="name" name="user" value="<%= name %>" />
   			<jsp:setProperty property="pw" name="user" value="<%= pw %>" />
   			<jsp:forward page="quiz03.jsp" />
   		<% } else {%>
   			<jsp:forward page="quiz04.jsp" />
   		<%} %>
   
   