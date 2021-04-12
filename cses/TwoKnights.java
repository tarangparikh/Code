import java.io.*;
import java.util.Arrays;

public class TwoKnights {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = true;

	void run() throws IOException {
		int n = 9;
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int c = 0;
				if (i + 1 < n && j - 2 >= 0) c++;
				if (i + 2 < n && j - 1 >= 0) c++;
				if (i + 1 < n && j + 2 < n) c++;
				if (i + 2 < n && j + 1 < n) c++;
				dp[i][j] = c;
			}
		}
		for (int[] e : dp) writer.println(Arrays.toString(e));
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		TwoKnights obj = new TwoKnights();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public TwoKnights() {
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
