import java.io.*;
import java.util.*;

public class Q1 {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    void run() throws IOException {
        int t = getInt();
        int[] c = ints();
        HashSet<Double> slope = new HashSet<>();
        for(int i = 0;i<t;i++) slope.add(slope(c,ints()));
        writer.print(slope.size());
    }

    double slope(int[] a,int[] b){
        return ((double)a[0] - (double)b[0]) / ((double)a[1] - (double)b[1]); 
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        Q1 obj = new Q1();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public Q1(){
        writer = new PrintWriter(System.out);
        bf = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
    }

    public int getInt() throws IOException {
        return Integer.parseInt(bf.readLine());
    }

    public long getLong() throws IOException {
        return Long.parseLong(bf.readLine());
    }

    public int[] ints() throws IOException {
        String[] data = bf.readLine().split(" ");
        int[] send = new int[data.length];
        for (int i = 0, h = data.length; i < h; i++) send[i] = Integer.parseInt(data[i]);
        return send;
    }

    public long[] longs() throws IOException {
        String[] data = bf.readLine().split(" ");
        long[] send = new long[data.length];
        for (int i = 0, h = data.length; i < h; i++) send[i] = Long.parseLong(data[i]);
        return send;
    }

    public void close() {
        writer.flush();
        writer.close();
    }
}


