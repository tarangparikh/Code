import java.io.*;
import java.util.*;

public class BINFUN {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	long evaluate(long a, long b) {
		final long ta = a;
		final long tb = b;
		long temp_a = a;
		long temp_b = b;
		while (temp_b > 0) {
			a <<= 1;
			temp_b >>= 1;
		}
		while (temp_a > 0) {
			b <<= 1;
			temp_a >>= 1;
		}
		a += tb;
		b += ta;
		return Math.max(a - b, b - a);
	}

	long solve1(final long[] d) {
		final long[] dp = new long[33];
		Arrays.fill(dp, Integer.MAX_VALUE);
		for (final long e : d) dp(e, dp);
		long max = Integer.MIN_VALUE;
		for (final long e : d) {
			for (int i = 0, h = dp.length; i < h; i++) {
				if (dp[i] != 0x7fffffff) {
					max = Math.max(max, evaluate(dp[i], e));
				}
			}
		}
		return max;
	}

	void dp(long n, final long[] dp) {
		int size = 0;
		final long temp = n;
		while (n > 0) {
			n >>= 1;
			size++;
		}
		dp[size] = Math.min(temp, dp[size]);
	}

	void run() throws IOException {
		int t = getInt();
		while (t-- > 0) {
			getInt();
			sb.append(solve1(longs())).append("\n");
		}
		writer.println(sb.toString().trim());
	}

	public static void main(final String[] args) throws IOException {
		final long start_time = System.currentTimeMillis();
		final BINFUN obj = new BINFUN();
		obj.run();
		final long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public BINFUN() {
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
		final String[] data = bf.readLine().split(" ");
		final int[] send = new int[data.length];
		for (int i = 0, h = data.length; i < h; i++) send[i] =
			Integer.parseInt(data[i]);
		return send;
	}

	public long[] longs() throws IOException {
		final String[] data = bf.readLine().split(" ");
		final long[] send = new long[data.length];
		for (int i = 0, h = data.length; i < h; i++) send[i] =
			Long.parseLong(data[i]);
		return send;
	}

	public void close() {
		writer.flush();
		writer.close();
	}
}
