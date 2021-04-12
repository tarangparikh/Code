import java.io.*;

public class Max_Array_Sum {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	void run() throws IOException {
		getInt();
		long d[] = longs();
		if (d.length == 1) {
			writer.println(d[0]);
		} else {
			d[0] = Math.max(0, d[0]);
			d[1] = Math.max(d[0], d[1]);
			for (int i = 2, h = d.length; i < h; i++) {
				d[i] = Math.max(d[i - 2], Math.max(d[i - 1], d[i] + d[i - 2]));
			}
			writer.println(Math.max(d[d.length - 1], d[d.length - 2]));
		}
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		Max_Array_Sum obj = new Max_Array_Sum();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public Max_Array_Sum() {
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

	public void close() throws IOException {
		writer.flush();
		writer.close();
		bf.close();
	}
}
