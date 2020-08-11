import java.io.*;
import java.util.Arrays;
public class GOLOMB {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    String solve(long[][] q){
        long mod = 1_000_000_007;
        int limit = 1900000;
        long[][] dp = new long[2][limit];
        dp[0][0] = 0;
        dp[1][0] = 0;
        for(int i = 1,h=dp[0].length;i<h;i++){
            int index = (int)((i)-dp[1][(int)dp[1][i-1]]);
            dp[1][i] = 1 + dp[1][index];
            dp[0][i] = ((((long)i)*((long)i))%mod*((dp[1][i]%mod))%mod + dp[0][i-1])%mod;
        }
        for(int i = 1,h=dp[0].length;i<h;i++){
            dp[1][i] += dp[1][i-1];
        }
        //System.out.println(dp[1][limit-1]);
        StringBuilder sb = new StringBuilder();
        for(long[] query : q){
            long a = getSum(dp,query[0]-1);
            long b = getSum(dp,query[1]);
            sb.append((b-a+ mod)%mod).append("\n");
        }
        return sb.toString().trim();
    }
    long getSum(long[][] dp,long length){
        int i = Arrays.binarySearch(dp[1],length);
        long mod = 1_000_000_007;
        long extra = 0;
        if(i<0){
            i = -(i+1);
            extra = dp[1][i] - length;
            extra = (extra * (((long)i)*((long)i))%mod)%mod;
        }
        return (dp[0][i] - extra + mod)%mod;
    }




    void run() throws IOException {
        int t = getInt();
        long[][] q = new long[t][2];
        int i = 0;
        while (t-->0){
            q[i++] = longs();
        }
        writer.println(solve(q));
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        GOLOMB obj = new GOLOMB();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public GOLOMB(){
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



