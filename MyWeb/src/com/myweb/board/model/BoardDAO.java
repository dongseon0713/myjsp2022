package com.myweb.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.myweb.util.Criteria;
import com.myweb.util.JdbcUtil;


public class BoardDAO {
	
	//1. 스스로 객체를 맴버변수로 선언하고 1개로 제한 - 싱글톤
	private static BoardDAO instance = new BoardDAO();
	
	//2. 외부에서 객체를 생성할 수 없도록  private설정함.
	private BoardDAO() {
		//커넥션풀을 꺼내는 작업
		try {
			InitialContext ctx = new InitialContext();	// Context.xml 값을 저장된 설정을 저장하기위해서
			ds =  (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			System.out.println("Connection Pool 에러");
		}
	}
	
	//3. 외부에서 객체를 요구할 때에 getter메서드만 써서 반환
	public static BoardDAO getInstance() {
		return instance;
	}
	
	//------- 중복되는 코드를 맴버변수로 선언 -------
	private DataSource ds;
	private Context ct;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//------- 메서드 구현 -------
	public void regist(String writer, String title, String content) {
		
			String sql = "insert into board (writer,title,content) values(?,?,?)";
			try {
				conn = ds.getConnection();
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, writer);
				pstmt.setString(2, title);
				pstmt.setString(3, content);
				
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					JdbcUtil.close(conn, pstmt, rs);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}	
	}
	
	
	/*
	public ArrayList<BoardVO> getList() {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
			String sql = "select * from Board order by num desc";	//게시글 번호 내림차순
			
			try {
				conn = ds.getConnection();
				
				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					//rs.getString(컬럼명), rs.getInt(), rs.getTimeStamp()
					//데이터를 vo에 담고 , 이 데이터를 list에 저장할 코드를 작성
					/*
					 * BoardVO vo = new BoardVO(); 
					 * vo.setNum(rs.getInt("num"));
					 * vo.setWriter(rs.getString("wirter")); 
					 * vo.setTitle(rs.getNString("title"));
					 * vo.setContent(rs.getString("content"));
					 * vo.setRegdate(rs.getTimestamp("regdate")); 
					 * vo.setHit(rs.getInt("hit"));
					 * list.add(vo);
					 */
	/*
					int num = rs.getInt("num");
					String writer = rs.getString("writer");
					String title = rs.getString("title");
					String content = rs.getString("content");
					Timestamp regdate = rs.getTimestamp("regdate");
					int hit = rs.getInt("hit");
					
					BoardVO vo = new BoardVO(num, writer, title, content, regdate, hit);
					
					//생성된 vo를 리스트에 추가
					list.add(vo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					JdbcUtil.close(conn, pstmt, rs);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		return list;
	}
	*/
	//페이징 게시물 목록 처리 메서드
	public ArrayList<BoardVO> getList(Criteria cri){
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
			
			String sql = "select * from "
					+ "(select rownum as rnum, B.* from board B where rownum <= ? order by num asc)"
					+ "where ? <= rnum";
			
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, cri.getCount_oracle());	//몇개의 데이터 조회 (끝)
				pstmt.setInt(2, cri.getPageStart());	//시작 번호
				//검증
				System.out.println(cri.getCount_oracle());
				System.out.println(cri.getPageStart());
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					int num = rs.getInt("num");
					String writer = rs.getString("writer");
					String title = rs.getString("title");
					String content = rs.getString("content");
					Timestamp regdate = rs.getTimestamp("regdate");
					int hit = rs.getInt("hit");
					
					BoardVO vo = new BoardVO(num, writer, title, content, regdate, hit);
					
					//생성된 vo를 리스트에 추가
					list.add(vo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(conn, pstmt, rs);
			}
		
		return list;
	}
	
	//총 게시물 수를 반환하는 메서드
	public int getTotal() {
		int result = 0;
		
			String sql = "select count(*) as total from board";
			
			try {
				conn = ds.getConnection();
				
				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					result = rs.getInt("total");
				}
				
				System.out.println("총 게시물 갯수 :" +result);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(conn, pstmt, rs);
			}
		return result;
	}
	
	public BoardVO getContent(String num1) {
		BoardVO vo = null;
			String sql = "select * from board where num = ?";
			
			try {
				conn = ds.getConnection();
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, num1);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					int num = rs.getInt("num");
					String writer = rs.getString("writer");
					String title = rs.getString("title");
					String content = rs.getString("content");
					Timestamp regdate = rs.getTimestamp("regdate");
					int hit = rs.getInt("hit");
					
					vo = new BoardVO(num, writer, title, content, regdate, hit);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					JdbcUtil.close(conn, pstmt, rs);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		return vo;
	}
	
	public void update(String num, String title, String content) {

		
		String sql = "update board set title = ?, content = ? where num = ?";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, Integer.parseInt(num));
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.close(conn, pstmt, rs);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}
	
	public void delete(String num) {
		
		String sql = "delete from board where num = ?";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.close(conn, pstmt, rs);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	public void upHit(String num) {
		
		String sql = "update board set hit= hit + 1 where num = ?";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(num));
			
			pstmt.executeUpdate();
				
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				JdbcUtil.close(conn, pstmt, rs);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
