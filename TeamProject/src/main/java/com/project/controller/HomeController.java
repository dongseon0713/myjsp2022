package com.project.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.board.service.BoardService;
import com.project.home.command.CounterVO;
import com.project.home.mapper.HomeMapper;
import com.project.home.service.HomeService;


/**
 * Handles requests for the application home page.
 */



@Controller
public class HomeController {
	
	@Autowired
	HomeService service;

	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, CounterVO vo,HttpSession session, Locale locale) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		vo.setSessionid(session.getId());
		this.service.register(vo);
		this.service.update();
		
		int counter = service.getCounter();
		
		model.addAttribute("counter", counter);
		
		
		
		
		
		return "home";
	}
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public String exception(Model model, Locale locale) {
		
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		this.service.update();
		int counter = service.getCounter();
		
		model.addAttribute("counter", counter);
		
		return "home";
	}
	
}
