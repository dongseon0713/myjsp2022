<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%	/*
    		1. 앞에서 전달 받은 폼값을 받아서 평균을 구한다.
    		2. 평균의 값이 60점 이상이면 score_quiz03.jsp로 이동
    		3. 평균의 값이 60점 미만이면 score_quiz04.jsp로 이동
    
    	*/
    	request.setCharacterEncoding("utf-8");
    	String name = request.getParameter("name");
    	int kor = Integer.parseInt(request.getParameter("kor"));
    	int math = Integer.parseInt(request.getParameter("math"));
    	int eng = Integer.parseInt(request.getParameter("eng"));
    	
    	double avg = (double)(kor+math+eng)/3;
    	
    	avg = avg*100/100;
    	
    %>
    	
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if (avg >= 60){%>
<jsp:forward page="score_quiz03.jsp" >
	<jsp:param value="<%= name %>" name="name"/>
	<jsp:param value="<%= avg %>" name="avg"/>
</jsp:forward>
<%}else{ %>
<jsp:forward page="score_quiz04.jsp" >
	<jsp:param value="<%= name %>" name="name"/>
	<jsp:param value="<%= avg %>" name="avg"/>
</jsp:forward>      	
<%} %>
</body>
</html>