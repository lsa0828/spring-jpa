package com.spring.pro28.ex03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class LocaleController {
	
	@RequestMapping(value="/test/locale.do", method= {RequestMethod.GET})
	public String locale(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("localeController입니다.");
		return "locale";
	}
}
