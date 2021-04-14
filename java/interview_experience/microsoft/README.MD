## ROUND 1

1. Explain Solid principles
2. Differenc between 2 large numbers. just explained concept, moved onto next question
3. Evaluate Expression.


[9:16 AM] Yogesh Prajapati
    
exp = "( 2 + 2 ( 3 + 3 ) )"

string Evaluate(string exp)
​[9:17 AM] Yogesh Prajapati
    
exp = "( 2 + 2 + ( 3 + 3 ) )"


( 2 + 2 + ( 3 + 3 ) + ( 3 + 3 ) + ( 3 + 3 ) )

exp = "( 2 + 2 + ( 3 + 3 ) + ( 3 - 3 ) + ( 3 + 3 ) )"
[9:55 AM] Yogesh Prajapati
    
exp = "( 2 + 2 + ( 3 + ( 4 + 5 ) ) + ( 3 - 3 ) + ( 3 + ( 4 + 5 ) + 3 ) )"

```
public int evaluate(String exp){
	if(exp.isEmpty()) return 0;

	Stack<Character> st = new Stack<>();

	for(int i=0;i<exp.length();i++){
		char c = exp.charAt(i);
		if(c == '(' || Character.isDigit(c) || c == '-') || c == '+'){
			st.push(c);
		} else (c == ')'){
			int ans = 0;
			while(st.peek()!='('){
				char c = st.pop();
				if(Character.isDigit(c)){
					ans+= c;
				} else if(c=='-'){
					ans = -1 * ans;
				}
			}
			st.pop();
			st.push(Character.valueOf(ans));
		}
	}
	return st.pop();
}
```

## ROUND 2 

1. Not able to answer Question related to frontEnd
2. Asked Sql Procedures question.
3. DS Question Diameter of tree.
4. Explain Interface Segregation with example

```

      1
   2    4
3          5


dia = [-2,2]


public int diameter(TreeNode node){
	if(node == null) return 0;
	int [] dia = new int[]{0,0};
	dfs(node,0,0,dia)
	return dia[1] - dia[0];
}

2 - (-2)
4

O(number of nodes in tree)


public void dfs(TreeNode node,int l,int r int [] dia){
	if(node == null) return;
	
	dia[0] = Math.min(l,dia[0]);
	dia[1] = Math.max(r,dia[1]);

	dfs(node.left,l-1,r,dia);

	dfs(node.right,l,r+1,dia);
}


interface DBConnection{
	
	Connection connect();
}

interface WorkerService{

	void processWorker();
}


class Doservice() implement WorkerService{
	
}

class DAOservice() implement DBConnection{
	
}

class ConnectPostproceesor implement DBConnection, WorkerService{
	
}
```

## ROUND 3 (HM)

1. Current Project Design, my Roles & Responsibility
2. SQL vs NoSQl
3. What is replication, Sharding, Consistent Hashing.
4. Design a System to facilitate first 100 users to order and do Payment for the same 
   4.1 Which database will be used - Show products and there counts.
   4.2 How will you handle order and payment scenario for first 100 users

## ROUND 4 ( Director 20 min)

1. General Discussion about project.
2. Location prefereneces
3. How will service reliability can be increased.
