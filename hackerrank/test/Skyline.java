import java.io.*;

public class Skyline {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	void solve(int[] a, int[] b) {
		long[] hash_a = new long[100005];
		long[] hash_b = new long[100005];

		for (int e : a) hash_a[e]++;
		for (int e : b) hash_b[e]++;

		long min_sum = 0;
		for (int i = 0, h = hash_a.length; i < h; i++) {
			min_sum += (long) i * Math.max(hash_a[i], hash_b[i]);
		}

		long[] sum_b = new long[100005];
		for (int i = 1; i < hash_b.length; i++) {
			sum_b[i] = i * hash_b[i];
		}

		for (int i = 1, h = hash_b.length; i < h; i++) {
			hash_b[i] += hash_b[i - 1];
			sum_b[i] += sum_b[i - 1];
		}

		int lim = hash_b.length - 1;
		long max_sum = 0;
		for (int e : a) {
			max_sum += sum_b[e] + (long) ((long) e * (hash_b[lim] - hash_b[e]));
		}
		System.out.println(min_sum + " " + max_sum);
	}

	void run() throws IOException {
		int[] c = ints();
		int[] a = ints();
		int[] b = ints();

		//solve(a,b);

		long[] bit_s = new long[100005];
		long[] bit_q = new long[100005];
		long[] q_a = new long[100005];
		long[] q_b = new long[100005];

		for (int e : a) q_a[e]++;
		for (int e : b) q_b[e]++;
		long min_sum = 0;
		for (int i = 0, h = q_a.length; i < h; i++) {
			min_sum += Math.max(q_a[i], q_b[i]) * (long) i;
		}
		for (int i = 0, h = b.length; i < h; i++) {
			update(bit_s, b[i], b[i]);
			update(bit_q, b[i], 1);
		}

		long sum = 0;
		int lim = 100000;
		for (int i = 0, h = a.length; i < h; i++) {
			long aa = query(bit_s, a[i]);
			long qq = query(bit_q, lim) - query(bit_q, a[i]);
			sum += aa + (qq * a[i]);
		}
		writer.println(min_sum + " " + sum);
	}

	static long query(long[] d, int i) {
		long s = 0;
		for (++i; i > 0; s += d[i], i -= i & -i);
		return s;
	}

	static void update(long[] d, int i, long v) {
		int n = d.length;
		for (++i; i < n; d[i] += v, i += i & -i);
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		Skyline obj = new Skyline();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public Skyline() {
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
