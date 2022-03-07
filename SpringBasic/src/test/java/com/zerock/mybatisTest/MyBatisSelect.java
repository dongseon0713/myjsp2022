package com.zerock.mybatisTest;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zerock.command.ScoreVO;
import com.zerock.testmapper.TestMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MyBatisSelect {
	
	//DAO로 가정하고 작업
	//Mybatis에 매퍼(mapper) 스캔 추가해야함, 매퍼 인터페이스, 매퍼XML이 있어야 동작
	@Autowired
	private TestMapper mapper;
	
	@Test
	public void select() {
		String time = mapper.getTime();
		
		System.out.println(time);
		
		ArrayList<ScoreVO> list = mapper.select();
		
		for(ScoreVO vo : list) {
			System.out.println(vo.getNum());
			System.out.println(vo.getName());
			System.out.println(vo.getKor());
			System.out.println(vo.getEng());
			System.out.println(vo.getMath());
			System.out.println("---------------");
		}
		
		
	}
}
