package com.example.system.demo;

import com.example.system.demo.test.UserRegisteredEvent;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Locale;

@SpringBootApplication(scanBasePackages = "com.example.system.demo")
public class SpringApplication {

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = org.springframework.boot.SpringApplication.run(SpringApplication.class, args);
        context.publishEvent(new UserRegisteredEvent(context));
    }

}
