<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>이름과 점수를 입력하세요!!</h2>
	<hr>
	<form action="score_quiz02.jsp" method="post">
		이름 : <input type="text" name="name"> <br>
		국어 : <input type="text" name="kor">	<br>
		영어 : <input type="text" name="math"> <br>
		수학 : <input type="text" name="eng"> <br>
		<input type="submit" value="확인">
	</form>
</body>
</html>