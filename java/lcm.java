import java.util.Scanner;

class lcm{
	
/*

1
2 3 4

 */
	
	public static int gcd(int a,int b) {
		if(b==0) return a;
		return gcd(b,a%b);
	}
	
	public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        while(testCase-->0) {
        	int n = sc.nextInt();
            int ans = sc.nextInt();
        	for(int i=1;i<n;i++) {
        		int next = sc.nextInt();
            	ans = ((ans * next)/gcd(ans,next));
            }
        	System.out.println(ans);
        }

    }
}
