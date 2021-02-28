import java.io.*;
import java.util.Arrays;

class BFRIEND {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	void run() throws IOException {
		int t = i();
		while (t-- > 0) {
			long[] c = nl();
			long[] d = nl();
			Arrays.sort(d);
			int i = Arrays.binarySearch(d, c[2]);
			if (i < 0) i = -(i + 1);
			long s = 0;
			if (c[2] > c[1] && i != 0) i -= 1;
			s = (Math.abs(d[i] - c[2]) + Math.abs(d[i] - c[1]) + c[3]);
			sb.append(s);
			if (t > 0) sb.append("\n");
		}
		writer.println(sb.toString());
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		BFRIEND obj = new BFRIEND();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public BFRIEND() {
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
