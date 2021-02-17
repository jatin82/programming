## Round 1
### Find the minimum element in a sorted and rotated array

Input: {16, 20, 25, 35(i), 1(i+1), 2, 3, 10}
Output: 1

i > i+1


5 4 3 2 1


2 1

7 8 1 2 3 5 6

<pre>
1. mid < mid+1 && mid < mid-1 return mid

2. mid < a[a.length-1] move towards left side of array

3. else right side.


public int find(int [] a){
	if(a.length==0) return -1;
	if(a.length==1) return a[0]; 

	int n = a.length;
	int lo = 0;
	int hi = n-1;

	while(lo<hi){
		int mid = (lo + hi)>>1;
		if(mid==0){
			if(a[mid] < a[mid+1]) return a[mid];
			else return a[mid+1];
		}
		else if(a[mid] < a[mid-1] && a[mid] < a[mid+1]) return a[mid];
		else if(a[mid] < a[n-1]) hi = mid;
		else lo = mid;
	}
	return a[mid];
}
</pre>

///////////////////////////////////////////

### You need to find the maximum node at each level and print it.


			50
		5       15    
	10		3		1	


Output :
50
15
10

<pre>
1. use bfs -
2. max add to list
3. return list

public List<Integer> maxElementTree(Node node){

	if(node==null) return Collections.EMPTY_LIST:

	ArrayDeque<Node> queue = new ArrayDeque<>();

	List<Integer> list = new ArrayList<>();

	queue.addLast(node);

	while(!queue.isEmpty()){
		int size = queue.size();
		int max = Integer.MIN_VALUE;
		for(int i=0;i<size;i++){
			Node parent = queue.removeFirst();
			max = Math.max(parent.val,max);
			if(parent.left!=null) queue.addLast(parent.left);
			if(parent.right!=null) queue.addLast(parent.right);
		}
		list.add(max);
	}
	return list;
}
</pre>


<pre> HASHMAP WORKING EXPLAIN
</pre>

## ROUND 2

General Discussion
