package learn.code;



public class LinkedList {

	static class node<T>{
		node right;
		T data;
		public node() {
		}
		
		public node(node left,T t) {
			this.right = left;
			this.data = t;
		}
		
		public node<T> build(T data){
			this.right = new node(null,data); 
			return this.right;
		}
		
		@Override
		public String toString() {
			return this.data+"";
		}
	}
	
	
	public static node<Integer> prepareList(node<Integer> root) {

		root.build(1)
			.build(2)
			.build(3)
			.build(4)
			.build(5)
			.build(6)
			.build(7)
			.build(8);
		
		return root;
				
	}
	
	public static void printLinkedList(node<Integer> root) {
		if(root==null) return;
		System.out.print(root.data);
		System.out.print(" ");
		printLinkedList(root.right);
	}
	
	public static node<Integer> swapInPair(node<Integer> root) {
		if(root==null && root.right == null) return root;
		node<Integer> current = root;
		node<Integer> prev = null;
		
		root = root.right;
		
		
		while(current!=null && current.right !=null) {
			node<Integer> swap = current.right;
			current.right = swap.right;
			
			if(prev!=null) prev.right = swap; // root node
			
			swap.right = current;
			prev = current;
			current = current.right;
			
		}
		
		
		return root;

	}
	
	
	public static void main(String[] args) {
		node<Integer> root = new node<>(null,0);
		prepareList(root);
		
		printLinkedList(root);
		System.out.println();
		
		root = swapInPair(root);
		
		printLinkedList(root);
		System.out.println();
		
		root = swapInPair(root);
		
		printLinkedList(root);
		System.out.println();
	}
	
	
	
	
}
