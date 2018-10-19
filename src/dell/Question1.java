//https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/practice-problems/algorithm/bob-and-cities-dfc06921/description/

package dell;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Question1 {
	
	private static long findHouse(String [] inp,long [] moves,
			ArrayList<HashSet<Integer>> visited,long power,int x,int y) {
		int n = inp.length;
		int m = inp[0].length();
		
		if(power < 0 || x < 0 || x >= n  || y < 0 || y >= m ) {
			return  0;
		}
		
		int count = 0;
		if(inp[x].charAt(y) == '#' || visited.get(x).contains(y))
			count = 0;
		else
			count = 1;
		visited.get(x).add(y);
		count += findHouse(inp,moves,visited,power-moves[0],x,y-1);//left
		count += findHouse(inp,moves,visited,power-moves[1],x,y+1);//right
		count += findHouse(inp,moves,visited,power-moves[2],x-1,y);//up
		count += findHouse(inp,moves,visited,power-moves[3],x+1,y);//down
		
		
		return count;
	}
	
	private static long findHouseUtil(String [] inp,long [] moves,int x,int y,long power) {
		ArrayList<HashSet<Integer>> visited = new ArrayList<>();
		for(int i=0;i<inp.length;i++) {
			visited.add(new HashSet<Integer>());
		}
		
		int count = 0;
		if(inp[x].charAt(y) == '#')
			count = 0;
		else
			count = 1;
		
		visited.get(x).add(y);
		
		count += findHouse(inp,moves,visited,power-moves[0],x,y-1);//left
		count += findHouse(inp,moves,visited,power-moves[1],x,y+1);//right
		count += findHouse(inp,moves,visited,power-moves[2],x-1,y);//up
		count += findHouse(inp,moves,visited,power-moves[3],x+1,y);//down
		
		
		return count;
		
	}
	
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		String s = sc.nextLine();
		
		String [] inp = new String[n];
		for(int i=0;i<n;i++) {
			inp[i] = sc.nextLine();
		}
		
		long[] moves = new long[4];
		
		for(int i=0;i<4;i++) {
			moves[i] = sc.nextLong();
		}
		
		int x = sc.nextInt()-1;
		int y = sc.nextInt()-1;
		
		int q = sc.nextInt();
		
		while(q-->0) {
			long power = sc.nextLong();
			long count = findHouseUtil(inp,moves,x,y,power);
			System.out.println(count);
		}
	}
	
	
	
}
