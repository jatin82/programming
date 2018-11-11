

/*

https://practice.geeksforgeeks.org/problems/maximum-difference-between-node-and-its-ancestor/1

*/



class GfG
{
    
 class Difference{
        int value = Integer.MIN_VALUE;
    }
    
    
    int maxDiff(Node root)
    {
        Difference dif = new Difference();
        maxDiffUtil(root,dif);
        return dif.value;
    }
    
    public int maxDiffUtil(Node root, Difference dif){
        if(root==null){
            return Integer.MAX_VALUE;
        }
        
        if(root.left == null && root.right == null) return root.data;
        
        int min = Math.min(maxDiffUtil(root.left,dif),maxDiffUtil(root.right,dif));
        
        dif.value = Math.max(dif.value,root.data-min);
        
        return Math.min(root.data,min);
    }
}
