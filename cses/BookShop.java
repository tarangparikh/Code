import java.io.*;

public class BookShop {

  BufferedReader bf;
  PrintWriter writer;
  StringBuilder sb;
  static boolean local_system = false;

  int solve1(int[] p, int[] pa, int x) {
    int[][] dp = new int[2][x + 1];
    int n = p.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= x; j++) {
        dp[1][j] = j - p[i] >= 0 ? pa[i] + dp[0][j - p[i]] : 0;
        dp[1][j] = Math.max(dp[1][j], dp[0][j]);
      }
      int[] t = dp[0];
      dp[0] = dp[1];
      dp[1] = t;
    }
    return dp[0][x];
  }

  void run() throws IOException {
    int[] c = ni();
    int x = c[1];
    int[] p = ni();
    int[] pa = ni();
    writer.println(solve1(p, pa, x));
  }

  public static void main(String[] args) throws IOException {
    long start_time = System.currentTimeMillis();
    BookShop obj = new BookShop();
    obj.run();
    long end_time = System.currentTimeMillis();
    if (local_system) obj.writer.println("Time : " + (end_time - start_time));
    obj.close();
  }

  public BookShop() {
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
