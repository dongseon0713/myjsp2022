<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String driver_oracle = "oracle.jdbc.driver.OracleDriver";  //DB드라이버
		String url_oracle = "jdbc:oracle:thin:@localhost:1521/XEPDB1"; //DB connection 작업 중 url값
		
		/*
		 =driver=
		 MySQL(6버전 이후) : com.mysql.cj.jdbc.Driver
		 MySQL(6버전 이전) : com.mysql.jdbc.Driver
		 Mariadb : org.mariadb.jdbc.Driver
		 
		 =URL설정=
		  오라클 : jdbc:oracle:thin:@[서버주소(IP 또는 도메인)]:[서비스포트(1521)]/[세션]
	     MySQL(6버전 이후) : jdbc:mysql://[서버주소(IP 또는 도메인)]:[서비스포트(3306)]/[DB이름]?severTimezone=UTC
	   	 MySQL(6버전 이전) : jdbc:mysql://[서버주소(IP 또는 도메인)]:[서비스포트(3306)]/[DB이름]
	   	 서울의 UTC : Asia/Seoul
	   	 Mariadb : jdbc:mysql://[서버주소(IP 또는 도메인)]:[서비스포드(3306)]/[DB이름]
		*/
		
		String user = "hr";
		String password = "hr";
		
		Connection conn = null;
		
		boolean connect = false;
	
		try {
			// 1. Driver 로딩
			Class.forName(driver_oracle);
			
			// 2. DB연결(Connection)
			conn = DriverManager.getConnection(url_oracle, user, password);
			connect = true;
		} catch (ClassNotFoundException cnfe) {
			// Driver 로딩 실패
			connect = false;
			%>
			DB드라이버 로딩 실패  : <%= cnfe.toString() %>
			<%
		} catch (SQLException sqle) {
			// DB연결 실패
			connect = false;
			%>
			DB접속 실패 : <%= sqle.toString() %>
			<%
		} catch (Exception e) {
			// Unkown Error
			connect = false;
			%>
			알 수 없는 에러 : 
			<% e.printStackTrace();
		}
		
		if (connect) {
			%>
			<h2>연결 성공</h2>
			<%
			conn.close();
		} else {
			%>
			<h2>연결 실패</h2> 
			<%
			conn.close();
			}
	%>
</body>
</html>