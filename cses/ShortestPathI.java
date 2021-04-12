import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ShortestPathI {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	void run() throws IOException {
		int[] c = ni();
		int n = c[0];
		int m = c[1];
		int[][] q = new int[m][];
		for (int i = 0; i < m; i++) {
			q[i] = ni();
			q[i][0]--;
			q[i][1]--;
		}
		int[][][] g = packDW(q, n);
		long[] dp = new long[n];
		Arrays.fill(dp, Long.MAX_VALUE);
		PriorityQueue<long[]> que = new PriorityQueue<>(
			(a, b) -> Long.compare(a[0], b[0])
		);
		que.add(new long[] { 0, 0 });
		dp[0] = 0;
		while (!que.isEmpty()) {
			long[] r = que.poll();
			if (dp[(int) r[0]] < r[1]) continue;
			for (int[] e : g[(int) r[0]]) {
				if (dp[e[0]] > dp[(int) r[0]] + e[1]) {
					dp[e[0]] = dp[(int) r[0]] + e[1];
					que.add(new long[] { e[0], dp[e[0]] });
				}
			}
		}
		for (long e : dp) sb.append(e).append(" ");
		writer.println(sb);
	}

	static int[][][] packDW(int[][] e, int n) {
		int[] q = new int[n];
		// System.out.println(Arrays.toString(q));
		int[][][] g = new int[n][][];
		for (int[] ed : e) {
			// System.out.println(Arrays.toString(ed));
			q[ed[0]]++;
		}
		for (int i = 0; i < n; i++) {
			g[i] = new int[q[i]][2];
		}
		for (int[] ed : e) {
			g[ed[0]][--q[ed[0]]][0] = ed[1];
			g[ed[0]][q[ed[0]]][1] = ed[2];
		}
		return g;
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		ShortestPathI obj = new ShortestPathI();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public ShortestPathI() {
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
