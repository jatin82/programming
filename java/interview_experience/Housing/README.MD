Arr1   n   |   sorted   |   contains n elements
Arr2   2n |  sorted    | contains first n elements and 2nd part contains null elements

Merge arr1 to arr2 in O(n)


==========
Max n threads
N threads in threads should be in an idle state if no task is submitted.
If the thread pool is running at full capacity, tasks will wait.


Worker Class - n
WorkerExecutor ( n){
List<Worker> workers = new ArrayList<>(); 

}

```
@FunctionalInterface
Interface Task {
	Void execute();
}

Class worker implements Runnable{
	
	Private Volatile LinkedBlockingQueue<Task> queue;
Worker(LinkedBlockingQueue<Task> queue){
	this.queue = queue;
}

Public void run(){
		while(true){
			while(queue.isEmpty()){
			Try{
	queue.wait();	
} catch(Exception){
}		
}

Task task = queue.poll();
task.

}
	
}



}
	

}




Class WorkerExecutor {

	List<Worker> workers;
	LinkedBlockingQueue<Task> queue;
	WorkerExecutor(int n){
		Workers = new ArrayList<>();
		queue = new LinkedBlockingQueue<>();
		for(int i=0;i<n;i++){
	workers.add()
}
}



Public void submit(Executor executor) {
	queue.add(executor);
	queue.notify();
}

}

```
============









```
class First{				
	public void funcA(){			
		synchronized(First.class){
	sleep(5000);		
		            // code here	
}	
	}						
}				
				
				
				
class CustomThread implements Runnable{				
	First obj;			
				
	CustomThread(First obj){			
		this.obj = obj;		
	}			
	run(){			
		obj.funcA();		
	}			
}				
				
class Main{				
	main(){			
		First obj1 = new First();		
		First obj2 = new First();		
		CustomThread t1 = new CustomThread(obj1);		
		CustomThread t2 = new CustomThread(obj2);		
				
		t1.start();		
		t2.start();		
				
	}			
}				
========
String s1 = “jatin”;
String s2 = “jatin”;
String s3 = new String(“jatin”);

s1.equals(s2) //true
S1 == s2        //true
S1 == s3
```
========
Users
- id    PK 
- name varchar
- email varchar
- city varchar
- is_indian boolean
- created_at timestamp
- updated_at timestamp


users_contact_numbers
- id    PK 
- user_id FK
- number varchar
- created_at timestamp
- updated_at timestamp

Select Users.id from Users left join users_contact_numbers as ucn on Users.id = ucn.user_id where ucn.user_id is null;

Q1: Select * from Users where city = ‘Bangalore’ AND created_at > ‘2021-05-01’;
Millions of records in table
100 unique cities

Index = city_created_at
Idx1: is_indian

Q2: SELECT * FROM Users where is_indian = true;
