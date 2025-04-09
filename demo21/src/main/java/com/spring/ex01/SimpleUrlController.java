package com.spring.ex01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.servlet.ModelAndView;

@Controller
public class SimpleUrlController {
	@RequestMapping("/test/index.do")
	public String handleTest() {
		return "index";
	}
	
	@RequestMapping("/test/login.do")
	public String login(@RequestParam("userID") String userID, @RequestParam("passwd") String passwd, Model model) {
		model.addAttribute("userID", userID);
		model.addAttribute("passwd", passwd);
		return "result";
	}
	/*
	@RequestMapping("/test/index.do")
	public ModelAndView handleTest() {
		return new ModelAndView("index.jsp");
	}*/
}
