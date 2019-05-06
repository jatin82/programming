import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*Complete the function below*/
public class Test4{
	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[][] a=new int[n][n];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					a[i][j]=sc.nextInt();
			Test4 g=new Test4();
			ArrayList<String> res=g.printPath(a,n);
			for(int i=0;i<res.size();i++)
				System.out.print(res.get(i)+" ");
			System.out.println();
		}
	}
	
    public static boolean isSafe(int sx,int sy, int[][] m, int n,int[][] sol){
        return sx<n && sx>=0 && sy >=0 && sy<n && m[sx][sy] == 1 && sol[sx][sy]==0;
    }
    public static boolean findPath(int sx,int sy,int [][] m, int n, int [][] sol,StringBuilder currentPath,ArrayList<String> paths){
        
        if(sx==n-1 && sy == n-1){
            paths.add(currentPath.toString()); 
            return true;
        }
        // DRDDRR DRDDRURD DRDRDR DRDRRD
        if(isSafe(sx,sy,m,n,sol)){
             sol[sx][sy] = 1;
            boolean result = findPath(sx+1,sy,m,n,sol,new StringBuilder(currentPath.toString()+"D"),paths); 
            result = findPath(sx,sy+1,m,n,sol,new StringBuilder(currentPath.toString()+"R"),paths) || result;
            result = findPath(sx-1,sy,m,n,sol,new StringBuilder(currentPath.toString()+"U"),paths) || result;
            result = findPath(sx,sy-1,m,n,sol,new StringBuilder(currentPath.toString()+"L"),paths) || result;
            
            if(result) {
            	sol[sx][sy] = 0;;
            	return true;
            }
            sol[sx][sy] = 0;
        }
        return false;
    }
    /*
     * 
     * 
1
6
1 1 1 1 1 1 0 1 0 1 0 1 1 1 1 1 1 1 0 1 0 1 0 1 1 1 1 1 1 1 0 1 0 1 0 1

     */
    
    
    
     public static ArrayList<String> printPath(int[][] m, int n)
     {
          int [][] sol = new int[n][n];
          ArrayList<String> paths = new ArrayList<>();
          findPath(0,0,m,n,sol,new StringBuilder(),paths);
          //printSols(m,n);
          Collections.sort(paths);
          return paths;
        //return new ArrayList<>();
     }
     public static void printSols(int [][] sol,int n){
         for(int i=0;i<n;i++){
             for(int j=0;j<n;j++){
                 System.out.print(sol[i][j]+" ");
             }
             System.out.println();
         }
     }
}
