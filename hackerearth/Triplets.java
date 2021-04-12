import java.io.*;
import java.util.Arrays;

public class Triplets {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	void run() throws IOException {
		int t = i();
		while (t-- > 0) {
			int n = i();
			int[] a = ni();
			int[] b = ni();

			int[] position = new int[n];
			for (int i = 0; i < n; i++) position[a[i] - 1] = i + 1;
			for (int i = 0; i < n; i++) a[i] = position[b[i] - 1];

			//writer.println(Arrays.toString(a));

			long[] bit_1 = new long[n + 5];
			long[] bit_2 = new long[n + 5];

			int limit = n;

			long sum = 0;
			for (int i = n - 1; i >= 0; i--) {
				long valid = query(bit_2, limit) - query(bit_2, a[i]);
				long larger = query(bit_1, limit) - query(bit_1, a[i]);
				// writer.print(larger+" ");
				// writer.println(valid);

				sum += valid;
				update(bit_2, a[i], larger);
				update(bit_1, a[i], 1);
			}
			writer.println(sum);
		}
	}

	void update(long[] bit, int i, long v) {
		int n = bit.length;
		for (++i; i < n; bit[i] += v, i += i & -i);
	}

	long query(long[] bit, int i) {
		long s = 0;
		for (++i; i > 0; s += bit[i], i -= i & -i);
		return s;
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		Triplets obj = new Triplets();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public Triplets() {
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
