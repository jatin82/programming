package com.Interview;

import java.util.NavigableMap;
import java.util.TreeMap;

public class TreemapImpl{
	
	static class test implements Comparable<test>{
		int a;
		public test(int a) {
			this.a = a;
		}
		
		@Override
		public boolean equals(Object obj) {
			System.out.println("equals called");
			test ob = (test)obj;
			return this.a == ob.a;
		}
		
		@Override
		public int hashCode() {
			System.out.println("Hashcode called");
			return this.a;
		}
		
		@Override
		public int compareTo(test o) {
			System.out.println("Comparable is called ::"+this.a+" == "+o.a);
			return this.a - o.a;
		}
	}
	
	public static void main(String[] args) {
		NavigableMap<test, String> map = new TreeMap<>();
		map.put(new test(1), "test");
		map.put(new test(2), "test");
		map.put(new test(3), "test");
		map.put(new test(4), "test");
		
	}

}
