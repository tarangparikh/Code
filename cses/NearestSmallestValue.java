import java.io.*;

public class NearestSmallestValue {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	void run() throws IOException {
		int n = i();
		int[] d = ni();
		int[] ps = new int[n];
		int[] s = new int[n];
		int t = -1;
		for (int i = d.length - 1; i >= 0; i--) {
			while (t != -1 && d[i] < d[s[t]]) ps[s[t--]] = i + 1;
			s[++t] = i;
		}
		for (int e : ps) writer.print(e + " ");
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		NearestSmallestValue obj = new NearestSmallestValue();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public NearestSmallestValue() {
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
