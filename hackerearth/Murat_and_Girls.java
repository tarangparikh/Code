import java.io.*;

public class Murat_and_Girls {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	void run() throws IOException {
		int m = i();
		int[] hash = new int[10001];
		int[] mq = ni();
		for (int e : mq) hash[e] = 1;
		int t = i();
		int qg = 0;
		while (t-- > 0) {
			int count = 0;
			for (int e : ni()) if (hash[e] >= 1) count++;
			qg += count == m ? 1 : 0;
		}
		writer.println(qg);
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		Murat_and_Girls obj = new Murat_and_Girls();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public Murat_and_Girls() {
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
