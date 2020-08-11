import java.io.*;

public class Q3 {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    int lcs(String a,String b){
        int[][] dp = new int[a.length()+1][b.length()+1];
        for(int i = 1,h=dp.length;i<h;i++){
            for(int j = 1,v=dp[0].length;j<v;j++){
                dp[i][j] = a.charAt(i-1) == b.charAt(j-1) ? 1 + dp[i-1][j-1] : Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    void run() throws IOException {
        String[] d = bf.readLine().split(" ");
        writer.print(lcs(d[0],d[1]));
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        Q3 obj = new Q3();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public Q3(){
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


