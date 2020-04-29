package com.capgemini.springcorerevision.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Hello {
	private int id;
	private String name;
	@Autowired
	@Qualifier("getBattery")
	private Mobile mobile;
	public Hello() {
		System.out.println("Default Hello constructor");
	}

	public Hello(int id,String name,Mobile mobile) {
		this.id=id;
		this.name=name;
		this.mobile=mobile;
	}

	public void display() {
		System.out.println("id......."+id);
		System.out.println("name..."+name);
		mobile.airtel();
		mobile.idea();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@PostConstruct
	public void init() {
		System.out.println("init method");
	}
	@PreDestroy
	public void destroy() {
		System.out.println("Destroy method");
	}
}
