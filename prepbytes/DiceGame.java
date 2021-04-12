import java.io.*;

public class DiceGame {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	void run() throws IOException {
		int t = i();
		while (t-- > 0) {
			int n = i();
			int[] d = ni();
			int[] hash = new int[2];
			for (int i = 0; i < d.length; i++) {
				hash[i % 2] += d[i] % 2 == 0 ? 1 : 0;
			}
			writer.print(hash[0] == hash[1] ? "Ben" : "Jim");
			if (t > 0) writer.println();
		}
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		DiceGame obj = new DiceGame();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public DiceGame() {
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
