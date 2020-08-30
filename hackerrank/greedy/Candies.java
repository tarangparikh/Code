import java.io.*;
import java.util.Arrays;



public class Candies {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    void solve(int[] d){
        int[][] data = new int[d.length][];
        for(int i = 0,h=d.length;i<h;i++){
            data[i] = new int[]{d[i],i};
        }
        Arrays.sort(data,(a,b) -> a[0] - b[0]);
        int[] c = new int[d.length];
        long count = 0l; 
        for(int[] e : data){
            int i = e[1] + 1;
            int j = e[1] - 1;
            int cc = 0;
           
            if(i<d.length&&d[i] < e[0]) cc = Math.max(cc,c[i]);
            if(j>=0&&d[j] < e[0]) cc = Math.max(cc, c[j]);
            cc++;

            c[e[1]] = cc;
            count+=cc;
        }
        writer.println(count);
    }
    void solve1(int[] d){
        int[] c = new int[d.length];
        Arrays.fill(c, 1);
        for(int i = 1,h=d.length;i<h;i++)
            if(d[i] > d[i-1]) c[i] = Math.max(c[i-1] + 1,c[i]);
        for(int i = d.length - 2;i>=0;i--)
            if(d[i] > d[i+1]) c[i] = Math.max(c[i+1] + 1,c[i]);
        
        long s = 0l;
        for(int e : c) s+=e;
        writer.println(s);
    }

    void run() throws IOException {
        int n = getInt();
        int[] d = new int[n];
        for(int i = 0;i<n;i++) d[i] = getInt();
        solve1(d);
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        Candies obj = new Candies();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public Candies(){
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


