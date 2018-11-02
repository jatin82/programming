/*

https://practice.geeksforgeeks.org/problems/bit-difference/0

*/


import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		
		while(testCase-->0){
		    int c = sc.nextInt() ^ sc.nextInt();
		    
		    int temp = c;
		    int count = 0;
    		
    		
		    while(temp !=0){
		        if( (temp & 1) !=0  ){
		            count++;
		        }
		        temp = temp >> 1;
		    }
		    
		    System.out.println(count);
		    
		}
	}
}
