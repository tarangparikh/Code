import java.io.*;
import java.util.*;

public class Invert_Binary_Tree {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = true;

	void run() throws IOException {
		int n = getInt();
		int[][] q = new int[n - 1][];
		for (int i = 0, h = q.length; i < h; i++) {
			q[i] = ints();
			q[i][0]--;
			q[i][1]--;
		}
		int[] a = ints();
		int[] b = ints();

		int[][] g = packU(q, n);
		int[] dp = new int[n];

		Stack<int[]> s = new Stack<>();
		s.push(new int[] { 0, -1, 0 });
		while (!s.isEmpty()) {
			int[] r = s.pop();
			int inverted = a[r[0]] != b[r[0]] ? 1 : 0;
			if (r[2] == -1) {
				for (int e : g[r[0]]) {
					if (e != r[1]) {
						inverted &= dp[e];
					}
				}
				dp[r[0]] = inverted;
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

		System.out.println(Arrays.toString(dp));
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
		Invert_Binary_Tree obj = new Invert_Binary_Tree();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public Invert_Binary_Tree() {
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
