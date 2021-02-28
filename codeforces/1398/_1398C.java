import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class _1398C {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	void solve(char[] d) {
		int[] p = new int[d.length + 1];
		HashMap<Integer, Integer> hash = new HashMap<>();
		hash.put(0, 1);
		long count = 0;
		for (int i = 1, h = p.length; i < h; i++) {
			p[i] += p[i - 1] + d[i - 1] - '0' - 1;
			count += hash.getOrDefault(p[i], 0);
			hash.put(p[i], hash.getOrDefault(p[i], 0) + 1);
		}
		writer.println(count);
	}

	void solve1(char[] d) {
		int p = 0;
		HashMap<Integer, Integer> hash = new HashMap<>();
		hash.put(0, 1);
		long count = 0;
		for (char e : d) {
			p += e - '0' - 1;
			count += hash.getOrDefault(p, 0);
			hash.put(p, hash.getOrDefault(p, 0) + 1);
		}
		writer.println(count);
	}

	void run() throws IOException {
		int t = i();
		while (t-- > 0) {
			i();
			solve1(bf.readLine().trim().toCharArray());
		}
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		_1398C obj = new _1398C();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public _1398C() {
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
