import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class MaxSum {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	static long solve(int n, int[] a, int[][] q) {
		int[][] g = packU(q, n);

		long[] dp = new long[n];
		for (int i = 0, h = a.length; i < h; i++) dp[i] = a[i];

		Stack<int[]> stack = new Stack<>();
		stack.push(new int[] { 0, -1, 0 });
		long max = a[0];
		while (!stack.isEmpty()) {
			int[] r = stack.pop();
			if (r[2] == -1) {
				long m1 = 0l;
				long m2 = 0l;
				for (int e : g[r[0]]) {
					if (e != r[1]) {
						if (dp[e] > m1) {
							m2 = m1;
							m1 = dp[e];
						} else if (dp[e] > m2) {
							m2 = dp[e];
						}
					}
				}
				max = Math.max(dp[r[0]] + m1 + m2, max);
				dp[r[0]] += Math.max(m1, m2);
			} else {
				r[2] = -1;
				stack.push(r);
				for (int e : g[r[0]]) {
					if (e != r[1]) {
						stack.push(new int[] { e, r[0], 0 });
					}
				}
			}
		}
		//writer.println(Arrays.toString(dp));
		return max;
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

	void run() throws IOException {
		int t = i();
		while (t-- > 0) {
			int n = i();
			int[] a = ni();
			int[][] q = new int[n - 1][];
			for (int i = 0; i < n - 1; i++) {
				q[i] = ni();
				q[i][0]--;
				q[i][1]--;
			}
			writer.println(solve(n, a, q));
		}
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		MaxSum obj = new MaxSum();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public MaxSum() {
		writer = new PrintWriter(System.out);
		bf = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
	}

	public int i() throws IOException {
		return Integer.parseInt(bf.readLine());
	}

	public int[] ni() throws IOException {
		String[] data = bf.readLine().split(" ");
		int[] send = new int[data.length];
		for (int i = 0, h = data.length; i < h; i++) send[i] =
			Integer.parseInt(data[i]);
		return send;
	}

	public void close() throws IOException {
		writer.flush();
		writer.close();
		bf.close();
	}
}
