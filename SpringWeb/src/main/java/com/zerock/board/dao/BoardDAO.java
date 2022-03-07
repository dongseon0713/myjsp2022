package com.zerock.board.dao;

import java.util.ArrayList;

import com.zerock.board.command.BoardVO;

public interface BoardDAO {
	
	public ArrayList<BoardVO> getList();	//�Խ��� ����Ʈ �������� �޼���
	public void register(BoardVO vo);		//�Խ��� ��� �޼���
	public BoardVO getContent(int num);		//�Խ��� �󼼺���(��ȯ ���� ����)
	public void update(BoardVO vo);			//�Խñ� ���� �Ϸ� ��ư
	public void delete(int num);			//�Խñ� ����
}