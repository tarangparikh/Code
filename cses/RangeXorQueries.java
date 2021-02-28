import java.io.*;

public class RangeXorQueries {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	void run() throws IOException {
		int[] c = ni();
		int n = c[0];
		int q = c[1];

		int[] d = ni();
		int[] px = new int[d.length + 1];
		for (int i = 1; i < px.length; i++) px[i] = px[i - 1] ^ d[i - 1];
		for (int i = 0; i < q; i++) {
			int[] qu = ni();
			writer.println(px[qu[1]] ^ px[qu[0] - 1]);
		}
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		RangeXorQueries obj = new RangeXorQueries();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public RangeXorQueries() {
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
