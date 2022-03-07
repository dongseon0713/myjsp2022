package com.project.member.mapper;

import com.project.member.command.MemberVO;

public interface MemberMapper {
	public int join(MemberVO vo);
	public int login(MemberVO vo);
	public void update();
	public void delete();
	public int checkId(String id);	//���̵� �ߺ� Ȯ��
	public int checkNname(String nickname);	//�г��� �ߺ� Ȯ��

}
