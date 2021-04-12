import java.io.*;
import java.util.Arrays;

public class Number_Of_Integers {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	void copyshift(long[] a, long[] b, int step) {
		for (int i = 0, h = a.length - step; i < h; i++) b[i + step] = a[i];
		for (int i = 0; i < step; i++) b[i] = 0;
	}

	long[][][] precompute(int klength) {
		long[][][] dp = new long[klength][10][klength + 1];
		dp[0][0][0] = 1;
		long[] prev = new long[klength + 1];
		for (int i = 0, h = dp.length; i < h; i++) {
			copyshift(dp[i][0], prev, 1);
			for (int j = 1, l = dp[0].length; j < l; j++) {
				for (int k = 0; k < prev.length; k++) {
					dp[i][j][k] = (dp[i][j - 1][k] + prev[k]) % mod;
				}
			}
			if (i < h - 1) dp[i + 1][0] = dp[i][dp[0].length - 1];
		}
		return dp;
	}

	static long mod = 1_000_000_007L;

	void add(long[] a, long[] b) {
		for (int i = 0, h = a.length; i < h; i++) {
			a[i] = (a[i] + b[i]) % mod;
		}
	}

	void sub(long[] a, long[] b) {
		for (int i = 0, h = a.length; i < h; i++) {
			a[i] = (a[i] - b[i] + mod) % mod;
		}
	}

	long[] compute(String number, long[][][] dp) {
		int k_len = dp[0][0].length;
		long[] sum = new long[k_len];
		long[] temp = new long[k_len];
		char[] d = number.toCharArray();
		int i = 0;
		int n = d.length;
		int c = 0;
		while (i < n) {
			int current = d[i] - '0';
			if (current > 0) {
				copyshift(dp[n - i - 1][current - 1], temp, c);
				add(sum, temp);
				c++;
			}
			i++;
		}
		sum[c] = (sum[c] + 1) % mod;
		return sum;
	}

	void run() throws IOException {
		String a = bf.readLine().trim();
		String b = bf.readLine().trim();
		int k = getInt();
		long[][][] dp = precompute(100);
		long[] aa = compute(a, dp);
		long[] bb = compute(b, dp);
		sub(bb, aa);
		writer.println(bb[k]);
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		Number_Of_Integers obj = new Number_Of_Integers();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public Number_Of_Integers() {
		writer = new PrintWriter(System.out);
		bf = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
	}

	public int getInt() throws IOException {
		return Integer.parseInt(bf.readLine());
	}

	public long getLong() throws IOException {
		return Long.parseLong(bf.readLine());
	}

	public int[] ints() throws IOException {
		String[] data = bf.readLine().split(" ");
		int[] send = new int[data.length];
		for (int i = 0, h = data.length; i < h; i++) send[i] =
			Integer.parseInt(data[i]);
		return send;
	}

	public long[] longs() throws IOException {
		String[] data = bf.readLine().split(" ");
		long[] send = new long[data.length];
		for (int i = 0, h = data.length; i < h; i++) send[i] =
			Long.parseLong(data[i]);
		return send;
	}

	public void close() throws IOException {
		writer.flush();
		writer.close();
		bf.close();
	}
}
