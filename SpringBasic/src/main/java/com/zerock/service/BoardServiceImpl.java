package com.zerock.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerock.command.BoardVO;
import com.zerock.dao.BoardDAO;
import com.zerock.dao.BoardDAOImpl;
import com.zerock.mapper.BoardMapper;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper mapper;
	
	//게시글 등록 메서드
	@Override
	public void register(String name, String title, String content) {
		
//		System.out.println("-------서비스 계층------");
//		System.out.println(name);
//		System.out.println(title);
//		System.out.println(content);
		
		//호출
		//1st 커멘드 객체를 이용
		//BoardVO vo = new BoardVO();
		//vo.setName(name);
		//vo.setTitle(title);
		//vo.setContent(content);
		//mapper.insert(vo);
		
		//2nd Map타입으로 이용
		//여러개의 값을 전달할 때에 사용한 key값이 마이바티스 전달에 사용할 값이 된다.
		Map<String, String> map = new HashMap<>();
		
		map.put("p1", name);
		map.put("p2", title);
		map.put("p3", content);
		
		mapper.insert2(map);
	}

	//게시글 리스트 보기 메서드
	@Override
	public ArrayList<BoardVO> getList() {
		
		ArrayList<BoardVO> DB = mapper.select();
		
		return DB;
	}

	@Override
	public void delete(String num) {
		
		mapper.delete(num);
		
	}

}
