import java.io.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Climbing_Stairs_Test {

	BufferedReader bf;
	PrintWriter writer;
	StringBuilder sb;
	static boolean local_system = true;

	void run() throws IOException {
		Random random = new Random();
		int test_b = 100000;
		long text_n = 1_000_000_000_000_000_000L;

		String folder = "./test/";

		int file = 15;

		int i = 0;

		while (file-- > 0) {
			int t = random.nextInt(test_b) + 1;
			StringBuilder sb = new StringBuilder();
			sb.append(t).append("\n");
			while (t-- > 0) {
				sb
					.append(ThreadLocalRandom.current().nextLong(text_n) + 1)
					.append("\n");
			}
			PrintWriter printWriter = new PrintWriter(
				folder + "input" + (getNum(i)) + ".txt"
			);
			printWriter.print(sb.toString().trim());
			printWriter.flush();
			printWriter.close();
			i++;
		}
	}

	String getNum(int i) {
		StringBuilder sb = new StringBuilder();
		if (i / 10 == 0) {
			sb.append(0);
		}
		sb.append(i);
		return sb.toString().trim();
	}

	public static void main(String[] args) throws IOException {
		long start_time = System.currentTimeMillis();
		Climbing_Stairs_Test obj = new Climbing_Stairs_Test();
		obj.run();
		long end_time = System.currentTimeMillis();
		if (local_system) obj.writer.println(
			"Time : " + (end_time - start_time)
		);
		obj.close();
	}

	public Climbing_Stairs_Test() {
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
