package com.zerock.controller;

import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/session/*")
public class SessionController {
	

	
	//���� ����
	//1. main ȭ�� ó��(mainPage)
	@RequestMapping("/mainPage")
	public String mainPage() {
		return "session/mainPage";
	} 
	
	//2. �α��� -> loginPage
	@RequestMapping("/loginPage")
	public String loginPage() {
		return "session/loginPage";
	}
	
	//3. ���������� ȭ�� ó�� -> myPage
	@RequestMapping(value="/myPage", method=RequestMethod.GET)
	public String myPage(HttpSession session) {
		//8. ���������� ���� ����
		// ���� ���̵� ���ٸ� ������ �� ���� �α��� �������� �̵�
		/*
		 * if(session.getAttribute("user_id") == null) { return
		 * "redirect:/session/mainPage"; }
		 * => ���ͼ��� ������ �ּ����� ó��
		 */
			return "session/myPage";
		
		
	}
	
	//4. ���� ���� ������
	@RequestMapping(value="/updatePage", method=RequestMethod.GET)
	public String updatePage() {
		//9. ���� ���̵� ���� ��� ���� ����... ���� ���� ��� �������� �̷��� ó�� �ϸ� �������� ���� �� �ִ�. ���� �ϱ� ���ؼ� ���ͼ��͸� ���....
		//[[���ͼ���(Interceptor)�� �뵵 �� ����]]
		// - �������� ���� �� ����/�ΰ� ���� �۾�
		// - API ȣ�⿡ ���ѷα� �Ǵ� ����
		// - Controller�� �Ѱ��ִ� ����(������)�� ����
		
		return "session/updatePage";
	}
	
	//5. �α��� �� ó��
	@RequestMapping("/sessionLogin")
	public String sessionLogin(@RequestParam("id") String id, @RequestParam("pw") String pw, HttpSession session, RedirectAttributes RA) {
		//���̵� abc, ��й�ȣ�� 1234��� �α��� �����̶� ����		
		if(id.equals("abc") && pw.equals("1234")) {
			//�α��� ������ ���� �� ����
			session.setAttribute("user_id", id); //���ǿ� ID����
			session.setAttribute("user_name", "ȫ�浿"); //���ǿ� �̸� ����
			
			return "redirect:/session/myPage";
		}else {
			//6. ���̵�� ��й�ȣ�� Ʋ���� ��� �ٽ� �α������� ������
			//9. �����̷�Ʈ��  �����鼭 1ȸ�� �����ͷ� �Ķ���� ���� �����ϰ��� �Ҷ� ����Ѵ�.
			RA.addFlashAttribute("msg", "���̵� ��й�ȣ�� Ȯ���ϽǷ���?");
			return "redirect:/session/loginPage";
		}
	}
	
	//7. �α� �ƿ�
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user_id");	//Ư�� ���� ����
		session.invalidate(); 	//���� ��ü ����
		
		return "redirect:/session/mainPage";
	}
	
}
