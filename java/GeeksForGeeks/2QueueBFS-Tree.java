/*

https://practice.geeksforgeeks.org/problems/sum-of-leaf-nodes-at-min-level/1

*/


class GfG{
    public int minLeafSum(Node root){
        if(root == null){
            return 0;
        }
        
        if(root.left == null && root.right == null){
            return root.data;
        }
        
        Queue<Node> bfs1 = new LinkedList<>();
        Queue<Node> bfs2 = new LinkedList<>();
        
        bfs1.add(root);
        
        boolean minFound = false;
        int sum = 0;
        
        while( !minFound && (!bfs1.isEmpty() || !bfs2.isEmpty() )){
            Queue<Node> primary = null;
            Queue<Node> secondary = null;
            
        
            if(!bfs1.isEmpty()){
                primary = bfs1;
                secondary = bfs2;
            }
            else{
                primary = bfs2;
                secondary = bfs1;
            }
            
            while(!primary.isEmpty()){
                Node current = primary.poll();
                if(current.left == null && current.right == null){
                    minFound = true;
                    sum+=current.data;
                }
                else{
                    if(current.left!=null) secondary.add(current.left);
                    if(current.right!=null) secondary.add(current.right);
                }
            }
            
        }
        return sum;
    }
}
