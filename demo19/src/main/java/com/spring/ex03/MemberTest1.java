package com.spring.ex03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberTest1 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("member.xml");
		MemberService member = context.getBean("memberService", MemberService.class);
		member.listMembers();
	}
}
