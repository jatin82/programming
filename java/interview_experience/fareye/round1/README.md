
### Question 1 - Check tree is BST

    	60
     30       80
  10    40  70



public boolean checkBST(Node node){
	return isValidTree(node,Integer.MIN_VALUE,Integer.MAX_VALUE);
}

private boolean isValidTree(Node node, int min, int max){
	if(node == null) return true;
	return min < node.val 
			&& node.val < max 
			&& isValidTree(node.left,min,node.val) 
			&& isValidTree(node.right,node.val,max);
}


### Question 2 - no of islands


{1, 1, 0, 0, 0},
{0, 1, 0, 0, 1},
{1, 0, 0, 1, 1},
{0, 0, 0, 0, 0},
{1, 0, 1, 0, 1} 

out = 5




for(iterating over row){
	for(iterating over col){
		if(a[row][col]==1){
			count++;
			dfs(row,col);
		}
	}
}


dfs(int row,int col){
	// visited
	a[row][col] = 0;

	for(iterate in all 8 directions){
		if(a[row1][col1]==1){
			dfs(row1,col1);
		}
	}
}

### Question 3 - Rectangel maximum Hieght

7 bars of heights {6, 2, 5, 4, 5, 1, 6}

12

Stack
6

maxArea = 0;

1st case is greater will add to stack
2nd case 
	area = calclate it's area with left out element in stack
	
  
