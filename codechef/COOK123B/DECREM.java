import java.io.*;

class DECREM {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	void run() throws IOException {
		int t = i();
		while (t-- > 0) {
			int[] c = ni();
			writer.println(c[1] % c[0] < c[1] - c[0] ? -1 : c[1]);
		}
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		DECREM obj = new DECREM();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public DECREM() {
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
