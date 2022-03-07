package test01;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import test02.ex01.construct.Hotel;
import test02.ex02.setter.DatabaseDev;
import test04.ex01.configuration.JavaConfig;


public class MainClass {

	public static void main(String[] args) throws SQLException {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(JavaConfig.class);
		
		SpringTest t = ctx.getBean("good", SpringTest.class);
		t.method();
		
		Hotel h = ctx.getBean("hotel", Hotel.class);
		h.getChef().cook();
		
		DatabaseDev DBdev = ctx.getBean("DBdev", DatabaseDev.class);
		DBdev.test();
		ResultSet rs = DBdev.testQuery("select * from users");
		try {
			System.out.println("아이디 : " + rs.getString("id") +",패스워드 : " +rs.getString("pw")+" 이름 : "+ rs.getString("name"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ctx.close();
	}
}
