import java.io.*;
import java.util.Arrays;

public class Components_in_a_graph {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	void solve(int[][] g) {
		int[] s = new int[g.length];
		int[] dp = new int[g.length];
		Arrays.fill(dp, -1);
		int t = -1;
		int c = -1;
		for (int i = 0, h = dp.length; i < h; i++) {
			if (dp[i] == -1) {
				s[++t] = i;
				dp[i] = ++c;
				while (t != -1) {
					int ind = s[t--];
					for (int e : g[ind]) {
						if (dp[e] == -1) {
							dp[e] = c;
							s[++t] = e;
						}
					}
				}
			}
		}
		int[] hash = new int[++c];
		for (int e : dp) hash[e]++;
		Arrays.sort(hash);
		int i = 0;
		while (i < hash.length && hash[i] == 1) i++;
		writer.println((hash[i] + " " + hash[hash.length - 1]));
	}

	void run() throws IOException {
		int n = i();
		int[][] q = new int[n][];
		for (int i = 0; i < n; i++) {
			q[i] = ni();
			q[i][0]--;
			q[i][1]--;
		}
		int[][] g = packU(q, n << 1);
		solve(g);
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
		Components_in_a_graph obj = new Components_in_a_graph();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public Components_in_a_graph() {
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
