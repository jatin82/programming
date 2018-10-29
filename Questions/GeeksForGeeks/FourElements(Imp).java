/*
https://practice.geeksforgeeks.org/problems/four-elements/0

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

	        int [] a = new int[n];
	        int [] aux = new int[(n*(n-1)/2)];
	        
	        for(int i=0;i<n;i++){
	            for(int j=i+1;j<n;j++){
	                int index = i * (n-1-i) + j;
	                aux[index] = a[i] + a[j];
	            }
	        }
	        int x = sc.nextInt();
	        Arrays.sort(aux);
	        
	        Set<Integer> sum = new HashSet<>();
	        
	        for(int i=0;i<aux.length;i++){
	            sum.add(x-aux[i]);
	        }
	        
	        boolean isFour = false;
	        
	        for(int ele:sum){
	            if(sum.contains(ele)){
	                isFour = true;
	            }
	        }
	        
	        if(isFour){
	            System.out.println(1);
	        }
	        else{
	            System.out.println(0);
	        }
	    }
	}
}
