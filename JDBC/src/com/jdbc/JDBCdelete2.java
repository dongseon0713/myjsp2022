package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCdelete2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String uid = "myjsp";
		String ups = "myjsp";
		
		Connection conn = null;
		Statement stmt = null;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 ID 입력 : ");
		String id = scan.next();
		
		String sql = "DELETE FROM member WHERE id='"+id+"'";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		conn = DriverManager.getConnection(url, uid, ups);
		
		stmt = conn.createStatement();
		
		int result = stmt.executeUpdate(sql);
		
		if (result == 1) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
		
		conn.close();
		stmt.close();
		
	}
}
