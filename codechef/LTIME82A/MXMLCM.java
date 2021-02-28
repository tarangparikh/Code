import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

class MXMLCM {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = true;

	void run() throws IOException {
		int[] d = new SOE(10005).getData();
		System.out.println(d.length);
	}

	class SOE {

		private final boolean[] prime;
		private final int size;
		private final int[] data;

		public int[] getData() {
			return data;
		}

		public SOE(int size) {
			this.size = size;
			this.prime = new boolean[size + 1];
			Arrays.fill(this.prime, true);
			this.data = makeData();
		}

		private int[] makeData() {
			int count = this.prime.length;
			for (int p = 2; p * p <= this.size; p++) {
				// If prime[p] is not changed, then it is a prime
				if (prime[p]) {
					// Update all multiples of p
					for (int i = p * p; i <= this.size; i += p) prime[i] =
						false;
				}
			}

			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 2, h = this.prime.length; i < h; i++) {
				if (this.prime[i]) {
					list.add(i);
				}
			}
			return list.stream().mapToInt(value -> value).toArray();
		}
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		MXMLCM obj = new MXMLCM();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public MXMLCM() {
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
