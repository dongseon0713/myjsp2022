package com.zerock.member.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.zerock.member.command.MemberVO;

public interface MemberMapper {
	
	public int insert(MemberVO vo);	//회원 가입
	public int login(MemberVO vo);	//로그인
	public int checkId(String id);	//아이디 중복 확인
	public int delete(String id);	//회원 탈퇴
	public MemberVO getInfo(String id);	//회원 정보 불러오기
	public int update(MemberVO vo);
	public int updatePw(@Param("pw") String pw, @Param("id") String id);	//비밀번호 변경
}
