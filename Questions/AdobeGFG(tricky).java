/*


https://practice.geeksforgeeks.org/problems/check-if-strings-are-rotations-of-each-other-or-not/0


2
asdfas
dfasas
me
mee

output:
1
0

*/



public class GFG {

	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		while(testCase-->0) {
			String s1 = sc.next();
			String s2 = sc.next();
			
			int s1Index = 0;
			
			if(s1.length()!=s2.length()) { // trick
				System.out.println(0);
			}
			else {
				for(int i=0;i<2 * s2.length() && s1Index <s1.length();i++) {
					
					int s2Index = i % s2.length();
					
					if(s1.charAt(s1Index) == s2.charAt(s2Index)) {
						s1Index++;
					}
					else if(s1.charAt(0)==s2.charAt(s2Index)){ // trick
						s1Index = 1;
					}
					else {
						s1Index = 0;
					}
				}
				if(s1Index == s1.length()) {
					System.out.println(1);
				}
				else
					System.out.println(0);
			}
		}
	}
	
	
}