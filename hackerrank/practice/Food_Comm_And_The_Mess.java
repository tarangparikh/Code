import java.io.*;
import java.util.*;

public class Food_Comm_And_The_Mess {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	void run() throws IOException {
		int t = getInt();
		while (t-- > 0) {
			int[] c = ints();
			int[] d = ints();
			//Arrays.sort(d);
			int max = d[d.length - 1];
			for (int e : d) max = Math.max(max, e);
			int r = 500 * 500000;
			int i = max;

			// while(i<r){
			//     int mid = (i+r) >> 1;
			//     if(solve1(d, mid)<=c[1]) r = mid;
			//     else i = mid + 1;
			// }

			writer.println(solve1(d, 20));
		}
	}

	int solve1(int[] d, int c) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int e : d) {
			map.put(e, map.getOrDefault(e, 0) + 1);
		}
		int count = 0;
		int left = 0;
		while (!map.isEmpty()) {
			Map.Entry<Integer, Integer> entry = map.floorEntry(left);
			if (entry == null) {
				count++;
				left = c;
			} else {
				if (entry.getValue() == 1) {
					map.remove(entry.getKey());
				} else {
					map.put(entry.getKey(), entry.getValue() - 1);
				}
				left -= entry.getKey();
			}
		}
		return count;
	}

	int solve(int[] d, int c) {
		int count = 0;
		int sum = 0;
		for (int e : d) {
			if (sum + e > c) {
				count++;
				sum = 0;
			}
			sum += e;
		}
		return sum > 0 ? count + 1 : count;
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		Food_Comm_And_The_Mess obj = new Food_Comm_And_The_Mess();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public Food_Comm_And_The_Mess() {
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

	public void close() throws IOException {
		writer.flush();
		writer.close();
		bf.close();
	}
}
