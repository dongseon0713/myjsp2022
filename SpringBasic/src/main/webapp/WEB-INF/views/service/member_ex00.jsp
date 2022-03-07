<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 가입(화면 URL요청 : 컨패스/service/member_tx01)</h2>
	
	<!-- 
	1. join의 맵핑을 처리할 수 있는 메서드를 생성하세요. (controller)
	2. command패키지에 parameter값을 처리할 수 있는 커멘드객체 JoinVO를 생성해서 값을 받아 처리한다.
	    (맴버는 id, pw , name 최소로...)
	3. Service패키지 JoinService인터페이스와 , JoinService를 구현하는 JoinServiceImpl 클래스를 생성
	4. JoinServiceImpl을 어노테이션을 이용하여 자동 객체 생성 시키세요. @Service(이름)
	5. 컨트롤러의 맴버 변수로 해당 객체를 자동의존성 주입 시키세요. @Autowired
	 -->
	
	<form action="join" method="post">
		ID : <input type="text" name="id" size="10"><br>
		PW : <input type="password" name="pw" size="10"><br>
		NAME : <input type="text" name="name" size="10"><br>
		<input type="submit" value="회원가입">
	</form>
	
</body>
</html>