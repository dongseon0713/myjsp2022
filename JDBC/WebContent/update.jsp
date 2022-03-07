<%@page import="com.ok.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//아이디는 세션을 통해서 얻고, 회원 정보는 request 객체를 통해서 얻음.
	String id = (String)session.getAttribute("user_id");
	
	/* 
	String pw = (String)request.getAttribute("user_pw");
	String name = (String)request.getAttribute("user_name");
	String phone1 = (String)request.getAttribute("user_phone1");
	String phone2 = (String)request.getAttribute("user_phone2");
	String email = (String)request.getAttribute("user_email");
	String gender = (String)request.getAttribute("user_gender");
	*/
	
	//VO를 이용한 값 받기
	MemberVO vo = (MemberVO)request.getAttribute("vo");
	
	String pw = vo.getPw();
	String name = vo.getName();
	String phone1 = vo.getPhone1();
	String phone2 = vo.getPhone2();
	String email = vo.getEmail();
	String gender = vo.getGender();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
</head>
<body>

	<!-- 
		input 태그의 읽기만 허용하는 속성 "readonly"
		select 태그의 옵션 중 미리 선택(default)값은 "selected"
		radio 버튼이나, checkbox 미리 선택하는 기능은 "checked"
		radio 버튼이나, checkbox 선택할 수 없게 하는 기능은 "disabled"
	
	 -->
	<h2>회원정보 수정 페이지</h2>
	<form action="update_ok" method="post">
		ID : <input type="text" name="id" size="10" value="<%= id %>" readonly> <br>
		PW : <input type="password" name="pw" size="10" value="<%= pw %>" > <br>
		이름 : <input type="text" name="name" size="10" value="<%= name %>"> <br>
		전화번호 : 
		<select name="phone1">
			<option <%= phone1.equals("010") ? "selected" : "" %>>010</option>
			<option <%= phone1.equals("011") ? "selected" : "" %>>011</option>
			<option <%= phone1.equals("019") ? "selected" : "" %>>019</option>
		</select>
		-<input type="text" name="phone2" placeholder="-빼고입력하세요." value="<%= phone2 %>"><br>
		<br>
		이메일 : <input type="email" name="email" size="30" value="<%= email %>"> <br>
		성별 : 
		<% if(gender == null || gender.equals("m")) {%>
		<input type="radio" name="gender" value="m" checked> 남자
		<input type="radio" name="gender" value="f"> 여자
		<%}else { %>
		<input type="radio" name="gender" value="m"> 남자
		<input type="radio" name="gender" value="f" checked> 여자
		<%} %>
		<br>
		<input type="submit" value="수정">
		<button type="button" onclick="location.href='cancel.jsp' ">취소</button>
	</form>

</body>
</html>