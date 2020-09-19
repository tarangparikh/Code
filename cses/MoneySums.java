import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class MoneySums {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    void run() throws IOException {
        int n = i();
        int[] d = ni();
        Set<Integer> one = new HashSet<>();
        one.add(0);
        Set<Integer> two = new HashSet<>();
        for(int i = 0;i<n;i++){
            for(int e : one){
                two.add(e + d[i]);
            }
            one.addAll(two);
            two = new HashSet<>();
        }
        one.remove(0);
        TreeSet<Integer> set = new TreeSet<>(one);
        writer.println(set.size()); 
        for(int e : set) writer.print(e + " ");
        writer.println();
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        MoneySums obj = new MoneySums();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public MoneySums(){
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


