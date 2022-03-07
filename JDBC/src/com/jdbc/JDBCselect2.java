package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCselect2 {

	public static void main(String[] args) {
		
		//1.DB연결을 위한 변수 (url, uid, ups)
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String uid = "myjsp";
		String ups = "myjsp";
		
		//연동을 위한 DB클래스 변수를 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		//SQL구문 설정
		String sql = "select * from member";
		
		try {
			//1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. 커넥션 생성
			conn = DriverManager.getConnection(url, uid, ups);
			//3. Statement 객체 생성
			stmt = conn.createStatement();
			//4. SQL구문 실행
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String email = rs.getString("email");
				System.out.println("-----------------------------------");
				System.out.println("DB로 부터 받은 ID값 : " + id);
				System.out.println("DB로 부터 받은 PW값 : " + pw);
				System.out.println("DB로 부터 받은 NAME값 : " + name);
				System.out.println("DB로 부터 받은 EMAIL값 : " + email);
			}
			
		} catch (ClassNotFoundException cnfe) {
			System.out.println("DB드라이버 로딩 실패" + cnfe.toString());
		} catch (SQLException sqle) {
			System.out.println("DB접속 실패 " + sqle.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
			if(conn != null) conn.close();
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
			} catch (Exception e) {
				}
			}
	}

}
