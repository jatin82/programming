/*

https://practice.geeksforgeeks.org/problems/print-this-pattern/0

*/

import java.util.*;
import java.lang.*;
import java.io.*;

/*

4444444
4333334
4322234
4321234
4322234
4333334
4444444

*/


class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		
		while(testCase-->0){
		    int n = sc.nextInt();
		    List<StringBuilder> str = new ArrayList<>();
	        
		    for(int i=0;i<n;i++){
		        int ele = n;
		        StringBuilder sb = new StringBuilder();
		        for(int j=0;j<((2*n) - 1);j++){
		            
		            
		            if(j<n){
		                if(i>=j){
		                    ele = n - j;
		                }
		            }
		            else{
		                int temp = n - j%n - 1;
		                if(temp<=i){
		                    ele++;
		                }
		            }
		            sb.append(ele);
		            
		        }
		        str.add(sb);
		    }
		    for(int i=0;i<n;i++){
		        System.out.println(str.get(i).toString());
		    }
		    for(int i=n-2;i>=0;i--){
		        System.out.println(str.get(i).toString());
		    }
		}
	}
}
