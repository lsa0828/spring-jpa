package com.spring.ex01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("person.xml");
		PersonService person = context.getBean("personService", PersonService.class);
		// PersionService person = new PersionServiceImpl();
		person.sayHello();
	}
}
