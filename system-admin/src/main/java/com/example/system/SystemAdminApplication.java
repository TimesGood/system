package com.example.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SystemAdminApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SystemAdminApplication.class, args);
		String[] beans = ctx.getBeanDefinitionNames();

		for(String bean:beans){

			System.out.println(bean);

		}
	}

}
