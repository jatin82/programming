import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

class Test4 {

	static class node{
	    public int slave;
	    public int master;
	    node(int slave,int master){
	        this.slave = slave;
	        this.master = master;
	    }
	    public String toString() {
			return this.slave + " "+this.master;
		}
	}
	
	private static int getCountDelDirectory(List<List<Integer>> a,Set<Integer> search) {
		
		Queue<node> bfs = new LinkedList<>();
		node node = new node(0,-1);
		bfs.add(node);
		int count = 0;
		while(!bfs.isEmpty()) {
			node current = bfs.poll();
			int master = current.master;
			if(current.master==-1 && search.contains(current.slave)) {
				count++;
				master = current.slave;
			}
			search.remove(current.slave);
			for(int child : a.get(current.slave)) {
				bfs.add(new node(child,master));
			}
		}
		return count;
	}
	
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<List<Integer>>a = new ArrayList<>(n);
		for(int i=0;i<n;i++) {
			a.add(new ArrayList<>());
		}
		for(int i=0;i<n;i++) {
			int current = sc.nextInt();
			if(current!=-1) {
				a.get(current-1).add(i);
			}
		}
		int m = sc.nextInt();
		Set<Integer> search = new HashSet<Integer>(m);
		
		for(int i=0;i<m;i++) {
			search.add(sc.nextInt()-1);
		}
		
		int ans = getCountDelDirectory(a,search);
		System.out.println(ans);
	}
	
	/**
	 * 
12
-1 1 1 3 3 4 5 5 1 2 2 10
6
2 12 8 11 7 6




	 */
	
}
