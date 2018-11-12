
/*

https://practice.geeksforgeeks.org/problems/print-all-nodes-that-dont-have-sibling/1

*/
class GfG
{
    
    List<Integer> printSiblingUtil(Node node, List<Integer> result){
        if(node == null) return result;
        
        if(node.left != null && node.right == null){
            result.add(node.left.data);
            return printSiblingUtil(node.left, result);
        }
        else if(node.left == null && node.right != null){
            result.add(node.right.data);
            return printSiblingUtil(node.right, result);
        }
        else{
            result = printSiblingUtil(node.left, result);
            return printSiblingUtil(node.right, result);
        }
    }
    
	void printSibling(Node node)
	{
        List<Integer> result = printSiblingUtil(node, new ArrayList<Integer>()); 
        
        if(result.size()==0){
            System.out.print(-1);
        }
        else{
            Collections.sort(result);
            for(int x: result){
               System.out.print(x+ " ");
            }
        }
        
        
	}
}
