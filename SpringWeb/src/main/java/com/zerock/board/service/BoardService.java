package com.zerock.board.service;

import java.util.ArrayList;

import com.zerock.board.command.BoardVO;
import com.zerock.board.command.Criteria;

public interface BoardService {
	
	//public ArrayList<BoardVO> getList();	//�Խ��� ����Ʈ �������� �޼���
	public ArrayList<BoardVO> getList(Criteria cri); //����¡ ó�� ����Ʈ ��������
	public int getTotal();					//��ü �Խù� ��
	public void register(BoardVO vo);		//�Խ��� ��� �޼���
	public BoardVO getContent(int num);		//�Խ��� �󼼺���(��ȯ ���� ����)
	public void update(BoardVO vo);			//�Խñ� ���� �Ϸ� ��ư
	public void delete(int num);			//�Խñ� ����
	
	
}