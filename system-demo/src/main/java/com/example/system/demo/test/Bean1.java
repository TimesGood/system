package com.example.system.demo.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

public class Bean1 {
    private static final Logger log = LoggerFactory.getLogger(Bean1.class);
    private Bean2 bean2;
    private Bean3 bean3;
    private String name;
    public Bean1(){
        log.debug("构造 Bean1()");
    }

    @Autowired
    public void setBean2(Bean2 bean2){
        this.bean2 = bean2;
        log.debug("@Autowired生效：{}",bean2);
    }
    @Resource
    public void setBean3(Bean3 bean3){
        this.bean3 = bean3;
        log.debug("@Resource生效：{}",bean3);
    }
    @Autowired
    public void setName(@Value("${JAVA_HOME}") String name){
        this.name = name;
        log.debug("@Value生效：{}",name);
    }
    @PostConstruct
    public void init(){
        log.debug("@PostConstruct生效");
    }
    @PreDestroy
    public void destroy(){
        log.debug("@PreDestroy生效");
    }

    @Override
    public String toString() {
        return "Bean1{" +
                "bean2=" + bean2 +
                ", bean3=" + bean3 +
                ", name='" + name + '\'' +
                '}';
    }
}
