package com.zerock.board.dao;

import java.util.ArrayList;

import com.zerock.board.command.BoardVO;

public interface BoardDAO {
	
	public ArrayList<BoardVO> getList();	//게시판 리스트 가져오는 메서드
	public void register(BoardVO vo);		//게시판 등록 메서드
	public BoardVO getContent(int num);		//게시판 상세보기(반환 유형 생각)
	public void update(BoardVO vo);			//게시글 수정 완료 버튼
	public void delete(int num);			//게시글 삭제
}