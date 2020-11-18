/*
asked in interview with amazon sde 2

If the 2 nodes are at same height and horizontal distance, then both nodes need to be added final output list.

*/


class Tree
{
 
    // Method that returns the bottom view.
    public ArrayList <Integer> bottomView(Node root)
    {
        ArrayList<Integer> list = new ArrayList<>();
        
        if(root==null) return list;
        
        int [] hds = new int[]{0,0};
        Map<Integer,List<int[]>> map = new HashMap<>();
        rec(root,hds,map,0,0);
        for(int i=hds[0];i<=hds[1];i++){
            list.add(map.get(i).get(map.get(i).size()-1)[0]);
        }
        return list;
    }
    
    private void rec(Node root, int [] hds, Map<Integer,List<int[]>> map,int distance,int height){
        if(root==null) return;
        
        if(!map.containsKey(distance)){
            map.put(distance,new ArrayList<>());
            map.get(distance).add(new int[]{root.data,height});
        }
        else{
            List<int[]> pairs = map.get(distance);
            int ht = pairs.get(0)[1];
            if(height>ht){
                map.put(distance,new ArrayList<>());
                map.get(distance).add(new int[]{root.data,height});
            }
            else if(height==ht){
                map.get(distance).add(new int[]{root.data,height});
            }
        }
        
        hds[0] = Math.min(distance,hds[0]);
        hds[1] = Math.max(distance,hds[1]);
        
        rec(root.left,hds,map,distance-1,height+1);
        rec(root.right,hds,map,distance+1,height+1);
    }
}
