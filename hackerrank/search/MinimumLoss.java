import java.io.*;
import java.util.*;

public class MinimumLoss {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    void solve(long[] d){
        long[][] s = new long[d.length][2];
        for(int i = 0,h=d.length;i<h;i++){
            s[i] = new long[]{d[i],i};
        }
        Arrays.sort(s,(a,b)->Long.compare(a[0],b[0]));
        long min = Integer.MIN_VALUE;
        for(int i = 1,h=d.length;i<h;i++){
            if(s[i][1] < s[i-1][1]){
                min = Math.max(min,s[i-1][0] - s[i][0]);
            }
        }
        System.out.println(-min);
    }

    void run() throws IOException {
        getInt();
        solve(longs());
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        MinimumLoss obj = new MinimumLoss();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public MinimumLoss(){
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


