import java.io.*;

public class SPREAD {

	static BufferedReader bf;
	static PrintWriter writer;
	static StringBuilder sb;
	static boolean local_system = false;

	static void update(long[] d, int i, long v) {
		int n = d.length;
		for (++i; i < n; d[i] += v, i += i & -1);
	}

	static long query(long[] d, int i) {
		long s = 0;
		for (++i; i > 0; s += d[i], i -= i & -i);
		return s;
	}

	static void run() throws IOException {
		int c[] = ints();
		long[] d = new long[c[0] + 5];
		update(d, 1, c[2]);
		update(d, c[0] + 1, -c[2]);
		while (c[1]-- > 0) {
			String[] s = bf.readLine().split(" ");
			if (s[0].equals("S")) {
				int a = Integer.parseInt(s[1]);
				int b = Integer.parseInt(s[2]);
				int v = Integer.parseInt(s[3]);
				update(d, a, v);
				update(d, b + 1, -v);
			} else {
				int a = Integer.parseInt(s[1]);
				sb.append(query(d, a)).append("\n");
			}
		}
		writer.println(sb.toString().trim());
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		writer = new PrintWriter(System.out);
		bf = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		run();
		long end_time = System.currentTimeMillis();
		if (local_system) writer.println("Time : " + (end_time - start_time));
		close();
	}

	public static int getInt() throws IOException {
		return Integer.parseInt(bf.readLine());
	}

	public static long getLong() throws IOException {
		return Long.parseLong(bf.readLine());
	}

	public static int[] ints() throws IOException {
		String[] data = bf.readLine().split(" ");
		int[] send = new int[data.length];
		for (int i = 0, h = data.length; i < h; i++) send[i] =
			Integer.parseInt(data[i]);
		return send;
	}

	public static long[] longs() throws IOException {
		String[] data = bf.readLine().split(" ");
		long[] send = new long[data.length];
		for (int i = 0, h = data.length; i < h; i++) send[i] =
			Long.parseLong(data[i]);
		return send;
	}

	public static void close() {
		writer.flush();
		writer.close();
	}
}
