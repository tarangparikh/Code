import java.io.*;
import java.security.KeyStore.Entry;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class FerrisWheel {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	void run() throws IOException {
		int[] c = ni();
		int x = c[1];
		int[] d = ni();
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int e : d) map.put(e, map.getOrDefault(e, 0) + 1);
		int left = 0;
		int count = 0;
		int current = 0;
		while (!map.isEmpty()) {
			if (current == 2) {
				current = 0;
				left = x;
				count++;
				continue;
			}
			Map.Entry<Integer, Integer> e = map.floorEntry(left);
			if (e == null) {
				left = x;
				count++;
				continue;
			}

			if (e.getValue() == 1) map.remove(e.getKey()); else map.put(
				e.getKey(),
				e.getValue() - 1
			);

			left -= e.getKey();
			current++;
		}
		writer.println(count);
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		FerrisWheel obj = new FerrisWheel();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public FerrisWheel() {
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
