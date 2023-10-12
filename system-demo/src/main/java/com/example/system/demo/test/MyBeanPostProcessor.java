package com.example.system.demo.test;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements InstantiationAwareBeanPostProcessor, DestructionAwareBeanPostProcessor {

    private static final Logger log = LoggerFactory.getLogger(MyBeanPostProcessor.class);
    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        log.debug("Bean销毁之前执行，如PreDestory");
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        log.debug("实例化之前执行，还没调用构造方法，这里如果返回对象会替换掉原本的bean");
        return null;
    }

    //实例化之后执行，还没调用构造方法
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        log.debug("实例化之后执行，这里如果放回false，会跳过依赖注入阶段");
        return true;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        log.debug("依赖注入阶段执行，如@Autowired、@Value、@Resource");
        return pvs;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.debug("初始化之前执行，这里返回的对象会替换原本的bean，如@PostConstruct、@ConfigurationProperties");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.debug("初始化之后执行，这里返回的对象会替换原本的bean，如代理增强");
        return InstantiationAwareBeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
