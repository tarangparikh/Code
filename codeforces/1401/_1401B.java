import java.io.*;

public class _1401B {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = true;

	void run() throws IOException {
		int t = i();
		while (t-- > 0) {
			int[] a = ni();
			int[] b = ni();
			long sum = 0;

			long s = Math.min(b[1], a[2]);
			sum += s << 1;
			a[2] -= s;
			b[1] -= s;
			s = Math.min(a[2], b[2]);
			a[2] -= s;
			b[2] -= s;
			s = Math.min(a[2], b[0]);
			a[2] -= s;
			b[0] -= s;
			s = Math.min(a[0], b[2]);
			b[2] -= s;
			a[0] -= s;
			s = Math.min(a[0], b[1]);
			b[1] -= s;
			a[0] -= s;
			s = Math.min(a[0], b[0]);
			b[0] -= s;
			a[0] -= s;
			s = Math.min(a[1], b[0]);
			a[1] -= s;
			b[0] -= s;
			s = Math.min(a[1], b[1]);
			a[1] -= s;
			b[1] -= s;
			s = Math.min(a[1], b[2]);
			a[1] -= s;
			b[2] -= s;
			sum -= s << 1;
			writer.println(sum);
		}
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		_1401B obj = new _1401B();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public _1401B() {
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
