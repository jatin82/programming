package general;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
/*

5 1
1 1 1 1 1
1 2
2 3
3 4
1 5

*/
import java.util.Set;

class Test {
	
	// --------------------------Disjoint sets-----------------------------------------
	static class Disjoint{
		int []sets;
		Disjoint(int n){
			sets = new int[n];
			for(int i=0;i<n;i++) sets[i] = -1;
		}
		
		int totalSets(){
			int cnt=0;
			for(int i=0;i<sets.length;i++){
				if(sets[i]==-1)
					cnt++;
			}
			return cnt;
		}
		
		int find(int i){
			if(sets[i]==-1)
				return i;
			return find(sets[i]);
		}
		
		void union(int A,int B){
			int Pa = find(A);
			int Pb = find(B);
			if(Pa!=Pb)   
				sets[Pa] = Pb;
		}	
	}
	//--------------------Seive----------------------
	public static boolean[] sieve(int n){
        
        boolean [] p = new boolean[n+1];
        for(int i=0;i<=n;i++){
            p[i] = true;
        }
        p[2] = true;
        for(int i=2;i*i<=n;i++){
            if(p[i]){
                for(int j=i*i;j<=n;j+=i){
                    p[j] = false;
                }
            }
        }
        return p;
        
    }
	
	
	//---------------------------Inclusion and Exclusion-------------------------------------
	public static long intersect(ArrayList<Integer> ind,long n){
        int p = 1;
        for(int x:ind){
            p *=x;
        }
        return n/p;
    }
    
    //--------------------------GCD-------------------------------------------------------
    public static long gcd(long a,long b){
    	if(b==0)
    		return a;
    	else
    		return gcd(b,a%b);
    }
	//-------------------------------------------
	
	static class node implements Comparable<node>{
	    public int index;
	    public int x;
	    node(int index,int x){
	        this.index = index;
	        this.x = x;
	    }
	    public int compareTo(node o){
	        return o.x-x;
	    }
	}
	//--------------------------precompute------------------------------------------
	public static void fac(long []a,long mod){
	    a[0] = 1;
	    int len = a.length;
	    for(int i=1;i<len;i++){
	        a[i] = (a[i-1]*i)%mod;
	    }
	}
	//------------------------power(n,r) = n^r-----------------------------
	
	public static long power(long n,long r){
		if(r==0)
			return 1;
		else{
			long temp = power(n,r/2)%mod;
			if(r%2==0){
				return (temp*temp)%mod;
			}
			else{
				return (((temp*temp)%mod)*n)%mod;
			}
		}
	}
	//---------------------Power of 2------------------

	
// 	----------------------------Mod defined---------------------------------
	public static final long mod = 1000000007;
// 	-----------------------------------------------------------------------
	public static long findHeightForNewNode(int currentNodeIndex,List<List<Integer>> nodes,long [] height) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(currentNodeIndex);
		
		Set<Integer> visited = new HashSet<>();
		
		while(!queue.isEmpty()) {
			int peek = queue.poll();
			visited.add(peek);
			
			if(nodes.get(peek).size() < 3) { // this 3 not 4
				return height[peek] + 1; // this height addition
			}
			else {
			    for(int node:nodes.get(peek)) {
					if(!visited.contains(node)){
					    queue.add(node);
					}
				}
				
			}
		}
		return -1;
	}
	public static void exploreHeight(int currentNodeIndex, long currentHeight, 
	        List<List<Integer>> nodes, long[] height,Set<Integer> visited) {
		
		height[currentNodeIndex] = currentHeight;
		
		for(int node:nodes.get(currentNodeIndex)) {
		
		    if(!visited.contains(node)){
		        visited.add(node);
			    exploreHeight(node,currentHeight+1,nodes,height,visited);
		    }
		
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		long [] value = new long[n];
		long [] height = new long[n];
		
		for(int i=0;i<n;i++) {
			value[i] = sc.nextLong();
		}
		
		List<List<Integer>> nodes = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
		    List temp = new ArrayList<>();
			nodes.add(temp);
		}
		
		for(int i=0;i<n-1;i++) {
			int u = sc.nextInt()-1;
			int v = sc.nextInt()-1;
			nodes.get(u).add(v);
			nodes.get(v).add(u);
		}
		
		// for root node add parent itself
		nodes.get(0).add(0);
		
		Set<Integer> visited = new HashSet<Integer>();
		visited.add(0);
		exploreHeight(0, 1, nodes, height,visited);
		long ans =(long) (findHeightForNewNode(0,nodes,height) * x);
		
		for(int i=0;i<n;i++) {
			ans += (long)(height[i] * value[i]);
		}
		System.out.println(ans);
		
	}
}