import java.io.*;
import java.util.Arrays;
import java.util.TreeSet;

public class SlidingMedian {

  BufferedReader bf;
  PrintWriter writer;
  StringBuilder sb;
  static boolean local_system = false;

  class SlidingWindow {

    TreeSet<int[]> min;
    TreeSet<int[]> max;

    public SlidingWindow() {
      this.min =
        new TreeSet<>(
          (a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1]; else return a[0] - b[0];
          }
        );
      this.max =
        new TreeSet<>(
          (a, b) -> {
            if (a[1] != b[1]) return b[1] - a[1]; else return a[0] - b[0];
          }
        );
    }

    public int add(int[] p) {
      int n = max.size();
      int m = min.size();
      if (n == m) {
        if (n == 0) max.add(p); else {
          int[] r = max.first();
          if (p[1] > r[1]) min.add(p); else max.add(p);
        }
      } else {
        int[] r;
        if (n > m) r = max.pollFirst(); else r = min.pollFirst();
        if (r[1] > p[1]) {
          min.add(r);
          max.add(p);
        } else {
          min.add(p);
          max.add(r);
        }
      }

      // System.out.println("Added : "+Arrays.toString(p));
      // System.out.println("-------------");
      // for(int[] e : max){
      //     System.out.println(Arrays.toString(e));
      // }
      // System.out.println("-------------");
      // for(int[] e : min){
      //     System.out.println(Arrays.toString(e));
      // }
      // System.out.println("-------------");

      if (
        max.size() >= min.size()
      ) return max.first()[1]; else return min.first()[1];
    }

    public int remove(int[] p) {
      if (min.contains(p)) min.remove(p); else max.remove(p);

      int n = max.size();
      int m = min.size();

      if (n > m + 1) min.add(max.pollFirst()); else if (m > n + 1) max.add(
        min.pollFirst()
      );

      if (
        max.size() >= min.size()
      ) return max.first()[1]; else return min.first()[1];
    }
  }

  void run() throws IOException {
    SlidingWindow window = new SlidingWindow();
    int[] c = ni();
    int[] data = ni();
    int k = c[1];
    int n = c[0];
    int[][] dp = new int[n][];
    int median = 0;

    for (int i = 0; i < k; i++) {
      median = window.add(dp[i] = new int[] { i, data[i] });
    }
    sb.append(median).append(' ');
    for (int i = k; i < n; i++) {
      window.add(dp[i] = new int[] { i, data[i] });
      median = window.remove(dp[i - k]);
      sb.append(median).append(' ');
    }
    writer.println(sb);
  }

  public static void main(String[] args) throws IOException {
    long start_time = System.currentTimeMillis();
    SlidingMedian obj = new SlidingMedian();
    obj.run();
    long end_time = System.currentTimeMillis();
    if (local_system) obj.writer.println("Time : " + (end_time - start_time));
    obj.close();
  }

  public SlidingMedian() {
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
