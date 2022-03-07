package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBCPinsert {

	public static void main(String[] args) {
		// 입력값 받는 처리(member)
		Scanner scan = new Scanner(System.in);
		System.out.print("id : ");
		String id = scan.next();
		System.out.print("pw : ");
		String pw = scan.next();
		System.out.print("name : ");
		String name = scan.next();
		System.out.print("email : ");
		String email = scan.next();
		
		//연결에 필요한 변수
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String user = "myjsp";
		String password = "myjsp";
		
		//객체 생성
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into member values(?,?,?,?)";
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(url, user, password);
			
			pstmt = conn.prepareStatement(sql);
			
			//pstmt 객체에 값을 설정 시  setString, setInt, setDouble...
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			
			//pstmt 실행(성공시 1, 실패시 0을 반환)
			int result = pstmt.executeUpdate(); 
			//주의 SQL구문을 인자로 전달하지 않아요.... 이미 prepareStatement에서 추가함.
			
			if (result == 1) {
				System.out.println("입력 성공");
			}else { 
				System.out.println("입력 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				scan.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		
	}

}
