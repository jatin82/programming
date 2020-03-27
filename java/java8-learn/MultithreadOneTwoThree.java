package com.Interview;

import java.util.concurrent.atomic.AtomicInteger;

public class Multithread extends Thread{

	private static AtomicInteger counter = new AtomicInteger(0);
	private int status;
	
	public Multithread(int status) {
		this.status = status;
	}
	
	@Override
	public void run() {
		super.run();
		try{
			synchronized (counter) {
				while(true){
					if(this.status == counter.get()%3 ){
						System.out.println(counter.getAndIncrement());
						counter.notifyAll();
					}
					counter.wait();
				}
			}
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Multithread t1 = new Multithread(0);
		Multithread t2 = new Multithread(1);
		Multithread t3 = new Multithread(2);
		t1.start();
		t2.start();
		t3.start();
	}
}
