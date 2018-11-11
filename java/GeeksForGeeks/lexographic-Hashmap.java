/*

https://practice.geeksforgeeks.org/problems/winner-of-an-election-where-votes-are-represented-as-candidate-names/0

*/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		while(testCase-->0){
		    int n = sc.nextInt();
		    
		    Map<String,Integer> counts = new HashMap<>();
		    for(int i=0;i<n;i++){
		        String name = sc.next();
		        if(!counts.containsKey(name)){
		            counts.put(name,0);
		        }
		        int temp = counts.get(name);
		        counts.put(name,++temp);
		    }
		    
		    String name = "";
		    int count = -1;
		    
		    for(String str : counts.keySet()){
		        int currentCount = counts.get(str);
		        if(currentCount>count || ( currentCount == count && str.compareTo(name) < 0)){
		            name = str;
		            count = currentCount;
		        }
		    }
		    System.out.println(name + " " + count);
		}
	}
}
