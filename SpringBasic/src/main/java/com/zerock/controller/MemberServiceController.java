package com.zerock.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zerock.command.MemberVO;
import com.zerock.service.MemberService;

@Controller
@RequestMapping("/service/*")
public class MemberServiceController {
	
	@Autowired
	MemberService memberService;
	
	//화면처리(연습)
	@RequestMapping("/member_ex01")
	public String member_ex01() {
		return "service/member_ex01";
	}
	//화면처리(회원가입)
	@RequestMapping("/member_ex00")
	public String member_ex00() {
		//회원 정보 입력
		return "service/member_ex00";
	}
	//회원 가입처리 메서드
	@RequestMapping("/join")
	public String join(MemberVO vo) {
		
		memberService.insertMember(vo);
		
		return "service/member_ex02";
	}
	
	//로그인 화면처리
	@RequestMapping("member_ex03")
	public String member_ex03() {
							
		return "service/member_ex03";
		
	}
	
	
	//로그인 메서드 처리
	@RequestMapping("/login")
	public ModelAndView login(MemberVO vo, Model model, RedirectAttributes RA) {
		
		//로그인 유효성 검사(서비스로 아이디를 전달)                
		int result = memberService.memberCheck(vo);
		
		//modelAndView로 변경하기
		ModelAndView mav = new ModelAndView();
		
		if(result == 1) {	//로그인 성공
			model.addAttribute("memberInfo", vo);
			mav.setViewName("service/member_mypage");
			return mav;	//로그인 성공시 전달할 페이지
			
		}else {		//로그인 실패 로그인 페이지로 이동
			RA.addFlashAttribute("msg", "아이디 또는 비밀번호를 확인해주세요!!");
			//redirect를 사용하는 경우에 ModelAndView는 addObject()로 값을 추가한 경우 오류 발생.
			mav.setViewName("redirect:/service/member_ex03");
			return mav;
		}
		
	}
	

	
	//전통적인 방식
	@RequestMapping(value="/memlogin" , method=RequestMethod.POST)
	public String memlogin(Model model, HttpServletRequest request) {
		
		String memid = request.getParameter("memid");
		String mempw = request.getParameter("mempw");
		
		model.addAttribute("memId", memid);
		model.addAttribute("memPw", mempw);
		
		return "service/result";
	}
	
	//RequestParam 어노테이션을 이용한 HTTP전송 정보 얻기
	@RequestMapping(value="/memlogin2" , method=RequestMethod.POST)
	public String memlogin(Model model, @RequestParam("memid") String memid, @RequestParam("mempw") String mempw) {
		
		model.addAttribute("memId", memid);
		model.addAttribute("memPw", mempw);
		
		return "service/result";
	}
	
	//커멘드를 이용한 HTTP전송 정보 처리
	@RequestMapping(value="/memlogin3" , method=RequestMethod.POST)
	public String memlogin3(Model model ,MemberVO vo) {
		
		System.out.println(vo.getId());
		System.out.println(vo.getPw());
		
		model.addAttribute("memId", vo.getId());
		model.addAttribute("memPw", vo.getPw());
		
		return "service/result";
	}
}
