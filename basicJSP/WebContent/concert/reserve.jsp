<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	//예약현황이 있다면, 예약 좌석을 꺼내서 처리
    	List<String> list = new ArrayList<>();
    	
    	if(application.getAttribute("seats") != null){ 	//얻어온 app가 null이아니라면
    		list = (List<String>)application.getAttribute("seats");	//list에 추가
    		
    	}
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body>
<div align="center">
	<h2>콘서트 예약 페이지</h2>
	<br>
	<h3>예약할 좌석을 선택하세요</h3>
	<hr>
	<form action="reserve_ok.jsp" method="post">
	<b>좌석 배치도</b><br>&nbsp;&nbsp;
	<% for(char c = 'A'; c <= 'Z'; c++){%> <!-- A부터 Z까지 -->
		<small><%= c %></small>&nbsp;&nbsp; <!-- &nbsp; = 스페이스바와 같은 원리 -->
	<% }%><br>
	<% for(int i = 1 ; i<=6 ; i++){%>
			<%=i %>
		<% for(char c = 'A'; c <= 'Z'; c++){%>
			<%if (list.contains(c+"-"+i)){%>
				<input type="checkbox" name="seat" value="<%= c %>-<%=i%>" disabled>
			<%}else {%>
				<input type="checkbox" name="seat" value="<%= c %>-<%=i%>">
			<%}%>
			<%}%>
			<br>
			<% if(i==3) {%>
			<br>
			<% }%>
			<%}%>
		<br>
		<input type="submit" value="예약">
		<input type="reset" value="취소">
	</form>
	<%-- <form action="#">
	<table>
	<tr>
	<td></td>

	<% for(int j = 65;j<=90;j++){
		out.print("<td>" + (char)j + "</td>");
	}
	%>
	
	</tr>

	<%
	for(int i = 1 ; i <=6 ; i++){
		out.println("<tr><td>" + i + "</td>");
		for(int k = 1; k<=26 ; k++){
			out.println("<td><input type='checkbox' name='ticket'></td>");
		}
	}
	out.println("</tr>");
	%>

	</table>
	</form> --%>
	</div>
</body>
</html>