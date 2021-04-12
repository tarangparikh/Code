import java.io.*;
import java.util.Arrays;

class LCOLLIS {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	void run() throws IOException {
		int t = i();
		long[] f = new long[11];
		f[0] = 1;
		for (int i = 1, h = f.length; i < h; i++) f[i] = f[i - 1] * i;
		while (t-- > 0) {
			int[] c = ni();
			String[] d = new String[c[0]];
			for (int i = 0, h = d.length; i < h; i++) d[i] = bf.readLine();
			int[] count = new int[c[1]];
			for (String s : d) for (int i = 0, h = s.length(); i < h; i++) if (
				s.charAt(i) == '1'
			) count[i]++;
			long sum = 0;
			for (int e : count) if (e > 1) sum += f[e] / (f[e - 2] * f[2]);
			sb.append(sum).append("\n");
		}
		writer.println(sb.toString().trim());
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		LCOLLIS obj = new LCOLLIS();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public LCOLLIS() {
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
