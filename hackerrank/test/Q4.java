import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Q4 {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	List<Integer> solve(List<Integer> d) {
		return convert(solve(convert(d)));
	}

	int[] solve(int d[]) {
		Arrays.sort(d);
		int[] send = new int[d.length];

		if (d.length == 2 || d.length == 1) return d;
		if (d.length == 3) {
			int t = d[0];
			d[0] = d[2];
			d[2] = t;
			return d;
		}
		if (d.length % 2 == 0) {
			int m = d[0];
			int j = 1;
			int i = 0;
			for (; i < 2; i++) {
				send[i] = d[j++];
			}
			send[i++] = m;
			for (; i < send.length; i++) {
				send[i] = d[j++];
			}
		} else {
			int m1 = d[0];
			int m2 = d[1];
			int j = 2;
			int i = 0;
			for (; i < 2; i++) {
				send[i] = d[j++];
			}
			send[i++] = m1;
			for (; i < send.length - 1; i++) {
				send[i] = d[j++];
			}
			send[i++] = m2;
		}
		return send;
	}

	List<Integer> convert(int[] c) {
		return Arrays.stream(c).boxed().collect(Collectors.toList());
	}

	int[] convert(List<Integer> c) {
		return c.stream().mapToInt(i -> i).toArray();
	}

	void run() throws IOException {
		int t = getInt();
		int[] d = new int[t];
		int i = 0;
		while (t-- > 0) d[i++] = getInt();
		int[] ans = solve(d);
		StringBuilder sb = new StringBuilder();
		for (int e : ans) sb.append(e).append("\n");
		writer.println(sb.toString().trim());
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		Q4 obj = new Q4();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public Q4() {
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
