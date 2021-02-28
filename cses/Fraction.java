import java.io.*;
import java.util.TreeMap;

public class Fraction {

  BufferedReader bf;
  PrintWriter writer;
  StringBuilder sb;
  static boolean local_system = false;

  private int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
  }

  int solve(int[] x, int[] y) {
    for (int i = 0, h = x.length; i < h; i++) {
      int gcd = gcd(x[i], y[i]);
      x[i] /= gcd;
      y[i] /= gcd;
    }
    TreeMap<int[], Integer> hash = new TreeMap<>(
      (a, b) -> {
        if (a[0] == b[0]) return a[1] - b[1]; else return a[0] - b[0];
      }
    );
    int max = 1;
    for (int i = 0, h = x.length; i < h; i++) {
      int[] key = new int[] { x[i], y[i] };
      int value = hash.getOrDefault(key, 0) + 1;
      max = Math.max(value, max);
      hash.put(key, hash.getOrDefault(key, 0) + 1);
    }
    return max;
  }

  void run() throws IOException {
    int[] x = { 1, 2 };
    int[] y = { 1, 2 };
    writer.println(solve(x, y));
  }

  public static void main(String[] args) throws IOException {
    long start_time = System.currentTimeMillis();
    Fraction obj = new Fraction();
    obj.run();
    long end_time = System.currentTimeMillis();
    if (local_system) obj.writer.println("Time : " + (end_time - start_time));
    obj.close();
  }

  public Fraction() {
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
