package com.zerock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.zerock.command.ScoreVO;

//DAO의 객체 주입은 일반적으로 Component나, Repository 어노테이션을 사용합니다.
//Component-scan에 꼭 추가해준다.

//@Component
@Repository
public class ScoreDAOImpl implements ScoreDAO {

	//DB를 대신할 저장소가 필요하다...
	//ArrayList<ScoreVO> DB = new ArrayList<>();
	
	/*
	 * create table score01(
	 * 		num int default board_num.nextval primary key,
	 * 		name varchar(30),
	 * 		kor varchar(30),
	 * 		eng varchar(30),
	 * 		math varchar(30)
	 * );
	 */
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override	//점수 입력 메서드
	public void scoreInsert(ScoreVO vo) {
		
		System.out.println("--------- DAO계층 ---------");
		System.out.println(vo.getName());
		System.out.println(vo.getKor());
		System.out.println(vo.getEng());
		System.out.println(vo.getMath());
		
		System.out.println("---------- 검증 ----------");
		System.out.println(jdbcTemplate);
		
		String sql = "insert into score01(name, kor, eng, math) values(?,?,?,?)";
		
		int result = jdbcTemplate.update(sql, new Object[] {vo.getName(),vo.getKor(),vo.getEng(),vo.getMath()});
		
		System.out.println("결과 조회(성공 : 1, 실패 : 0) : " + result);
	}

	@Override	//점수 결과 출력 메서드
	public ArrayList<ScoreVO> scoreSelect() {
		/*
		 * query()의 파라미터 의미
		 *  - sql : sql쿼리, preparedStatment방식의 ? 값
		 *  - new Object[] {값1, 값2} : sql물음표에 셋팅 값을 지정(바인딩)
		 *  - new RowMapper<Type>() : 조회결과 ResultSet으로 부터 데이터를 읽어와 type 데이터를 생성
		 *     -> 익명 클래스로 사용
		 *     -> mapRow() 메서드는 ResultSet에서 읽어온 값을 처리한 후에 리턴
		 */
		
		String sql = "select * from score01 order by num";
		
		List<ScoreVO> list = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<ScoreVO>() {
			
			@Override
			public ScoreVO mapRow(ResultSet rs, int rowNum) throws SQLException{
				ScoreVO vo = new ScoreVO();
					vo.setNum(rs.getInt("num"));
					vo.setName(rs.getString("name"));
					vo.setKor(rs.getString("kor"));
					vo.setEng(rs.getString("eng"));
					vo.setMath(rs.getString("math"));
				return vo;
			}
			
		});
		return (ArrayList<ScoreVO>)list;
	}

	@Override	//점수 삭제 메서드
	public void scoreDelete(String num) {
		
		String sql = "delete from score01 where num =?";
		
		int result = jdbcTemplate.update(sql, new Object[] {num});
		
		System.out.println("결과 조회(성공 : 1, 실패 : 0) : " + result);

	}

}
