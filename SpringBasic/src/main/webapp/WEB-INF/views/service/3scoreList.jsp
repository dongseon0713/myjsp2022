<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	<!-- service에서 점수 저장 결과 메서드를 만든 후 사용 -->
	<!-- 현재 for문에 index를 알 수 있는 상태 변수 num을 이용 -->
	<div align="center">
		<h2>점수 등록 결과</h2>
		<table border="1" >
			<tr>
				<td>번호</td>
				<td>이름</td>
				<td>국어</td>
				<td>영어</td>
				<td>수학</td>
				<td>비고</td>
			</tr>
			<c:forEach var="good" items="${scoreList }" varStatus="num">
				<tr>
					<td width="50">${num.index +1 }</td>
					<td width="100">${good.name }</td>
					<td width="100">${good.kor }</td>
					<td width="100">${good.eng }</td>
					<td width="100">${good.math }</td>
					<td><input type="button" value="삭제" onclick="location.href='scoreDelete?num=${good.num}'"></td>
				</tr>
			</c:forEach>
		</table>
	<a href="1scoreRegister">점수 등록하러 가기</a>
	</div>
</body>
</html>