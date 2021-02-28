import java.io.*;
import java.util.*;

public class _438 {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	boolean isValid(int[] a, int[] b) {
		for (int i = 0, h = a.length; i < h; i++) {
			if (a[i] != b[i]) return false;
		}
		return true;
	}

	ArrayList<Integer> solve(char[] s, char[] p) {
		int[] hash = new int[128];
		for (char e : p) hash[e]++;
		int[] roll = new int[128];
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0, h = s.length, l = p.length; i < h; i++) {
			roll[s[i]]++;
			if (i - l >= 0) roll[s[i - l]]--;
			if (isValid(roll, hash)) list.add(i - l + 1);
		}
		return list;
	}

	void run() throws IOException {
		char[] s = bf.readLine().trim().toCharArray();
		char[] p = bf.readLine().trim().toCharArray();
		writer.println(solve(s, p));
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		_438 obj = new _438();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public _438() {
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
