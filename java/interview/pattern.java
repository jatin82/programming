import java.util.Scanner;

/*
 
***** 
 ***
  *
 
testCase:
 
4
5
7
9
13
 
 
 
 */


public class Pattern {

	
	public static void drawPattern(int n) {
		
		int count=0;
		while(n>=1) {
			
			for(int i=0;i<count;i++) System.out.print(" ");
			for(int i=0;i<n;i++) System.out.print("*");
			for(int i=0;i<count;i++) System.out.print(" ");
			
			count++;
			n = n-2;
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		
		while(testCase-->0) {
			int n = sc.nextInt();
			drawPattern(n);
		}
		
	}
	
	
	
}

