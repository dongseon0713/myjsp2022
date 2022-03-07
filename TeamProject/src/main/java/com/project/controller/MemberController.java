package com.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.member.command.MemberVO;
import com.project.member.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService member;
	
	//로그인 화면 처리
	@RequestMapping("/login")
	public String login() {
		
		return "member/mem_login";
	}
	//로그인 form처리
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
	
	//회원가입 화면처리
	@RequestMapping("/join")
	public String join() {
		
		
		return "member/mem_register";
	}
	
	//회원가입 form처리
	@RequestMapping("/joinForm")
	public String joinForm(MemberVO vo, RedirectAttributes RA) {
		
		//서비스로 join을 처리
		int result = member.join(vo);
		
		if(result == 1) {	//1을 반환 받았다는 것은 insert가 성공
			RA.addFlashAttribute("msg", "회원가입 성공했습니다.");
		}else {		//insert 실패
			RA.addFlashAttribute("msg", "회원가입에 실패했습니다.");
		}
				
		return "redirect:/member/login";
	}
	
	@RequestMapping("/checkId")
	@ResponseBody
	//메소드 @ResponseBody로 어노테이션이 되어 있다면 메소드에서 리턴되는 값은
	//View리졸버로 전달되지 않고, 헤당 메서드로 호출한 곳으로 결과를 반환합니다.
	public int CheckId(@RequestParam("id") String id) {
		
		int result = member.checkId(id);
		
		return result;
	}
	
	@RequestMapping("/checkNname")
	@ResponseBody
	//메소드 @ResponseBody로 어노테이션이 되어 있다면 메소드에서 리턴되는 값은
	//View리졸버로 전달되지 않고, 헤당 메서드로 호출한 곳으로 결과를 반환합니다.
	public int CheckNname(@RequestParam("nickname") String nickname) {
		
		int result = member.checkNname(nickname);
		
		return result;
	}
	
	@RequestMapping("/mem_logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/member/login";
	}
	@RequestMapping("/mem_findId")
	public String findId() {
		
		return "/member/mem_findId";
	}
	

		
	
}
