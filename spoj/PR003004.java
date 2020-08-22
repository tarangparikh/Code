import java.io.*;
import java.util.Arrays;

class Main {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    //Compute dp for number of 16th length can to till 15th
    /**
     *  1 0  1   2   3   4   5   6   7   8   9
     *  2 9  19  29  39  49  59  69  79  89  99
     *  3 99 199 299 399 499 599 699 799 899 999
     *  4
     *  5
     *  6
     *  7
     *  8
     *  .
     *  .
     *  15 99999999999999 199999999999999 .. .. .. . .. 
     * 
     * 
     */
    long[][] precompute(){
        long[][] dp = new long[16][10];
        long prev = 1;
        for(int i = 0,h=dp.length;i<h;i++){
            for(int j = 1,l=dp[0].length;j<l;j++){
                dp[i][j] = dp[i][j-1] + j*prev+dp[i][0];
            }
            if(i<h-1) dp[i+1][0] = dp[i][dp[0].length - 1];
            prev*=10;
        }
        return dp;
    }

    /**
     *  compute for a given number 
     *    
     *  
     *  
     */
    long compute(long a,long[][] dp){
        long sum = 0;
        int len = 1;
        long power = 1;
        

        int a_sum = 0;
        long temp = a;
        while(temp>0){
            a_sum += (int)(temp%10);
            temp/=10;
        }

        long a_sum_temp = a_sum;

        while(a>0){
            int r = (int)(a%10);
            a_sum -= r;
            long temp_sum = 0;
            if(r>0){
                temp_sum = a_sum*power*r + dp[len-1][r-1];
            }
            sum+=temp_sum;
            len++;
            power*=10;
            a/=10;
        }
        
        return sum + a_sum_temp;
    }

    long compute(long[] a,long[][] dp){
        if(a[0]==0) return compute(a[1],dp);
        else return compute(a[1],dp) - compute(a[0]-1,dp);
    }

    void run() throws IOException {
        int t = i();
        long[][] dp = precompute();
        while(t-->0){
            sb.append(compute(nl(),dp)).append("\n");
        }
        writer.println(sb.toString().trim());
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        Main obj = new Main();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public Main(){
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


