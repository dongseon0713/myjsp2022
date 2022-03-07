<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h2>로그인 연습</h2>
	<form action="Login_ok" method="post">
	ID : <input type="text" name="id"><br>
	PW : <input type="password" name="pw"><br>
	<br>
	<input type="submit" value="로그인">
	<button type="button" onclick="location.href='join.jsp' ">회원가입</button>
	</form>
</body>
</html>