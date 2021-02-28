import java.io.*;
import java.util.*;

public class Pairs {

	static BufferedReader bf = new BufferedReader(
		new InputStreamReader(System.in)
	);

	public static void main(String[] args) throws Exception {
		int[] c = ni();
		int[] d = ni();
		Arrays.sort(d);
		int count = 0;
		for (int i = 0, h = d.length; i < h; i++) {
			if (bs1(d, i + 1, h - 1, d[i] + c[1]) >= 0) count++;
		}
		System.out.print(count);
	}

	static boolean bs(int[] d, int i, int j, int v) {
		while (i <= j) {
			int mid = (i + j) >> 1;
			if (d[mid] == v) return true;
			if (d[mid] > v) j = mid - 1; else i = mid + 1;
		}
		return false;
	}

	static int bs1(int[] d, int i, int j, int v) {
		int mid = (i + j) >> 1;
		while (i <= j) {
			mid = (i + j) >> 1;
			if (d[mid] == v) return mid;
			if (d[mid] > v) j = mid - 1; else i = mid + 1;
		}
		return -mid - 1;
	}

	static int i() throws IOException {
		return Integer.parseInt(bf.readLine());
	}

	static int[] ni() throws IOException {
		String[] d = bf.readLine().split(" ");
		int[] s = new int[d.length];
		for (int i = 0, h = d.length; i < h; i++) s[i] = Integer.parseInt(d[i]);
		return s;
	}
}
