package com.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootExampleApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootExampleApplication.class, args);
		
		Book b = ctx.getBean(Book.class);
		
		System.out.println(b);
	}
}
