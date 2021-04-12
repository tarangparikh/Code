import java.io.*;
import java.util.Arrays;

public class ArrayDescription {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	long mod = 1_000_000_007;

	void run() throws IOException {
		int[] c = ni();
		int n = c[0];
		int m = c[1];
		int[] d = ni();
		long[][] dp = new long[2][m + 2];

		if (d[0] == 0) {
			Arrays.fill(dp[0], 1);
			dp[0][0] = 0;
			dp[0][m + 1] = 0;
		} else {
			dp[0][d[0]] = 1;
		}

		for (int i = 1, h = d.length; i < h; i++) {
			for (int j = 1; j <= m; j++) dp[1][j] =
				(dp[0][j] + dp[0][j - 1] + dp[0][j + 1]) % mod;

			long[] t = dp[0];
			dp[0] = dp[1];
			dp[1] = t;

			int r = d[i];
			if (r != 0) {
				for (int j = 1; j <= m; j++) if (r != j) dp[0][j] = 0;
			}
			//writer.println(Arrays.toString(dp[0]));
		}

		long sum = 0;
		for (long e : dp[0]) sum = (sum + e) % mod;
		writer.println(sum);
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		ArrayDescription obj = new ArrayDescription();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public ArrayDescription() {
		writer = new PrintWriter(System.out);
		bf = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
	}

	public int i() throws IOException {
		return Integer.parseInt(bf.readLine());
	}

	public long l() throws IOException {
		return Long.parseLong(bf.readLine());
	}

	public int[] ni() throws IOException {
		String[] data = bf.readLine().split(" ");
		int[] send = new int[data.length];
		for (int i = 0, h = data.length; i < h; i++) send[i] =
			Integer.parseInt(data[i]);
		return send;
	}

	public long[] nl() throws IOException {
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
