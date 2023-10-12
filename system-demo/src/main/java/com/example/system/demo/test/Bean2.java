package com.example.system.demo.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class Bean2 {
    private static final Logger log = LoggerFactory.getLogger(Bean1.class);
    public Bean2(){
        log.debug("构造 Bean2()");
    }
}
