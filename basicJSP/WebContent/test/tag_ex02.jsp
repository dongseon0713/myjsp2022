<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%--
	페이지 누적 요청 및 랜덤값을 출력, 매 10번째 방문자에게는 기프트콘을 드립니다.
	10번째 마다 "당첨되었습니다."가 출력되게 해보세요.
	scriptlet은 <body>태그에서 작성하세요!!!
 --%>
 <%!
 	int total = 0;
 	
 	public int randomNum(){
 	Random ran = new Random();
 	
 	int num = ran.nextInt(8)+2;
 	return num;
 	}
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	total++; 
	int ran = randomNum();
%>
<p>
페이지 누적요청 : <%= total %> <br>
매 10번째 방문자에게는 기프티콘을 드립니다.<br>

<% if(total%10 == 0){
	%>
	당첨되었습니다.
	<%
}
%>
</p>
랜덤 값 출력 : <%= ran %><br>
<h2>랜덤 구구단 <%= ran %>단 입니다.</h2>
<%
	for(int i = 1; i<=9 ; i++){
		int re = ran*i;
		%>
			<%= ran %> x <%= i %> = <%= re %> <br>
		<%
	}
%>
</body>
</html>