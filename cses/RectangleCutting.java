import java.io.*;

public class RectangleCutting {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	void run() throws IOException {
		int[] c = ni();
		int n = c[0];
		int m = c[1];
		int INF = 1_000_000_007;
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (i == j) continue;
				int a = 1;
				int b = i - 1;
				dp[i][j] = INF;
				while (a <= b) dp[i][j] =
					Math.min(1 + dp[a++][j] + dp[b--][j], dp[i][j]);
				a = 1;
				b = j - 1;
				while (a <= b) dp[i][j] =
					Math.min(1 + dp[i][a++] + dp[i][b--], dp[i][j]);
			}
		}
		writer.println(dp[n][m]);
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		RectangleCutting obj = new RectangleCutting();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public RectangleCutting() {
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
