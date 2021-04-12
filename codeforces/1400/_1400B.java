import java.io.*;
import java.util.Arrays;

public class _1400B {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = true;

	void run() throws IOException {
		int t = i();
		while (t-- > 0) {
			int[] c = ni();
			int[] q = ni();
			int[] u = ni();
			int[][] data = new int[][] { { q[0], u[0] }, { q[1], u[1] } };
			Arrays.sort(
				data,
				(a, b) -> {
					if (a[1] == b[1]) return Integer.compare(b[0], a[0]);
					return Integer.compare(a[1], b[1]);
				}
			);
		}
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		_1400B obj = new _1400B();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public _1400B() {
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
