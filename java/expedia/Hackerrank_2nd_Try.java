package test;

import java.util.Stack;

// This is 2nd try on Hackerrank test
public class Expedia2 {

	public static void main(String[] args) {
		String [] values = {"{}[]()","{[}]"};
		System.out.println(braces(values));
	}
	
	// Q1 : https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
	static String[] braces(String[] values) {
        int n = values.length;
        String[] res = new String[values.length];

        for(int i=0;i<n;i++){
            String str = values[i];
            Stack<Character> s = new Stack<>();
            s.push(str.charAt(0));
            int j = 1;
            for(j=1;j<str.length();j++){
                char c = str.charAt(j);
                
                if(c=='{'||c=='(' || c=='['){
                	s.add(c);
                }
                else{
                	if(s.isEmpty()){
                		res[i] = "NO";
                		break;
                	}
                	char first = s.peek();
                	if((c=='}' && first=='{') || (c==']' && first=='[') || (c==')' && first=='(')){
                		s.pop();
                	}
                	else{
                		s.push(c);
                	}
                }
            }
            if(j<str.length() || !s.isEmpty()){
            	res[i] = "NO";
            }
            else{
            	res[i] = "YES";
            }
        }
        return res;
    }
	
	// Q2 : aaabbbbcdee => a3b4cde2
	public static String compressedString(String str) {
        StringBuilder sb = new StringBuilder();
        char prev = str.charAt(0);
        int count=1;
		for(int i=1;i<str.length();i++){
            char c = str.charAt(i);
			if(c==prev){
				count++;
			}
			else{
				if(count==1){
					sb.append(prev);
					prev = c;
				}
				else{
					sb.append(prev);
					sb.append(count);
					count=1;
					prev = c;
				}
			}
        }
		
		if(count==1){
            sb.append(prev);
        }
        else{
            sb.append(prev);
            sb.append(count);
        }
        return sb.toString();
    }
	
	// Q3 : https://stackoverflow.com/questions/58260014/number-of-ways-to-divide-n-objects-in-k-groups-such-that-no-group-will-have-few
	public static long countOptions(int n, int k) {
        if(k>n) return 0;
        long[][] dp = new long[n+1][n+1];

        dp[0][0] = 1;
        for (int i=1; i<=n; i++){
            int min = Math.min(i, k);
            for (int j=1; j<=min; j++){
                dp[i][j] = dp[i - j][j] + dp[i - 1][j - 1];
            }
        }
        return dp[n][k];
    }
}
