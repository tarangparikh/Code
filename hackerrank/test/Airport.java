import java.io.*;

public class Airport {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	int solve(int n, String data) {
		String[] tokens = data.split(" ");
		int[][] matrix = new int[n][10];
		for (String token : tokens) {
			int[] index = getIndex(token);
			matrix[index[0]][index[1]] = 1;
		}
		int count = 0;
		for (int[] e : matrix) {
			count += getCount(e);
		}
		return count;
	}

	int getCount(int[] row) {
		int one = 0;
		one += row[1] == 0 && row[2] == 0 && row[3] == 0 && row[4] == 0 ? 1 : 0;
		one += row[5] == 0 && row[6] == 0 && row[7] == 0 && row[8] == 0 ? 1 : 0;
		int two = 0;
		two += row[3] == 0 && row[4] == 0 && row[5] == 0 && row[6] == 0 ? 1 : 0;
		return Math.max(one, two);
	}

	int[] getIndex(String d) {
		int len = d.length();
		int j = d.charAt(len - 1) - 'A';
		int i = 0;
		i = i * 10 + d.charAt(i) - '0';
		i = len > 2 ? i * 10 + d.charAt(i + 1) - '0' : i;
		return new int[] { i - 1, j };
	}

	void run() throws IOException {
		int t = getInt();
		while (t-- > 0) {
			int n = getInt();
			String tokens = bf.readLine().trim();
			writer.println(solve(n, tokens));
		}
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		Airport obj = new Airport();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public Airport() {
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
