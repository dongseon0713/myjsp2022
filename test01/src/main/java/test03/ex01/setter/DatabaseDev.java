package test03.ex01.setter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseDev {
	
	private String url;
	private String uid;
	private String upw;
	private String dirver="oracle.jdbc.driver.OracleDriver";
	private Connection conn;
	private Statement stmt;
	
	public DatabaseDev() {

	}
	
	
	public DatabaseDev(String url, String uid, String upw) {
		try {
			Class.forName(this.dirver);
			this.conn = DriverManager.getConnection(url, uid, upw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void test() {
		try {
			this.conn = DriverManager.getConnection(url, uid, upw);
			System.out.println("연결성공");
		} catch (Exception e) {
			System.out.println("연결실패");
			e.printStackTrace();
		}
		System.out.println(this.url);
		System.out.println(this.uid);
		System.out.println(this.upw);
	}
	
	public ResultSet testQuery(String sql) {
		ResultSet rs = null;
		
		try {
			this.conn = DriverManager.getConnection(url, uid, upw);
			this.stmt = this.conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				System.out.println("쿼리 성공");
			}else {
				System.out.println("쿼리 실패");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public String getUrl() {
		return url;
	}
	public String getUid() {
		return uid;
	}
	public String getUpw() {
		return upw;
	}
	
}
