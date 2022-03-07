package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCquiz01 {

	public static void main(String[] args) {
		/*
		 * JDBC 만들기...
		 * id를 입력 받아 해당 ID에 속한 정보만 출력하는 예제
		 * */
		
		Scanner scan = new Scanner(System.in);
		System.out.print("ID를 입력하세요 : ");
		String id = scan.next();
		
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String uid = "myjsp";
		String ups = "myjsp";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "select * from member where id='"+id+"'";
		
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, uid, ups);
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				String id1 = rs.getString("id");
				String pw1 = rs.getString("pw");
				String name1 = rs.getString("name");
				String email1 = rs.getString("email");
				System.out.println("-----------검색한 ID : "+id+"님 정보---------");
				System.out.println("ID : " + id1);
				System.out.println("PW : " + pw1);
				System.out.println("NAME : " + name1);
				System.out.println("EMAIL : " + email1);
			}else {
				System.out.println(id+"값 이 없습니다.");
			}
		} catch (ClassNotFoundException cnfe) {
			System.out.println("DB드라이버 로딩 실패" + cnfe.toString());
		} catch (SQLException sqle) {
			System.out.println("DB접속 실패 " + sqle.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
			if (conn != null) conn.close();
			if (stmt != null) stmt.close();
			if (rs != null) rs.close();
			} catch (Exception e) {
				
			}
		}
		
	}

}
