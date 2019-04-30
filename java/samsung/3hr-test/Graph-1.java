import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/*
 * 
 *
 
 Desc - Given a graph having edges defining the probability of going to a particular node, 
 say edge u-v denotes the probability of going v from u. you can stay at any node for 10 minutes. 
 Starting from node 1, on which node you will be after T minutes and with what probability.


1
6 10 40
1 2 0.3 1 3 0.7 3 3 0.2 2 4 1 3 4 0.8 4 4 0.1 4 5 0.9 5 6 1 6 3 0.5 6 6 0.5 

2
6 10 40
1 2 0.3 1 3 0.7 3 3 0.2 2 4 1 3 4 0.8 4 4 0.1 4 5 0.9 5 6 1 6 3 0.5 6 6 0.5 
6 10 50
1 2 0.3 1 3 0.7 3 3 0.2 2 4 1 3 4 0.8 4 4 0.1 4 5 0.9 5 6 1 6 3 0.5 6 6 0.5 


3
6 10 40
1 2 0.3 1 3 0.7 3 3 0.2 2 4 1 3 4 0.8 4 4 0.1 4 5 0.9 5 6 1 6 3 0.5 6 6 0.5 
6 10 50
1 2 0.3 1 3 0.7 3 3 0.2 2 4 1 3 4 0.8 4 4 0.1 4 5 0.9 5 6 1 6 3 0.5 6 6 0.5 
6 10 60
1 2 0.3 1 3 0.7 3 3 0.2 2 4 1 3 4 0.8 4 4 0.1 4 5 0.9 5 6 1 6 3 0.5 6 6 0.5 



 */



public class Test2{
	
	
	public static int N;
	public static int E;
	public static int T;
	public static int Answer;
	public static double answerPred;
	
	public static class Pair{
		public int vertex;
		public double prob;
		public int timer;
		public int p;
		Pair(int vertex,double prob){
			this.vertex = vertex;
			this.prob = prob;
		}
		public String toString() {
			return this.vertex + " " +this.prob + " "+ this.timer;
		}
	}
	
	public static class edge{
		public int from;
		public double prob;
		public int to;
		edge(int from,double prob,int to){
			this.from = from;
			this.prob = prob;
			this.to= to;
		}
		public String toString() {
			return this.from + " " +this.prob + " "+ this.to;
		}
		
		@Override
		public int hashCode() {
			return this.from + (int)this.prob + this.to;
		}
		@Override
			public boolean equals(Object obj) {
				edge obj1 = (edge) obj;
				return obj1.from==this.from && obj1.to==this.to && this.prob==obj1.prob;
			}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		while(testCase-->0) {
			int N = sc.nextInt();
			int E = sc.nextInt();
			int T = sc.nextInt();
			HashSet<edge> visited = new HashSet<>();
			
			List<List<Pair>> graph = new ArrayList<>();
			for(int i=0;i<E;i++) {
				graph.add(new ArrayList<>());
			}
			
			for(int i=0;i<E;i++) {
				int from = sc.nextInt()-1;
				int to = sc.nextInt() -1;
				double weight = sc.nextDouble();
				graph.get(from).add(new Pair(to, weight));
			}
			double [] pred = new double[N];
//			Queue<Pair> queue = new PriorityQueue<Pair>((t1,t2)->{
//				return t1.timer - t2 .timer;
//			});
			
			Queue<Pair> queue = new LinkedList<Pair>();
			
			Pair current = new Pair(0,1);
			pred[0] = 1;
			queue.add(current);
			int time = 0;
			
			boolean flag = true;
			
			while(!queue.isEmpty() && flag) {
				Pair parent = queue.poll();
				if(parent.timer>T) break;
				
				if(parent.vertex==0) pred[parent.vertex] = pred[parent.p];
				else pred[parent.vertex] += parent.prob * pred[parent.p];
				
				if(parent.timer == time && answerPred < pred[parent.vertex]) {
					answerPred = pred[parent.vertex];
					Answer = parent.vertex+1;
				}
				else if(parent.timer != time){
					time = parent.timer;
					answerPred = pred[parent.vertex];
					Answer = parent.vertex+1;
				}
				
				for(Pair child:graph.get(parent.vertex)) {
					edge temp = new edge(parent.vertex, child.prob, child.vertex);
					if(parent.vertex != child.vertex && !visited.contains(temp)) {
						int currentTime = parent.timer + 10;
						double newProb = child.prob;
						Pair childAdd = new Pair(child.vertex,newProb);
						childAdd.timer = currentTime;
						childAdd.p = parent.vertex;
						queue.add(childAdd);
						visited.add(new edge(parent.vertex, child.prob, child.vertex));
					}
				}
			}
			
			if(time<T) {
				Answer=-1;
				answerPred = 0;
			}
			
			System.out.println(Answer+" "+answerPred);
		}
	}
	
}
