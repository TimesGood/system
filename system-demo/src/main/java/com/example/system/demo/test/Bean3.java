package com.example.system.demo.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bean3 {
    private static final Logger log = LoggerFactory.getLogger(Bean1.class);
    public Bean3(){
        log.debug("构造 Bean3()");
    }
}
