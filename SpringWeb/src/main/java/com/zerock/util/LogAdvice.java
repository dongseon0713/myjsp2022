package com.zerock.util;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component	//bean �ڵ� �������(������Ʈ ��ĵ�� �߰�)
@Aspect		//Aspect Ŭ������ �ǹ�
public class LogAdvice {
	//�ش� ����� �α׸� ����� �� �ִ� ���
	// log4j.xml�� ���� �����ؾ���
	//<logger name="com.zerock.util">
	//	<level value="info" />
	//<logger>
	
	private static final Logger logger = LoggerFactory.getLogger(LogAdvice.class);
	
	//�� �տ� �ִ� *�� ���� �����ڸ� �ǹ��ϰ� , �� �ڿ� *�� �޼��带 �ǹ���.
	@Before("execution(* com.zerock.board.service.BoardServiceImpl*.*(..))")
	//@Before("execution(* com.zerock.controller.*Controller*.*(..))")
	public void beforeLog() {
		logger.info("-------Before-------");
	}
	
	//���� AOP����!
	
	@After("execution(* com.zerock.board.service.BoardServiceImpl.*(..))")
	public void afterLog() {
		logger.info("-------After-------");
	}
	
	//�޼��� ���� ������ ������, ������, ���� �� ó���� ����
	//@Around�� ����Ǵ� �޼���(�����̽�)�� �ݵ�� ������ �־�� �մϴ�.
	@Around("execution(* com.zerock.board.service.BoardServiceImpl.*(..))")
	public Object aroundLog(ProceedingJoinPoint jp) {
		long start = System.currentTimeMillis();
		
		//�ش� ����� ���� �޼��� ������ ����� Ȯ�� �� �� ����.
		//System.out.println("���� Ŭ���� : " + jp.getTarget());
		//System.out.println("���� �Ķ���� :" + Arrays.toString(jp.getArgs()));
		
		logger.info("���� Ŭ���� : " + jp.getTarget());
		logger.info("���� �Ķ���� : " + Arrays.toString(jp.getArgs()));
		
		Object result = null;
		
		try {
			//proceed() �޼���� Ÿ�� �޼��带 ��Ī�Ѵ�. �ش� �޼��带 ���� ���Ѿ� Ÿ���� �Ǵ� �޼��尡 ����ȴ�.
			//�ش� �޼��带 ������ ������ Before �����̽��� ����ȴ�.
			result = jp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		//System.out.println("�޼��� ���࿡ �ɸ� �ð� : " + (end-start));
		logger.info("�޼��� ���࿡ �ɸ� �ð� : " + (end-start));
		
		return result;
		
	}
	
	//�ش� ������̼��� ���ܰ� �߻��ϸ� �����ϴ� ������̼�
	//pointcut - � �޼��忡 ������ ���ΰ�...
	//throwing - ó���� ���� ����
	@AfterThrowing(pointcut="execution(* com.zerock.service.memberService*.*(..))"
			, throwing = "e")
	public void errorLog(Exception e) {
		System.out.println("���� ��� : " + e);
	}
}
