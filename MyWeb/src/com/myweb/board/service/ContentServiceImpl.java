package com.myweb.board.service;



import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.model.BoardDAO;
import com.myweb.board.model.BoardVO;


public class ContentServiceImpl implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//System.out.println(request.getParameter("num"));
		/*
		 * 1. DAO에 getContent() 메서드를 생성하고 호출  
		 * 2. getContent() 메서드를 num을 가지고, 게시글에 대한 정보를 vo객체에 담는 코드를 작성
		 * 3. 메서드 리턴타입 BoardVO
		 * 4. 화면 전송을 위한 리턴값을 vo라는 이름으로 강제 저장처리합니다.
		 */
		String num = request.getParameter("num");
		
		BoardDAO dao = BoardDAO.getInstance();
		
		//2. 쿠키 생성 : 서버에 요청시 자동으로 request에 담겨서 전달
		Cookie[] arr = request.getCookies();	//생성된 쿠키값 얻기
		
		//쿠키 검사
		boolean bool = true;
		for(Cookie c : arr) {
			if(c.getName().equals("hitNum" + num)) {  //쿠키 이름이 개시글 번호의 쿠키인지 확인.
				bool = false;
				break;
			}
		}
		
		//조회수 업데이트
		if(bool) {  //bool이 true면 클릭한 적이 없다.
			dao.upHit(num);		// hit값을 +1 해서 업데이트하는 메서드.....
			
		}
		
		BoardVO vo = dao.getContent(num);
		
		request.setAttribute("vo", vo);
		
		//1. 중복 증가를 방지하기 위한 쿠키 생성()
		Cookie hitcoo = new Cookie("hitNum"+num, num);
		
		hitcoo.setMaxAge(30);
		response.addCookie(hitcoo);
		
	}

}
