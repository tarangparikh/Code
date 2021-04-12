import java.io.*;

public class RelativeSorting {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	String solve(int[] a, int[] b) {
		int[] hash = new int[1000001];
		for (int i = 0, h = a.length; i < h; i++) {
			hash[a[i]]++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0, h = b.length; i < h; i++) {
			for (int j = 0, v = hash[b[i]]; j < v; j++) {
				sb.append(b[i]).append(" ");
			}
			hash[b[i]] = 0;
		}
		for (int i = 0, h = hash.length; i < h; i++) {
			for (int j = 0, v = hash[i]; j < v; j++) {
				sb.append(i).append(" ");
			}
		}
		return sb.toString().trim();
	}

	void run() throws IOException {
		int t = getInt();
		while (t-- > 0) {
			int[] c = ints();
			int[] a = ints();
			int[] b = ints();
			sb.append(solve(a, b)).append("\n");
		}
		writer.println(sb.toString().trim());
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		RelativeSorting obj = new RelativeSorting();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public RelativeSorting() {
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
