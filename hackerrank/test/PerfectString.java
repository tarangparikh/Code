import java.io.*;
import java.util.Arrays;

public class PerfectString {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	int solve(String s) {
		char[] d = s.toCharArray();
		int n = d.length;
		int[][] hash = new int[d.length + 1][52];
		for (int i = 1; i < hash.length; i++) {
			System.arraycopy(hash[i - 1], 0, hash[i], 0, 52);
			if (d[i - 1] >= 'a' && d[i - 1] <= 'z') hash[i][d[i - 1] -
				'a']++; else hash[i][d[i - 1] - 'A' + 26]++;
		}
		int min = Integer.MAX_VALUE;
		int[] freq = new int[52];
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = 0; k < 52; k++) freq[k] =
					hash[j + 1][k] - hash[i][k];
				if (isValid(freq)) min = Math.min(j - i + 1, min);
			}
		}
		return min == Integer.MAX_VALUE ? -1 : min;
	}

	boolean isValid(int[] hash) {
		for (int i = 0; i < 26; i++) {
			if (hash[i] > 0 && hash[i + 26] == 0) return false;
			if (hash[i + 26] > 0 && hash[i] == 0) return false;
		}
		return true;
	}

	void run() throws IOException {
		int t = getInt();
		while (t-- > 0) {
			writer.println(solve(bf.readLine().trim()));
		}
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		PerfectString obj = new PerfectString();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public PerfectString() {
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
