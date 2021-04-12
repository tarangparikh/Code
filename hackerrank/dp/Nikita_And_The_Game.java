import java.io.*;
import java.util.*;

public class Nikita_And_The_Game {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	static long solve(int[] d) {
		long[] prefix = new long[d.length + 1];
		for (int i = 1, h = prefix.length; i < h; i++) prefix[i] =
			prefix[i - 1] + d[i - 1];
		return dfs(prefix, 1, prefix.length - 1);
	}

	static long dfs(long[] prefix, int s, int e) {
		if (s == e) return 0;
		for (int i = s; i < e; i++) {
			if (prefix[i] - prefix[s - 1] == prefix[e] - prefix[i]) {
				long a = dfs(prefix, s, i);
				long b = dfs(prefix, i + 1, e);
				return a > b ? a + 1 : b + 1;
			}
		}
		return 0;
	}

	static long solve1(int[] d) {
		long[] prefix = new long[d.length + 1];
		for (int i = 1, h = prefix.length; i < h; i++) {
			prefix[i] = prefix[i - 1] + d[i - 1];
		}

		return idfs(prefix, 1, prefix.length - 1);
	}

	static long idfs(long[] prefix, int i, int j) {
		if (j - i < 1) return 0;
		long sum = prefix[j] - prefix[i - 1];
		if (sum % 2 == 1) return 0;
		sum >>= 1;
		long find = prefix[i - 1] + sum;
		int index = lb(prefix, i, j, find);
		if (index < 0) return 0;
		long a = idfs(prefix, i, index);
		long b = idfs(prefix, index + 1, j);
		return Math.max(a + 1, b + 1);
	}

	static int lb(long[] d, int i, int j, long v) {
		while (i < j) {
			int mid = (i + j) >> 1;
			if (v <= d[mid]) j = mid; else i = mid + 1;
		}
		if (i >= d.length || d[i] != v) return -1;
		return i;
	}

	void run() throws IOException {
		int t = i();
		while (t-- > 0) {
			i();
			int[] d = ni();
			writer.println(solve1(d));
		}
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		Nikita_And_The_Game obj = new Nikita_And_The_Game();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public Nikita_And_The_Game() {
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
