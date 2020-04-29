package com.capgemini.springcorerevision.bean;

public class Battery implements Mobile{
	private int capacity;
	

	@Override
	public void idea() {
		System.out.println("Iam a Idea Method");
		
	}

	@Override
	public void airtel() {
		System.out.println("I am Airtel Sim ");
		
	}
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
