package com.atguigu.config;

import com.atguigu.bean.MyJavaBean;
import com.atguigu.service.BookService;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;

import com.atguigu.bean.Person;
import org.springframework.stereotype.Controller;

import java.util.Iterator;

//配置类==配置文件
@Configuration  //告诉Spring这是一个配置类
@ComponentScans(value = {@ComponentScan(value = "com.atguigu.bean")})
//@ComponentScan  value:指定要扫描的包
//excludeFilters = Filter[] ：指定扫描的时候按照什么规则排除那些组件
//includeFilters = Filter[] ：指定扫描的时候只需要包含哪些组件
//FilterType.ANNOTATION：按照注解
//FilterType.ASSIGNABLE_TYPE：按照给定的类型；
//FilterType.ASPECTJ：使用ASPECTJ表达式
//FilterType.REGEX：使用正则指定
//FilterType.CUSTOM：使用自定义规则
public class MainConfig implements BeanFactoryPostProcessor, BeanPostProcessor{


	@Autowired
	private BookService bookService;
	
	//给容器中注册一个Bean;类型为返回值的类型，id默认是用方法名作为id
	//@Bean("person")
	//@Lazy
	public Person person01(){
		return new Person("lisi", 20);
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		/*System.out.println("调用了自定义的BeanFactoryPostProcessor " + beanFactory);
		Iterator it = beanFactory.getBeanNamesIterator();

		String[] names = beanFactory.getBeanDefinitionNames();
		// 获取了所有的bean名称列表
		for(int i=0; i<names.length; i++){
			String name = names[i];

			BeanDefinition bd = beanFactory.getBeanDefinition(name);
			System.out.println(name + " bean properties: " + bd.getPropertyValues().toString());
			// 本内容只是个demo，打印持有的bean的属性情况
		}*/
		System.out.println("调用MyBeanFactoryPostProcessor的postProcessBeanFactory");
		BeanDefinition bd = beanFactory.getBeanDefinition("myJavaBean");
		MutablePropertyValues pv =  bd.getPropertyValues();
		if (pv.contains("remark")) {
			pv.addPropertyValue("remark", "在BeanFactoryPostProcessor中修改之后的备忘信息");
		}
		System.out.println("===========================================================");
	}



	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("BeanPostProcessor，对象" + beanName + "调用初始化方法之前的数据： " + bean.toString());
		if(bean instanceof MyJavaBean){
			((MyJavaBean) bean).setRemark("99999999999999999999999");
			System.out.println("1111111111111111111111111");
		}
		return bean;

	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("BeanPostProcessor，对象" + beanName + "调用初始化方法之后的数据：" + bean.toString());
		return bean;
	}
}
