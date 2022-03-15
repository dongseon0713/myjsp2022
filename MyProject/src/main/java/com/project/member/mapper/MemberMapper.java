package com.project.member.mapper;

import org.apache.ibatis.annotations.Param;

import com.project.member.command.MemberVO;

public interface MemberMapper {
	public int join(MemberVO vo);
	public int login(MemberVO vo);
	public int checkId(String id);	//아이디 중복 확인
	public int checkNname(String nickname);	//닉네임 중복 확인
	public int findIdCheck(@Param("name") String name,@Param("phone")String phone,
			@Param("phone1")int phone1,@Param("phone2")int phone2,@Param("question")String question,@Param("answer")String answer); //아이디 찾기 전 유효성 검사
	public MemberVO findId(@Param("name") String name,@Param("phone")String phone,
			@Param("phone1")int phone1,@Param("phone2")int phone2,@Param("question")String question,@Param("answer")String answer);	//아이디 찾기
	public int findPw(@Param("id")String id, @Param("email")String email, @Param("emailAd") String emailAd);	//비밀번호 찾기 전 유효성 검사
	public int updatePw(@Param("id")String id,@Param("pw")String pw);	//비밀번호 변경
	public MemberVO getInfo(String id);	//유저 정보 가져오기
	public int pwCheck(@Param("id")String id, @Param("pw")String pw);	//정보 수정 전 유효성 검사
	public int update(MemberVO vo);		//회원 정보 수정
	public int unregister(@Param("reason") String reason, @Param("cause") String cause);	//회원 탈퇴
	public void delete(@Param("id") String id);	//회원 탈퇴
}
