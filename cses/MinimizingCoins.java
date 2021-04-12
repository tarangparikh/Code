import java.io.*;

public class MinimizingCoins {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	void run() throws IOException {
		int[] c = ni();
		int n = c[0];
		int[] d = ni();
		int[] dp = new int[c[1] + 1];
		for (int i = 1, h = dp.length; i < h; i++) {
			int min = 1_000_000_007;
			for (int j = 0, l = d.length; j < l; j++) {
				min =
					i - d[j] >= 0
						? Math.min(
							min,
							Math.min(1 + dp[i - d[j]], 1_000_000_007)
						)
						: min;
			}
			dp[i] = min;
		}
		writer.println(dp[c[1]] == 1_000_000_007 ? -1 : dp[c[1]]);
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		MinimizingCoins obj = new MinimizingCoins();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public MinimizingCoins() {
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
