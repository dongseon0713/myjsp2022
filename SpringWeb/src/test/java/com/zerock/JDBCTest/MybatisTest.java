package com.zerock.JDBCTest;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//테스트를 위한 준비
//porm.xml의 Junit 버전을 4.12로 변경. spring-test 라이브러리가 다운되어 있어야 함.

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MybatisTest {
	
	@Autowired	//자동 의존성 주입
	private SqlSessionFactoryBean session;
	//private SqlSessionFactory session2;
	
	@Autowired
	private DataSource datasource;
	
	@Test
	public void testFactory() {
		try {
			System.out.println("주입성공? >>>>> " + session);
			System.out.println("------------------------");
			System.out.println("주입성공? >>>>> " + datasource);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
