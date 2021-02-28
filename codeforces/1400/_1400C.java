import java.io.*;
import java.util.*;

public class _1400C {

	static BufferedReader bf = new BufferedReader(
		new InputStreamReader(System.in)
	);
	static PrintWriter writer = new PrintWriter(System.out);

	static void close() throws IOException {
		bf.close();
		writer.flush();
		writer.close();
	}

	static int i() throws IOException {
		return Integer.parseInt(bf.readLine().trim());
	}

	static int[] ni() throws IOException {
		String[] d = bf.readLine().trim().split(" ");
		int[] s = new int[d.length];
		for (int i = 0, h = d.length; i < h; i++) s[i] = Integer.parseInt(d[i]);
		return s;
	}

	static long mod = 1_000_000_007;

	static long pow(long a, long b) {
		long p = 1L;
		for (; b > 0; a = a * a % mod, b >>= 1) if ((b & 1) == 1) p =
			p * a % mod;
		return p;
	}

	static int lcs(String a, String b) {
		int[][] dp = new int[a.length() + 1][b.length() + 1];
		for (int i = 1, h = a.length() + 1; i < h; i++) {
			for (int j = 1, v = b.length() + 1; j < v; j++) {
				dp[i][j] =
					a.charAt(i) == b.charAt(j)
						? dp[i - 1][j - 1] + 1
						: Math.max(dp[i][j - 1], dp[i - 1][j]);
			}
		}
		return dp[a.length()][b.length()];
	}

	static void update(int[] d, int i, int v) {
		int n = d.length;
		for (++i; i < n; d[i] += v, i += i & -i);
	}

	static int query(int[] d, int i) {
		int s = 0;
		for (++i; i > 0; s += d[i], i -= i & -i);
		return s;
	}

	public static void main(String... args) throws IOException {
		int t = i();
		while (t-- > 0) {
			char[] d = bf.readLine().trim().toCharArray();
			int[][] bits = new int[26][d.length + 5];
			for (int i = 0, h = d.length; i < h; i++) {
				update(bits[d[i] - 'a'], i, 1);
			}
		}

		close();
	}
}
