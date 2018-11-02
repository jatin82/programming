/*
https://practice.geeksforgeeks.org/problems/four-elements/0

2
3
2 2 1
6
6
1 5 1 0 6 0
7

output:
0
1

*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;



class GFG {
	
	static class node{
		int first;
		int second;
		int sum;
		
		public node(int first,int second,int sum) {
			this.first = first;
			this.second = second;
			this.sum = sum;
		}
		public String toString() {
			return first + "-" + second +" = "+sum;
		}
	}
	
	
	public static void main (String[] args) {
	
	    Scanner sc = new Scanner(System.in);
	    int testCase = sc.nextInt();
	    
	    while(testCase-->0){
	        int n = sc.nextInt();

	        int [] a = new int[n];
	        List<node> aux = new ArrayList();
	        
	        
	        for(int i=0;i<n;i++){
	            a[i] = sc.nextInt();
	        }
	        
	        int x = sc.nextInt();
	        
	        int index = 0;

	        for(int i=0;i<n;i++){
	            for(int j=i+1;j<n;j++){
					int temp = a[i] + a[j];
					aux.add(new node(i,j,temp));
	            }
	        }
	        
	        //Collections.sort(aux, (node a1,node a2) -> a1.sum - a2.sum );
	        
	        Map<Integer,node> sum = new HashMap<>();
	        
			
	        for(int i=0;i<aux.size();i++){
	            sum.put(x-aux.get(i).sum,aux.get(i));
	        }
	        
	        boolean isFour = false;
	        
	        for(int i=0;i<aux.size() && !isFour;i++){

	            if(sum.containsKey(aux.get(i).sum)){
	                node current = aux.get(i);
	                node got = sum.get(current.sum);
	                
	                if(current.first!=got.first && current.first!=got.second && current.second!=got.second && current.second!=got.first)
	                    isFour = true;
	            }
	        }
	        
	        if(isFour){
	            System.out.println(1);
	        }
	        else{
	            System.out.println(0);
	        }
	    }
	}
}