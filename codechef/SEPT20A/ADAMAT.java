import java.io.*;

class ADAMAT {

	BufferedReader b;
	PrintWriter w;
	StringBuilder sb;
	static boolean local_system = false;

	/**
	 * 0 0 0
	 * 0 1 1
	 * 1 0 1
	 * 1 1 0
	 *
	 * @throws IOException
	 */
	void run() throws IOException {
		int t = i();
		while (t-- > 0) {
			int r = i();
			int[] d = ni();
			for (int i = 1; i < r; i++) b.readLine();
			int s = 0;
			for (int i = r - 1, x = 0; i > 0; i--) {
				int res = (d[i] == (i + 1) ? 0 : 1);
				s += res ^ x;
				x = res;
			}
			w.println(s);
		}
	}

	public static void main(String[] args) throws IOException {
		long s = System.currentTimeMillis();
		ADAMAT o = new ADAMAT();
		o.run();
		long e = System.currentTimeMillis();
		if (local_system) o.w.println("Time : " + (e - s));
		o.close();
	}

	public ADAMAT() {
		w = new PrintWriter(System.out);
		b = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
	}

	public int i() throws IOException {
		return Integer.parseInt(b.readLine());
	}

	public long l() throws IOException {
		return Long.parseLong(b.readLine());
	}

	public int[] ni() throws IOException {
		String[] d = b.readLine().split(" ");
		int[] s = new int[d.length];
		for (int i = 0, h = d.length; i < h; i++) s[i] = Integer.parseInt(d[i]);
		return s;
	}

	public long[] nl() throws IOException {
		String[] d = b.readLine().split(" ");
		long[] s = new long[d.length];
		for (int i = 0, h = d.length; i < h; i++) s[i] = Long.parseLong(d[i]);
		return s;
	}

	public void close() throws IOException {
		w.flush();
		w.close();
		b.close();
	}
}
