import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

public class Playlist {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	void run() throws IOException {
		i();
		int[] d = ni();
		HashMap<Integer, Integer> pl = new HashMap<>();
		int len = 0;
		int max = 0;
		for (int i = 0, h = d.length; i < h; i++) {
			if (pl.containsKey(d[i]) && pl.get(d[i]) >= i - len) len =
				i - pl.get(d[i]) - 1;
			pl.put(d[i], i);
			len++;
			max = Math.max(len, max);
		}
		writer.println(max);
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		Playlist obj = new Playlist();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public Playlist() {
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
