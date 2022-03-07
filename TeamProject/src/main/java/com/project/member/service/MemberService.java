package com.project.member.service;

import com.project.member.command.MemberVO;

public interface MemberService {
	public int join(MemberVO vo);	//회원가입
	public int login(MemberVO vo);	//회원 로그인
	public int delete(String id);	//회원 탈퇴
	public void update(MemberVO vo);	//회원 정보 수정
	public int checkId(String id);	//아이디 중복 체크
	public int checkNname(String nickname);	//닉네임 중복 체크

}
