import java.io.*;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Towers {

  BufferedReader bf;
  PrintWriter writer;
  StringBuilder sb;
  static boolean local_system = false;

  void run() throws IOException {
    int n = i();
    int[] d = ni();
    TreeMap<Integer, Integer> hash = new TreeMap<>();
    for (int i = 0; i < n; i++) {
      Entry<Integer, Integer> entry = hash.higherEntry(d[i]);
      if (entry == null) {
        hash.put(d[i], hash.getOrDefault(d[i], 0) + 1);
      } else {
        int key = entry.getKey();
        int new_key = d[i];
        if (entry.getValue() == 1) hash.remove(key); else hash.put(
          key,
          entry.getValue() - 1
        );
        hash.put(new_key, hash.getOrDefault(new_key, 0) + 1);
      }
    }
    long count = 0;
    for (Entry<Integer, Integer> entry : hash.entrySet()) {
      count += entry.getValue();
    }
    writer.println(count);
  }

  public static void main(String[] args) throws IOException {
    long start_time = System.currentTimeMillis();
    Towers obj = new Towers();
    obj.run();
    long end_time = System.currentTimeMillis();
    if (local_system) obj.writer.println("Time : " + (end_time - start_time));
    obj.close();
  }

  public Towers() {
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
