import java.io.*;
import java.util.*;

public class Rooms {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    long solve(int[] a,int[] b){
        TreeSet<int[]> set = new TreeSet<>(Comparator.comparingInt(x -> x[0]));
        for(int i = 0,h=a.length;i<h;i++){
            int x = a[i];
            int y = a[i] + b[i] ;
            if(!set.contains(new int[]{x})) set.add(new int[]{x,0});
            if(!set.contains(new int[]{y})) set.add(new int[]{y,0});

            int[] xx = set.floor(new int[]{x});
            xx[1]+=1;
            int[] yy = set.floor(new int[]{y});
            yy[1]-=1;
        }

        long mx = 0;
        long dp = 0;
        for(int[] e : set){
            dp += e[1];
            mx = Math.max(dp,mx);
        }
        return mx;
    }

    void run() throws IOException {
        int t = i();
        while(t-->0){
            i();
            int[] a = ni();
            int[] b = ni();
            sb.append(solve(a,b)).append("\n");
        }
        writer.println(sb.toString().trim());
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        Rooms obj = new Rooms();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public Rooms(){
        writer = new PrintWriter(System.out);
        bf = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
    }

    public int i() throws IOException {
        return Integer.parseInt(bf.readLine().trim());
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


