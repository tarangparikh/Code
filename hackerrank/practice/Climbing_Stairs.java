import java.io.*;
import java.util.*;

public class Climbing_Stairs {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	long mod = 1_000_000_007L;

	long[][] mul(final long[][] a, final long[][] b) {
		final int p = a.length;
		final int q = b[0].length;
		final int r = a[0].length;
		final long[][] res = new long[p][q];
		for (int i = 0; i < p; i++) {
			for (int j = 0; j < q; j++) {
				for (int k = 0; k < r; k++) {
					res[i][j] = (res[i][j] + (a[i][k] * b[k][j]) % mod) % mod;
				}
			}
		}
		return res;
	}

	long[][] pow(long[][] a, long e) {
		long[][] mat = unit(a.length);
		for (; e > 0; e >>= 1) {
			if ((e & 1) == 1) mat = mul(a, mat);
			a = mul(a, a);
		}
		return mat;
	}

	long[][] unit(final int s) {
		final long[][] m = new long[s][s];
		for (int i = 0; i < s; i++) m[i][i] = 1L;
		return m;
	}

	long solve(final long n) {
		final long[][] m = new long[][] { { 1, 1 }, { 1, 0 } };
		final long[][] i = new long[][] { { 1, 0 } };
		final long[][] ans = mul(i, pow(m, n));
		return ans[0][1];
	}

	long solve(final String n) {
		long[][] u = unit(2);
		long[][] m = new long[][] { { 1, 1 }, { 1, 0 } };
		final char[] d = n.toCharArray();
		for (int i = d.length - 1; i >= 0; i--) {
			if (d[i] == '1') u = mul(u, m);
			m = mul(m, m);
		}
		final long[][] i = new long[][] { { 1, 0 } };
		final long[][] ans = mul(i, u);
		return ans[0][1];
	}

	void run() throws IOException {
		int t = getInt();
		while (t-- > 0) {
			sb.append(solve(getLong())).append("\n");
		}
		writer.println(sb.toString().trim());
	}

	void generateOutput() throws IOException {
		final String folder = "./test/";
		final File file = new File(folder);
		final File[] listFiles = file.listFiles();

		for (File f : listFiles) {
			final BufferedReader bf = new BufferedReader(
				new InputStreamReader(new FileInputStream(f))
			);
			int t = Integer.parseInt(bf.readLine().trim());
			final StringBuilder sb = new StringBuilder();
			String suff = f.getName().split("input")[1].split("[.]")[0];
			while (t-- > 0) {
				final long n = Long.parseLong(bf.readLine().trim());
				sb.append(solve(n)).append("\n");
			}
			final PrintWriter printWriter = new PrintWriter(
				folder + "output" + (suff) + ".txt"
			);
			printWriter.append(sb.toString().trim());
			printWriter.flush();
			printWriter.close();
			bf.close();
		}
	}

	public static void main(final String[] args) throws IOException {
		final long start_time = System.currentTimeMillis();
		final Climbing_Stairs obj = new Climbing_Stairs();
		obj.run();
		final long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public Climbing_Stairs() {
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
		final String[] data = bf.readLine().split(" ");
		final int[] send = new int[data.length];
		for (int i = 0, h = data.length; i < h; i++) send[i] =
			Integer.parseInt(data[i]);
		return send;
	}

	public long[] longs() throws IOException {
		final String[] data = bf.readLine().split(" ");
		final long[] send = new long[data.length];
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
