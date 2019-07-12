package com.githup;



import com.githup.bean.Person;
import com.githup.processor.MyBeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyBeanDefinitionRegistryPostProcessor.class);
        Person person = applicationContext.getBean(Person.class);
        System.out.println(person);
    }
}
