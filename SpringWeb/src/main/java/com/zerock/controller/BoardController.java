package com.zerock.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zerock.board.command.BoardVO;
import com.zerock.board.command.Criteria;
import com.zerock.board.command.PageVO;
import com.zerock.board.service.BoardService;

@Controller
@RequestMapping("*/board/*")
public class BoardController {
	
	@Autowired
	private BoardService service;
	/*
	create table tbl_board(
		    num int DEFAULT TBL_BOARD_SEQ.nextval primary key,
		    title varchar(200) not null,
		    content varchar(2000) not null,
		    writer varchar(50) not null,
		    regdate timestamp default sysdate,
		    updatedate timestamp default sysdate
	);
	*/
	//1. Controller 구현 (뷰)
		//2. 테이블 생성(더미 데이터작업)
		//3. DB관련 설정테스트(root-context.xml 작업 후 테스트)
		//4. BoardVO생성 (DB컬럼명과 동일하게 생성)
		//5. Service 구현
		//6. DAO를 구현
		//7. MyBatis DB작업
	
	//게시글 리스트
//	@RequestMapping("/list")
//	public String list(Model model) {
//		//list에 요청이 들어오면, DB에서 모든 값을 가지고, 화면으로 이동해야 한다.
//		ArrayList<BoardVO> list = service.getList();
//		
//		//컨트롤러 메서드의 리턴값을 추가하고 싶다면, 
//		//1. Model객체를 추가. 간편하게 전달...
//		//2. 리턴 유형을 ModelAndView 객체를 추가한다.
//		model.addAttribute("list", list);
//		
//		return "board/list";
//		
//	}
	
	//페이징 화면 처리
	@RequestMapping("/list")
	public String list(Model model, Criteria cri) {
		//게시글 정보 가져오기(Criteria 기준으로 설정)
		ArrayList<BoardVO> list = service.getList(cri);
		model.addAttribute("list", list);
		
		//게시글 전체 데이터를 가져오기
		int total = service.getTotal();
		//PageVO(페이징 기준, 전체 게시글 갯수) 전달하면, PageVO에서는 페이징에 대한 계산을 모두 끝냄.
		model.addAttribute("pageMaker", new PageVO(total, cri));
		
		return "board/list";
	}
	
	
	//게시글 상세보기 페이지 처리
	@RequestMapping("/content")
	public String content(Model model,@RequestParam("num") int num,
			@ModelAttribute("cri") Criteria cri) {	//8. 페이징에서 추가함. (이후 Content,jsp를 변경)
		System.out.println("======컨트롤러 계층=====");
		System.out.println(num);
		
		BoardVO vo = service.getContent(num);
		
		model.addAttribute("vo",vo);
		
		return "board/content";
	}
	//게시판 수정 페이지 처리
	@RequestMapping("/modify")
	public String modify(Model model,@RequestParam("num") int num,@ModelAttribute("cri") Criteria cri) {
		
		
		BoardVO vo = service.getContent(num);
		
		model.addAttribute("vo",vo);
		return "board/modify";
	}
	
	//게시판 수정 완료 버튼
	@RequestMapping("/update")
	public String update(BoardVO vo) {
		System.out.println("=====컨트롤 계층=====");
		System.out.println(vo.getNum());
		System.out.println(vo.getTitle());
		System.out.println(vo.getContent());
		System.out.println(vo.getWriter());
		
		//문제
		//1. service 계층에 전달받은 폼값을 전달하는 update(vo)를 생성하세요.
		//2. update() 메서드 안에서 myBatis로 연결하는updateBoard(vo) 메서드를 생성하세요.
		service.update(vo);
		
		
		return "redirect:list";
	}
	
	//게시판 삭제 완료 버튼
	@RequestMapping("/delete")
	public String delete(@RequestParam("num") int num) {
		//delete 구현
		//1. service 계층에 num을 전달받아 처리하는 delete()를 생성.
		//2. mapper 인터페이스 void deleteBoard()를 선언
		//3. service안에 mapper에 선언된 deleteBoard()를 실행
		//4. mapper.xml에서는 <delete></delete>태그를 통해 삭제를 진행
		//5. sql = delete from tbl_board where nun=#{num}
		service.delete(num);
		
		return "redirect:list";
	}
	
	//get방식
	@RequestMapping(value="/register" , method=RequestMethod.GET)
	public String register(@ModelAttribute("cri") Criteria cri) {			//페이징 작업...
		System.out.println("화면처리");
		return "board/register";
	}
	//post방식으로 등록처리
	@RequestMapping(value="/regForm", method=RequestMethod.POST)
	public String regForm(BoardVO vo) {
		System.out.println("등록 처리");
		
		//서비스 처리...
		service.register(vo);
		
		return "redirect:/board/list";
	}
	
	
}
