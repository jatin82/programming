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
	        int [] aux = new int[ (n*(n-1)/2) ];
	        
	        
	        for(int i=0;i<n;i++){
	            a[i] = sc.nextInt();
	        }
	        
	        int x = sc.nextInt();
	        
	        int index = 0;
	        for(int i=0;i<n;i++){
	            for(int j=i+1;j<n;j++){
	                aux[index++] = a[i] + a[j];
	            }
	        }
	        
	        Arrays.sort(aux);
	        
	        Map<Integer,Integer> sum = new HashMap<>();
	        
	        for(int i=0;i<aux.length;i++){
	            sum.put(x-aux[i],i);
	        }
	        
	        boolean isFour = false;
	        
	        for(int i=0;i<n;i++){
	            if(sum.containsKey(aux[i])){
	                int current = sum.get(aux[i]);
	                if(i!=current)
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
