package com.cognizant.truyum;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

public class AppTest {
	
	public static void main(String args[])
	{
		ApplicationContext ctx= new ClassPathXmlApplicationContext("truyum-spring/src/main/resources/spring-config.xml");
		 Object bean = ctx.getBean("menuItems");
		 System.out.println(bean);
		System.out.println("hello");
	}

}
