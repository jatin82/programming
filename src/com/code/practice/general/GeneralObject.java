package com.code.practice.general;

public class GeneralObject {
	
	Object obj;
	
	public void setObject(Object obj) {
		obj = new Object();
	}
	
	public GeneralObject() {
	}
	
	
	public static void main(String[] args) {
		GeneralObject obj1 = new GeneralObject();
		obj1.setObject(obj1.obj);
		System.out.println(obj1.obj.toString());
	}
	
	
}
