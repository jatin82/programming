import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

class Test2 {
	
	
	/*
	 * 
	 * 
	 * 
	
	
	
2
8 18
1 2
1 3
2 4
2 5
2 6
3 7
3 8
7 15
1 2
1 3
1 4
2 5
2 6
3 7
	 */
		
// 	----------------------------Mod defined---------------------------------
	public static final long mod = 1000000007;
	
	
	
	public static List<Integer> findAllPairs(List<List<Integer>> tree){
	    List<Integer> lengths = new ArrayList<>();
	    
	    for(int i=0;i<tree.size();i++){
	        List<Integer> current = tree.get(i);
	        if(current.size() == 1){
	           int length = searchLongestPath(tree,i);
	           lengths.add(length);
	        }
	    }
	    return lengths;
	}
	
	public static int searchLongestPath(List<List<Integer>> tree, int pos){
	    
	    
	    int dist[] = new int[tree.size()];
	    
	    Queue<Integer> bfs = new LinkedList<>();
	    bfs.add(pos);
	    dist[pos] = 0;
	    Set<Integer> visited = new HashSet<>();
	    
	    
	    while(!bfs.isEmpty()){
	        int parent = bfs.poll();
	        visited.add(parent);
	        
	        List<Integer> childs = tree.get(parent);
	        
	        for(int i=0;i<childs.size();i++){
	           int child = childs.get(i);
	           if(!visited.contains(child)){
	               bfs.add(child);
	               dist[child] = dist[parent] + 1;
	           }
	        }
	    }
	   int length = dist[0];
	    for(int i=1;i<dist.length;i++){
	        if(length < dist[i]){
	            length = dist[i];
	        }
	    }
	    return length;
	}

// 	-----------------------------------------------------------------------
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in); 
        int testCase = sc.nextInt();
        while(testCase-->0){
            int n = sc.nextInt();
            int s = sc.nextInt();
            
            List<List<Integer>> tree = new ArrayList<>();
            
            for(int i=0;i<n;i++){
                tree.add(new ArrayList<Integer>());
            }
            
            for(int i=0;i<n-1;i++){
                int e = sc.nextInt()-1;
                int v = sc.nextInt()-1;
                tree.get(e).add(v);
                tree.get(v).add(e);
            }
            
            List<Integer> lengths = findAllPairs(tree);
            
            
            boolean isShort = false;
            
            Collections.sort(lengths);
            
            
            int length = lengths.get(0);
            
            
            
            for(int i=1;i<lengths.size() && !isShort;i++){
                if(length < lengths.get(i))
                {
                    isShort = true;
                }
            }
            
            if(isShort){
                System.out.println(0);
            }
            else{
                int ans = s/(n-1);
                if(s % (n-1) == 0){
                    System.out.println(ans);
                }
                else{
                    System.out.println((ans+1));
                }
            }
        }
        
    }
}