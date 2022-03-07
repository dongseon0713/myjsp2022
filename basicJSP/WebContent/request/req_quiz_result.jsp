<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("UTF-8");
    	String name = request.getParameter("name");
    	double cm = Double.parseDouble(request.getParameter("cm"));
	    double kg = Double.parseDouble(request.getParameter("kg"));
 		double BMI = kg/(cm/100 * cm/100);
 		
 		BMI = (int)(BMI * 100) / 100.0; // 연산을 통해서 자리수를 잘라내는 방식
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BMI 측정 프로그램 결과</title>
</head>
<body>
	이름 : <%= name %> <br>
	키 : <%= cm %> <br>
	몸무게 : <%= kg %> <br>
	BIM지수 : <%= BMI %><br>
	<% if(BMI>=25){
		%>
		당신은 과체중 입니다.
		<%
	}else if(BMI<=18){
		%>
		당신은 저체중 입니다.
		<% 
	}else {
	%>
		당신은 정상입니다.
	<%
	} 
	%>
</body>
</html>