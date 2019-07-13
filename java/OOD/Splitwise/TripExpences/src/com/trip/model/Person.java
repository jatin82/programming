package com.trip.model;

public class Person implements Comparable<Person>{
	
	private String name;
	
	private float farePaid;
	
	private float balance;
	
	public Person(String name, String farePaid) {
		super();
		this.name = name;
		this.farePaid = Float.parseFloat(farePaid);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getFarePaid() {
		return farePaid;
	}

	public void setFarePaid(float farePaid) {
		this.farePaid = farePaid;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	@Override
	public int compareTo(Person o) {
		return (int)(this.getBalance() - o.getBalance());
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", farePaid=" + farePaid + ", balance=" + balance + "]";
	}
	
	


}
