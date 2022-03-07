package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCtest {
	
	public static void main(String[] args) {
		
		//Oracle 설정 
		String driver_oracle = "oracle.jdbc.driver.OracleDriver";
		String url_oracle = "jdbc:oracle:thin:@localhost:1521/XEPDB1"; 
		//오라클 18c는 /XEPDB1이 붙는다. , 11버전은 /XE
		
		//MariaDB 설정
		String dirver_MariaDB = "org.mariadb.jdbc.Driver";
		String url_mariadb = "jdbc:mysql://localhost:3306/testdb";
		
		//DB접속 계정 정보
		String user = "myjsp";
		String password = "myjsp";
		
		//Mariadb사용
		String m_user = "root";
		String m_password = "0000";
		
		//연결을 위한 객체 생성
		Connection conn = null;
		
		//connection값을 판별하는 boolean값
		boolean connect = false;
		
		try { 
			//1. Driver 로딩
			Class.forName(dirver_MariaDB);
			
			//2. DB연결
			conn = DriverManager.getConnection(url_mariadb, m_user, m_password);
			connect = true;
		} catch (ClassNotFoundException cnfe) {
			//드라이버 로딩 실패시 예외
			connect = false;
			System.out.println("DB드라이버 로딩 실패 : " + cnfe.toString());
		} catch (SQLException sqle) {
			//Connection 실패시 에러(SQLException)
			connect = false;
			System.out.println("DB접속 실패 : " + sqle.toString());
		} catch (Exception e) {
			//Unknown 에러 
			connect = false;
			System.out.println("알 수 없는 에러 발생 ");
			e.printStackTrace();
		}
		
		if (connect) {
			System.out.println("연결 성공");
		} else {
			System.out.println("연결 실패");
		}
		
		
		
	}
}
