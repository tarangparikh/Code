import java.io.*;
import java.util.Arrays;

public class _1535 {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    int solve(int[] d,int k){
        int[] hash = new int[11];
        int max = d[0];
        for(int i = 1,h=d.length;i<h;i++){
            max = Math.max(d[i],max);
            hash[max]++;
            if(hash[max]>=k) break;
        
        }
        return max;
    }

    void run() throws IOException {
        int k = getInt();
        System.out.println(solve(ints(),k));
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        _1535 obj = new _1535();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public _1535(){
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


