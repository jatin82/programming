/*
 * 
 *  DP + Bitmasking + Graph
 *  
 *  https://www.hackerearth.com/practice/algorithms/graphs/hamiltonian-path/practice-problems/algorithm/fredos-crush-2/
 */

package general;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class HamiltonPath {

	private static void printDp(List<List<Boolean>> dp) {
		for(List s : dp) {
			System.out.println(s.toString());
		}
	}
	
	private static void printGraph(List<Set<Integer>> graph) {
		for(Set s : graph) {
			System.out.println(s.toString());
		}
	}
	
	private static List<List<Boolean>> findHamiltonPath(List<Set<Integer>> graph) {
		
		List<List<Boolean>> dp = new ArrayList<>();
		int n = graph.size();

		int [] sum = new int[n];
		
				
		for(int i=0;i<n;i++) {
			sum[i] = i+1;
			dp.add(new ArrayList<Boolean>());
		}
		
		for(int i=0;i<(1<<n);i++) {
			for(int j=0;j<n;j++) {
				dp.get(j).add(false);
			}
		}
		
		for(int i=0;i<n;i++) {
			dp.get(i).set(1<<i, true);
		}
		
		
		
		for(int i=0;i<(1<<n);i++) {
			for(int j=0;j<n;j++) {
				if( (i & (1<<j))!=0  ) {
					for(int k=0;k<n;k++) {
						if(j!=k && ((i & (1<<k))!=0) && graph.get(j).contains(k)) {
							if(dp.get(k).get(i ^ (1<<j))) {
								dp.get(j).set(i, true);
								
								break;
							}
						}
					}
				}
			}
		}
		return dp;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		while(testCase-->0) {
			List<Set<Integer>> graph = new ArrayList<>();
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			for(int i=0;i<n;i++) {
				graph.add(new HashSet<Integer>());
			}
			
			for(int i=0;i<m;i++) {
				int e = sc.nextInt()-1;
				int v = sc.nextInt()-1;
				graph.get(e).add(v);
				graph.get(v).add(e);
			}
			
			printGraph(graph);
			List<List<Boolean>> dp  = findHamiltonPath(graph);
			printDp(dp);
		}
	}
}

/*
 * 

1
3 2
1 2
2 3

 * 
 * 
 */

