<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="true">
		무조건 실행 되는 문장
	</c:if>
	
	<hr>
	
	<c:if test="${param.name eq '홍길동'}">
		홍길동 입니다.	<br>
	</c:if>
	
	<c:if test="${param.name == '이순신' }">
		이순신 입니다.  <br>
	</c:if>
	
	<%--
	age값이 20이상 이면 성인입니다. 
	20 미만이면 미성년 입니다.
	를 출력하는 코드 작성
	--%>
	<c:if test="${param.age >= 20 }">
		성인 입니다. <br>
	</c:if>
	<c:if test="${param.age < 20 }">
		미성년 입니다. <br>
	</c:if>
</body>
</html>