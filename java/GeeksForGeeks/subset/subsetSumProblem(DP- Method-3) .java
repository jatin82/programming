

/*

https://practice.geeksforgeeks.org/problems/subset-sum-problem/0

*/

import java.util.*;
import java.lang.*;
import java.io.*;


class GFG {
    
    public static void isSumSubset(int[] a, boolean [][] dp, int n, int sum)
    {
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                dp[i][j] = false;
            }
        }
        
        for(int i=0;i<=sum;i++){
            dp[0][i] = false;
        }
        
        for(int i=0;i<=n;i++){
            dp[i][0] = true;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                

	// if sum is below zero then its last optimal set is taken
                if(a[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                    
                else 
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-a[i-1]];
            }
        }
        
        
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
		    
		    
		    boolean [][] dp = new boolean[n + 1][(sum/2) + 1];
		    
		    isSumSubset(a,dp,n,sum/2);
		    
		    
		    if(sum % 2 != 0){
		        System.out.println("NO");
		    }
		    else{
		        
		        if(dp[n][sum/2]){
			        System.out.println("YES");
		        }
		        else{
		            System.out.println("NO");
		        }
		        
		    }
		    
		}
		
	}
}
