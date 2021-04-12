import java.io.*;
import java.util.*;

public class CHECK {

	static BufferedReader bf = new BufferedReader(
		new InputStreamReader(System.in)
	);

	static void close() throws IOException {
		bf.close();
	}

	static int getInt() throws IOException {
		return Integer.parseInt(bf.readLine().trim());
	}

	static int[] getInts() throws IOException {
		String[] data = bf.readLine().split(" ");
		int[] send = new int[data.length];
		for (int i = 0, h = data.length; i < h; i++) send[i] =
			Integer.parseInt(data[i]);
		return send;
	}

	public static void main(String[] args) throws IOException {
		int number = getInt();
		int[] dist = getInts();
		int[] liter = getInts();
		int[] cons = getInts();
		int p[] = new int[100005];
		Arrays.fill(p, -1);
		p[0] = cons[1];
		for (int i = 0; i < number; i++) p[dist[i]] += liter[i];

		for (int i = 1; i < p.length; i++) p[i] += p[i - 1];

		if (p[cons[0]] < 0) System.out.println(-1); else {
			int left = p[cons[0]];
			int remove = 0;
			Arrays.sort(liter);
			for (int i = 0; i < liter.length; i++) {
				if (left > liter[i]) {
					left -= liter[i];
					remove++;
				}
			}
			System.out.println(number - remove);
		}
	}
}
