import java.util.Random;
import java.util.Stack;

        /*
        
        https://leetcode.com/discuss/interview-experience/881394/amazon-sde-2-hyderabadindia-rejected
        
        String based problem : a key on keyboard was inserting # instead of backspace in the strings. 
                             Given two such erroneous strings check if they are equal or not.

        Example : str1 - a#bc##dd str2 - b#dd. Both strings are equal as, the str1 -> dd as output after deleting every character 
        that occurs before # similarly str2 -> dd.
        
        

        "#x#zd##","##x#vw#g##"

        "j","jp#"

         */


class Solution {

    public static void main(String[] args) {
        new Solution().stressTesting();
    }

    public boolean naive(String str1, String str2) {

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == '#') {
                if (!st.isEmpty()) st.pop();
            } else st.push(str1.charAt(i));
        }

        Stack<Character> st2 = new Stack<>();
        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) == '#') {
                if (!st2.isEmpty()) st2.pop();
            } else st2.push(str2.charAt(i));
        }

        if (st.size() != st2.size()) return false;

        while (!st.isEmpty() && !st2.isEmpty()) {
            if (st.pop() != st2.pop()) return false;
        }
        if (st2.isEmpty() && !st.isEmpty()) return false;
        if (!st2.isEmpty() && st.isEmpty()) return false;
        return true;
    }

    public boolean optimal(String str1, String str2) {
        int i = str1.length() - 1;
        int j = str2.length() - 1;

        int hc1 = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0 && str1.charAt(i) == '#') {
                hc1++;
                i--;
            }

            while (i >= 0 && hc1 > 0) {
                if (str1.charAt(i) == '#') hc1++;
                else hc1--;
                i--;
            }

            hc1 = 0;

            while (j >= 0 && str2.charAt(j) == '#') {
                hc1++;
                j--;
            }
            while (j >= 0 && hc1 > 0) {
                if (str2.charAt(j) == '#') hc1++;
                else hc1--;
                j--;
            }

            hc1 = 0;

            if (i < 0 && j < 0) return true;

            if ((i >= 0 && str1.charAt(i) == '#') || (j >= 0 && str2.charAt(j) == '#')) continue;
            if ((i < 0 && j >= 0) || (i >= 0 && j < 0)) return false;
            if (str1.charAt(i) == str2.charAt(j)) {
                i--;
                j--;
            } else return false;
        }
        return true;
    }


    private void stressTesting() {
        int itr = 50000; // number of testcase to run
        int max_n = 500; // set small value for smaller testcase
        int max_q_n = 26; // alphabet limit
        Random r = new Random();
        int it = 0;
        while (it < itr) {
            String str1 = null;
            String str2 = null;

            int n = r.nextInt(max_n) + 1;
            int m = r.nextInt(max_n) + 1;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                int flag = r.nextInt(2);
                if (flag == 1) sb.append((char) (r.nextInt(max_q_n) + 'a'));
                else sb.append('#');
            }
            str1 = sb.toString();

            sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                int flag = r.nextInt(2);
                if (flag == 1) sb.append((char) (r.nextInt(max_q_n) + 'a'));
                else sb.append('#');
            }
            str2 = sb.toString();


            Boolean naiveLs = new Solution().naive(str1, str2);
            Boolean myLs = new Solution().optimal(str1, str2);


            if (!naiveLs.equals(myLs)) {
                System.out.println("FAILED TEST CASE : " + (++it));
                System.out.println("\"" + str1 + "\",\"" + str2 + "\"");
                System.out.println("naive = " + naiveLs);
                System.out.println("match = " + myLs);
                break;
            } else {
                System.out.println("PASSED TEST CASE : " + (++it));
            }
        }
    }
}
