
<%@page import="java.util.Arrays"%>
<%@page import="java.util.UUID"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
//네트워크 상에서 고유성이 보장되는 id를 만들기 위한 표준 규약
UUID uuid = UUID.randomUUID();

//uuid를 문자열로 변환 후 uid로 대입
String uid = uuid.toString();

//하나의 배열로 만들기
String[] arr = uid.split("-");
//System.out.println(Arrays.toString(arr)); 배열을 주소가 아닌 값으로 표현할때는 Arrays이용

session.setAttribute("auth", arr[1]);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.wrap{
		width:257px;
		margin: 0 auto;
		text-align:center;
	}
	.btn{
		width:60px;
		height:50px;
		background-color:#ddd;
	}
</style>
</head>
<body>
	<div class="wrap">
		<h2>콘서트 좌석 예약하기</h2>
		<hr>
		<form action="con_login_ok.jsp" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id" size="10"></td>
					<td rowspan="2"><input type="submit" value="로그인" class="btn">
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pw" size="10"></td>
				</tr>
				<tr>
				<td>인증문자</td>
				<td colspan="2"><del><%= arr[1] %></del></td>
				</tr>
				<tr>
				<td>인증문자 확인</td>
				<td colspan="2"><input type="text" name="code" size="10"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>