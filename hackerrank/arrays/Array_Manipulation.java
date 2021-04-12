import java.io.*;

public class Array_Manipulation {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	long solve(int n, int[][] qu) {
		long[] d = new long[n + 1];
		for (int[] q : qu) {
			d[q[0] - 1] += q[2];
			d[q[1]] -= q[2];
		}
		long sum = d[0];
		for (int i = 1, h = d.length; i < h; i++) {
			d[i] += d[i - 1];
			sum = Math.max(sum, d[i]);
		}
		return sum;
	}

	void run() throws IOException {
		int[] c = ni();
		int[][] q = new int[c[1]][];
		for (int i = 0, h = q.length; i < h; i++) q[i] = ni();
		writer.println(solve(c[0], q));
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		Array_Manipulation obj = new Array_Manipulation();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public Array_Manipulation() {
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
