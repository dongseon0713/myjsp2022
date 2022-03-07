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
	
	//�α��� ȭ�� ó��
	@RequestMapping("/login")
	public String login() {
		
		return "member/mem_login";
	}
	//�α��� formó��
	@RequestMapping("/loginForm")
	public String loginForm(MemberVO vo, HttpSession session, RedirectAttributes RA) {
		int result = member.login(vo);
		if(result == 1) {	//1���� ī��Ʈ ���Դٴ� ������ �α��� ����
			session.setAttribute("user_id", vo.getId());
			return "redirect:/";	//home��Ʈ�ѷ��� �������� �̵�
		}else {
			RA.addFlashAttribute("msg", "���̵� ��й�ȣ�� Ȯ���ϼ���.");
			
			return "redirect:/member/login";
		}
	}
	
	//ȸ������ ȭ��ó��
	@RequestMapping("/join")
	public String join() {
		
		
		return "member/mem_register";
	}
	
	//ȸ������ formó��
	@RequestMapping("/joinForm")
	public String joinForm(MemberVO vo, RedirectAttributes RA) {
		
		//���񽺷� join�� ó��
		int result = member.join(vo);
		
		if(result == 1) {	//1�� ��ȯ �޾Ҵٴ� ���� insert�� ����
			RA.addFlashAttribute("msg", "ȸ������ �����߽��ϴ�.");
		}else {		//insert ����
			RA.addFlashAttribute("msg", "ȸ�����Կ� �����߽��ϴ�.");
		}
				
		return "redirect:/member/login";
	}
	
	@RequestMapping("/checkId")
	@ResponseBody
	//�޼ҵ� @ResponseBody�� ������̼��� �Ǿ� �ִٸ� �޼ҵ忡�� ���ϵǴ� ����
	//View�������� ���޵��� �ʰ�, ��� �޼���� ȣ���� ������ ����� ��ȯ�մϴ�.
	public int CheckId(@RequestParam("id") String id) {
		
		int result = member.checkId(id);
		
		return result;
	}
	
	@RequestMapping("/checkNname")
	@ResponseBody
	//�޼ҵ� @ResponseBody�� ������̼��� �Ǿ� �ִٸ� �޼ҵ忡�� ���ϵǴ� ����
	//View�������� ���޵��� �ʰ�, ��� �޼���� ȣ���� ������ ����� ��ȯ�մϴ�.
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
