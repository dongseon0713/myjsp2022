package com.zerock.member.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.zerock.member.command.MemberVO;

public interface MemberMapper {
	
	public int insert(MemberVO vo);	//ȸ�� ����
	public int login(MemberVO vo);	//�α���
	public int checkId(String id);	//���̵� �ߺ� Ȯ��
	public int delete(String id);	//ȸ�� Ż��
	public MemberVO getInfo(String id);	//ȸ�� ���� �ҷ�����
	public int update(MemberVO vo);
	public int updatePw(@Param("pw") String pw, @Param("id") String id);	//��й�ȣ ����
}
