import java.io.*;
import java.util.Arrays;

public class SumofFourValues {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = true;

	void run() throws IOException {
		int[] c = ni();
		int n = c[0];
		int t = c[1];
		int[] d = ni();
		Arrays.sort(d);
		long[][] dp = new long[n * (n - 1) / 2][];
		for (int i = 0, k = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				dp[k++] = new long[] { d[i] + d[j], i, j };
			}
		}
		int i = 0;
		int j = dp.length - 1;
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		SumofFourValues obj = new SumofFourValues();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public SumofFourValues() {
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
