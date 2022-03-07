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
	//���̺� ���� (id, pw, name, ��¥)
	/*
	 * create table member (
	 * 	id varchar(30) primary key,
	 * 	pw varchar(30) not null,
	 * 	name varchar(30),
	 * 	regdate timestamp default sysdate
	 * );
	 */
	
	//�α��� ȭ��ó��
	@RequestMapping("/login")
	public String login() {
		return "member/login";
	}
	
	//ȸ������ ȭ�� ó��
	@RequestMapping("/join")
	public String join() {
		return "member/join";
	}
	
	//ȸ�� ���� ó��
	@RequestMapping("/joinForm")
	public String joinForm(MemberVO vo, RedirectAttributes RA) {
		
		//���񽺷� join�� ó���ؾ� ��.
		int result = member.join(vo);
		if(result == 1) {	//1�� ��ȯ �޾Ҵٴ� ���� insert�� ����
			RA.addFlashAttribute("msg", "ȸ������ �����߽��ϴ�.");
		}else {		//insert ����
			RA.addFlashAttribute("msg", "ȸ�����Կ� �����߽��ϴ�.");
		}
		return "redirect:/member/login";	//login��Ʈ�ѷ��� ����
	}
	
	@RequestMapping("join_result")
	public String join_result( ) {
		
		return "/member/login";
	}
	
	//login �� ó�� - ����, ����, ����?=> "/" ����? => "login"
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
	//�α׾ƿ�
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
	//Ajax ��û �ޱ�
	//JSON���̺귯��
	/*
	 * <dependency>
	 * 	<groupId>com.fasterxml.jackson.core</groupId>
	 * 	<artifactId>jackson-databind</artifactId>
	 * 	<version>2.9.8</version>
	 * </dependency>
	 */
	@RequestMapping("/checkId")
	@ResponseBody
	//�޼ҵ� @ResponseBody�� ������̼��� �Ǿ� �ִٸ� �޼ҵ忡�� ���ϵǴ� ����
	//View�������� ���޵��� �ʰ�, ��� �޼���� ȣ���� ������ ����� ��ȯ�մϴ�.
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
	//Ajax_test�� ����
	@RequestMapping("/ajax_test")
	public String test() {
		return "member/ajax_test";
	}
	
	//mypage ��û �ޱ�
	@RequestMapping("/mypage")
	public String mypage() {
		
		return "member/mypage";
	}
	
	//ȸ�� Ż�� ��û
	@RequestMapping("/delete")
	public String delete() {
		
		return "member/delete";
	}
	
	//deleteForm ó��
	@RequestMapping("/deleteForm")
	public String deleteForm(@RequestParam("id") String id, HttpSession session, RedirectAttributes RA
			) {
		
		int result = member.delete(id);
		if(result == 1) {
			session.invalidate();
			return "redirect:/";
		}else {
			RA.addFlashAttribute("msg", "ȸ�� Ż�� �����߽��ϴ�");
			return "redirect:/member/mypage";
		}
		
		
	}
	//���� ���� ȭ�� ó��
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
			RA.addFlashAttribute("msg", "������ �����߽��ϴ�.");
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
		
		if(result == 1) {	//1���� ī��Ʈ ���Դٴ� ������ �α��� ����
			return "redirect:/member/pwUpdate";	//home��Ʈ�ѷ��� �������� �̵�
		}else {
			RA.addFlashAttribute("msg", "���̵� ��й�ȣ�� Ȯ���ϼ���.");
			
			return "redirect:/member/pwCheck";
		}
	}
	
	@RequestMapping("/pwUpdate")
	public String update() {
		
		return "member/pwUpdate";
	}

}
