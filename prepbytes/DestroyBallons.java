import java.io.*;

public class DestroyBallons {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	static int solve(int[] data) {
		int n = data.length;

		int[][] count = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) for (int j = 0; j <= n; j++) count[i][j] =
			0;
		for (int tt = 1; tt <= n; tt++) {
			for (int i = 0, j = tt - 1; j < n; i++, j++) {
				if (tt == 1) count[i][j] = 1; else {
					count[i][j] = 1 + count[i + 1][j];

					if (data[i] == data[i + 1]) count[i][j] =
						Math.min(1 + count[i + 2][j], count[i][j]);
					for (int kth = i + 2; kth <= j; kth++) if (
						data[i] == data[kth]
					) count[i][j] =
						Math.min(
							count[i + 1][kth - 1] + count[kth + 1][j],
							count[i][j]
						);
				}
			}
		}
		return count[0][n - 1];
	}

	void run() throws IOException {
		i();
		int[] d = ni();
		writer.println(solve(d));
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		DestroyBallons obj = new DestroyBallons();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public DestroyBallons() {
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
