package com.spring.ex02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAdvice {
	
	@Before("execution(* com.spring.ex02.Calculator.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("[메서드 호출 전 : LogginAdvice");
		System.out.println(joinPoint.getSignature().getName() + "메서드 호출 전");
	}
	
	@AfterReturning("execution(* com.spring.ex02.Calculator.*(..))")
	public void logAfter(JoinPoint joinPoint) {
		System.out.println("[메서드 호출 후 : LoggingAdvice");
		System.out.println(joinPoint.getSignature().getName() + "메서드 호출 후");
	}
}
