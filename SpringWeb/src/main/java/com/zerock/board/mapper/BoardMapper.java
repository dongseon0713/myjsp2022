
package com.zerock.board.mapper;

import java.util.ArrayList;

import com.zerock.board.command.BoardVO;
import com.zerock.board.command.Criteria;

public interface BoardMapper {
	
	public ArrayList<BoardVO> getList(); 	//��� �Խù� ��������
	public void insertBoard(BoardVO vo);	//�Խù� ���
	public BoardVO getContent(int num);		//�Խñ� �󼼺���
	public boolean updateBoard(BoardVO vo);	//�Խñ� �����Ϸ��ư Ŭ���� DB�� update����
	public void deleteBoard(int num);		//�Խñ� ����
	
	//����¡ ���� ó��
	//�Ű� ������ CriteriaŬ������ ����.(����¡ ������ ���� ���� Ŭ����)
	public ArrayList<BoardVO> pagingList(Criteria cri);
	
	//��ü �������� ��
	public int getTotal();
	
}