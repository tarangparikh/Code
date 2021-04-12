import java.io.*;
import java.util.Arrays;

public class DICE {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = true;

	public int numRollsToTarget(int d, int f, int target) {
		if (d * f < target) return 0;
		long mod = 1_000_000_007;
		long[][] dp = new long[31][1001];
		for (int i = 1, h = dp[0].length; i < h; i++) {
			dp[1][i] = 1;
		}
		for (int i = 2, h = dp.length; i < h; i++) {
			for (int j = 1, v = dp[0].length; j < v; j++) {
				long sum = 0;
				for (int k = 1; k <= f; k++) {
					if (j - k >= 0 && j - k <= (i - 1) * f) {
						sum = (sum + dp[i - 1][j - k]) % mod;
					}
				}
				dp[i][j] = sum % mod;
			}
		}
		return (int) (dp[d][target] % mod);
	}

	void run() throws IOException {
		System.out.println(numRollsToTarget(30, 30, 500));
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		DICE obj = new DICE();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public DICE() {
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

	public void close() {
		writer.flush();
		writer.close();
	}
}
