import java.io.*;

public class SortedSum {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;

	long mod = 1_000_000_007;

	long query(long[] d, int i) {
		long s = 0;
		for (++i; i > 0; s = s + d[i] % mod, i -= i & -i);
		return s;
	}

	void update(long[] d, int i, long v) {
		int n = d.length;
		for (++i; i < n; d[i] = d[i] + v % mod, i += i & -i);
	}

	void run() throws IOException {
		int n = getInt();
		int[] d = new int[n];
		for (int i = 0; i < n; i++) d[i] = getInt();
		long[] bit_sum = new long[1000005];
		long[] bit_qunt = new long[1000005];
		int limit = 1000001;
		long sum = 0;
		long prev = 0;
		for (int i = 0, h = d.length; i < h; i++) {
			long less = query(bit_qunt, d[i]) + 1;
			long more =
				query(bit_sum, limit) - query(bit_sum, d[i]) + mod % mod;

			long add = d[i] * less % mod;
			add = add + more % mod;
			add = prev + add % mod;
			prev = add;

			sum = sum + add % mod;

			update(bit_qunt, d[i], 1l);
			update(bit_sum, d[i], d[i]);
		}

		writer.println(sum);
	}

	public static void main(String[] args) throws IOException {
		SortedSum obj = new SortedSum();
		obj.run();
		obj.close();
	}

	public SortedSum() {
		writer = new PrintWriter(System.out);
		bf = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
	}

	public int getInt() throws IOException {
		return Integer.parseInt(bf.readLine());
	}

	public void close() throws IOException {
		writer.flush();
		writer.close();
		bf.close();
	}
}
