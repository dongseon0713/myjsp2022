package com.zerock.TestDB;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zerock.mapper.TestMapper;
import com.zerock.vo.ScoreVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TestdbSelect {
	
	@Autowired
	private TestMapper mapper;
	
	@Test
	public void select() {
		ArrayList<ScoreVO> list = mapper.select();
	
		for(ScoreVO vo : list) {
			System.out.println(vo.getNum());
			System.out.println(vo.getName());
			System.out.println(vo.getKor());
			System.out.println(vo.getEng());
			System.out.println(vo.getMath());
			System.out.println("---------------------------");
		}
		
	}
}
