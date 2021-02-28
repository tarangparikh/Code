import java.io.*;
import java.util.*;

public class Jack_goes_to_Rapture {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	void run() throws IOException {
		int[] c = ints();
		int[][] q = new int[c[1]][];
		for (int i = 0, h = q.length; i < h; i++) {
			q[i] = ints();
			q[i][0]--;
			q[i][1]--;
		}
		int[][][] g = packUW(q, c[0]);
		int[] dp = new int[c[0]];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		PriorityQueue<int[]> que = new PriorityQueue<>(
			(a, b) -> Integer.compare(a[1], b[1])
		);

		que.add(new int[] { 0, 0 });
		while (!que.isEmpty()) {
			int[] r = que.poll();
			if (dp[r[0]] < r[1]) continue;
			for (int[] e : g[r[0]]) {
				int v = Math.max(r[1], e[1]);
				if (v < dp[e[0]]) {
					dp[e[0]] = v;
					que.add(new int[] { e[0], v });
				}
			}
		}

		writer.println(
			dp[dp.length - 1] == Integer.MAX_VALUE
				? "NO PATH EXISTS"
				: dp[dp.length - 1]
		);
	}

	static int[][][] packUW(int[][] e, int n) {
		int[] q = new int[n];
		int[][][] g = new int[n][][];
		for (int[] ed : e) {
			q[ed[0]]++;
			q[ed[1]]++;
		}
		for (int i = 0; i < n; i++) {
			g[i] = new int[q[i]][2];
		}
		for (int[] ed : e) {
			g[ed[0]][--q[ed[0]]][0] = ed[1];
			g[ed[0]][q[ed[0]]][1] = ed[2];
			g[ed[1]][--q[ed[1]]][0] = ed[0];
			g[ed[1]][q[ed[1]]][1] = ed[2];
		}
		return g;
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		Jack_goes_to_Rapture obj = new Jack_goes_to_Rapture();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public Jack_goes_to_Rapture() {
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

	public void close() throws IOException {
		writer.flush();
		writer.close();
		bf.close();
	}
}
