package com.zerock.TestDB;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zerock.mapper.TestMapper;
import com.zerock.vo.ScoreVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TestdbInsert {
	
	@Autowired
	private TestMapper mapper;
	
	
	@Test
	public void insert() {
		try {

			ScoreVO vo = new ScoreVO();
			vo.setName("강감찬");
			vo.setKor("100");
			vo.setEng("100");
			vo.setMath("100");
			
			boolean result = mapper.insert(vo);
			
			System.out.println("결과 성공(true), 실패(false) : " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
