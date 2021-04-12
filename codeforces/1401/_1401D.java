import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class _1401D {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	long mod = 1_000_000_007L;

	long solve(int[][] e, long[] m) {
		int[][] g = packU(e, e.length + 1);
		int[] dp = dfs(g);

		long[] count = new long[e.length];
		int i = 0;
		int n = e.length + 1;

		for (int[] ed : e) {
			int a = Math.min(dp[ed[0]], dp[ed[1]]);
			int b = n - a;
			count[i++] = ((long) a * (long) b);
		}

		Arrays.sort(count);
		Arrays.sort(m);

		int mlen = m.length;
		int clen = count.length;

		long[] mul = new long[n - 1];
		Arrays.fill(mul, 1L);
		if (mlen < clen) {
			for (int ii = mlen - 1, j = n - 2; ii >= 0; ii--, j--) {
				mul[j] = m[ii];
			}
		} else {
			for (int ii = mlen - 1; ii >= 0; ii--) {
				int j = Math.min(ii, n - 2);
				mul[j] = (mul[j] * m[ii]) % mod;
			}
		}
		long sum = 0;
		for (int ii = 0; ii < clen; ii++) {
			sum = (sum + ((count[ii] % mod) * mul[ii]) % mod) % mod;
		}

		return sum;
	}

	int[] dfs(int[][] g) {
		int[] dp = new int[g.length];
		Arrays.fill(dp, 1);
		Stack<int[]> s = new Stack<>();
		s.push(new int[] { 0, -1, 0 });
		while (!s.isEmpty()) {
			int[] r = s.pop();
			if (r[2] == -1) {
				for (int e : g[r[0]]) {
					if (e != r[1]) {
						dp[r[0]] += dp[e];
					}
				}
			} else {
				r[2] = -1;
				s.push(r);
				for (int e : g[r[0]]) {
					if (e != r[1]) {
						s.push(new int[] { e, r[0], 0 });
					}
				}
			}
		}
		return dp;
	}

	void run() throws IOException {
		int t = i();
		while (t-- > 0) {
			int n = i();
			int[][] q = new int[n - 1][];
			for (int i = 0, h = q.length; i < h; i++) {
				q[i] = ni();
				q[i][0]--;
				q[i][1]--;
			}
			i();
			long[] m = nl();
			sb.append(solve(q, m)).append("\n");
		}
		writer.println(sb.toString().trim());
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
		_1401D obj = new _1401D();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public _1401D() {
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
