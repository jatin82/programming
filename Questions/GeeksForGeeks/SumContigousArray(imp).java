

/*

https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0

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
		    int sum = sc.nextInt();
		    
		    int [] a = new int[n];
		    
		    for(int i=0;i<n;i++){
		        a[i] = sc.nextInt();
		    }
		    
		    
		    int currentSum = a[0];
		    int start = 0;
		    int i;
		    
		    for(i=1;i<=n;i++){
		        while(currentSum > sum && start < i-1){
		            currentSum -= a[start++];
		        }
		        
		        if(currentSum == sum){
		            break;
		        }
		        
		        if(i<n)
		            currentSum += a[i];
		    }
		    
		    if(currentSum == sum){
		            System.out.println((start+1)+" "+i);
		    }
		    else{
		        System.out.println(-1);
		    }
		}
	}
}
