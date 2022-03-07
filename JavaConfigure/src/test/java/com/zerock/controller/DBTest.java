package com.zerock.controller;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zerock.config.RootConfig;
import com.zerock.testmapper.TestMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class DBTest {
	
	@Setter(onMethod_ = {@Autowired})
	private DataSource dataSource;
	
	@Test
	public void DataSourceTest() {
		try(Connection conn =  dataSource.getConnection()) {
			log.info("==== 히카리 CP 연결 확인 ====");
			log.info(conn);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Setter(onMethod_ = {@Autowired})
	private SqlSessionFactory sqlSessionFactory;
	@Test
	public void MyBatisConnectTest() {
		try(SqlSession session = sqlSessionFactory.openSession();
				Connection conn2 = session.getConnection()) {
			log.info("==== MyBatis연결 ====");
			log.info(conn2);
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Setter(onMethod_ = {@Autowired})
	private TestMapper mapper;
	
	@Test
	public void testmapper() {
		log.info(mapper.getClass().getName());	
		log.info(mapper.getTime());	//TestMapper에 getTime()를 샐행 결과
	}
}
