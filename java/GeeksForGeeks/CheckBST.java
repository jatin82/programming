class GfG
{
    
    int isBST(Node root)  
    {
        if(root == null){
            return 1;
        }
        Stack<Node> s = new Stack();
        s.add(root);
        Node prev = null;
        boolean notBST = false;
        HashSet<Node> visited = new HashSet<Node>();
        
        while(!s.isEmpty() && !notBST){
            Node pop = s.peek();
            
            if(pop.left!=null && !visited.contains(pop.left)){
                s.add(pop.left);
            }
            else{
                s.pop();
                if(prev==null || pop.data >= prev.data){
                    prev = pop;
                    visited.add(pop);
                    if(pop.right != null && !visited.contains(pop.right) ) s.add(pop.right);
                }
                else{
                    //System.out.println(pop.data+" >= "+prev.data);
                    notBST = true;
                }
            }
        }
        return notBST ? 0 : 1;
    }
}
