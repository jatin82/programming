package com.trip.model;

public class Pairs implements Comparable<Pairs>{
	
	private Person person;
	
	private int ammount;

	public Pairs(Person person,int ammount) {
		this.person = person;
		this.ammount = ammount;
	}
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public int getAmmount() {
		return ammount;
	}

	public void setAmmount(int ammount) {
		this.ammount = ammount;
	}

	@Override
	public int compareTo(Pairs o) {
		return this.ammount - o.ammount;
	}
	
	

}
