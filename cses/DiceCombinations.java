import java.io.*;

public class DiceCombinations {

  BufferedReader bf;
  PrintWriter writer;
  StringBuilder sb;
  static boolean local_system = false;

  long mod = 1_000_000_007;

  public long[][] matrixMul(long[][] a, long[][] b) {
    int n = a.length;
    int m = a[0].length;
    int k = b[0].length;
    long[][] res = new long[n][k];
    for (int i = 0; i < n; i++) for (int j = 0; j < k; j++) for (
      int p = 0;
      p < m;
      p++
    ) res[i][j] = (res[i][j] + (a[i][p] * b[p][j]) % mod) % mod;
    return res;
  }

  public long[][] matrixPow(long[][] a, long p) {
    if (p == 0) return matrixUnit(a.length); else if (
      p % 2 == 0
    ) return matrixPow(matrixMul(a, a), p / 2); else return matrixMul(
      a,
      matrixPow(a, p - 1)
    );
  }

  public long[][] matrixUnit(int n) {
    long[][] res = new long[n][n];
    for (int i = 0; i < n; ++i) {
      res[i][i] = 1;
    }
    return res;
  }

  /**
   * 16 8 4 2 1 1
   *
   * 1 1 0 0 0 0
   * 1 0 1 0 0 0
   * 1 0 0 1 0 0
   * 1 0 0 0 1 0
   * 1 0 0 0 0 1
   * 1 0 0 0 0 0
   *
   * @throws IOException
   */
  void run() throws IOException {
    long[][] bast = new long[][] { { 16, 8, 4, 2, 1, 1 } };
    long[][] fact = new long[][] {
      { 1, 1, 0, 0, 0, 0 },
      { 1, 0, 1, 0, 0, 0 },
      { 1, 0, 0, 1, 0, 0 },
      { 1, 0, 0, 0, 1, 0 },
      { 1, 0, 0, 0, 0, 1 },
      { 1, 0, 0, 0, 0, 0 },
    };
    int n = i();
    int p = Math.max(n - 5, 0);
    long[][] mul = matrixMul(bast, matrixPow(fact, p));
    writer.println(n < 6 ? mul[0][5 - n] : mul[0][0]);
  }

  public static void main(String[] args) throws IOException {
    long start_time = System.currentTimeMillis();
    DiceCombinations obj = new DiceCombinations();
    obj.run();
    long end_time = System.currentTimeMillis();
    if (local_system) obj.writer.println("Time : " + (end_time - start_time));
    obj.close();
  }

  public DiceCombinations() {
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
