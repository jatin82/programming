import java.util.Scanner;

class Test2{
	
/*

8
5 10 30 21 22 24 25 40


16
0 8 4 12 2 10 6 14 1 9 5 13 3 11 7 15

6
0 8 4 12 2 10

 */
	
	private static int findLisRec(int [] a,int n) {

		int maxLis = 1;
		
		if(n==0)
			return 1;
		
		for(int i=0;i<n;i++) {
			int res = findLisRec(a,i);
			if(a[i] < a[n] && (res+1)>maxLis) {
				maxLis = res + 1;
			}
		}
		return maxLis;
		
	}
	
	private static int findLis(int [] a,int n) {
		int[] lis = new int[n]; 
		int maxLisSoFar=-1;
		for(int j=0;j<n;j++) {
			int maxLis = 1;
			for(int i=0;i<j;i++) {
				int res = lis[i] + 1;
				if(a[i] < a[j] && res>maxLis) {
					maxLis = res;
				}
			}
			lis[j] = maxLis; 
			if(maxLisSoFar < lis[j]) {
				maxLisSoFar = lis[j];
			}
		}
		return maxLisSoFar;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] a = new int[n];
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(findLis(a,n));
	}
}
