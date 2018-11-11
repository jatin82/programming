/*

https://practice.geeksforgeeks.org/problems/next-larger-element/0 

*/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		
		while(testCase-->0){
		    int n = sc.nextInt();
		    long [] a = new long[n];

		    for(int i=0;i<n;i++){
		        a[i] = sc.nextLong();
		    }

		    Stack<Long> s = new Stack();
		    List<Long> result = new ArrayList<>();
		    
		    s.add(a[n-1]);
		    result.add(-1L);

		    for(int i=n-2;i>=0;i--){
		        while(!s.isEmpty() && a[i] > s.peek()){
                    s.pop();
		        }
		        if(!s.isEmpty()){
		            result.add(s.peek());
		        }
		        else{
		            result.add(-1L);
		        }
		        s.push(a[i]);
		    }
		    Collections.reverse(result);
		    for(long x:result){
		        System.out.print(x+" ");
		    }
		    System.out.println();
		}
	}
}
