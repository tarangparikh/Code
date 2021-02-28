import java.io.*;

public class CoinCombinationsII {

  BufferedReader bf;
  PrintWriter writer;
  StringBuilder sb;
  static boolean local_system = false;

  void run() throws IOException {
    int[] c = ni();
    int n = c[0];
    int x = c[1];
    c = ni();
    long mod = 1_000_000_007;
    long[] dp = new long[x + 1];
    dp[0] = 1;
    for (int i = 0; i < n; i++) {
      for (int j = 1, h = dp.length; j < h; j++) {
        dp[j] = (dp[j] + (j - c[i] >= 0 ? dp[j - c[i]] : 0)) % mod;
      }
    }
    writer.println(dp[x]);
  }

  public static void main(String[] args) throws IOException {
    long start_time = System.currentTimeMillis();
    CoinCombinationsII obj = new CoinCombinationsII();
    obj.run();
    long end_time = System.currentTimeMillis();
    if (local_system) obj.writer.println("Time : " + (end_time - start_time));
    obj.close();
  }

  public CoinCombinationsII() {
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
