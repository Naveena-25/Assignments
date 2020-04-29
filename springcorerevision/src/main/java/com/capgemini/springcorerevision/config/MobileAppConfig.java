package com.capgemini.springcorerevision.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.capgemini.springcorerevision.bean.Battery;
import com.capgemini.springcorerevision.bean.Hello;
import com.capgemini.springcorerevision.bean.Sim;

@Configuration
public class MobileAppConfig {
	@Bean
	 @Scope("prototype")
	 public Hello getHello() {
		 Hello hello = new Hello();
		 hello.setId(5);
		 hello.setName("Naveena");
		 return hello;
	 }
	 @Bean
	
	 public Sim getSim() {
		 Sim sim = new Sim();
		 sim.setNoOfSims(4);
		 sim.setSimtype("dual");
		 sim.airtel();
		 sim.idea();
		 return sim;
	 }
	 @Bean
	 @Primary
	 public Battery getBattery() {
		 Battery b = new Battery();
		 b.setCapacity(2000);
		 b.airtel();
		 b.idea();
		 return b;
	 }
}
