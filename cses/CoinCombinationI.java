import java.io.*;

public class CoinCombinationI {

  BufferedReader bf;
  PrintWriter writer;
  StringBuilder sb;
  static boolean local_system = true;

  //Getting timeout
  void run() throws IOException {
    int[] c = ni();
    int n = c[0];
    int mod = 1_000_000_007;
    int[] d = ni();
    int[] dp = new int[c[1] + 1];
    dp[0] = 1;
    for (int i = 1, h = dp.length; i < h; i++) {
      for (int j = 0, l = d.length; j < l; j++) {
        dp[i] = i - d[j] >= 0 ? (dp[i] + dp[i - d[j]]) % mod : dp[i];
      }
    }
    writer.println(dp[c[1]]);
  }

  public static void main(String[] args) throws IOException {
    long start_time = System.currentTimeMillis();
    CoinCombinationI obj = new CoinCombinationI();
    obj.run();
    long end_time = System.currentTimeMillis();
    if (local_system) obj.writer.println("Time : " + (end_time - start_time));
    obj.close();
  }

  public CoinCombinationI() {
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
