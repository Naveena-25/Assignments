package com.capgemini.springcorerevision.bean;

public class Sim implements Mobile{
	private String simtype;

	private int noOfSims;
	@Override
	public void idea() {
		System.out.println("Idea method");

	}

	@Override
	public void airtel() {
		System.out.println("Airtel Method");

	}
	public String getSimtype() {
		return simtype;
	}

	public void setSimtype(String simtype) {
		this.simtype = simtype;
	}

	public int getNoOfSims() {
		return noOfSims;
	}

	public void setNoOfSims(int noOfSims) {
		this.noOfSims = noOfSims;
	}


}
