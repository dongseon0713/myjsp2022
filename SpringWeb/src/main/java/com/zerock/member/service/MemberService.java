package com.zerock.member.service;

import com.zerock.member.command.MemberVO;

public interface MemberService {
	
	public int checkId(String id);	//���̵� �ߺ� üũ
	public int join(MemberVO vo);	//ȸ������
	public int login(MemberVO vo);	//ȸ�� �α���
	public int delete(String id);	//ȸ�� Ż��
	public MemberVO getInfo(String id);	//ȸ�� ���� �ҷ�����
	public int update(MemberVO vo);
	public int updatePw(String id, String pw);
}
