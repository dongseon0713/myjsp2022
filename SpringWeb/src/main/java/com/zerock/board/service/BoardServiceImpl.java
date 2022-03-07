package com.zerock.board.service;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerock.board.command.BoardVO;
import com.zerock.board.command.Criteria;
import com.zerock.board.dao.BoardDAO;
import com.zerock.board.dao.BoardDAOImpl;
import com.zerock.board.mapper.BoardMapper;

//Service
//스프링에서 DispatcherServlet이 동작하고, 핸들러어댑터가 가동되면, 헤당 어노테이션을 확인
//빈으로 등록 생성.
//수동으로 bean등록을 하지 않았고, 어노테이션을 사용했다면 servlet-context에서 컴포넌트 스캔을 처리
@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper mapper;
	//게시글 리스트
	/*
	@Override
	public ArrayList<BoardVO> getList() {
		ArrayList<BoardVO> list = mapper.getList();
		
		return list;
	}
	*/
	
	//페이징 게시글 리스트
	@Override
	public ArrayList<BoardVO> getList(Criteria cri) {
		//cri값을 전달하여 받아 처리하는 DAO를 mapper를 통해서 구현
		
		ArrayList<BoardVO> list =  mapper.pagingList(cri);
		return list;
	}
	
	//전체 게시물 수
	@Override
	public int getTotal() {
		int total = mapper.getTotal();
		return total;
	}
	
	@Override
	public void register(BoardVO vo) {
		//등록처리...
		mapper.insertBoard(vo);
		
	}

	@Override
	public BoardVO getContent(int num) {
		
		BoardVO vo = mapper.getContent(num);
		System.out.println("======서비스 계층=====");
		System.out.println(vo.getNum());
		System.out.println(vo.getTitle());
		System.out.println(vo.getContent());
		System.out.println(vo.getWriter());
		return vo;
	}

	@Override
	public void update(BoardVO vo) {
		System.out.println("======서비스 계층=====");
		System.out.println(vo.getNum());
		System.out.println(vo.getTitle());
		System.out.println(vo.getContent());
		System.out.println(vo.getWriter());
		
		boolean bool = mapper.updateBoard(vo);
		
		System.out.println("성공 실패 ? : " + bool);

	}

	@Override
	public void delete(int num) {
		
		
		mapper.deleteBoard(num);

	}


}