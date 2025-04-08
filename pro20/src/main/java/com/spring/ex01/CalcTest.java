package com.spring.ex01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcTest {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("AOPTest.xml");
		Calculator cal = context.getBean("proxyCal", Calculator.class);
		cal.add(100, 20);
		System.out.println();
		cal.subtract(100, 20);
		System.out.println();
		cal.multiply(100, 20);
		System.out.println();
		cal.divide(100, 20);
		context.close();
	}
}
