
/*
https://www.hackerearth.com/practice/data-structures/advanced-data-structures/segment-trees/tutorial/


5 5
1 5 2 4 3
q 1 5
q 1 3
q 3 5
u 3 6
q 1 5



*/

import java.util.Scanner;

public class SegmentTreeMin {

    public static void constructST(int [] a, int [] tree, int currentIndex, int start, int end){
        if(start == end){
            tree[currentIndex] = a[start];
            return;
        }
        int mid = start + (end-start)/2;
        constructST(a,tree,(currentIndex<<1) + 1, start, mid);
        constructST(a,tree,(currentIndex<<1) + 2, mid + 1, end);
        tree[currentIndex] = Math.min(tree[(currentIndex<<1) + 1], tree[(currentIndex<<1) + 2]);
    }
    public static int updateST(int [] a, int [] tree, int currentIndex, int start, int end, int updateIndex, int updateValue){
        if(start == updateIndex && end == updateIndex){
            a[updateIndex] = updateValue;
            tree[currentIndex] = updateValue;
            return tree[currentIndex];
        }    
        int mid = start + ( end - start ) / 2;
        if( mid >= updateIndex){
            updateST(a,tree,(currentIndex<<1) + 1, start, mid,updateIndex, updateValue);    
        }
        else{
            updateST(a,tree,(currentIndex<<1) + 2, mid+1, end, updateIndex, updateValue);
        }
        tree[currentIndex] = Math.min(tree[(currentIndex<<1) + 1], tree[(currentIndex<<1) + 2]);
        return tree[currentIndex];
    }
    public static int queryST(int [] a, int [] tree, int currentIndex, int start, int end, int left, int right){
        
        if(end < left || start > right ){
            return Integer.MAX_VALUE;
        }

        if(left <=start && right >=end){
            return tree[currentIndex];
        }
        int mid = start + (end - start) / 2;
        
        return Math.min( 
            queryST(a,tree,(currentIndex<<1) + 1, start,mid, left,right), 
            queryST(a,tree,(currentIndex<<1) + 2, mid+1, end, left,right) 
        );

    }


    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        int [] a = new int[n];
        int treeSize = (2 * (int)Math.ceil(Math.pow(2,(Math.log(n)/Math.log(2))))) - 1;
        int [] tree = new int[treeSize];

        
        for(int i=0;i<n;i++) a[i] = sc.nextInt();
        constructST(a,tree,0,0,n-1);

        while(q-->0){
            char type = sc.next().charAt(0);
            if(type == 'q'){
                int l = sc.nextInt()-1;
                int r = sc.nextInt()-1;
                System.out.println(queryST(a,tree,0,0,n-1,l,r));        
            }
            else{
                updateST(a,tree,0,0,n-1,sc.nextInt()-1, sc.nextInt());
            }
        }
    }
}