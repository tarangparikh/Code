import java.io.*;
import java.util.Arrays;

public class Min_Max_Riddle {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	void run() throws IOException {
		getInt();
		int[] d = ints();
		int[] ng = new int[d.length];
		int[] pg = new int[d.length];
		Arrays.fill(ng, d.length);
		Arrays.fill(pg, -1);
		int[] s = new int[d.length];
		int t = -1;
		for (int i = 0, h = d.length; i < h; i++) {
			while (t != -1 && d[i] < d[s[t]]) ng[s[t--]] = i;
			s[++t] = i;
		}
		t = -1;
		for (int i = d.length - 1; i >= 0; i--) {
			while (t != -1 && d[i] < d[s[t]]) pg[s[t--]] = i;
			s[++t] = i;
		}
		int[] max = new int[d.length];
		for (int i = 0, h = d.length; i < h; i++) {
			int l = ng[i] - pg[i] - 1;
			max[l - 1] = Math.max(d[i], max[l - 1]);
		}

		for (int i = max.length - 2; i >= 0; i--) {
			max[i] = Math.max(max[i + 1], max[i]);
		}

		for (int e : max) sb.append(e + " ");
		writer.println(sb.toString().trim());
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		Min_Max_Riddle obj = new Min_Max_Riddle();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public Min_Max_Riddle() {
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
