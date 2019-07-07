package com.githup.processor;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Test01 {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ValueBeanPostProcessor.class);
        Object person = applicationContext.getBean("person");
        System.out.println(person);
    }

}
