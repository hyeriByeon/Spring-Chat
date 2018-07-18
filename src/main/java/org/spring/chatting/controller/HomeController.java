package org.spring.chatting.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Handles requests for the application home page.
 */

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/")
	public String home() {
		logger.info("Welcome home! The client locale is {}.");
		
		return "index";
	}
	
	@RequestMapping("/login")
	public void loggerLogin() {
		logger.info("dddd");
	}
	
	@RequestMapping("/error")
	public String loginError(RedirectAttributes rttr) {
		
		rttr.addFlashAttribute("error", "로그인 실패! 아이디/패스워드을 확인하세요.");
			
		return "redirect:/login";
	}
}
