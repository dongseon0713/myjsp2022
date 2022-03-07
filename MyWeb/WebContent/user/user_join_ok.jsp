<%@ page import="com.myweb.user.model.UserVO"%>
<%@ page import="com.myweb.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	/* 진행 흐름 : 
		1. 전달받은 값을 처리
		2. 회원가입 여부를 확인
		3. 가입된 경우 실패(뒤로가기) | 가입이 안된 경우 -> 가입 진행(join())
		4. 회원 가입 축하 및 로그인 페이지로 이동 | 실패시 재가입 페이지로 이동
	*/
	//전달받은 값 처리
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String address = request.getParameter("address");
	
	//DAO 객체 생성
	UserDAO dao = UserDAO.getInstance();
	
	//VO 객체 생성
	UserVO vo = new UserVO(id,pw,name,email,address,null);
	
	int result = dao.IdConfirm(id);
	
	if(result == 1){ //아이디 중복
%>
		<script>
			alert("아이디가 중복입니다.");
			history.go(-1);	//뒤로가기
		</script>
<%	} else {	//중복이 없는 경우
		int result2 = dao.join(vo);
		if(result2 == 1){	
%>
			<script>
				alert("회원가입을 축하합니다.");
				location.href="user_login.jsp";
			</script>
<%
		}else{
%>
			<script>
				alert("회원가입에 실패했습니다.");
				history.go(-1); //뒤로 가기
			</script>
<% 
		}
	}
%>
