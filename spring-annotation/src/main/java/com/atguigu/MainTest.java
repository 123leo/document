package com.atguigu;

import com.atguigu.bean.MyJavaBean;
import com.atguigu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig;

public class MainTest {

	@Autowired
	private BookService bookService;

	@SuppressWarnings("resource")
	public static void main(String[] args) {

//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
//		Person bean = (Person) applicationContext.getBean("person");
//		System.out.println(bean);
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		MyJavaBean bean = (MyJavaBean) applicationContext.getBean("myJavaBean");

		System.out.println("===============下面输出结果============");
		System.out.println("描述：" + bean.getDesc());
		System.out.println("备注：" + bean.getRemark());


		//Person bean = applicationContext.getBean(Person.class);
		//System.out.println(bean);
		
		/*String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
		for (String name : namesForType) {
			System.out.println(name);
		}*/
	
	}



}
