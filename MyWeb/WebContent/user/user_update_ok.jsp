<%@page import="com.myweb.user.model.UserVO"%>
<%@page import="com.myweb.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    

<!-- URL주소를 통해서 강제 접근 막기 -->
	
	<c:choose>
		<c:when test="${sessionScope.user_id eq null }">
			<c:redirect url="user_login.jsp" />
		</c:when>
	</c:choose>
<%
	/*
	1. 폼 값을 받기
	2. DAO연동을 통해서 update() 메서드를 호출해서 회원 정보를 수정
	3. 매개값을 VO로 전달.
	4. 수정 성공시 "회원 정보가 수정되었습니다." 출력 후 마이페이지로 이동
	    수정 실패시 "회원정보 수정에 실패했습니다." 출력 후 마이페이지로 이동
	*/
	request.setCharacterEncoding("utf-8");
	String id = (String)session.getAttribute("user_id");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String address = request.getParameter("address");
	
	UserDAO dao = UserDAO.getInstance();
	
	UserVO vo = new UserVO(id, null, name, email, address,null);
	
	int result = dao.update(vo);
	
	if(result == 1){ 
		//이름을 변경한 경우 세션에 저장된 이름을 변경
		session.setAttribute("user_name", name);
%>
		<script>
			alert("회원 정보가 수정되었습니다.");
			location.href="user_mypage.jsp";
		</script>
		<%
	}else {%>
		<script>
			alert("회원정보 수정에 실패했습니다.");
			location.href="user_mypage.jsp";
		</script>
	<%}
%>	