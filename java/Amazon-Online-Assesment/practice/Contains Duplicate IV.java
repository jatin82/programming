import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Solution {

/*

AMAZON ASKED IN INTERVIEW

Given an unsorted array and two integers k and t, find Ai and Aj such that
|Ai-Aj| == t and |i-j| <= k.

*/

    public static void main(String[] args) {
        new Solution().stressTesting();
    }


    public boolean naive(int[] nums, int t, int k) {
        if (k < 2) return false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    int iDiff = Math.abs(i - j) + 1;
                    int nDiff = Math.abs(nums[i] - nums[j]);
                    if (nDiff == t && iDiff <= k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public boolean myMethod(int[] nums, int t, int k) {
        if (k < 2) return false;
        Map<Integer, Integer> map = new HashMap<>();

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int add = nums[i] + t;
            int min = nums[i] - t;
            if (map.containsKey(nums[i]) && map.get(nums[i]) > 0) {
                return true;
            }
            map.put(add, map.getOrDefault(add, 0) + 1);
            map.put(min, map.getOrDefault(min, 0) + 1);
            count++;
            if (count >= k) {
                map.put(nums[i - k + 1] + t, map.get(nums[i - k + 1] + t) - 1);
                map.put(nums[i - k + 1] - t, map.get(nums[i - k + 1] - t) - 1);
                count--;
            }

        }
        return false;
    }


    private void stressTesting() {
        int itr = 5000;
        int max_n = 1000;
        int max_q_n = 1000;
        Random r = new Random();
        int it = 0;
        while (it < itr) {
            int n = r.nextInt(max_n) + 1;
            int[] nums = new int[n];

            for (int i = 0; i < n; i++) {
                int q_n = r.nextInt(max_q_n) + 1;
                nums[i] = q_n;
            }
            int t = r.nextInt(max_q_n);
            int k = r.nextInt(n);

            Boolean naiveLs = new Solution().naive(nums, t, k);
            Boolean myLs = new Solution().myMethod(nums, t, k);

            if (!naiveLs.equals(myLs)) {
                System.out.println("FAILED TEST CASE : " + (++it));
                System.out.print("[");
                for (int i = 0; i < n; i++) {
                    System.out.print(nums[i] + ",");
                }
                System.out.println("]");
                System.out.println("t=" + t);
                System.out.println("k=" + k);

                System.out.println("naive = " + naiveLs);
                System.out.println("myLs = " + myLs);
                break;
            } else {
                System.out.println("PASSED TEST CASE : " + (++it));

            }
        }
    }
}
