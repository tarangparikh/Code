import java.io.*;

public class _1534 {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	int solve(int[] d, int a, int b, int c) {
		int count = 0;
		for (int i = 0, h = d.length; i < h; i++) {
			for (int j = i + 1; j < h; j++) {
				for (int k = j + 1; k < h; k++) {
					if (
						Math.abs(d[i] - d[j]) <= a &&
						Math.abs(d[j] - d[k]) <= b &&
						Math.abs(d[k] - d[i]) <= c
					) count++;
				}
			}
		}
		return count;
	}

	void run() throws IOException {
		int[] c = ints();
		int[] d = ints();
		System.out.println(solve(d, c[0], c[1], c[2]));
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		_1534 obj = new _1534();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public _1534() {
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
