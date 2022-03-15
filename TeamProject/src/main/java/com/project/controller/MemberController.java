/*     */ package com.project.controller;
/*     */ 
/*     */ import com.project.member.command.MemberVO;
/*     */ import com.project.member.service.MemberService;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
/*     */ import org.springframework.web.servlet.mvc.support.RedirectAttributes;
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping("/member/*")
/*     */ public class MemberController
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private MemberService member;
/*     */ 
/*     */   @RequestMapping("/login")
/*     */   public String login(HttpSession session)
/*     */   {
/*  28 */     session.removeAttribute("id");
/*     */ 
/*  30 */     return "member/mem_login";
/*     */   }
/*     */ 
/*     */   @RequestMapping("/loginForm")
/*     */   public String loginForm(MemberVO vo, HttpSession session, RedirectAttributes RA) {
/*  35 */     int result = member.login(vo);
/*  36 */     if (result == 1) {
/*  37 */       session.setAttribute("user_id", vo.getId());
/*  38 */       return "redirect:/";
/*     */     }
/*  40 */     RA.addFlashAttribute("msg", "아이디 비밀번호를 확인하세요.");
/*     */ 
/*  42 */     return "redirect:/member/login";
/*     */   }
/*     */ 
/*     */   @RequestMapping("/join")
/*     */   public String join()
/*     */   {
/*  51 */     return "member/mem_register";
/*     */   }
/*     */ 
/*     */   @RequestMapping("/joinForm")
/*     */   public String joinForm(MemberVO vo, RedirectAttributes RA)
/*     */   {
/*  59 */     int result = member.join(vo);
/*     */ 
/*  61 */     if (result == 1)
/*  62 */       RA.addFlashAttribute("msg", "회원가입 성공했습니다.");
/*     */     else {
/*  64 */       RA.addFlashAttribute("msg", "회원가입에 실패했습니다.");
/*     */     }
/*     */ 
/*  67 */     return "redirect:/member/login";
/*     */   }
/*     */ 
/*     */   @RequestMapping("/checkId")
/*     */   @ResponseBody
/*     */   public int CheckId(@RequestParam("id") String id)
/*     */   {
/*  77 */     int result = member.checkId(id);
/*     */ 
/*  79 */     return result;
/*     */   }
/*     */ 
/*     */   @RequestMapping("/checkNname")
/*     */   @ResponseBody
/*     */   public int CheckNname(@RequestParam("nickname") String nickname)
/*     */   {
/*  89 */     int result = member.checkNname(nickname);
/*     */ 
/*  91 */     return result;
/*     */   }
/*     */ 
/*     */   @RequestMapping("/mem_logout")
/*     */   public String logout(HttpSession session) {
/*  96 */     session.invalidate();
/*     */ 
/*  98 */     return "redirect:/member/login";
/*     */   }
/*     */ 
/*     */   @RequestMapping("/mem_findId")
/*     */   public String findId()
/*     */   {
/* 104 */     return "/member/mem_findId";
/*     */   }
/*     */ 
/*     */   @RequestMapping("/mem_idResult")
/*     */   public String findIdForm(Model model, MemberVO vo, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("phone1") int phone1, @RequestParam("phone2") int phone2, @RequestParam("question") String question, @RequestParam("answer") String answer, HttpSession session, RedirectAttributes RA)
/*     */   {
/* 111 */     int result = member.findIdCheck(name, phone, phone1, phone2, question, answer);
/*     */ 
/* 113 */     if (result == 1) {
/* 114 */       vo = member.findId(name, phone, phone1, phone2, question, answer);
/*     */ 
/* 116 */       model.addAttribute("vo", vo);
/*     */ 
/* 118 */       return "/member/mem_idResult";
/*     */     }
/* 120 */     RA.addFlashAttribute("msg", "아이디랑 전화번호, 본인확인을 다시 확인해주세요");
/* 121 */     return "redirect:/member/mem_findId";
/*     */   }
/*     */ 
/*     */   @RequestMapping("/mem_findPw")
/*     */   public String findPw()
/*     */   {
/* 128 */     return "/member/mem_findPw";
/*     */   }
/*     */ 
/*     */   @RequestMapping("/findPwForm")
/*     */   public String findPw(@RequestParam("id") String id, @RequestParam("email") String email, @RequestParam("emailAd") String emailAd, RedirectAttributes RA, HttpSession session)
/*     */   {
/* 134 */     int result = member.findPw(id, email, emailAd);
/*     */ 
/* 136 */     if (result == 1) {
/* 137 */       session.setAttribute("user_id", id);
/* 138 */       return "/member/mem_alterPw";
/*     */     }
/* 140 */     RA.addFlashAttribute("msg", "아이디랑 이메일을 확인해주세요.");
/* 141 */     return "redirect:/member/mem_findPw";
/*     */   }
/*     */ 
/*     */   @RequestMapping("mem_alterPw")
/*     */   public String mem_alterPw()
/*     */   {
/* 150 */     return "/member/mem_alterPw";
/*     */   }
/*     */ 
/*     */   @RequestMapping("/updatePwForm")
/*     */   public String updatePwForm(@RequestParam("pw") String pw, @SessionAttribute("user_id") String id, HttpSession session, RedirectAttributes RA)
/*     */   {
/* 157 */     int result = member.updatePw(id, pw);
/*     */ 
/* 159 */     if (result == 1) {
/* 160 */       RA.addFlashAttribute("msg", "변경 되었습니다. 다시 로그인 해주세요.");
/* 161 */       session.invalidate();
/* 162 */       return "redirect:/member/login";
/*     */     }
/* 164 */     RA.addFlashAttribute("msg", "변경에 실패하였습니다.");
/* 165 */     return "redirect:/member/mem_alterPw";
/*     */   }
/*     */ 
/*     */   @RequestMapping("/mem_mypage")
/*     */   public String mypage()
/*     */   {
/* 172 */     return "/member/mem_mypage";
/*     */   }
/*     */ 
/*     */   @RequestMapping("/mem_modify")
/*     */   public String getInfo(@SessionAttribute("user_id") String id, Model model)
/*     */   {
/* 178 */     MemberVO vo = member.getInfo(id);
/*     */ 
/* 180 */     model.addAttribute("vo", vo);
/*     */ 
/* 182 */     return "/member/mem_modify";
/*     */   }
/*     */ 
/*     */   @RequestMapping("/mem_modifyCheck")
/*     */   public String modifyCheck()
/*     */   {
/* 190 */     return "/member/mem_modifyCheck";
/*     */   }
/*     */ 
/*     */   @RequestMapping("/pwCheckForm")
/*     */   public String pwCheckForm(@SessionAttribute("user_id") String id, @RequestParam("pw") String pw, RedirectAttributes RA)
/*     */   {
/* 197 */     int result = member.pwCheck(id, pw);
/*     */ 
/* 199 */     if (result == 1) {
/* 200 */       return "redirect:/member/mem_modify";
/*     */     }
/* 202 */     RA.addFlashAttribute("msg", "비밀번호를 확인해주세요.");
/* 203 */     return "redirect:/member/mem_modifyCheck";
/*     */   }
/*     */ 
/*     */   @RequestMapping("/modifyForm")
/*     */   public String modifyForm(MemberVO vo, RedirectAttributes RA)
/*     */   {
/* 212 */     int result = member.update(vo);
/*     */ 
/* 214 */     if (result == 1) {
/* 215 */       RA.addFlashAttribute("msg", "회원 정보 수정을 완료했습니다.");
/* 216 */       return "redirect:/member/mem_mypage";
/*     */     }
/* 218 */     RA.addFlashAttribute("msg", "회원 정보 수정을 실패하였습니다.");
/* 219 */     return "redirect:/member/mem_modify";
/*     */   }
/*     */ 
/*     */   @RequestMapping("/mem_unregister")
/*     */   public String mem_unregister()
/*     */   {
/* 227 */     return "/member/mem_unregister";
/*     */   }
/*     */ 
/*     */   @RequestMapping("/unregister")
/*     */   public String unregister(@RequestParam("reason") String reason, @RequestParam("cause") String cause, @SessionAttribute("user_id") String id, HttpSession session, RedirectAttributes RA)
/*     */   {
/* 235 */     int result = member.unregister(reason, cause);
/*     */ 
/* 237 */     if (result == 1) {
/* 238 */       member.delete(id);
/* 239 */       session.invalidate();
/* 240 */       RA.addFlashAttribute("msg", "회원탈퇴 처리가 완료되었습니다.");
/* 241 */       return "redirect:/";
/*     */     }
/* 243 */     RA.addFlashAttribute("msg", "회원탈퇴에 실패했습니다.");
/* 244 */     return "redirect:/member/mem_mypage";
/*     */   }
/*     */ }
