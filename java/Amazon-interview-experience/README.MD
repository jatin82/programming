# LP Question practice
https://www.principle.cards/

# SDE 2 experience 
[October 28, 2020] https://leetcode.com/discuss/interview-experience/913583/Amazon-or-SDE2-or-REJECT<br>


# My Experience
## 1st Round : 
Technical - Asked about the current project working<br>
			1. Redis vs OracleSql <br>
			2. Why Redis for caching <br>
			3. TPS of Login and recharges <br>
			4. TPS for db and redis on both functionality <br>
			5. Consistant Hashing <br>
			6. Any change in system which is already Designed <br>
			<img src="https://github.com/jatin82/programming/blob/master/java/Amazon-interview-experience/media/round1.png" width="1000" height="500" align="centre">

Behavioual - 1 LP Question : Tell me about the time when you focused on Quality of the product while delivering the project

## 2nd Round :

<pre>
Techinal : 

Question 1: Given an array and a linked list.In linked list each node data is derived from the given array, 
currently all the elements in linked list are in random order. Linked list may contain multiple occurrences of elements present in array: 
Goal is to sort all the elements in given linked list according to the order given in the 
array.array: [5, 15, 18, 20,1] LL: Head-> 15->5->20->1->18->15 ... Output: Head->5->15->15->18->20->1 …


Node {
    int val;
    Node next;
}

[5, 15, 18, 20,1] LL: Head-> 15->5->20->1->18->15->null

public Node arrangeLL(int [] a, Node head){
    if(a.length==0) return null;

    Map<Integer,List<Node>> records = new HashMap<>();
    
    Node current = head;
    
    while(current!=null){
        if(!records.containsKey(current.val)){
            records.put(current.val,new ArrayList<>());
        }
        records.get(current.val).add(current);
        current = current.next;
    }
    
    Node newHead = new Node();
    current = newHead;
    
    /*
      []->5->15->18, 20,1
    */
    
    for(int x : a){
        List<Node> nodes = records.get(x);
        for(Node node : nodes){
            current.next = node;
            current = current.next; 
        }
    }
    current.next = null;
    return newHead.next;
}




Question 2: There is an amazon fulfillment centre which contains many shelves.
Shelves contains unit of items like: Shelf1: 4 Shelf2: 3 Shelf3: 5 etc. 
Whenever any items unit enters the FC it should be placed in the self which contains least items.
Whenever items unit exit the FC it should be taken from the self which contains maximum units. 
Which data structure will you use and why.


class Shelf{
    int shelfId;
    List<Item> items;
    String name;
    Location location
    int capacity;
}

class Item{
    int itemId;
    ItemType type;
    String name;
}

LAPU -> 



Shelf1: 4 Shelf2: 4 Shelf3: 5

4-> shelf1, shel2
5->shelf3

enters

TreeMap<Integer,List<Shelfs>> 

first() - > min O(Log n)
last() -> maximum O(Log n)

</pre>

1 LP Question : [Ownership] Tell me about the time 


## 3rd Round

<img src="https://github.com/jatin82/programming/blob/master/java/Amazon-interview-experience/media/round3.png" width="1000" height="500" align="centre">






