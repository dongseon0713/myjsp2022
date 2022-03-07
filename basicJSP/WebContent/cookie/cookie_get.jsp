<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	//쿠키 사용하기
    	//쿠키는 요청시 자동으로 전송되고 request에 자동으로 저장됨.
    	Cookie[] arr = request.getCookies();
    	//쿠키 타입은 배열임으로 변수선언 할 때 배열로 선언해야한다.
    	
    	if(arr != null){	//쿠키가 null이 아닌경우(존재할 경우) null이면 쿠키값이 존재x
    		for(int i = 0 ; i< arr.length;i++){
    			out.println(arr[i].getName() + "<br>"); //쿠키 이름을 얻기
    			out.println(arr[i].getValue() + "<br>");//쿠키 값을 얻기
    			out.println("<br>");
    		}
    	}
    	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>