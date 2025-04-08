package com.spring.ex02;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages="com.spring.ex02")
@EnableAspectJAutoProxy
public class AppConfig {

}
