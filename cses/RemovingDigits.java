import java.io.*;
import java.util.Arrays;

public class RemovingDigits {

  BufferedReader bf;
  PrintWriter writer;
  StringBuilder sb;
  static boolean local_system = false;

  boolean valid(int n, int x) {
    while (n > 0) {
      if (n % 10 == x) return true;
      n /= 10;
    }
    return false;
  }

  void run() throws IOException {
    int[] dp = new int[1000010];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int i = 0; i < 1000001; i++) {
      for (int j = 1; j <= 9; j++) {
        if (valid(i + j, j)) {
          dp[i + j] = Math.min(dp[i + j], 1 + dp[i]);
        }
      }
    }
    writer.println(dp[i()]);
  }

  public static void main(String[] args) throws IOException {
    long start_time = System.currentTimeMillis();
    RemovingDigits obj = new RemovingDigits();
    obj.run();
    long end_time = System.currentTimeMillis();
    if (local_system) obj.writer.println("Time : " + (end_time - start_time));
    obj.close();
  }

  public RemovingDigits() {
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
