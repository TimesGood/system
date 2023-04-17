package com.example.system.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.system.**")
public class SystemDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemDemoApplication.class, args);
    }

}
