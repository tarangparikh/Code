import java.io.*;

class Main {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	void run() throws IOException {
		int t = i();
		long sum = 0;
		int c = 0;
		while (t-- > 0) {
			int n = i();
			if (n == 0) {
				bf.readLine();
				sb.append("Case " + (++c) + ": " + 0).append("\n");
				continue;
			}
			long[] dp = nl();
			if (dp.length == 1) {
				sb.append("Case " + (++c) + ": " + dp[0]).append("\n");
				continue;
			}
			dp[1] = Math.max(dp[1], dp[0]);
			for (int i = 2, h = dp.length; i < h; i++) {
				dp[i] = Math.max(dp[i - 1], dp[i] + dp[i - 2]);
			}
			sb
				.append(
					"Case " +
					(++c) +
					": " +
					Math.max(dp[dp.length - 1], dp[dp.length - 2])
				)
				.append("\n");
		}
		writer.println(sb.toString().trim());
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		Main obj = new Main();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public Main() {
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
