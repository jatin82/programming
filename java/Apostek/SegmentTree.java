/**
 *

https://www.hackerearth.com/practice/data-structures/advanced-data-structures/segment-trees/practice-problems/algorithm/easy-queries-751f9372/

6 6
0 0 0 0 0 0
0 2
1 2
1 0
0 1
1 5
0 4


3 4
0 0 0
1 0
0 1
1 2
0 1


 */
import java.io.*;
import java.util.*;
 
public class Apostek1 {
 
	static int[] left, right;
	static int n;
 
	static void updateleft(int index, int val) {
		left[index + n] = val;
		for (index += n; index > 1; index >>= 1)
			left[index >> 1] = Math.max(left[index], left[index ^ 1]);
	}
 
	static void updateright(int index, int val) {
		right[index + n] = val;
		for (index += n; index > 1; index >>= 1)
			right[index >> 1] = Math.min(right[index], right[index ^ 1]);
	}
 
	static int getleft(int l, int r) {
		int res = -1;
		for (l += n, r += n; l < r; l >>= 1, r >>= 1) {
			if (l % 2 == 1)
				res = Math.max(res, left[l++]);
			if (r % 2 == 1)
				res = Math.max(res, left[--r]);
		}
		return res;
	}
 
	static int getright(int l, int r) {
		int res = n;
		;
		for (l += n, r += n; l < r; l >>= 1, r >>= 1) {
			if (l % 2 == 1)
				res = Math.min(res, right[l++]);
			if (r % 2 == 1)
				res = Math.min(res, right[--r]);
		}
		return res;
	}
 
	public static void main(String args[]) throws IOException {
		n = in.ni();
		left = new int[1000000];
		right = new int[1000000];
 
		int t = in.ni();
		int a[] = in.nai(n);
		for (int i = 0; i < n; i++) {
			if (a[i] == 1) {
				updateleft(i, i);
				updateright(i, i);
			} else {
				updateleft(i, -1);
				updateright(i, n);
			}
 
		}
	
 
		while (t-- > 0) {
			int q = in.ni();
			int index = in.ni();
			if (q == 0) {
				if (index == 0) {
					int r = getright(index + 1, n);
					if (r == n)
						r = -1;
					out.prn(-1 + " " + r);
				} else if (index == n - 1) {
					int l = getleft(0, index);
					out.prn(l + " " + -1);
				} else {
					int l = getleft(0, index);
					int r = getright(index + 1, n);
					if (r == n)
						r = -1;
					out.prn(l + " " + r);
				}
			} else {
				updateleft(index, index);
				updateright(index, index);
 
			}
 
		}
		out.flush();
		out.close();
		in.close();
	}
 
	static long modpow(long x, long y, long MOD) {
		long res = 1;
		x = x % MOD;
		while (y > 0) {
			if (y % 2 == 1)
				res = (res * x) % MOD;
			x = (x * x) % MOD;
			y = y >> 1;
		}
		return res;
	}
 
	static long gcd(long a, long b) {
		return a == 0 ? b : gcd(b % a, a);
	}
 
	static Reader in = new Reader();
	static OutputWriter out = new OutputWriter(System.out);
 
	static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;
 
		public Reader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}
 
		public Reader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}
 
		public String readLine() throws IOException {
			byte[] buf = new byte[64]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}
 
		public int ni() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
 
			if (neg)
				return -ret;
			return ret;
		}
 
		public long[] nal(int n) throws IOException {
			long temp[] = new long[n];
			for (int i = 0; i < n; i++)
				temp[i] = in.nl();
			return temp;
		}
 
		public int[] nai(int n) throws IOException {
			int temp[] = new int[n];
			for (int i = 0; i < n; i++)
				temp[i] = in.ni();
			return temp;
		}
 
		public long nl() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}
 
		public double nd() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
 
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
 
			if (c == '.') {
				while ((c = read()) >= '0' && c <= '9') {
					ret += (c - '0') / (div *= 10);
				}
			}
 
			if (neg)
				return -ret;
			return ret;
		}
 
		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}
 
		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}
 
		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}
 
	static class OutputWriter {
		private final PrintWriter writer;
 
		public OutputWriter(OutputStream outputStream) {
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
		}
 
		public OutputWriter(Writer writer) {
			this.writer = new PrintWriter(writer);
		}
 
		public void pr(Object... objects) {
			for (int i = 0; i < objects.length; i++) {
				if (i != 0)
					writer.print(' ');
				writer.print(objects[i]);
			}
		}
 
		public void prn(Object... objects) {
			pr(objects);
			writer.println();
		}
 
		public void close() {
			writer.close();
		}
 
		public void flush() {
			writer.flush();
		}
 
	}
}
