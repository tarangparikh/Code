import java.io.*;
import java.util.*;

public class Solving_for_Queries_with_Cups {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	void run() throws IOException {
		int[] c = ints();
		int[] m = ints();
		int[][] s = new int[c[2]][];
		int[][] q = new int[c[3]][];
		for (int i = 0, h = s.length; i < h; i++) s[i] = ints();
		for (int i = 0, h = q.length; i < h; i++) q[i] = ints();

		TreeSet<int[]> set = new TreeSet<>(
			(a, b) -> Integer.compare(a[0], b[0])
		);
		for (int i = 0, h = m.length; i < h; i++) {
			set.add(new int[] { m[i], 1 });
		}
		for (int[] sw : s) {
			if (!set.contains(new int[] { sw[0] })) set.add(
				new int[] { sw[0], 0 }
			);
			if (!set.contains(new int[] { sw[1] })) set.add(
				new int[] { sw[1], 0 }
			);

			int[] a = set.floor(new int[] { sw[0] });
			int[] b = set.floor(new int[] { sw[1] });

			int t = b[1];
			b[1] = a[1];
			a[1] = t;
		}

		int[][] data = set.stream().toArray(int[][]::new);
		int[] index = new int[data.length];
		int[] value = new int[data.length];
		for (int i = 0, h = data.length; i < h; i++) {
			index[i] = data[i][0];
			value[i] = data[i][1];
		}

		// System.out.println(Arrays.toString(index));
		// System.out.println(Arrays.toString(value));

		int[] prefix = new int[value.length + 1];
		for (int i = 1, h = prefix.length; i < h; i++) {
			prefix[i] = prefix[i - 1] + value[i - 1];
		}

		for (int[] qu : q) {
			if (qu[0] > index[index.length - 1] || qu[1] < index[0]) {
				sb.append("0").append(" ");
			}

			int i = Arrays.binarySearch(index, qu[0]);
			if (i < 0) i = -(i + 1);
			int j = Arrays.binarySearch(index, qu[1]);
			if (j < 0) j = -(j + 1) - 1;
			sb.append(prefix[j + 1] - prefix[i]).append(" ");
		}

		writer.println(sb.toString().trim());
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		Solving_for_Queries_with_Cups obj = new Solving_for_Queries_with_Cups();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public Solving_for_Queries_with_Cups() {
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

	public void close() throws IOException {
		writer.flush();
		writer.close();
		bf.close();
	}
}
