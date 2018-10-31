/*

https://practice.geeksforgeeks.org/problems/set-bits/0

*/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    public static boolean isSetBit(int n,int position){
        return ((n & (1<<position)) != 0);
    }
    
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int testCase = sc.nextInt();
	    while(testCase-->0){
	        int n = sc.nextInt();
	    
	    int length = 0;
	    int temp = n;
	    
	    while(temp!=0){
	        temp = temp >> 1;
	        length++;
	    }
	    //System.out.println(" dsd "+length);
	    
	    int countSetBit = 0;
	    for(int i=0;i<length;i++){
	        if(isSetBit(n,i)){
	            countSetBit++;
	        }
	    }
	    System.out.println(countSetBit);
	    }
	    
	}
}