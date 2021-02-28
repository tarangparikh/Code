import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijMatrix {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	void run() throws IOException {
		// N and M from the Input
		int[] c = ints();

		// Value of N = Number of Rows
		int n = c[0];

		// Value of M = Number of Columns
		int m = c[1];

		// Declaration of matrix D
		int[][] d = new int[n][];

		// Taking Input of the matrix
		for (int i = 0; i < n; i++) d[i] = ints();

		// Declaring DP matrix of NxM dimension
		int[][] dp = new int[n][m];

		// Filling entrire DP with MAXIMUM VALUE of INTEGER
		for (int i = 0; i < n; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);

		// Maxium of first 0,0 index is 0
		dp[0][0] = 0;

		// Min heap based on current maximum for each index
		PriorityQueue<int[]> q = new PriorityQueue<>(
			(a, b) -> Integer.compare(a[2], b[2])
		);

		// Adding the frist Value (0,0,0) i = 0 j = 0 max = 0
		q.add(new int[] { 0, 0, 0 });

		// Looping till the queue is empty
		while (!q.isEmpty()) {
			// Removing minumum entry
			int[] r = q.poll();

			// ith index of current entry
			int i = r[0];

			// jth index of current entry
			int j = r[1];

			// Max for current entry
			int max = r[2];

			// Continue of previous iterations found minium value of maximum differece
			if (dp[i][j] < max) continue;

			/**
			 *  Checking for four possible directions
			 *
			 *  i + 1 , j
			 *  i - 1 , j
			 *  i , j + 1
			 *  i , j - 1
			 */

			if (i + 1 < n) {
				int v = Math.max(max, Math.abs(d[i + 1][j] - d[i][j]));
				if (v < dp[i + 1][j]) {
					dp[i + 1][j] = v;
					q.add(new int[] { i + 1, j, v });
				}
			}

			if (i - 1 >= 0) {
				int v = Math.max(max, Math.abs(d[i - 1][j] - d[i][j]));
				if (v < dp[i - 1][j]) {
					dp[i - 1][j] = v;
					q.add(new int[] { i - 1, j, v });
				}
			}

			if (j + 1 < m) {
				int v = Math.max(max, Math.abs(d[i][j + 1] - d[i][j]));
				if (v < dp[i][j + 1]) {
					dp[i][j + 1] = v;
					q.add(new int[] { i, j + 1, v });
				}
			}

			if (j - 1 >= 0) {
				int v = Math.max(max, Math.abs(d[i][j - 1] - d[i][j]));
				if (v < dp[i][j - 1]) {
					dp[i][j - 1] = v;
					q.add(new int[] { i, j - 1, v });
				}
			}
		}

		// Minimum among all absolute difference on path till the n-1,m-1 index
		writer.println(dp[n - 1][m - 1]);
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		DijMatrix obj = new DijMatrix();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public DijMatrix() {
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
