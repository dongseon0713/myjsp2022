package com.zerock.member.service;

import com.zerock.member.command.MemberVO;

public interface MemberService {
	
	public int checkId(String id);	//아이디 중복 체크
	public int join(MemberVO vo);	//회원가입
	public int login(MemberVO vo);	//회원 로그인
	public int delete(String id);	//회원 탈퇴
	public MemberVO getInfo(String id);	//회원 정보 불러오기
	public int update(MemberVO vo);
	public int updatePw(String id, String pw);
}
