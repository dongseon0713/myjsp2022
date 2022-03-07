package com.zerock.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zerock.member.command.MemberVO;
import com.zerock.member.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService member;
	//테이블 생성 (id, pw, name, 날짜)
	/*
	 * create table member (
	 * 	id varchar(30) primary key,
	 * 	pw varchar(30) not null,
	 * 	name varchar(30),
	 * 	regdate timestamp default sysdate
	 * );
	 */
	
	//로그인 화면처리
	@RequestMapping("/login")
	public String login() {
		return "member/login";
	}
	
	//회원가입 화면 처리
	@RequestMapping("/join")
	public String join() {
		return "member/join";
	}
	
	//회원 가입 처리
	@RequestMapping("/joinForm")
	public String joinForm(MemberVO vo, RedirectAttributes RA) {
		
		//서비스로 join을 처리해야 함.
		int result = member.join(vo);
		if(result == 1) {	//1을 반환 받았다는 것은 insert가 성공
			RA.addFlashAttribute("msg", "회원가입 성공했습니다.");
		}else {		//insert 실패
			RA.addFlashAttribute("msg", "회원가입에 실패했습니다.");
		}
		return "redirect:/member/login";	//login컨트롤러로 돌림
	}
	
	@RequestMapping("join_result")
	public String join_result( ) {
		
		return "/member/login";
	}
	
	//login 폼 처리 - 인증, 세션, 성공?=> "/" 실패? => "login"
	@RequestMapping("/loginForm")
	public String loginForm(MemberVO vo, HttpSession session, RedirectAttributes RA) {
		int result = member.login(vo);
		
		if(result == 1) {	//1개의 카운트 나왔다는 것으로 로그인 성공
			session.setAttribute("user_id", vo.getId());
			return "redirect:/";	//home컨트롤러의 매핑으로 이동
		}else {
			RA.addFlashAttribute("msg", "아이디 비밀번호를 확인하세요.");
			
			return "redirect:/member/login";
		}
	}
	//로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
	//Ajax 요청 받기
	//JSON라이브러리
	/*
	 * <dependency>
	 * 	<groupId>com.fasterxml.jackson.core</groupId>
	 * 	<artifactId>jackson-databind</artifactId>
	 * 	<version>2.9.8</version>
	 * </dependency>
	 */
	@RequestMapping("/checkId")
	@ResponseBody
	//메소드 @ResponseBody로 어노테이션이 되어 있다면 메소드에서 리턴되는 값은
	//View리졸버로 전달되지 않고, 헤당 메서드로 호출한 곳으로 결과를 반환합니다.
	public int CheckId(@RequestParam("id") String id) {
		
		int result = member.checkId(id);
		
		return result;
	}
	
	@RequestMapping("/updatePw")
	@ResponseBody
	public int updatePw(@SessionAttribute("user_id") String id, @RequestParam("pw") String pw) {
		
		System.out.println(id);
		System.out.println(pw);
		int result = member.updatePw(id, pw);
		
		return result;
	}
	//Ajax_test에 접속
	@RequestMapping("/ajax_test")
	public String test() {
		return "member/ajax_test";
	}
	
	//mypage 요청 받기
	@RequestMapping("/mypage")
	public String mypage() {
		
		return "member/mypage";
	}
	
	//회원 탈퇴 요청
	@RequestMapping("/delete")
	public String delete() {
		
		return "member/delete";
	}
	
	//deleteForm 처리
	@RequestMapping("/deleteForm")
	public String deleteForm(@RequestParam("id") String id, HttpSession session, RedirectAttributes RA
			) {
		
		int result = member.delete(id);
		if(result == 1) {
			session.invalidate();
			return "redirect:/";
		}else {
			RA.addFlashAttribute("msg", "회원 탈퇴에 실패했습니다");
			return "redirect:/member/mypage";
		}
		
		
	}
	//정보 수정 화면 처리
	@RequestMapping("/modify")
	public String modify(@SessionAttribute("user_id") String id, Model model) {
		
		MemberVO vo = member.getInfo(id);
		
		model.addAttribute("vo", vo);
		
		return "member/modify";
	}
	
	@RequestMapping("/updateForm")
	public String update(MemberVO vo, RedirectAttributes RA) {
		
		int result = member.update(vo);
		if(result == 1) {
			return "redirect:/member/mypage";
		}else {
			RA.addFlashAttribute("msg", "수정에 실패했습니다.");
			return "redirect:/member/modify";
		}
		
	}
	
	@RequestMapping("/pwCheck")
	public String pwcheck() {
		
		return "member/pwCheck";
	}
	
	@RequestMapping("/pwForm")
	public String pwForm(MemberVO vo, RedirectAttributes RA) {
		int result = member.login(vo);
		
		if(result == 1) {	//1개의 카운트 나왔다는 것으로 로그인 성공
			return "redirect:/member/pwUpdate";	//home컨트롤러의 매핑으로 이동
		}else {
			RA.addFlashAttribute("msg", "아이디 비밀번호를 확인하세요.");
			
			return "redirect:/member/pwCheck";
		}
	}
	
	@RequestMapping("/pwUpdate")
	public String update() {
		
		return "member/pwUpdate";
	}

}
