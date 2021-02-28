import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class RestaurantCustomers {

  BufferedReader bf;
  PrintWriter writer;
  StringBuilder sb;
  static boolean local_system = false;

  void run() throws IOException {
    int n = i();
    TreeMap<Integer, Long> map = new TreeMap<>();
    for (int i = 0; i < n; i++) {
      int[] c = ni();
      map.put(c[0], map.getOrDefault(c[0], 0l) + 1);
      map.put(c[1] + 1, map.getOrDefault(c[1] + 1, 0l) - 1);
    }
    long max = 0;
    long cur = 0;
    for (Map.Entry<Integer, Long> entry : map.entrySet()) {
      cur += entry.getValue();
      max = Math.max(cur, max);
    }
    writer.println(max);
  }

  public static void main(String[] args) throws IOException {
    long start_time = System.currentTimeMillis();
    RestaurantCustomers obj = new RestaurantCustomers();
    obj.run();
    long end_time = System.currentTimeMillis();
    if (local_system) obj.writer.println("Time : " + (end_time - start_time));
    obj.close();
  }

  public RestaurantCustomers() {
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
