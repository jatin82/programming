
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Solution {

    public static void main(String[] args) {
        new Solution().stressTesting();
    }

    private void stressTesting(){
        int itr = 1000;
        int max_n = 10000;
        int max_q_n = 5000;
        Random r = new Random();
        int it=0;
        while(it<itr){
            int n = r.nextInt(max_n)+1;
            int q_n = r.nextInt(max_q_n)+1;
            StringBuilder sb = new StringBuilder();

            for(int i=0;i<n;i++){
                sb.append(r.nextInt(2)==0?'*':'|');
            }
            int [][] queries = new int[q_n][2];
            for(int i=0;i<q_n;i++){
                queries[i][1] = r.nextInt(n);
                queries[i][0] = r.nextInt(queries[i][1]+1);
            }
            List<Integer> naiveLs = new Solution().naive(sb.toString(),queries);
            List<Integer> myLs = new Solution().myMethod(sb.toString(),queries);

            if(!naiveLs.equals(myLs)){
                System.out.println("FAILED TEST CASE : "+(++it));
                System.out.println("String : "+sb.toString());
                System.out.println("[");
                for(int i=0;i<q_n;i++){
                    System.out.println("{"+queries[i][0]+","+queries[i][1]+"},");
                }
                System.out.println("]");

                System.out.println("naive = "+naiveLs);
                System.out.println("myLs = "+myLs);
                break;
            }
            else{
                System.out.println("PASSED TEST CASE : "+(++it));

            }
        }
    }

    public List<Integer> naive(String str, int [][] queries){

        List<Integer> ans = new ArrayList<>();

        for(int [] q: queries){
            int l = q[0];
            int r = q[1];
            int gl = 0;
            int count = 0;
            boolean isSeen = false;
            for(int i=l;i<=r;i++){
                if(str.charAt(i)=='|'){
                    gl+=count;
                    count= 0;
                    isSeen = true;
                }
                count+= str.charAt(i)=='*' && isSeen ? 1 : 0;
            }
            ans.add(gl);
        }
        return ans;
    }

    public List<Integer> myMethod(String str, int [][] queries){
        int [] l = new int[str.length()];
        List<Integer> ans = new ArrayList<>();

        boolean isPipe = false;
        int count = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='|'){
                if(isPipe){
                    l[i] = count;
                }
                isPipe = true;
            }
            else if(isPipe){
                count++;
                l[i] = i-1>=0 ? l[i-1] : 0;
            }
        }


        for(int [] q: queries){
            int hi = q[1];
            int li = q[0];
            while(hi>=0 && str.charAt(hi)!='|') hi--;
            while(li<str.length() && str.charAt(li)!='|') li++;
            int diff = hi>=li? l[hi]  - l[li]:0;
            ans.add(Math.abs(diff));
        }
        return ans;
    }
    /*


    [824,938,1399,5607,6973,5703,9609,4398,8247]

     */
}