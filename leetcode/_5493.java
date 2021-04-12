import java.io.*;

public class _5493 {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = true;

	int bs(int[] d, int start, int end, int v) {
		int i = start;
		int j = end;
		int mid;
		while (i < j) {
			mid = (i + j) >> 1;
			//writer.println(i +" "+ j+" "+mid);
			if (v <= d[mid]) j = mid; else i = mid + 1;
		}
		mid = (i + j) >> 1;
		return d[mid] == v ? mid : -mid - 1;
	}

	int bs1(int[] d, int start, int end, int v) {
		int i = start;
		int j = end;
		int mid;
		while (i < j) {
			mid = (i + j + 1) >> 1;
			//writer.println(i +" "+ j+" "+mid);
			if (v >= d[mid]) i = mid; else j = mid - 1;
		}
		mid = (i + j + 1) >> 1;
		return d[mid] == v ? mid : -mid - 1;
	}

	int solve(int[] d) {
		int left = -1;
		int right = -1;
		for (int i = 0, h = d.length - 1; i < h; i++) {
			if (d[i] > d[i + 1]) {
				left = i;
				break;
			}
		}
		for (int i = d.length - 1; i > 0; i--) {
			if (d[i] < d[i - 1]) {
				right = i;
				break;
			}
		}

		// writer.println(righ1,12,15t+" "+left);

		if (left == -1 || right == -1) return 0;
		int min = d.length;
		for (int i = 0; i <= left; i++) {
			int index = bs(d, right, d.length - 1, d[i]);
			if (index < 0) index = -(index + 1);
			int len = index - i - 1;
			if (d[i] > d[index]) len += 1;
			min = Math.min(len, min);
			//writer.println(index + " " +len);
		}

		//writer.println("riht");
		for (int i = d.length - 1; i >= right; i--) {
			int index = bs1(d, 0, left, d[i]);
			if (index < 0) index = -(index + 1);
			int len = i - index - 1;
			if (d[i] < d[index]) len += 1;
			min = Math.min(len, min);
			//writer.println(index + " " +len);
		}
		return min;
	}

	void run() throws IOException {
		int[] d = new int[] { 1, 2, 3, 10, 4, 2, 3, 5 };
		int[] dd = new int[] { 5, 4, 3, 2, 1 };
		int[] ddd = new int[] { 16, 10, 0, 3, 22, 1, 14, 7, 1, 12, 15 };
		writer.println(solve(ddd));
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		_5493 obj = new _5493();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public _5493() {
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
