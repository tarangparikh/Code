import java.io.*;
import java.util.TreeMap;
import java.util.TreeSet;

public class TrafficLights {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	void run() throws IOException {
		int[] c = ni();
		TreeSet<Integer> set = new TreeSet<>();
		TreeMap<Integer, Integer> map = new TreeMap<>((a, b) -> b - a);
		map.put(c[0], 1);
		set.add(0);
		set.add(c[0]);
		int[] d = ni();
		for (int i = 0; i < c[1]; i++) {
			if (!set.contains(d[i])) {
				int l = set.lower(d[i]);
				int h = set.higher(d[i]);
				int len = h - l;
				int value = map.get(len);
				if (value == 1) map.remove(len); else map.put(len, value - 1);
				int a = d[i] - l;
				int b = h - d[i];
				map.put(a, map.getOrDefault(a, 0) + 1);
				map.put(b, map.getOrDefault(b, 0) + 1);
				set.add(d[i]);
			}
			//writer.println(map);
			writer.print(map.firstKey() + " ");
		}
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		TrafficLights obj = new TrafficLights();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public TrafficLights() {
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
