package com.spring.ex02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonTest2 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("person.xml");
		PersonService person1 = context.getBean("personService1", PersonService.class);
		person1.sayHello();
		
		PersonService person2 = context.getBean("personService2", PersonService.class);
		person2.sayHello();
	}
}
