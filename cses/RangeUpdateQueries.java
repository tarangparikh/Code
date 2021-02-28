import java.io.*;

public class RangeUpdateQueries {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	long query(long[] d, int i) {
		long s = 0;
		for (++i; i > 0; s += d[i], i -= i & -i);
		return s;
	}

	void update(long[] d, int i, int v) {
		int n = d.length;
		for (++i; i < n; d[i] += v, i += i & -i);
	}

	void update(long[] d, int i, int j, int v) {
		update(d, i, v);
		update(d, j + 1, -v);
	}

	void run() throws IOException {
		int[] c = ni();
		int n = c[0];
		int q = c[1];

		int[] d = ni();
		long[] bit = new long[d.length + 5];
		for (int i = 0; i < n; i++) update(bit, i + 1, i + 1, d[i]);
		for (int i = 0; i < q; i++) {
			int[] qu = ni();
			if (qu[0] == 1) {
				update(bit, qu[1], qu[2], qu[3]);
			} else {
				writer.println(query(bit, qu[1]));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		RangeUpdateQueries obj = new RangeUpdateQueries();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public RangeUpdateQueries() {
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
