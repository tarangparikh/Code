import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class RoomAllocation {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = false;

	void run() throws IOException {
		int n = i();
		int[][] q = new int[n][];
		for (int i = 0; i < n; i++) {
			q[i] = ni();
			int[] t = new int[] { q[i][0], q[i][1], i };
			q[i] = t;
		}
		Arrays.sort(
			q,
			(a, b) -> {
				if (a[0] == b[0]) return a[1] - b[1]; else return a[0] - b[0];
			}
		);
		//writer.println(Arrays.deepToString(q));
		PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		PriorityQueue<Integer> free = new PriorityQueue<>();
		int total = 0;
		int[] allotment = new int[n];
		for (int[] g : q) {
			// for(int[] e : que){
			//     writer.print(Arrays.toString(e)+" ");
			// }
			// writer.println();
			// writer.println("Free : "+free);
			int arr = g[0];
			while (!que.isEmpty() && que.peek()[0] < arr) free.add(
				que.poll()[1]
			);
			if (free.isEmpty()) {
				total += 1;
				que.add(new int[] { g[1], total });
				allotment[g[2]] = total;
			} else {
				que.add(new int[] { g[1], free.peek() });
				allotment[g[2]] = free.poll();
			}
		}
		writer.println(total);
		for (int e : allotment) {
			writer.print(e + " ");
		}
		writer.println();
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		RoomAllocation obj = new RoomAllocation();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public RoomAllocation() {
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
