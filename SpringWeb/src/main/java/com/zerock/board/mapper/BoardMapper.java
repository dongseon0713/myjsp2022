
package com.zerock.board.mapper;

import java.util.ArrayList;

import com.zerock.board.command.BoardVO;
import com.zerock.board.command.Criteria;

public interface BoardMapper {
	
	public ArrayList<BoardVO> getList(); 	//모든 게시물 가져오기
	public void insertBoard(BoardVO vo);	//게시물 등록
	public BoardVO getContent(int num);		//게시글 상세보기
	public boolean updateBoard(BoardVO vo);	//게시글 수정완료버튼 클릭시 DB에 update진행
	public void deleteBoard(int num);		//게시글 삭제
	
	//페이징 퀴리 처리
	//매개 변수로 Criteria클래스를 받음.(페이징 기준의 대한 설정 클래스)
	public ArrayList<BoardVO> pagingList(Criteria cri);
	
	//전체 데이터의 수
	public int getTotal();
	
}