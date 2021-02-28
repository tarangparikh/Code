import java.io.*;
import java.util.Arrays;

public class _1398D {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	void solve(int[] r, int[] g, int[] b) {
		Arrays.sort(r);
		Arrays.sort(g);
		Arrays.sort(b);

		long[][][] dp = new long[r.length + 1][g.length + 1][b.length + 1];
		for (int i = 0, rr = r.length + 1; i < rr; i++) {
			for (int j = 0, gg = g.length + 1; j < gg; j++) {
				for (int k = 0, bb = b.length + 1; k < bb; k++) {
					long m = 0;
					m =
						i - 1 >= 0 && j - 1 >= 0
							? Math.max(
								m,
								dp[i - 1][j - 1][k] + r[i - 1] * g[j - 1]
							)
							: m;
					m =
						j - 1 >= 0 && k - 1 >= 0
							? Math.max(
								m,
								dp[i][j - 1][k - 1] + b[k - 1] * g[j - 1]
							)
							: m;
					m =
						i - 1 >= 0 && k - 1 >= 0
							? Math.max(
								m,
								dp[i - 1][j][k - 1] + r[i - 1] * b[k - 1]
							)
							: m;
					dp[i][j][k] = m;
				}
			}
		}

		writer.println(dp[r.length][g.length][b.length]);
	}

	void run() throws IOException {
		bf.readLine();
		int[] r = ni();
		int[] g = ni();
		int[] b = ni();
		solve(r, g, b);
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		_1398D obj = new _1398D();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public _1398D() {
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
