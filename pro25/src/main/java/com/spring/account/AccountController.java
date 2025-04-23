package com.spring.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {
	@Autowired
	private AccountService accService;
	
	@GetMapping("/sendMoney")
	public String sendMoney() throws Exception {
		accService.sendMoney();
		return "result";
	}
}
