import java.io.*;
import java.util.Arrays;

public class Merging_Communities {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	class DJSet {

		int[] upper;

		DJSet(int n) {
			upper = new int[n];
			Arrays.fill(upper, -1);
		}

		int root(int x) {
			return upper[x] < 0 ? x : (upper[x] = root(upper[x]));
		}

		void union(int x, int y) {
			x = root(x);
			y = root(y);
			if (x != y) {
				if (y < x) {
					int t = y;
					y = x;
					x = t;
				}
				upper[x] += upper[y];
				upper[y] = x;
			}
		}

		boolean equi(int x, int y) {
			return root(x) == root(y);
		}

		int size(int x) {
			return -upper[root(x)];
		}
	}

	void run() throws IOException {
		int[] c = ni();
		DJSet set = new DJSet(c[0] + 1);
		while (c[1]-- > 0) {
			String[] q = bf.readLine().trim().split(" ");
			if (q[0].equals("Q")) {
				int a = Integer.parseInt(q[1]);
				writer.println(set.size(a));
			} else {
				int a = Integer.parseInt(q[1]);
				int b = Integer.parseInt(q[2]);
				set.union(a, b);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		Merging_Communities obj = new Merging_Communities();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public Merging_Communities() {
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
