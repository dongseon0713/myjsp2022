<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/_header.jsp" %>

	<!-- 
	1. MyWeb사이트와 연동되어야 한다.....
	2. 로그인시 필요한 아이디와 비밀번호를 입력 받게 설정
	3. 로그인(submit) 버튼과, 회원가입 버튼을 생성
	-->
	<section>
		<div align="center">
			<form name="regform" action="user_login_ok.jsp" method="post">
				<h2>로그인 페이지</h2>
					<hr>
					 <table>
					 	<tr>
					 		<td>아이디</td>
					 		<td><input type="text" name="id" placeholder="아이디"></td>
					 	</tr>
					 	<tr>
					 		<td>비밀번호</td>
					 		<td><input type="password" name="pw" placeholder="비밀번호"></td>
					 	</tr>
					 </table>
					 <input type="submit" value="로그인" class="btn btn-default">
					 <input type="button" onclick="location.href='join.jsp'" value="회원가입" class="btn btn-primary">
			</form>
		</div>
	</section>

<%@ include file="../include/_footer.jsp" %>