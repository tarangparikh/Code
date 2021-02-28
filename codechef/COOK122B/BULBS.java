import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

class BULBS {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	void run() throws IOException {
		int t = i();
		while (t-- > 0) {
			int[] c = ni();
			int n = c[0];
			int k = c[1];
			PriorityQueue<Integer> que = new PriorityQueue<>((a, b) -> b - a);
			char[] d = bf.readLine().trim().toCharArray();
			n = d.length;
			int i = -1;
			while ((i + 1) < n && d[i + 1] == '0') i++;
			int j = n;
			while ((j - 1 >= 0) && d[j - 1] == '0') j--;
			if (j == 0) {
				writer.println(0);
			} else {
				//writer.println(j+" "+i);
				long left = 0, right = left;
				if (j != n) right = n - j;
				if (i != -1) left = i + 1;

				int prev = i + 1;
				for (int kk = i + 2; kk < j; kk++) {
					if (d[kk] == '1') {
						int len = kk - prev - 1;
						if (len > 0) que.add(len);
						prev = kk;
					}
				}
				for (int e : que) {
					writer.println(e);
				}

				long count = 0;
				while (
					!que.isEmpty() && k >= 2 && (left + right) < que.peek()
				) {
					que.poll();
					k -= 2;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		BULBS obj = new BULBS();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public BULBS() {
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
