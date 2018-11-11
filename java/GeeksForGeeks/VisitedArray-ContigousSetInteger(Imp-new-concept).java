/*

https://practice.geeksforgeeks.org/problems/check-if-array-contains-contiguous-integers-with-duplicates-allowed/0

slow solution: nlogn
fast solution: n

 */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static final String SUCCESS = "Yes";
	public static final String FAILED = "No";
		
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int testCase = sc.nextInt();
	    while(testCase-->0){
	        
	        int n = sc.nextInt();
	        
	        int [] a = new int[n];
	        int max = Integer.MIN_VALUE;
	        int min = Integer.MAX_VALUE;
	        
	        
	        for(int i=0;i<n;i++){
	            a[i] = sc.nextInt();
	            if(max < a[i]){
	                max = a[i];
	            }
	            if(min>a[i]){
	                min = a[i];
	            }
	        }
	        
	        boolean [] isVisited = new boolean[max-min+1];
	        
	        for(int x:a){
	            isVisited[x-min] = true;
	        }
	        
	        boolean isContigous = true;
	        
	        for(boolean x:isVisited){
	            if(!x){
	                isContigous = false;
	            }
	        }
	        
	        System.out.println(isContigous ? SUCCESS : FAILED);
	        
	    }
	    
	}
}
