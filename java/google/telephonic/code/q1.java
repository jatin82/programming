
import java.util.*;

public class Driver {

/*
link : https://github.com/jatin82/programming/blob/master/java/google/telephonic/q1_1.jpeg


TestCase 

2
5
2 L
3 R
4 L
1 R
5 L
6
2 L
3 R
4 L
1 R
5 L
11 R

*/

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        while (testCase-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(sc.next());
                char ops = sc.next().charAt(0);
                if (ops == 'R') a[i] = x;
                else a[i] = -1 * x;
            }
            System.out.println(solve(a));
        }
    }

    public static int solve(int[] a) {
        int n = a.length;
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + a[i - 1];
            int x = i - 2;
            int y = i - 1;
            while (check(a, x, y)) {
                if (Math.abs(dp[x]) > Math.abs(dp[i])) {
                    dp[i] = dp[x];
                }
                x--;
                y--;
            }
            x = i - 2;
            y = i - 3;
            while (check(a, x, y)) {
                if (Math.abs(dp[y] + a[i - 1]) > Math.abs(dp[i])) dp[i] = dp[y] + a[i - 1];
                x--;
                y--;
            }
        }
        return Math.abs(dp[n]);
    }

    private static boolean check(int[] a, int x, int y) {
        return x >= 0 && y >= 0 && ((a[x] < 0 && a[y] >= 0) || ((a[x] >= 0 && a[y] < 0)));
    }

}
