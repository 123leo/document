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

//������==�����ļ�
@Configuration  //����Spring����һ��������
@ComponentScans(value = {@ComponentScan(value = "com.atguigu.bean")})
//@ComponentScan  value:ָ��Ҫɨ��İ�
//excludeFilters = Filter[] ��ָ��ɨ���ʱ����ʲô�����ų���Щ���
//includeFilters = Filter[] ��ָ��ɨ���ʱ��ֻ��Ҫ������Щ���
//FilterType.ANNOTATION������ע��
//FilterType.ASSIGNABLE_TYPE�����ո��������ͣ�
//FilterType.ASPECTJ��ʹ��ASPECTJ���ʽ
//FilterType.REGEX��ʹ������ָ��
//FilterType.CUSTOM��ʹ���Զ������
public class MainConfig implements BeanFactoryPostProcessor, BeanPostProcessor{


	@Autowired
	private BookService bookService;
	
	//��������ע��һ��Bean;����Ϊ����ֵ�����ͣ�idĬ�����÷�������Ϊid
	//@Bean("person")
	//@Lazy
	public Person person01(){
		return new Person("lisi", 20);
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		/*System.out.println("�������Զ����BeanFactoryPostProcessor " + beanFactory);
		Iterator it = beanFactory.getBeanNamesIterator();

		String[] names = beanFactory.getBeanDefinitionNames();
		// ��ȡ�����е�bean�����б�
		for(int i=0; i<names.length; i++){
			String name = names[i];

			BeanDefinition bd = beanFactory.getBeanDefinition(name);
			System.out.println(name + " bean properties: " + bd.getPropertyValues().toString());
			// ������ֻ�Ǹ�demo����ӡ���е�bean���������
		}*/
		System.out.println("����MyBeanFactoryPostProcessor��postProcessBeanFactory");
		BeanDefinition bd = beanFactory.getBeanDefinition("myJavaBean");
		MutablePropertyValues pv =  bd.getPropertyValues();
		if (pv.contains("remark")) {
			pv.addPropertyValue("remark", "��BeanFactoryPostProcessor���޸�֮��ı�����Ϣ");
		}
		System.out.println("===========================================================");
	}



	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("BeanPostProcessor������" + beanName + "���ó�ʼ������֮ǰ�����ݣ� " + bean.toString());
		if(bean instanceof MyJavaBean){
			((MyJavaBean) bean).setRemark("99999999999999999999999");
			System.out.println("1111111111111111111111111");
		}
		return bean;

	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("BeanPostProcessor������" + beanName + "���ó�ʼ������֮������ݣ�" + bean.toString());
		return bean;
	}
}
