package com.ok;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Login_ok")
public class Login_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login_ok() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//로그인 form으로부터 받은 정보 전달 받음
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		//DAO객체 생성
		MemberDAO dao = MemberDAO.getInstance();
		
		int result = dao.login(id, pw);
		/*
		//DB연동을 위한 변수 및 객체 생성
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String user = "myjsp";
		String password = "myjsp";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * from testusers where id= ? and pw= ?";
		
		//DB 연동
		try {
			//1. 드라이버 로드
			Class.forName(driver);
			
			//2. 커넥션 객체 생성
			conn = DriverManager.getConnection(url, user, password);
			
			//3. preparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			//4. 쿼리 실행
			rs = pstmt.executeQuery();
			*/
			
			if(result == 1) {
				//자바에서 Session이용하기
				HttpSession session = request.getSession();
				session.setAttribute("user_id", id);
				//session.setAttribute("name", rs.getString("name"));
				//name값을 받으려면 반환값을 int로 하면 안됨.
				
				//아이디, 패스워드 일치하는 경우
				response.sendRedirect("mypage.jsp");
			}else {
				//로그인 실패 시 - 아이디, 패스워드 일치하지 않는 경우
				response.sendRedirect("login_fail.jsp");         
			}
			/*
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		*/
		
		
		
	}

}
