import java.io.*;
import java.util.*;

class CMPRSS {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	String solve(int[] d) {
		int s = d[0];
		int p = d[0];
		List<String> l = new ArrayList<>();
		for (int i = 1, h = d.length; i < h; i++) {
			if (d[i] != p + 1) {
				String ss;
				if (p - s + 1 > 2) {
					ss = s + "..." + p;
				} else if (p - s + 1 > 1) {
					ss = s + "," + p;
				} else {
					ss = Integer.toString(s);
				}
				l.add(ss);
				s = d[i];
			}
			p = d[i];
		}
		String ss;
		if (p - s + 1 > 2) {
			ss = s + "..." + p;
		} else if (p - s + 1 > 1) {
			ss = s + "," + p;
		} else {
			ss = Integer.toString(s);
		}
		l.add(ss);
		StringBuilder sb = new StringBuilder();
		for (int i = 0, h = l.size(); i < h; i++) {
			sb.append(l.get(i));
			if (i < h - 1) sb.append(",");
		}
		return sb.toString();
	}

	void run() throws IOException {
		int t = i();
		while (t-- > 0) {
			i();
			sb.append(solve(ni()));
			if (t > 0) sb.append("\n");
		}
		writer.println(sb.toString());
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		CMPRSS obj = new CMPRSS();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public CMPRSS() {
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
