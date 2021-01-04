import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class ConnectedWays {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;

    public class DJSet {
        public int[] upper;
    
        public DJSet(int n) {
            upper = new int[n];
            Arrays.fill(upper, -1);
        }
    
        public int root(int x) {
            return upper[x] < 0 ? x : (upper[x] = root(upper[x]));
        }
    
        public boolean equiv(int x, int y) {
            return root(x) == root(y);
        }
    
        public boolean union(int x, int y) {
            x = root(x);
            y = root(y);
            if (x != y) {
                if (upper[y] < upper[x]) {
                    int d = x;
                    x = y;
                    y = d;
                }
                upper[x] += upper[y];
                upper[y] = x;
            }
            return x == y;
        }
    
        public int count() {
            int ct = 0;
            for (int u : upper)
                if (u < 0)
                    ct++;
            return ct;
        }
    }
    

    void run() throws IOException {
        int t = i();
        while(t-->0){
            int n = i();
            int[][] d = new int[n][];
            for(int i = 0;i<n;i++) d[i] = ni();
            int[] dp = new int[n];
            
            DJSet set = new DJSet(n);
            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++){
                    int md = Math.abs(d[i][0] - d[j][0]) + Math.abs(d[i][1] - d[j][1]);
                    if(md == 1){ set.union(i, j); }
                }
            }           
        }
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        ConnectedWays obj = new ConnectedWays();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public ConnectedWays(){
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