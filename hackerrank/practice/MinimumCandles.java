import java.io.*;

public class MinimumCandles {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	int solve(int[] data, int b) {
		int possible = -1;
		int ans = 0;
		int n = data.length;
		while (true) {
			int or = possible;
			for (
				int i = Math.min(n - 1, possible + b);
				i > possible - (b - 1) && i >= 0;
				i--
			) {
				if (data[i] == 1) {
					possible = i + b - 1;
					ans++;
					break;
				}
			}
			if (or == possible) return -1;
			if (possible >= n - 1) break;
		}
		return ans;
	}

	void run() throws IOException {
		int[] d = new int[] { 0, 0, 0, 1, 0 };
		int k = 3;
		writer.println(solve(d, k));
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		MinimumCandles obj = new MinimumCandles();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public MinimumCandles() {
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
