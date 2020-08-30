import java.io.*;
import java.util.Arrays;

public class _2_s_complement {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;

    long[] dp = precompute();

    long[] precompute(){
        long[] dp = new long[33];
        long pow = 1L;
        for(int i = 1,h=dp.length;i<h;pow<<=1,i++){
            dp[i]  = dp[i-1]<<1;
            dp[i] += pow;
        }
        return dp;
    }

    long compute(long a){
        if(a<0) return compute((1L<<32) - 1) - compute((1L<<32) - (-a)) ;
        long len = 0;
        long temp = a;
        for(;temp>0;temp>>=1) 
            if((temp & 1) == 1) len++;
        long count = len;

        long pow = 1L<<32;
        for(int i = 0;a>0;a>>=1,i++){
            if((a & 1) == 1){
                count += (pow * len) + dp[i];
                len--;
            }
            pow>>=1;
        }
        return count;
    }


    

    

    void run() throws IOException {
        writer.println(compute(7));
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        _2_s_complement obj = new _2_s_complement();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public _2_s_complement(){
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


