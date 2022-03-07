package com.zerock.controller;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zerock.board.command.BoardVO;
import com.zerock.board.command.Criteria;
import com.zerock.board.mapper.BoardMapper;

//1) JUnit 4.7 -> 4.12 ,  2) spring-test ��ġ : ���̺��� ���ؼ� ��ġ

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main//webapp/WEB-INF/spring/root-context.xml")
public class PagingTest {
	
	@Autowired
	BoardMapper mapper; 	//main/com.zerock.board.mapper
	
	@Test
	public void pagingTest() {
		
		System.out.println("----pagingTest----");
		
		Criteria cri = new Criteria();
		
		cri.setPageNum(2);
		cri.setCount(10);
		
		ArrayList<BoardVO> list = mapper.pagingList(cri);
		
		for(BoardVO vo : list) {
			System.out.println("�Խù� ��ȣ : " + vo.getNum());
		}
	}
	
	@Test
	public void ceilTest() {
		System.out.println("----ceilTest----");
		
		//�ø� �Լ� Math.ceil(�Ǽ�)
		System.out.println("ceilȮ�� :" + Math.ceil(2.1));
		
		//5�������� ���� �ִٸ� ȭ�鿡 ������ ������ 1~10
		//11�������� ���� �ִٸ� ȭ�鿡 ������ ������ 11~20
		
		//�� ������ ��ȣ
		//���� : (int)Math.ceil (��������ȣ / 10.0) * 10;
		int end = (int)Math.ceil( 5 / 10.0) * 10;
		System.out.println("5������ �϶� �������� ����ȣ : " + end );
		
		//���� ������ ��ȣ
		//���� : (�� ������ - 9);
		int start = end - 9;
		System.out.println("5������ �϶� �������� ���۹�ȣ :" + start);
		
		//�� ������ ��ȣ
		int end1 = (int)Math.ceil(12/10.0) * 10;
		System.out.println("12������ �϶� �������� ����ȣ : " + end1 );
		
		//���� ������ ��ȣ
		int start1 = end1 - 9;
		System.out.println("12������ �϶� �������� ���۹�ȣ : " + start1);
		
		//���� �����Ͱ� �� �Խñ� ���� 100�� ���϶��?
		//�� �Խñ� �� : 81��
		//�������� �� ������ �� = 9
		//���� : Math.ceil( ��ü �Խñ� �� * 1.0 / ������ ������ ��)
		int realEnd = (int)Math.ceil(81 * 1.0 / 10);
		System.out.println("��ü �����Ͱ� 100�� ������ �� :" + realEnd);
		
	}
}
