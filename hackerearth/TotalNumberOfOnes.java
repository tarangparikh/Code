import java.io.*;
import java.util.*;
import java.lang.*;

public class TotalNumberOfOnes {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    long l,r;

    int dfs(long n,long a,long b){
        if( r < a || l > b ) return 0;
        if(n == 1) return 1;
        if(n == 0) return 0;
        long gap = Long.highestOneBit(n) - 1;
        return dfs(n>>1,a,a + gap - 1) + dfs(n%2 ,a+gap , a+gap) + dfs(n>>1,a+gap+1,b);

    }

    void run() throws IOException {
        long[] c = nl();
        l = c[1] - 1;
        r = c[2] - 1;
        long limit = (Long.highestOneBit(c[0])<<1) - 1;
        long ans = dfs(c[0],0,limit);
        writer.println(ans);
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        TotalNumberOfOnes obj = new TotalNumberOfOnes();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public TotalNumberOfOnes(){
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


