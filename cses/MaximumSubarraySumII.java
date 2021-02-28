import java.io.*;
import java.util.*;

public class MaximumSubarraySumII {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	void run() throws IOException {
		int[] c = ni();
		int n = c[0];
		int a = c[1];
		int b = c[2];
		int l = b - a + 1;

		int[] d = ni();
		long[] p = new long[d.length + 1];
		for (int i = 1; i < p.length; i++) p[i] = p[i - 1] + d[i - 1];
		ArrayDeque<Integer> q = new ArrayDeque<>();
		long max = Long.MIN_VALUE;
		for (int i = p.length - 1; i >= 1; i--) {
			while (!q.isEmpty() && p[q.peekLast()] <= p[i]) q.pollLast();
			while (!q.isEmpty() && q.peekFirst() >= i + l) q.pollFirst();
			q.addLast(i);

			int index = i - a;
			if (index >= 0) max = Math.max(max, p[q.peekFirst()] - p[index]);
		}
		writer.println(max);
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		MaximumSubarraySumII obj = new MaximumSubarraySumII();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public MaximumSubarraySumII() {
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
