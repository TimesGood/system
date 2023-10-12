package com.example.system.demo.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.type.MethodMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;

import java.io.IOException;
import java.util.Set;

public class AtBeanPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        try {
            //读取某配置类
            CachingMetadataReaderFactory factory = new CachingMetadataReaderFactory();
            MetadataReader metadataReader = factory.getMetadataReader(new ClassPathResource("com/example/system/demo/test/Config.class"));
            //查找标注了@Bean注解的方法
            Set<MethodMetadata> methods = metadataReader.getAnnotationMetadata().getAnnotatedMethods(Bean.class.getName());
            for (MethodMetadata method : methods) {

                //获取bean的定义
                BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition();
                builder.setFactoryMethodOnBean(method.getMethodName(),"config");
                builder.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_CONSTRUCTOR);//对于工厂方法和构造方法来讲，要使用AUTOWIRE_CONSTRUCTOR，我们会把配置类来当作一个工厂来看待
                String initMethod = method.getAllAnnotationAttributes(Bean.class.getName()).get("initMethod").toString();
                if (initMethod.length() > 0) builder.setInitMethodName(initMethod);//设置初始化方法
                AbstractBeanDefinition bd = builder.getBeanDefinition();
                //注册
                if(configurableListableBeanFactory instanceof DefaultListableBeanFactory){
                    DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) configurableListableBeanFactory;
                    beanFactory.registerBeanDefinition(method.getMethodName(),bd);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
