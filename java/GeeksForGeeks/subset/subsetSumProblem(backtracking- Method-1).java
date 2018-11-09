

/*

https://practice.geeksforgeeks.org/problems/subset-sum-problem/0

*/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    public static boolean isSumSubset(int index, int[] a,int sum){
        
        if(sum == 0){
            return true;
        }
        if(sum<0 || index>=a.length){
            return false;
        }
        
        return isSumSubset(index+1,a,sum - a[index]) ||
               isSumSubset(index+1,a,sum);
    }
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		
		while(testCase-->0){
		    int n = sc.nextInt();
		    int [] a = new int[n];
		    
		    int sum = 0;
		    
		    for(int i=0;i<n;i++){
		        a[i] = sc.nextInt();
		        sum += a[i];
		    }
		    
		    if(sum%2 != 0){
		        System.out.println("NO");
		    }
		    else{
		        if(isSumSubset(0,a,sum/2)){
    		        System.out.println("YES");
		        }
		        else{
		            System.out.println("NO");
		        }
		    }
		    
		}
	}
}
