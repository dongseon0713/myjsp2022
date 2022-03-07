package com.zerock.JDBCTest;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class jdbcTest {

	String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	String uid = "myjsp";
	String upw = "myjsp";
	
	//src/test/java 폴더에는 자바 클래스를 이용하여 여러 작업을 test할 용도로 사용됨..
	//실행은 Run as -> JUnitTest를 사용하여 실행
	//@Test 어노테이션을 사용하여 테스트할 메서드를 지정
	@Test
	public void JdbcTests() {
		try {
			//JDBC드라이버를 호출
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection(url, uid, upw);
			System.out.println(">>>>>>>>> connection 객체 생성 : "+conn);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
