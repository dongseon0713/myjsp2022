package com.ok;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class MemberDAO {
	
	private DataSource ds; //데이터 소스 객체 생성
	private Context ct ; //javax.naming.*
	/*
	 * DAO는 단수 DB연동을 담당하는 클래스
	 * 여러 생성하지 않도록 일반 클래스로 만들면, 메모리 과부하가 올 수 있다.
	 * 싱글톤 패턴을 적용하여 객체를 1개로 제한.
	 */
	
	//1. 스스로의 객체를 맴버변수로 선언하고 1개로 제한.
	private static MemberDAO instance = new MemberDAO();
	
	//2. 외부에서 객체를 생성할 수 없도록 생성자에 private 처리.
	private MemberDAO() {
		//생성자가 한번 동작할 때에 다음 내용을 처리...
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			ct = new InitialContext(); //이니셜 컨텍스트 객체 생성
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/oracle"); //이니셜 컨텍스트로 부터 찾음.
		} catch (Exception e) {
			//System.out.println("드라이버 호출시 에러 발생");
			e.printStackTrace();
		}
	}
	
	//3. 외부에서 객체를 요구할 때 getter메서드만 써서 반환
	public static MemberDAO getInstance() {
		return instance;
	}
	
	// DB연동을 위해서 필요한 변수와 객체를 선언
	// 커넥션 풀을 이용했기 때문에 url이나 user,password를 쓸 필요가 없다.
	//private String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	//private String user = "myjsp";
	//private String password = "myjsp";
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// --------------------- 기능을 메서드로 선언 ---------------------
	// 회원 가입 메서드 
	public int join(MemberVO vo) {
		int result = 0;
		
		String sql = "insert into testusers values(?,?,?,?,?,?,?)";
		
		try {
			//Connction 객체 생성
			//conn = DriverManager.getConnection(url, user, password);
			conn = ds.getConnection();
			
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getPhone1());
			pstmt.setString(5, vo.getPhone2());
			pstmt.setString(6, vo.getEmail());
			pstmt.setString(7, vo.getGender());
			
			//SQL실행
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {
				
			}
		}
		return result;
	}
	
	public int login(String id, String pw) {
		int result = 0;
		
		String sql = "select * from testusers where id= ? and pw = ?";
		
		try {
			//conn = DriverManager.getConnection(url, user, password);
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 1;
			}
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return result;
	}
	
	//회원 정보 조회하는 메서드
	public MemberVO getInfo(String id) {
		MemberVO vo = null;
		
		String sql = "select * from testusers where id = ?";
		
		try {
			//Connection 객체 생성
			//conn = DriverManager.getConnection(url, user, password);
			conn = ds.getConnection();
			
			//PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			//SQL쿼리 실행
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				//rs.getSting(컬럼명) 값을 얻어오는 코드를 작성
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String phone1 = rs.getString("phone1");
				String phone2 = rs.getString("phone2");
				String gender = rs.getString("gender");
				String email = rs.getString("email");
				
				vo = new MemberVO(id, pw, name, phone1, phone2, email, gender);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return vo;
	}
	
	//update 메서드
	public int update(MemberVO vo) {
		int result = 0;
		
		String sql = "update testusers set pw= ?, name= ?, phone1= ?, phone2= ?, email= ? ,gender= ? where id = ?";
		
		try {
			//conn = DriverManager.getConnection(url, user, password);
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getPhone1());
			pstmt.setString(4, vo.getPhone2());
			pstmt.setString(5, vo.getEmail());
			pstmt.setString(6, vo.getGender());
			pstmt.setString(7, vo.getId());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return result;
	}
	
	//회원삭제
	public int delete(String id) {
		int result = 0;
		
		String sql = "delete from testusers where id = ?";
		
		try {
			//conn = DriverManager.getConnection(url, user, password);
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return result;
	}
}
