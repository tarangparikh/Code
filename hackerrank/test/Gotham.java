import java.io.*;
import java.util.*;

public class Gotham {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	long solve(int[][] q, int[] c) {
		int[] dp = new int[c[0]];
		int[][] g = packU(q, c[0]);
		Arrays.fill(dp, -1);
		int co = -1;
		for (int i = 0; i < c[0]; i++) {
			if (dp[i] == -1) {
				dfs(g, i, -1, ++co, dp);
			}
		}
		HashMap<Integer, Integer> hash = new HashMap<>();
		for (int i = 0, h = dp.length; i < h; i++) {
			if (!hash.containsKey(dp[i])) hash.put(dp[i], 0);
			hash.put(dp[i], hash.get(dp[i]) + 1);
		}

		int total_r = 0;
		int total_c = 0;

		long cost = 0;

		double ratio = (double) c[2] / (double) c[3];

		long total = 0;
		long cc = 0;

		for (Map.Entry<Integer, Integer> e : hash.entrySet()) {
			total += e.getValue();
		}

		//writer.println(total_c+" "+total_r);

		return cost;
	}

	void run() throws IOException {
		int t = getInt();
		while (t-- > 0) {
			int[] c = ints();
			int[][] q = new int[c[1]][];
			for (int i = 0, h = q.length; i < h; i++) {
				q[i] = ints();
				q[i][0]--;
				q[i][1]--;
			}
			writer.println(solve(q, c));
		}
	}

	void dfs(int[][] g, int c, int p, int co, int[] dp) {
		if (dp[c] != -1) return;
		dp[c] = co;
		for (int e : g[c]) {
			dfs(g, e, c, co, dp);
		}
	}

	static int[][] packU(int[][] e, int n) {
		int[] q = new int[n];
		int[][] g = new int[n][];
		for (int[] ed : e) {
			q[ed[0]]++;
			q[ed[1]]++;
		}
		for (int i = 0; i < n; i++) g[i] = new int[q[i]];
		for (int[] ed : e) {
			g[ed[0]][--q[ed[0]]] = ed[1];
			g[ed[1]][--q[ed[1]]] = ed[0];
		}
		return g;
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		Gotham obj = new Gotham();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public Gotham() {
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
