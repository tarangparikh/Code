import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class BuildingTeams {

  BufferedReader bf;
  PrintWriter writer;
  StringBuilder sb;
  static boolean local_system = false;

  void run() throws IOException {
    int[] c = ni();
    int n = c[0];
    int m = c[1];
    int[] dp = new int[n];
    Arrays.fill(dp, -1);
    int[][] q = new int[m][];
    for (int i = 0; i < m; i++) {
      q[i] = ni();
      q[i][0]--;
      q[i][1]--;
    }
    int[][] g = packU(q, n);
    boolean notFound = false;
    for (int i = 0; i < n; i++) {
      if (notFound) break;
      if (dp[i] == -1) {
        // writer.println("Entering : " + i);
        Stack<int[]> s = new Stack<>();
        s.push(new int[] { i, 0 });
        dp[i] = 0;
        while (!s.isEmpty()) {
          int[] r = s.pop();
          int cc = r[1] ^ 1;
          int acc = r[1];
          for (int e : g[r[0]]) {
            if (notFound = dp[e] == acc) {
              // writer.println("Breaking : "+e +" ");
              break;
            }
            if (dp[e] == -1) {
              s.push(new int[] { e, cc });
              dp[e] = cc;
            }
          }
        }
      }
    }

    // System.out.println(Arrays.toString(dp));
    if (notFound) {
      writer.println("IMPOSSIBLE");
    } else {
      for (int e : dp) {
        writer.print((e + 1) + " ");
      }
      writer.println();
    }
  }

  static int[][] packU(int[][] e, int n) {
    int[] q = new int[n];
    int[][] g = new int[n][];
    for (int[] ed : e) {
      q[ed[0]]++;
      q[ed[1]]++;
    }
    for (int i = 0; i < n; i++) g[i] = new int[q[i]];
    for (int[] ed : e) {
      g[ed[0]][--q[ed[0]]] = ed[1];
      g[ed[1]][--q[ed[1]]] = ed[0];
    }
    return g;
  }

  public static void main(String[] args) throws IOException {
    long start_time = System.currentTimeMillis();
    BuildingTeams obj = new BuildingTeams();
    obj.run();
    long end_time = System.currentTimeMillis();
    if (local_system) obj.writer.println("Time : " + (end_time - start_time));
    obj.close();
  }

  public BuildingTeams() {
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
