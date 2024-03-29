import java.io.*;

public class RemovalGame {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = true;

	void run() throws IOException {
		int n = i();
		long[] d = nl();
		long[] p = new long[n + 1];
		for (int i = 1; i <= n; i++) p[i] = p[i - 1] + d[i - 1];
		long[][] dp = new long[n][n];
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		RemovalGame obj = new RemovalGame();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public RemovalGame() {
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
