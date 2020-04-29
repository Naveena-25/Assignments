package com.capgemini.springcorerevision;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.springcorerevision.bean.Hello;
import com.capgemini.springcorerevision.config.MobileAppConfig;

public class TestAnnotation {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(MobileAppConfig.class);
		Hello hello = context.getBean(Hello.class);
		hello.display();
		context.close();
		
	}
}
