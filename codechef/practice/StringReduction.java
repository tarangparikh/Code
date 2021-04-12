import java.io.*;

class StringReduction {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	int solve(String s) {
		char[] d = s.toCharArray();
		int[] hash = new int[26];
		for (char e : d) hash[e - 'a']++;
		int count = 0;
		for (int e : hash) count += e - 1 >= 0 ? e - 1 : 0;
		return count;
	}

	void run() throws IOException {
		writer.println(solve(bf.readLine().trim()));
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		StringReduction obj = new StringReduction();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public StringReduction() {
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
