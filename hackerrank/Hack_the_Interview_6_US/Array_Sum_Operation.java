import java.io.*;
import java.util.Arrays;

public class Array_Sum_Operation {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	String solve(int n, int[] q) {
		int[] hash = new int[500005];
		Arrays.fill(hash, -1);
		for (int i = 1; i <= n; i++) hash[i] = i;
		int f = 1;
		int l = n;
		StringBuilder sb = new StringBuilder();
		long sum = ((long) n * ((long) n + 1l)) >> 1;
		for (int e : q) {
			if (hash[e] != -1) {
				int t = hash[f];
				hash[f] = hash[l];
				hash[l] = t;
				t = f;
				f = l;
				l = t;
			} else {
				hash[l] = -1;
				hash[e] = n;
				sum -= l;
				sum += e;
				l = e;
			}
			sb.append(sum).append("\n");
		}

		return sb.toString().trim();
	}

	void run() throws IOException {
		int[] c = new int[2];
		c[0] = getInt();
		c[1] = getInt();
		int[] q = new int[c[1]];
		for (int i = 0, h = q.length; i < h; i++) q[i] = getInt();
		writer.println(solve(c[0], q));
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		Array_Sum_Operation obj = new Array_Sum_Operation();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public Array_Sum_Operation() {
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
