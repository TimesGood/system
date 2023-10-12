package com.example.system.demo.test;

import com.alibaba.fastjson2.util.AnnotationUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.stereotype.Component;

import java.io.IOException;

public class ComponentScanPostProcessor implements BeanFactoryPostProcessor {
    //执行context.refresh时被调用
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        try {
            //查找某类上标注的ComponentScan注解
            ComponentScan annotation = AnnotationUtils.findAnnotation(Config.class, ComponentScan.class);
            CachingMetadataReaderFactory factory = new CachingMetadataReaderFactory();//读取类的元信息
            AnnotationBeanNameGenerator generator = new AnnotationBeanNameGenerator();
            if(annotation != null) {
                for (String p : annotation.basePackages()) {
                    String path = "classpath:" + p.replace(".", "/") + "/**/*.class";
                    System.out.println(path);
                    //获取该资源下的类
                    Resource[] resources = new PathMatchingResourcePatternResolver().getResources(path);
                    for (Resource resource : resources) {
                        System.out.println(resource);
                        MetadataReader metadataReader = factory.getMetadataReader(resource);
                        //检查是否加了Component注解
                        boolean verify = metadataReader.getAnnotationMetadata().hasAnnotation(Component.class.getName());
                        //检查是否加了Component或派生注解
                        boolean verify1 = metadataReader.getAnnotationMetadata().hasMetaAnnotation(Component.class.getName());
                        if(verify || verify1){
                            //获取bean定义
                            AbstractBeanDefinition bd = BeanDefinitionBuilder
                                    .genericBeanDefinition(metadataReader.getClassMetadata().getClassName())
                                    .getBeanDefinition();
                            //生成bean名称
                            if (configurableListableBeanFactory instanceof DefaultListableBeanFactory) {
                                DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) configurableListableBeanFactory;
                                String name = generator.generateBeanName(bd, beanFactory);
                                //注册进容器
                                beanFactory.registerBeanDefinition(name,bd);
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
