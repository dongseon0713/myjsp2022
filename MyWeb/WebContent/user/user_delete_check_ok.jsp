<%@page import="com.myweb.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<%
	/*
	1. user_delete_check.jsp로 받은 폼데이터 값을 처리
	2. login(id,pw) 메서드를 재사용하여, 비밀번호를 확인
	3. login메서드가 0을 반환하면, "비밀번호를 확인하세요" 라고 출력
	   login메서드가 1을 반환하면, delete()를 실행 
	4. 삭제 성공시 "회원 탈퇴처리가 되었습니다." 출력 후에 세션을 전부 삭제 후 /MyWeb으로 이동
	      삭제 실패시 "회원 탈퇴에 실패 했습니다." 출력 후에 마이페이지로 이동
	      sql = delete from users where id = ?
	*/
%>
	<c:choose>
		<c:when test="${sessionScope.user_id eq null}">
			<c:redirect url="user_login.jsp" />
		</c:when>
	</c:choose>
<%
	String pw = request.getParameter("pw");
	String id = (String)session.getAttribute("user_id");
	
	UserDAO dao = UserDAO.getInstance();
	
	int result = dao.login(id, pw);
	
	if(result == 1){
		int result2 = dao.delete(id);
		if(result2 == 1){
			session.invalidate();
			%>
			<script>
				alert("회원탈퇴 처리가 되었습니다.");
				location.href="/MyWeb";
			</script>
			<%
		}else{%>
			<script>
				alert("회원탈퇴에 실패했습니다.");
				location.href="user_mypage.jsp";
			</script>
			<%
		}
	}else{%>
		<script>
			alert("비밀번호를 확인하세요");
			history.go(-1);
		</script>
		<%
	}
%>
