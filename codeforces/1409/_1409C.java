import java.io.*;

public class _1409C {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	void run() throws IOException {
		int t = i();
		while (t-- > 0) {
			long[] c = nl();
			int n = (int) c[0];
			long x = c[1];
			long y = c[2];
			long diff = y - x;
			long last_min = Long.MAX_VALUE;
			long first_min = Long.MAX_VALUE - n + 1;
			for (int i = n; i >= 2; i--) {
				for (int j = i - 1; j >= 1; j--) {
					int gap = i - j;
					if (diff % gap == 0) {
						long d = diff / gap;
						long last = (n - i) * d + y;
						long first = x - (j - 1) * d;
						if (first > 0 && last < last_min) {
							last_min = last;
							first_min = first;
						}
					}
				}
			}
			long d = (last_min - first_min) / (n - 1);
			int i = 0;
			while (i < n) {
				writer.print(first_min + " ");
				first_min += d;
				i++;
			}
			writer.println();
		}
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		_1409C obj = new _1409C();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public _1409C() {
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
