import java.io.*;

public class Fruits {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = true;

	long solve(long[] d) {
		long[] dp = d;
		int n = dp.length;
		if (n == 1) return dp[0];
		dp[1] = Math.max(dp[1], dp[0]);
		for (int i = 2, h = dp.length; i < h; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i] + dp[i - 2]);
		}
		return Math.max(dp[dp.length - 1], dp[dp.length - 2]);
	}

	void run() throws IOException {
		writer.println(solve(nl()));
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		Fruits obj = new Fruits();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public Fruits() {
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
