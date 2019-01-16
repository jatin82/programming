import java.util.Scanner;

class Test2{
	
/*

8
5 10 30 21 22 24 25 40

 */
	
	
	private static int findLisRec(int [] a,int n) {

		int maxLis = 1;
		
		if(n==0)
			return 1;
		
		for(int i=0;i<n;i++) {
			int res = findLis(a,i);
			if(a[i] < a[n] && (res+1)>maxLis) {
				maxLis = res + 1;
			}
		}
		return maxLis;
		
	}
	
	private static int findLis(int [] a,int n) {
		
		int[] lis = new int[n]; 
		lis[0] = 1;
		
		for(int j=0;j<n;j++) {
			int maxLis = 1;
			for(int i=0;i<j;i++) {
				int res = lis[i];
				if(a[i] < a[j] && (res+1)>maxLis) {
					maxLis = res + 1;
				}
			}
			lis[j] = maxLis; 
		}
		return lis[n-1];
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
