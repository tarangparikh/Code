import java.io.*;
import java.util.Arrays;

public class _1401C {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	void run() throws IOException {
		int t = i();
		while (t-- > 0) {
			i();
			int[] d = ni();
			int mi = d[0];
			for (int e : d) mi = Math.min(mi, e);
			int[] dc = new int[d.length];
			System.arraycopy(d, 0, dc, 0, d.length);
			Arrays.sort(dc);

			boolean notFound = false;
			for (int i = 0, h = d.length; i < h; i++) {
				if (notFound = d[i] != dc[i] && (d[i] % mi) > 0) break;
			}
			writer.println(notFound ? "NO" : "YES");
		}
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		_1401C obj = new _1401C();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public _1401C() {
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
