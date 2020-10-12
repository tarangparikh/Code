import java.io.*;

public class GameOfA {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;

    void run() throws IOException {
        int[] dp = new int[1000001];
        for(int i = 1;i<dp.length;i++){
            int min = Integer.MAX_VALUE;
            for(int j = 2;j*j<=i;j++)
                if((i % j) == 0)
                    min = Math.min(min, 1 + dp[Math.max(i / j, j)]);
            dp[i] = min = Math.min(min, 1 + dp[i - 1]);
        }
        int t = i();
        while(t-->0){
            writer.println(dp[i()]);
        }
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        GameOfA obj = new GameOfA();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public GameOfA(){
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


