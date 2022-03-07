package com.zerock.TestDB;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zerock.mapper.TestMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TestUpdate {
	
	@Autowired
	private TestMapper mapper;
	@Test
	public void update() {
		
		String num = "1";
		
		boolean result = mapper.update(num);
		
		System.out.println("결과 성공(true) , 실패(false) : " + result);
	}
}
