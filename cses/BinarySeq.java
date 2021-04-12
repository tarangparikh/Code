import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;

public class BinarySeq {

	BufferedReader bf;

	/**
	 * Version 2
	 *
	 * @throws IOException
	 */
	void run() throws IOException {
		long[] dp = new long[40];
		dp[0] = 1;
		dp[1] = 2;

		for (int i = 2; i < dp.length; i++) dp[i] = dp[i - 1] + dp[i - 2];

		int t = i();
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			long n = i() + 1;
			long res = 0;
			int i = dp.length;
			while (n > 1) {
				while (dp[i - 1] >= n) i--;
				res |= 1l << (i - 1);
				n -= dp[i - 1];
			}
			sb.append(Long.toBinaryString(res)).append("\n");
		}
		System.out.println(sb.toString().trim());
	}

	public static void main(String[] args) throws IOException {
		BinarySeq obj = new BinarySeq();
		obj.run();
		obj.close();
	}

	public BinarySeq() {
		bf = new BufferedReader(new InputStreamReader(System.in));
	}

	public int i() throws IOException {
		return Integer.parseInt(bf.readLine().trim());
	}

	public void close() throws IOException {
		bf.close();
	}
}
