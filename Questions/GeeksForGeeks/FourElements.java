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
	            for(int j=i;j<n-1;j++){
	                int index = i * (n-1) + j;
	                aux[index] = 
	            }
	        }
	    
	    }
	    
	    
	}
}