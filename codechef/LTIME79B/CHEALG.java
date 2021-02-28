import java.io.*;

class CHEALG {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	boolean solve(String a) {
		StringBuilder sb = new StringBuilder();
		char[] d = a.toCharArray();
		char prev = d[0];
		int count = 1;
		for (int i = 1, h = d.length; i < h; i++) {
			if (d[i] == prev) count++; else {
				sb.append(prev).append(count);
				prev = d[i];
				count = 1;
			}
		}
		sb.append(prev).append(count);

		System.out.println(sb.toString());
		return sb.toString().length() < a.length();
	}

	void run() throws IOException {
		int t = i();
		while (t-- > 0) {
			sb.append(solve(bf.readLine()) ? "YES" : "NO");
			if (t > 0) sb.append("\n");
		}
		writer.println(sb.toString().trim());
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		CHEALG obj = new CHEALG();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public CHEALG() {
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
