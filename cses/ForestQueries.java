import java.io.*;
import java.util.*;

public class ForestQueries {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	int query(int[][] pm, int a, int b, int c, int d) {
		int x = pm[c][d];
		x -= pm[a - 1][d];
		x -= pm[c][b - 1];
		x += pm[a - 1][b - 1];
		return x;
	}

	void run() throws IOException {
		int[] c = ni();
		int n = c[0];
		int q = c[1];
		char[][] forest = new char[n][];
		for (int i = 0; i < n; i++) forest[i] =
			bf.readLine().trim().toCharArray();
		int[][] pm = new int[n + 1][forest[0].length + 1];
		for (int i = 1, h = pm.length; i < h; i++) {
			for (int j = 1, l = pm[0].length; j < l; j++) {
				int v = forest[i - 1][j - 1] == '*' ? 1 : 0;
				int x = pm[i - 1][j];
				x += pm[i][j - 1];
				x -= pm[i - 1][j - 1];
				x += v;
				pm[i][j] = x;
			}
		}
		// for(int[] e : pm){
		//     writer.println(Arrays.toString(e));
		// }
		for (int i = 0; i < q; i++) {
			int[] qu = ni();
			writer.println(query(pm, qu[0], qu[1], qu[2], qu[3]));
		}
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		ForestQueries obj = new ForestQueries();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public ForestQueries() {
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
