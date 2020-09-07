import java.io.*;

public class GridPaths {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    void run() throws IOException {
        int n = i();
        long mod = 1_000_000_007;
        char[][] d = new char[n][];
        for(int i = 0;i<n;i++) d[i] = bf.readLine().trim().toCharArray();
        long[][] dp = new long[n + 1][n + 1];
        dp[n-1][n-1] = d[n-1][n-1] == '*' ? 0 : 1;
        for(int i = n-1;i>=0;i--){
            for(int j = n-1;j>=0;j--){
                dp[i][j] = d[i][j] == '*' ? 0 : (dp[i][j] + dp[i+1][j] + dp[i][j+1])%mod; 
            }
        }
        writer.println(dp[0][0]);    
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        GridPaths obj = new GridPaths();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public GridPaths(){
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


