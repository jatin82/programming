import java.util.Scanner;

public class Test2 {

	
	/*
	 * 
	 * my recursive way 
	 * problem here is the coin duplicacy 
	 * see the memoization method findAllWaysDP
	 * 
	 */
	public static int findAllWays(int sum, int[] a, int coin) {
		if(sum==0) {
			return 1;
		}
		if(sum<0) {
			return 0;
		}
		int ways = 0;
		for(int i=coin;i<a.length;i++) {
			ways += findAllWays(sum - a[i],a,i);
		}
		return ways;
	}
	
	
	
	/*
	 * 
	 * Method uses dp but failed to handle duplicacy and returns wrong answer
	 *  as relationship mapped reversed in this for loop
	 * 
	 * i.e. for every sum-->coin is dependent, as mentioned in below for loop
	 * 
	 * but actually sum is dependent on every coin, so for loop should be reversed.
	 * 
	 * also recursive solutions in not properly following DP
	 * 
	 */
	public static int findAllWaysDP(int sum, int[] a) {
		
		int [] dp = new int[sum+1];
		dp[0] = 1; // if sum is zero
		
		for(int i=1;i<=sum;i++) {
			dp[i] = allWays(dp,i,a);
		}
		
		return dp[sum];
	}
	
	
	public static int allWays(int dp[],int sum,int [] a) {
		int ways = 0;
			for(int j=0;j<a.length;j++) {
				int temp = sum - a[j];
				if(temp>=0) {
					ways += dp[temp];
//					ways+= allWays(dp,sum-a[j],a,j);
				}
			}
		return ways;
	}
	
	public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        
        while(testCase-->0) {
        	int m = sc.nextInt();
        	int a[] = new int[m];
        	for(int i=0;i<m;i++) {
        		a[i] = sc.nextInt();
        	}
        	int n = sc.nextInt();
        	System.out.println(findAlldp(n,a));
        }
        
    }
	
	
	/*
	 * 
	 * THE CORRECT SOLUTION
	 * actually sum is dependent on every coin
	 * look for geeks for geeks DP-7
	 * 
	 */
	public static int findAlldp(int n, int [] a) {
		int dp[] = new int[n+1];
		dp[0] = 1;
		
		for(int i=0;i<a.length;i++) {
			for(int j=a[i];j<=n;j++) {
				dp[j] += dp[j-a[i]];
			}
		}
		
		return dp[n];
	}
	
}
