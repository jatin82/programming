package com.query.QueryApp.model;

public class PlayerDetails {

	private String name;
	private int age;
	private String photo;
	private String value;
	private String wage;
	private long potential;
	private long overall;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getWage() {
		return wage;
	}

	public void setWage(String wage) {
		this.wage = wage;
	}

	public long getPotential() {
		return potential;
	}

	public void setPotential(long potential) {
		this.potential = potential;
	}

	public long getOverall() {
		return overall;
	}

	public void setOverall(long overall) {
		this.overall = overall;
	}

	@Override
	public String toString() {
		return "PlayerDetails  [name=" + name + ", age=" + age + ", photo=" + photo + ", value=" + value
				+ ", wage=" + wage + ", potential=" + potential + ", overall=" + overall + "]";
	}
	
	
}
