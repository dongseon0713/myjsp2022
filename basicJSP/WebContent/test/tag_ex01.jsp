<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%!
	//선언자와 스크립트릿의 차이 => 맴버변수는 전역변수의 성질을 가지면서 전체 어플에 영향을 준다.
	int total = 0;
	
	public int randomNum() {
		Random ran = new Random();
		int num = ran.nextInt(10);
		
		return num;
	}
%>
<%
/* 
	hint : 선언자, 스크립틀, 표현식, 지시자를 사용하는 예제
	1. 페이지를 접속할 때 마다 랜덤으로 생성된 값을 출력(메소드를 사용) : 
	출력 양식 => 오늘의 숫자 : 랜덤 숫자를 출력
	2. 페이지 누적요청 숫자를 계산하여 출력
	출력 양식 => 페이지 누적요청 : 누적요청 숫자(int)
	3. 요청한 페이지 개별요청 숫자를 표시
	출력 양식 => 페이지 개별 요청 : 개별요청 수(int)
*/
	// 페이지가 실행될 때 마다 발생하는 코드를 작성
	
	int each = 0;	// 지역변수 프로그램을 실행하면 0으로 다시 초기화 되기때문에 ++를 해도 1이된다.
	
	total++;	//전역 변수는 개별로 사용되기 때문에 ++하게 되면 값이 누적되어 저장된다.
	
	each++;
	
	int rn = randomNum(); // 0 ~ 9 사이에 있는 랜덤값 출력
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p>
		오늘의 숫자 : <%= rn %>
		<br>
		페이지 누적요청 : <%= total %>
		<br>
		페이지 개별요청 : <%= each %>
	</p>
	
</body>
</html>