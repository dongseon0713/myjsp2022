package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCdelete {
	public static void main(String[] args) {
		
		//DB연결을 하기 위한 변수 url , uid , upw
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String uid = "myjsp";
		String ups = "myjsp";
		
		//DB연동을 위한 객체
		Connection conn = null;
		Statement stmt = null;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 id 입력 : " );
		String id = scan.next();
		
		String sql = "DELETE FROM member where id='"+id+"'";
		
		try {
			//1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. 커넥션 생성
			conn = DriverManager.getConnection(url, uid, ups);
			//3. Statement 객체 생성
			stmt = conn.createStatement();
			//4. SQL구문 실행
			int result = stmt.executeUpdate(sql);
			
			if(result == 1) {
				System.out.println(id + "가 삭제 되었습니다.");
			}else {
				System.out.println("삭제 실패");
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
			} catch (Exception e) {
				}
			}
	}
}
