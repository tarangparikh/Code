import java.io.*;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class ConcertTickets {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    void run() throws IOException {
        int[] c = ni();
        int n = c[0];
        int m = c[1];
        int[] d = ni();
        int[] t = ni();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int e : d){
            map.put(e,map.getOrDefault(e,0) + 1);
        }
        for(int e : t){
            Map.Entry<Integer, Integer> entry = map.floorEntry(e);
            if(entry == null) sb.append(-1).append("\n");
            else{
                sb.append(entry.getKey()).append("\n");
                if(entry.getValue() == 1) map.remove(entry.getKey());
                else map.put(entry.getKey(),entry.getValue() - 1);
            }
        }
        writer.println(sb);
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        ConcertTickets obj = new ConcertTickets();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public ConcertTickets(){
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
        for (int i = 0, h = data.length; i < h; i++) send[i] = Integer.parseInt(data[i]);
        return send;
    }

    public long[] nl() throws IOException {
        String[] data = bf.readLine().split(" ");
        long[] send = new long[data.length];
        for (int i = 0, h = data.length; i < h; i++) send[i] = Long.parseLong(data[i]);
        return send;
    }

    public void close() throws IOException{
        writer.flush();
        writer.close();
        bf.close();
    }
}


