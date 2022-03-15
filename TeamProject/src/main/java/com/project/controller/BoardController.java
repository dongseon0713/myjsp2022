package com.project.controller;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.project.board.command.BoardVO;
import com.project.board.command.Criteria;
import com.project.board.command.PageVO;
import com.project.board.service.BoardService;
import com.project.comment.command.CommentVO;
import com.project.comment.service.CommentService;
import com.project.util.UploadFileUtils;


/*     */ @Controller
/*     */ @RequestMapping("/board/")
/*     */ public class BoardController
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   BoardService service;
/*     */ 
/*     */   @Autowired
/*     */   CommentService serviceC;
/*     */ 
/*     */   @Resource(name="uploadPath")
/*     */   private String uploadPath;
/*     */ 
/*     */   @RequestMapping("/list")
/*     */   public String getList(Model model, Criteria cri, @RequestParam("city") String city_b) {
/*  44 */     cri.setCity_b(city_b);
/*     */ 
/*  46 */     System.out.println(cri.getCity_b());
/*     */ 
/*  48 */     ArrayList<BoardVO> list = service.getList(cri);
/*     */ 
/*  50 */     model.addAttribute("board", list);
/*  51 */     model.addAttribute("city", city_b);
/*     */ 
/*  53 */     int total = service.getTotal(city_b);
/*     */ 
/*  55 */     model.addAttribute("page", new PageVO(total, cri));
/*     */ 
/*  57 */     return "board/list";
/*     */   }
			
/*     */ 
/*     */   @RequestMapping(value="/register", method=RequestMethod.GET)
/*     */   public String submitBoard()
/*     */   {
/*  63 */     System.out.println("화면처리");
/*     */ 
/*  66 */     return "board/register";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value="/register", method=RequestMethod.POST)
/*     */   public String submit(BoardVO vo, MultipartFile file) throws Exception
/*     */   {
/*  72 */     System.out.println("등록처리");
/*     */ 
/*  74 */     String city = vo.getCity_b();
/*  75 */     String imgUploadPath = uploadPath + File.separator + "imgUpload";
/*  76 */     String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
/*  77 */     String fileName = null;
/*     */ 
/*  79 */     if ((file.getOriginalFilename() != null) && (file.getOriginalFilename() != ""))
/*  80 */       fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
/*     */     else {
/*  82 */       fileName = this.uploadPath + File.separator + "images" + File.separator + "none.png";
/*     */     }
/*     */ 
/*  85 */     vo.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
/*  86 */     vo.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
/*     */ 
/*  88 */     this.service.register(vo);
/*     */ 
/*  90 */     return "redirect:/board/list?city=" + city;
/*     */   }
/*     */ 
/*     */   @RequestMapping("/content")
/*     */   public String getContent(@RequestParam("num") int num, Model model)
/*     */   {
/*  96 */     System.out.println(num);

			  this.service.boardHit(num);
/*     */ 
/*  98 */     BoardVO vo = service.getContent(num);
/*  99 */     ArrayList<CommentVO> list = serviceC.getList(num);
/*     */ 
/* 101 */     model.addAttribute("content", vo);
/* 102 */     model.addAttribute("comment", list);
/*     */ 
/* 104 */     return "board/content";
/*     */   }
/*     */ 
/*     */   @RequestMapping("/modify")
/*     */   public String modify(@RequestParam("num") int num, @SessionAttribute("user_id") String user_id, Model model) {
			  
	          int result = service.getmodifyinfo(num, user_id);
	          
	          if (result == 1) {
	        	  BoardVO vo = this.service.getContent(num);
	        	  model.addAttribute("content", vo);
	           	  return "board/modify";
	          } else {
	        	  return "redirect:/board/content?num=" + num;
	          }
/*     */   }
/*     */ 
/*     */ 
@RequestMapping("/update")
/*     */   public String update(BoardVO vo)
/*     */   {
/* 121 */     String city = vo.getCity_b();
/* 122 */     System.out.println(vo.getName());
/*     */ 
/* 124 */     this.service.updateBoard(vo);
/*     */ 
/* 126 */     return "redirect:/board/list?city=" + city;
/*     */   }
/*     */ 
/*     */   @RequestMapping("/delete")
/*     */   public String delete(@RequestParam("num") int num, @RequestParam("city") String city)
/*     */   {
/* 133 */     this.service.deleteBoard(num);
/*     */ 
/* 135 */     return "redirect:/board/list?city=" + city;
/*     */   }
/*     */ 
/*     */   @RequestMapping("/commentSubmit")
/*     */   public String submit(@RequestParam("uniquenum") int num, CommentVO vo, RedirectAttributes RA) {
/* 140 */     vo.setUniquenum(num);
/* 141 */     int result = serviceC.submit(vo);
/*     */ 	  System.out.println(result);
/* 143 */     return "redirect:/board/content?num=" + num;
/*     */   }
/*     */ 
/*     */   @RequestMapping("/commentDelete")
/*     */   public String delete(@RequestParam("uniquenum") int uniquenum, @RequestParam("num") int num, RedirectAttributes RA)
/*     */   {
/* 204 */     int result = serviceC.delete(num);
/*     */ 
/* 206 */     System.out.println(result);
/*     */ 
/* 208 */     if (result == 1) {
/* 209 */       RA.addFlashAttribute("co", "댓글이 삭제되었습니다.");
/*     */     }
/*     */ 
/* 212 */     return "redirect:/board/content?num=" + uniquenum;
/*     */   }

			@RequestMapping("/search")
			public String search(@RequestParam("search") String search, Model model, Criteria cri) {
				
				cri.setCity_b(search);
				System.out.println(cri.getCity_b());
				ArrayList<BoardVO> list = service.getSearchList(cri);
				
				model.addAttribute("board", list);
				model.addAttribute("city", search);
				
				int total = service.getSearchTotal(search);
				
				model.addAttribute("page", new PageVO(total, cri));
				
				return "board/searchList";
			}
			
			@RequestMapping("/searchList")
			public String searchList(@RequestParam("search") String search, Model model, Criteria cri) {
				
				cri.setCity_b(search);

				ArrayList<BoardVO> list = service.getSearchList(cri);
				
				model.addAttribute("board", list);
				model.addAttribute("city", search);
				
				int total = service.getSearchTotal(search);
				
				model.addAttribute("page", new PageVO(total, cri));
				
				return "board/searchList";
			}
/*     */ }

