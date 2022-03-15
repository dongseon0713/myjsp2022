package com.project.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
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
	public String login(HttpSession session) {
		session.removeAttribute("id");
		
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
	
	//아이디 중복 검사
	@RequestMapping("/checkId")
	@ResponseBody
	//메소드 @ResponseBody로 어노테이션이 되어 있다면 메소드에서 리턴되는 값은
	//View리졸버로 전달되지 않고, 헤당 메서드로 호출한 곳으로 결과를 반환합니다.
	public int CheckId(@RequestParam("id") String id) {
		
		int result = member.checkId(id);
		
		return result;
	}
	
	//닉네임 중복검사
	@RequestMapping("/checkNname")
	@ResponseBody
	//메소드 @ResponseBody로 어노테이션이 되어 있다면 메소드에서 리턴되는 값은
	//View리졸버로 전달되지 않고, 헤당 메서드로 호출한 곳으로 결과를 반환합니다.
	public int CheckNname(@RequestParam("nickname") String nickname) {
		
		int result = member.checkNname(nickname);
		
		return result;
	}
	//로그아웃 처리
	@RequestMapping("/mem_logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/member/login";
	}
	//아이디 찾기 화면처리
	@RequestMapping("/mem_findId")
	public String findId() {
		
		return "/member/mem_findId";
	}
	//아이디 찾기 폼처리
	@RequestMapping("/mem_idResult")
	public String findIdForm(Model model, MemberVO vo,@RequestParam("name") String name,
			@RequestParam("phone") String phone, @RequestParam("phone1") int phone1,@RequestParam("phone2") int phone2,
			@RequestParam("question") String question, @RequestParam("answer") String answer,HttpSession session, RedirectAttributes RA) {
		int result = member.findIdCheck(name, phone, phone1, phone2, question, answer);
		
		if(result == 1) {
			vo = member.findId(name,phone,phone1,phone2,question,answer);

			model.addAttribute("vo", vo);
			
			return "/member/mem_idResult";
		}else {
			RA.addFlashAttribute("msg", "아이디랑 전화번호, 본인확인을 다시 확인해주세요");
			return "redirect:/member/mem_findId";
		}				
	}
	//비밀번호 찾기 화면 처리
	@RequestMapping("/mem_findPw")
	public String findPw() {
		
		return "/member/mem_findPw";
	}
	//비밀번호 찾기 폼 처리
	@RequestMapping("/findPwForm")
	public String findPw(@RequestParam("id") String id, @RequestParam("email") String email ,@RequestParam("emailAd") String emailAd, RedirectAttributes RA,HttpSession session) {
		
		int result = member.findPw(id,email,emailAd);
		
		if(result == 1) {
			session.setAttribute("user_id", id);
			return "/member/mem_alterPw"; 
		}else {
			RA.addFlashAttribute("msg", "아이디랑 이메일을 확인해주세요.");
			return "redirect:/member/mem_findPw";
		}
		
	}

	//비밀번호 변경 화면 처리
	@RequestMapping("mem_alterPw")
	public String mem_alterPw() {
		
		return "/member/mem_alterPw";
	}

	//비밀번호 변경 폼처리
	@RequestMapping("/updatePwForm")
	public String updatePwForm(@RequestParam("pw") String pw,@SessionAttribute("user_id") String id,HttpSession session,RedirectAttributes RA) {

		int result = member.updatePw(id,pw);
		
		if(result == 1) {
			RA.addFlashAttribute("msg", "변경 되었습니다. 다시 로그인 해주세요.");
			session.invalidate();
			return "redirect:/member/login";
		}else {
			RA.addFlashAttribute("msg", "변경에 실패하였습니다.");
			return "redirect:/member/mem_alterPw";
		}
	}
	//마이페이지 화면 처리
	@RequestMapping("/mem_mypage")
	public String mypage() {
		
		return "/member/mem_mypage";
	}
	//회원 정보 수정 페이지 화면처리
	@RequestMapping("/mem_modify")
	public String getInfo(@SessionAttribute("user_id") String id, Model model) {
		
		MemberVO vo = member.getInfo(id);
		
		model.addAttribute("vo", vo);
		
		return "/member/mem_modify";
	}
	
	//정보 수정 전 검증 페이지
	@RequestMapping("/mem_modifyCheck")
	public String modifyCheck() {
		
		
		return "/member/mem_modifyCheck";
	}
	
	//정보 수정 전 유효성 검사
	@RequestMapping("/pwCheckForm")
	public String pwCheckForm(@SessionAttribute("user_id") String id , @RequestParam("pw") String pw, RedirectAttributes RA) {
		
		int result = member.pwCheck(id, pw);
		
		if(result == 1) {
			return "redirect:/member/mem_modify";
		}else {
			RA.addFlashAttribute("msg", "비밀번호를 확인해주세요.");
			return "redirect:/member/mem_modifyCheck";
		}
		
	}
	
	//회원 정보 수정 폼 처리
	
	 @RequestMapping("/modifyForm") 
	 public String modifyForm(MemberVO vo, RedirectAttributes RA) { 
		 int result = member.update(vo);
	 
		 if(result == 1) { 
			 RA.addFlashAttribute("msg", "회원 정보 수정을 완료했습니다."); 
			 return "redirect:/member/mem_mypage"; 
		 }else { 
			 RA.addFlashAttribute("msg", "회원 정보 수정을 실패하였습니다."); 
			 return "redirect:/member/mem_modify"; 
		 } 
	 }
	 
	//회원 탈퇴 처리 페이지
	@RequestMapping("/mem_unregister")
	public String mem_unregister() {
		
		return "/member/mem_unregister";
	}
	
	//회원 탈퇴 폼 처리
	@RequestMapping("/unregister")
	public String unregister(@RequestParam("reason") String reason , @RequestParam("cause") String cause, @SessionAttribute("user_id") String id ,
								HttpSession session, RedirectAttributes RA) {
		
		int result = member.unregister(reason,cause);
		
		if(result == 1) {
			member.delete(id);
			session.invalidate();
			RA.addFlashAttribute("msg", "회원탈퇴 처리가 완료되었습니다.");
			return "redirect:/";
		}else {
			RA.addFlashAttribute("msg", "회원탈퇴에 실패했습니다.");
			return "redirect:/member/mem_mypage";
		}
		
	}
}