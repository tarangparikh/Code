import java.io.*;

public class MaximumSubarraySum {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	void run() throws IOException {
		i();
		int[] d = ni();
		long p = 0;
		long m = 0;
		long s = Integer.MIN_VALUE;
		for (int e : d) {
			p += e;
			s = Math.max(p - m, s);
			m = Math.min(p, m);
		}
		writer.println(s);
	}

	public static int sm(int[] d) {
		return 0;
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		MaximumSubarraySum obj = new MaximumSubarraySum();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public MaximumSubarraySum() {
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
