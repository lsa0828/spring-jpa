package com.spring.ex02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CalcTest {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Calculator cal = context.getBean(Calculator.class);
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
