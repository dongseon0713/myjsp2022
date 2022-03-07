package com.zerock.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan(basePackages = {"com.zerock.testmapper"})	//MyBatis MapperScan 설정
public class RootConfig {

	//HikariCP 설정
	@Bean
	public DataSource dataSource() {
		
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("oracle.jdbc.OracleDriver");
		hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/XEPDB1");
		hikariConfig.setUsername("spring");	//DB계정 (spring)
		hikariConfig.setPassword("spring");	//DB계정 패스워드(spring)
		
		HikariDataSource dataSoruce = new HikariDataSource(hikariConfig);
		
		return dataSoruce;
	}
	
	
	//MyBatis 설정
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();	
		sqlSessionFactory.setDataSource(dataSource());		//sqlSessionFactory에 DataSource 설정
		
		return (SqlSessionFactory)sqlSessionFactory.getObject();
	}
	
}
