package com.zerock.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zerock.command.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	//DB로 가정할 ArrayList 처리
	//ArrayList<BoardVO> DB = new ArrayList<>();
	
	//JDBC처리...
	//1. 아티펙트 설치 (ojdbc8.jar) - maven에서... (pom.xml)
	//2. DB내에 board01테이블 생성
	/*
	 *  create table board01( 
	 *  	num int default board_num.nextval primary key,
	 *  	name varchar(20),
	 *  	title varchar(30),
	 *  	content varchar(50)
	 *  );
	 * 
	 */
	
	/*
	 * 빈 설정 없는 경우(root-context.xml에 설정하지 않은 경우)
	 * 
	 * private HikariConfig hikariConfig;
	 * private HikariDataSource dataSource;
	 * private JdbcTemplate jdbcTemplate;
	 * 
	 * public BoardDAOImpl() {
	 * 	hikariConfig = new hikariConfig();	// hikari객체 생성(bean생성)
	 * 	hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	 * 	hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/XEPDB1");
	 * 	hikariConfig.setUsername("myjsp");
	 * 	hikariConfig.setPassword("myjsp");
	 * 
	 * 	dataSource = new HikariDataSource(hikariConfig);
	 * 	jdbcTemplate = new JdbcTemplate();
	 * 	
	 * 	jdbcTemplate.setDataSource(dataSource);
	 * }
	 */
	
//	//3. DB연결정보 생성
//	private String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
//	private String user = "myjsp";
//	private String password = "myjsp";
//	
//	private Connection conn = null;
//	private PreparedStatement pstmt = null;
//	private ResultSet rs = null;
//	//4. 각 메소드별 처리
//	//게시글 등록 처리
//	@Override
//	public void boardInsert(String name, String title, String content) {
//		String sql = "insert into board01(name, title, content) values (?,?,?)";
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			
//			conn = DriverManager.getConnection(url, user, password);
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, name);
//			pstmt.setString(2, title);
//			pstmt.setString(3, content);
//			
//			pstmt.executeUpdate();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(conn != null) conn.close();
//				if(pstmt != null) pstmt.close();
//				if(rs != null) rs.close(); 
//			} catch (Exception e2) {
//				
//			}
//		}
//		
//		
//		
//	}
//
//	@Override
//	public ArrayList<BoardVO> boardSelect() {
//		ArrayList<BoardVO> DB = new ArrayList<BoardVO>();
//		String sql = "select * from board01 order by num asc";
//		
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			
//			conn = DriverManager.getConnection(url, user, password);
//			pstmt = conn.prepareStatement(sql);
//			
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				int num = rs.getInt("num");
//				String name = rs.getString("name");
//				String title = rs.getString("title");
//				String content = rs.getString("content");
//				
//				BoardVO vo = new BoardVO();
//				vo.setNum(num);
//				vo.setName(name);
//				vo.setTitle(title);
//				vo.setContent(content);
//				
//				DB.add(vo);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(conn != null) conn.close();
//				if(pstmt != null) pstmt.close();
//				if(rs != null) rs.close();
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
//		}
//		return DB;
//	}
//
//	@Override
//	public void boardDelete(String num) {
//		
//		String sql = "delete from board01 where num=?";
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			conn = DriverManager.getConnection(url, user, password);
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, num);
//					
//			pstmt.executeUpdate();
//					
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				try {
//					if(conn != null) conn.close();
//					if(pstmt != null) pstmt.close();
//					if(rs != null) rs.close(); 
//				} catch (Exception e2) {
//					
//				}
//				}
//	}

	
//	 private HikariConfig hikariConfig;
//	 private HikariDataSource dataSource;
//	 private JdbcTemplate jdbcTemplate;
//	 
//	 public BoardDAOImpl() {
//	 	hikariConfig = new HikariConfig();	// hikari객체 생성(bean생성)
//	 	hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//	 	hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/XEPDB1");
//	 	hikariConfig.setUsername("myjsp");
//	 	hikariConfig.setPassword("myjsp");
//	 
//	 	dataSource = new HikariDataSource(hikariConfig);
//	 	jdbcTemplate = new JdbcTemplate();
//	 	
//	 	jdbcTemplate.setDataSource(dataSource);
//	 }
	
	// root-context.xml에서 설정 후 주입
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void boardInsert(String name, String title, String content) {
		
		
		System.out.println(jdbcTemplate);	//검증
		
		String sql = "insert into board01(name,title,content) values(?,?,?)";
		/*
		//1st
		int result = jdbcTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, name);
				ps.setString(2, title);
				ps.setString(3, content);
				
			}
		});
		System.out.println("결과 조회(성공 : 1, 실패 : 0) : " + result);
		*/
		//2nd
		//update() 메서드의 파라미터 값으로 (sql문, ?의 바인딩할 값)
		int result = jdbcTemplate.update(sql, new Object[] {name, title, content} );
		
		System.out.println("결과 조회(성공 : 1, 실패 : 0) : " + result);
	}
	
	@Override
	public ArrayList<BoardVO> boardSelect() {
		/*
		 * query()의 파라미터 의미
		 *  - sql : sql쿼리,
		 * 	- new Object[] {값1, 값2} : sql물음표에 셋팅할 값을 저장함(바인딩)
		 * 	- new RowMapper<Type>() : 조회결과를 ResultSet으로부터 데이터를 읽어와서 Type 데이터 생성
		 * 		-> 익명클래스로 사용합니다.
		 * 		-> mapRow() 메서드는 ResultSet에서 읽어온 값을 처리한 후 리턴한다.
		 */
		String sql = "select * from board01";
		
		List<BoardVO> list = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<BoardVO>() {
			
			@Override
			public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardVO vo = new BoardVO();
					vo.setNum(rs.getInt("num"));
					vo.setName(rs.getString("name"));
					vo.setTitle(rs.getString("title"));
					vo.setContent(rs.getString("content"));
				return vo;
			}
		});
		return (ArrayList<BoardVO>)list;
	}
	
	@Override
	public void boardDelete(String num) {
		String sql = "delete from board01 where num =?";
		
		int result = jdbcTemplate.update(sql, new Object[] {num});
		
		System.out.println("결과 조회(성공 : 1, 실패 : 0) : " + result);
	}
}
