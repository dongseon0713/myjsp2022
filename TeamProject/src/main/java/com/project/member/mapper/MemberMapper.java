package com.project.member.mapper;

import com.project.member.command.MemberVO;

public interface MemberMapper {
	public int join(MemberVO vo);
	public int login(MemberVO vo);
	public void update();
	public void delete();
	public int checkId(String id);	//아이디 중복 확인
	public int checkNname(String nickname);	//닉네임 중복 확인

}
