package com.atguigu.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import com.atguigu.bean.Color;
import com.atguigu.bean.ColorFactoryBean;
import com.atguigu.bean.Person;
import com.atguigu.bean.Red;
import com.atguigu.condition.LinuxCondition;
import com.atguigu.condition.MyImportBeanDefinitionRegistrar;
import com.atguigu.condition.MyImportSelector;
import com.atguigu.condition.WindowsCondition;


@Conditional({WindowsCondition.class})
@Configuration
@Import({Color.class,Red.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {
	

//	@Scope("prototype")
	@Lazy
	@Bean("person")
	public Person person(){
		System.out.println("�����������Person....");
		return new Person("����", 25);
	}
	

	
	@Bean("bill")
	public Person person01(){
		return new Person("Bill Gates",62);
	}
	
	@Conditional(LinuxCondition.class)
	@Bean("linus")
	public Person person02(){
		return new Person("linus", 48);
	}
	

	@Bean
	public ColorFactoryBean colorFactoryBean(){
		return new ColorFactoryBean();
	}
	
	
	
	
	
	

}