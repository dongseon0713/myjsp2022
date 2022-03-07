package com.ok;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/delete_ok")
public class delete_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public delete_ok() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * delete from 테이블명 where id = ?
		 * 
		 * 1. 아이디는 세션에서 얻는다
		 * 2. pstmt를 이용해서 삭제를 진행
		 * 3. 사용 메서드는 executeUpdate()로 sql문을 실행... (인자X)
		 *   => 1을 반환 : 쿼리 성공 -> 세션을 전부 삭제후에 login.jsp로 이동
		 *   => 0을 반환 : 쿼리 실패 -> mypage.jsp로 이동
		 * 
		 * */
		/*
		 * DAO를 이용한 코드
		 * 1. 아이디는 세션에서 얻는다. DAO에 delete(id) 메서드를 생성
		 * 2. 메서드 생성시에 executeUpdate()메서드를 사용하셔 성공시 delete(id)메서드에
		 * 	 => 1을 반환 : 쿼리 성공 -> 세션을 전부 삭제후에 login.jsp로 이동
		 *   => 0을 반환 : 쿼리 실패 -> mypage.jsp로 이동
		 * 
		 */
		
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("user_id");
		
		MemberDAO dao = MemberDAO.getInstance();
		
		int result = dao.delete(id);
		
		if (result == 1) {
			session.invalidate();
			response.sendRedirect("login.jsp");
		} else {
			response.sendRedirect("mypage.jsp");
		}
		/*
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String user = "myjsp";
		String password = "myjsp";
		String driver = "oracle.jdbc.driver.OracleDriver";

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete from testusers where id = ?";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			int result = pstmt.executeUpdate();
			
			if (result == 1) {
				session.invalidate();
				response.sendRedirect("login.jsp");
			} else {
				response.sendRedirect("mypage.jsp");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		*/
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
