package com.Interview;


class sharedResource{
	private volatile int i;
	
	public sharedResource(int i) {
		this.i=i;
	}

	public int getI() {
		return i;
	}

	public void increment(){
		i++;
	}
}

public class MultithreadFooBar extends Thread {

	public static sharedResource resource = null;
	
	private String msg;
	private int state;
	
	public MultithreadFooBar(String message,int state) {
		this.msg = message;
		this.state = state;
	}
	
	public void run(){
		
		synchronized(resource){
			try{
				while(true){
					if(this.state==resource.getI()%3){
						System.out.print(msg);
						resource.increment();
						resource.notifyAll();
					}
					resource.wait();
				}
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		sharedResource resource = new sharedResource(0);
		MultithreadFooBar.resource = resource;
		MultithreadFooBar foo = new MultithreadFooBar("foo + ",0);
		MultithreadFooBar bar = new MultithreadFooBar("bar = ",1);
		MultithreadFooBar foobar = new MultithreadFooBar("foobar\n",2);
		bar.start();
		foobar.start();
		foo.start();
	}
	
	
}
