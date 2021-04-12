import java.io.*;
import java.util.*;

public class Spirallytraversingamatrix {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	void run() throws IOException {
		int t = getInt();
		while (t-- > 0) {
			int[] c = ints();
			int[] d = ints();
			int[][] s = convert(d, c);
			//System.out.println(Arrays.deepToString(s));
			writer.println(solve(s));
		}
	}

	String solve(int[][] d) {
		int a = 0;
		int c = d.length - 1;
		int b = 0;
		int m = d[0].length - 1;
		StringBuilder sb = new StringBuilder();
		while (a <= c && b <= m && a >= 0 && c >= 0 && b >= 0 && m >= 0) {
			sb.append(solve(d, a, b, c, m));
			a++;
			b++;
			c--;
			m--;
		}
		return sb.toString().trim();
	}

	String solve(int[][] m, int a, int b, int c, int d) {
		StringBuilder sb = new StringBuilder();
		for (int i = b; i <= d; i++) {
			sb.append(m[a][i]).append(" ");
		}
		for (int i = a + 1; i <= c; i++) {
			sb.append(m[i][d]).append(" ");
		}
		for (int i = d - 1; i >= b && a != c; i--) {
			sb.append(m[c][i]).append(" ");
		}
		for (int i = c - 1; i >= a + 1 && b != d; i--) {
			sb.append(m[i][b]).append(" ");
		}
		return sb.toString();
	}

	int[][] convert(int[] d, int[] c) {
		int[][] s = new int[c[0]][c[1]];
		for (int i = 0, h = c[0]; i < h; i++) {
			for (int j = 0, v = c[1]; j < v; j++) {
				s[i][j] = d[c[1] * i + j];
			}
		}
		return s;
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		Spirallytraversingamatrix obj = new Spirallytraversingamatrix();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public Spirallytraversingamatrix() {
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
