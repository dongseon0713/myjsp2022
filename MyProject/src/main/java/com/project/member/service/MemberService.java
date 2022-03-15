package com.project.member.service;


import com.project.member.command.MemberVO;

public interface MemberService {
	public int join(MemberVO vo);	//회원가입
	public int login(MemberVO vo);	//회원 로그인
	public int checkId(String id);	//아이디 중복 체크
	public int checkNname(String nickname);	//닉네임 중복 체크
	public int findIdCheck(String name,String phone,
			int phone1,int phone2,String question,String answer); //아이디 찾기 전 유효성 검사
	public MemberVO findId(String name,String phone,int phone1,int phone2,String question,String answer);	//아이디 찾기
	public int findPw(String id, String email,String eamilAd);	//비밀번호 찾기 전 유효성 검사
	public int updatePw(String id,String pw);	//비밀번호 변경
	public MemberVO getInfo(String id);	//유저 정보 가져오기
	public int pwCheck(String id, String pw);	//회원 정보 수정 전 유효성 검사
	public int update(MemberVO vo);	//회원 정보 수정
	public int unregister(String reason, String cause);	//회원 탈퇴
	public void delete(String id);	//회원 탈퇴
	
}
