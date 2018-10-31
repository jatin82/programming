package dp;

/*

1
5 84

 */

import java.io.*;
import java.util.*;

public class DP3D {

	public static long /* pow[], */ dp[][][], a, b;

	public static void main(String[] args) throws IOException {
		Reader in = new Reader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		/*
		 * pow = new long[19]; pow[0] = 1; for(int i=1; i<=18; i++) pow[i] =
		 * 10*pow[i-1];
		 */
		int test = in.nextInt();
		int sum = 199, sqsum = 1499;
		dp = new long[19][200][1500];
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 200; j++)
				Arrays.fill(dp[i][j], -1);

		}
		while (test-- > 0) {
			a = in.nextLong();
			b = in.nextLong();

			System.out.println(solve(b) - solve(a - 1));
		}

		out.flush();
		out.close();
	}

	private static long solve(long n) {

		if (n == 0)
			return 0;
		n++;
		String dig = n + "";
		int digits = dig.length();
		long ans = 0;
		int sum = 199, sqsum = 1499;
		// System.out.println(dig);
		for (int i = 0; i < digits; i++) {
			int k = dig.charAt(i) - '0';
			// System.out.println("Hello"+k);
			for (int j = 0; j < k; j++) {
				ans += find(digits - i - 1, sum - j, sqsum - (j * j));
			}
			sum -= k;
			sqsum -= (k * k);
		}
		return ans;
	}

	private static long find(int digits, int sum, int sqsum) {

		if (sum < 0 || sqsum < 0) {
			return 0;
		}

		if (digits == 0) {
			if (gcd(199 - sum, 1499 - sqsum) == 1)
				return 1;
			else
				return 0;
		}

		if (dp[digits][sum][sqsum] != -1)
			return dp[digits][sum][sqsum];
		long ret = 0;
		for (int i = 0; i < 10; i++) {
			ret += find(digits - 1, sum - i, sqsum - (i * i));
		}

		dp[digits][sum][sqsum] = ret;
		return ret;
	}

	public static long gcd(long a, long b) {
		long x = Math.min(a, b);
		long y = Math.max(a, b);
		while (x != 0) {
			long temp = x;
			x = y % x;
			y = temp;
		}
		return y;
	}

	public static class Reader {
		public BufferedReader reader;
		public StringTokenizer st;

		public Reader(InputStreamReader stream) {
			reader = new BufferedReader(stream);
			st = null;
		}

		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public String nextLine() throws IOException {
			return reader.readLine();
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

	}
}
