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
@MapperScan(basePackages = {"com.zerock.testmapper"})	//MyBatis MapperScan ����
public class RootConfig {

	//HikariCP ����
	@Bean
	public DataSource dataSource() {
		
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("oracle.jdbc.OracleDriver");
		hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/XEPDB1");
		hikariConfig.setUsername("spring");	//DB���� (spring)
		hikariConfig.setPassword("spring");	//DB���� �н�����(spring)
		
		HikariDataSource dataSoruce = new HikariDataSource(hikariConfig);
		
		return dataSoruce;
	}
	
	
	//MyBatis ����
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();	
		sqlSessionFactory.setDataSource(dataSource());		//sqlSessionFactory�� DataSource ����
		
		return (SqlSessionFactory)sqlSessionFactory.getObject();
	}
	
}
