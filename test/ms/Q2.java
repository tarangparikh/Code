import java.io.*;
import java.util.*;

public class Q2 {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	void run() throws IOException {
		getInt();
		solve(ints());
	}

	void solve(int[] d) {
		int[] prefix = new int[d.length + 1];
		TreeMap<Integer, Integer> count = new TreeMap<>();

		for (int i = 0, h = d.length; i < h; i++) {
			prefix[i + 1] += prefix[i];
			prefix[i + 1] += d[i] == 0 ? -1 : d[i];
			count.put(prefix[i + 1], i);
		}

		int len = -1;
		int s = -1;
		int e = -1;

		//System.out.println(count);

		for (int i = 0, h = d.length; i < h; i++) {
			if (count.containsKey(prefix[i])) {
				int last = count.get(prefix[i]);
				if (last != i) {
					int l = last - i + 1;

					//System.out.println(last+" "+i);

					if (l > len) {
						len = l;
						s = i + 1;
						e = last + 1;
					}
				}
			}
		}
		writer.print(len < 0 ? -1 : s + " " + e);
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		Q2 obj = new Q2();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public Q2() {
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
