package com.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zerock.command.JoinVO;
import com.zerock.service.JoinService;

@Controller
@RequestMapping("/join/*")
public class JoinServiceController {
	
	@Autowired
	JoinService joinService;
	
	@RequestMapping("/join_ex01")
	public String join() {
		return "join/join_ex01";
	}
	
	@RequestMapping("/join")
	public ModelAndView join(JoinVO vo,Model model, RedirectAttributes RA) {
		
		
		ModelAndView mav = new ModelAndView();
		
		joinService.joinMember(vo);
		model.addAttribute("joinInfo", vo);
		mav.setViewName("join/join_mypage");

		
		return mav;
	}
}
