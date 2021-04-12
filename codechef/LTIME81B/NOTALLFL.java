import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class NOTALLFL {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	int solve(int[] d, int k) {
		int[] h = new int[k + 1];
		Arrays.fill(h, -1);
		int max = 1;
		for (int i = 0, l = d.length; i < l; i++) {
			max = Math.max(i - h[d[i]] - 1, max);
			h[d[i]] = i;
		}
		for (int i = 1, v = d.length, l = h.length; i < l; i++) {
			max = Math.max(v - h[i] - 1, max);
		}
		return max;
	}

	int solve1(int[] d, int k) {
		HashMap<Integer, Integer> h = new HashMap<>();
		int max = 1;
		for (int i = 0, l = d.length; i < l; i++) {
			max = Math.max(i - h.getOrDefault(d[i], -1) - 1, max);
			h.put(d[i], i);
		}
		for (int i = 1, v = d.length; i <= k; i++) {
			max = Math.max((v - h.getOrDefault(i, -1)) - 1, max);
		}
		return max;
	}

	void run() throws IOException {
		int t = getInt();
		while (t-- > 0) {
			int[] c = ints();
			int[] d = ints();
			sb.append(solve1(d, c[1]));
			if (t > 0) sb.append("\n");
		}
		writer.println(sb.toString());
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		NOTALLFL obj = new NOTALLFL();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public NOTALLFL() {
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
