package com.spring.ex01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("person.xml");
		PersonService person1 = context.getBean("personService1", PersonService.class);
		person1.sayHello();
		PersonService person2 = context.getBean("personService2", PersonService.class);
		person2.sayHello();
		context.close();
	}
}
