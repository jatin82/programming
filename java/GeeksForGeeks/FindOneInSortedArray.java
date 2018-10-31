import java.util.Scanner;

public class FindOneInSortedArray{

    public static int searchOne(int [] a,int start,int end){
        if(end < start) return -1;
        int mid = (end + start)/2;
        if(a[mid] == 1 && (mid == 0 || a[mid-1] == 0 )){
            return mid;
        }
        
        if(a[mid] == 1){
            return searchOne(a,start,mid-1);
        }
        else{
            return searchOne(a,mid+1,end);
        }
    }

    public static void main(String args []){
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        while(testCase-->0){
            int n = sc.nextInt();
            int [] a = new int[n];
            for(int i=0;i<n;i++){
                a[i] = sc.nextInt();
            }
            System.out.println(searchOne(a,0,n-1));
        }
    }
}