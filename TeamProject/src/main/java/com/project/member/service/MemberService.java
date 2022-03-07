package com.project.member.service;

import com.project.member.command.MemberVO;

public interface MemberService {
	public int join(MemberVO vo);	//ȸ������
	public int login(MemberVO vo);	//ȸ�� �α���
	public int delete(String id);	//ȸ�� Ż��
	public void update(MemberVO vo);	//ȸ�� ���� ����
	public int checkId(String id);	//���̵� �ߺ� üũ
	public int checkNname(String nickname);	//�г��� �ߺ� üũ

}
