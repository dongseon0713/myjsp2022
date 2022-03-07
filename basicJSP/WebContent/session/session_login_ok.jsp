<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	/*
    	 1. 아이디와 비밀번호, 닉네임을 받기
    	 2. 조건 : 아이디와 비밀번호가 서로 동일하면 로그인
    	  	로그인 시에 user_id로 id값을 세션에 저장
    	  	user_name이름으로 nick을 세션에 저장
    	  	session_welcome.jsp 페이지로 이동하여 
    	  	"id님(이름) 님 환영합니다."
    	 3. 로그인 실패시에는 다시 로그인 페이지로 리다이렉트 처리.
    	*/
    	request.setCharacterEncoding("UTF-8");
    	String id = request.getParameter("id");
    	String pw = request.getParameter("pw");
    	String name = request.getParameter("nick");
    	
    	if(id.equals(pw)){
    		session.setAttribute("user_id", id);
    		session.setAttribute("user_name", name);
    		response.sendRedirect("session_welcome.jsp");
    	}else {
    		//response.sendRedirect("session_login.jsp");
    		
    		//자바스크립트를 써보자!!
    		/*
    		 자바스크립트의 변수 선언
    		 var = 변수(variable)
    		 
    		 var a = 1;	//int형 변수
    		 var b = "1";//문자형 변수
    		 let c = 1;		//es6 방식
    		 const d = "1";
    		 
    		 자바스크립트의 함수(fuction 키워드 사용)
    		 function 이름(매개변수) {
    			 
    		 }
    		 
    		함수(es6방식)
    		이름 = () => {
    			
    		}
    		
    		제어 : for, if, switch, while, try ...
    		
    		자바스크립트에서 자주사용되는 내장객체
    		alert(); : 경고창
    		confirm(); : 확인창
    		history.go(-1); : 뒤로가기
    		location.href = "경로"; //웹 페이지를 "경로" 정보로 redirect
    	
    		*/
    		%>
    		<script>
    			check(); //함수 호출. 선언되면 앞뒤 어디서든 사용가능함.
    			
    			function check(){
    				alert("로그인에 실패했습니다."); //경고창
    				history.go(-1); //뒤로가기(history객체는 접속 페이지를 저장하는 객체)
    			}
    		
    		</script>
    		<%
    	}
    %>
