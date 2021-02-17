## ROUND 1 : Passed

### Question 1
<b> Add 2 numbers in a String </b>

s1 = "456789089"
s2 = "789878989"

s3 = "78"

<pre>
public String add(String s1, String s2){
	
	if(s2==null) return s1;
	if(s1==null) return s2;

    if(s1.isEmpty()) return s2;
	if(s2.isEmpty()) return s1;

	int carry = 0;             

	/*

	s1 = 727
	s2 = 494
	s3 = "1221" -> 1221
	carry = 1

*/
	int i=s1.length()-1;
	int j=s2.length()-1;

	StringBuilder s3 = new StringBuilder();

	while(i>=0 || j>=0){
		int a = 0;
		int b = 0;
		if(i>=0) a = (int)(s1.charAt(i--) - '0');
		if(j>=0) b = (int)(s2.charAt(j--) - '0');

		int sum = a + b + carry;
		carry = sum/10;
		s3.append(Character.valueOf(sum%10));
	}
	if(carry!=0) s3.append(carry);

	return s3.reverse().toString();
}
</pre>


### Question 2
<b> Intersection point of 2 LinkedList </b>

9->8->5->4->3->2->1
         | 
      7->6  


l1 = 7

l2 = 6


7-6 = 1

### Approach 1
<pre>
class Node{
	int val;
	Node next;
}

public Node findIntersection(Node l1, Node l2){
	
	if(l1 == null || l2 == null) return null;

	Set<Node> set = new HashSet<>();

	Node itr = l1;
	while(itr!=null){
		set.add(itr);
		itr = itr.next;
	}
	itr = l2;
	while(itr!=null){
		if(set.contains(itr)) return itr;
		itr = itr.next;
	}
	return null;
}
</pre>

### Approach 2

9->8->5->4->3->2->1
         
      7->6  

<pre>
public Node findIntersection(Node l1, Node l2){

	if(l1 == null || l2 == null) return null;
	int len1 = length(l1);
	int len2 = length(l2);
	if(len1 > len2) return intersect(l1,l2,len1,len2);
	return intersect(l2,l1,len2,len1);
}


private Node intersect(Node node1, Node node2, int l1, int l2){
	
	int diff = l1 - l2;

	while(diff-- > 0) node1 = node1.next;

	while(l2-->0){
		if(node1 == node2) return node1;
		node1 = node1.next;
		node2 = node2.next;
	}
	return null;
}

private int length(Node node){
	int len = 0;
	while(node!=null) {
		node = node.next;
		len++;
	}
	return len;
}
</pre>


### Question 3
<b> Is pair with target sum in Array </b>

sum = 6

3 4 8 2

out = true

Map<Integer,Integer>

key -> array value
value-> array index

time - O(N)
space - O(N)


sum = 6

3 4 8 2

1. Sorting 2 3 4 8
2. 2 pointer searching

i = 0;
j = 2;

Time - N Log n
space - O(1)


## ROUND 2 : Passed

Question : Design LRU cache on leetcode

https://leetcode.com/problems/lru-cache/

<b>Also, Design Publisher and Subscriber in LRUCache</b>

<pre>
class LRUCache {
    
    private LRUCacheHelper<Integer,Integer> helper;
    
    public LRUCache(int capacity) {
        helper = new LRUCacheHelper(capacity);
        helper.addSubscriber((k)->{
            // System.out.println("Key got evicted :: "+k);
        });    
    }
    
    public int get(int key) {
        try{
            return helper.get(key);
        } catch(Exception ex){
            return -1;
        }
    }
    
    public void put(int key, int value) {
         helper.put(key,value);
    }
}


public class Node<K,V>{
    public V val;
    public K key;
    public Node<K,V> next;
    public Node<K,V> prev;
    
    Node(K key, V value){
        this.key = key;
        this.val = value;
    }
}

@FunctionalInterface
interface Subscriber<K>{
    void executeLog(K key);
}


class LRUCacheHelper<K,V>{
    
     private Map<K, Node<K, V>> records;
    private Node<K, V> head;
    private Node<K, V> last;
    private List<Subscriber<K>> subscribers;

    private int size;
    private int maxCapacity;


    public LRUCacheHelper(int capacity) {
        size = 0;
        maxCapacity = capacity;
        records = new HashMap<>();
        subscribers = new ArrayList<>();
    }

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public V get(K key) throws Exception {
        if (records.containsKey(key)) {
            updateCache(key);
            return records.get(key).val;
        }
        throw new Exception("Key Not found");
    }

    public void put(K key, V value) {
        if (!records.containsKey(key)) {
            if (size == maxCapacity) {
                processEvict();
            }
            Node<K, V> node = addNode(key, value);
            records.put(key, node);
        } else {
            records.get(key).val = value;
            updateCache(key);
        }
    }

    private void updateCache(K key) {
        if (head.next == null) return;
        Node node = records.get(key);
        if(head==node) return;
        if(node == last){
            last = node.prev;
        }
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        if (next != null) next.prev = prev;

        node.prev = null;
        node.next = head;
        head.prev = node;
        head = node;
    }

    private void processEvict() {
        records.remove(last.key);
        Node prev = last.prev;
        K key = last.key;
        if (prev == null) {
            head = null;
            last = null;
        } else {
            prev.next = null;
            last.prev = null;
            last = prev;
        }
        logSubscriber(key);
        size--;

    }

    private void logSubscriber(K key) {
        CompletableFuture<Void> task = CompletableFuture.supplyAsync(() -> {
            subscribers.forEach(subscriber -> {
                subscriber.executeLog(key);
            });
            return null;
        });
    }

    private Node<K, V> addNode(K key, V value) {
        Node addedNode = null;
        if (head == null) {
            addedNode = new Node(key, value);
            head = addedNode;
            last = head;
        } else {
            addedNode = new Node(key, value);
            addedNode.next = head;
            head.prev = addedNode;
            head = addedNode;
        }
        size++;
        return addedNode;
    }
    
}

/*
["LRUCache","put","get","put","get","put","get","put","get","get","get"]
[[1],[1,1],[1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]

["LRUCache","get","put","get","put","put","get","get"]
[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]

*/



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
 </pre>
 
 Code failing on leetcode base test case
 
 ## ROUND 3 : HM
 to be update...
 
 
 
