import java.io.*;

public class Snakes_and_Ladders_The_Quickest_Way_Up {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;

    void run() throws IOException {
        int t = getInt();
        while(t-->0){
            int[][] l = new int[getInt()][];
            for(int i = 0,h=l.length;i<h;i++){
                l[i] = ints();
                l[i][0]--;
                l[i][1]--;
            }
            int[][] s = new int[getInt()][];
            for(int i = 0,h=s.length;i<h;i++){
                s[i] = ints();
                s[i][0]--;
                s[i][1]--;
            }
            int[] dp = new int[100];
            
            
            
            Arrays.fill(dp,-1);
            dp[99] = 0;
            for(int i = 98;i=>0;i--){
                
            }
        }
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        Snakes_and_Ladders_The_Quickest_Way_Up obj = new Snakes_and_Ladders_The_Quickest_Way_Up();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public Snakes_and_Ladders_The_Quickest_Way_Up(){
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

    public void close() throws IOException{
        writer.flush();
        writer.close();
        bf.close();
    }
}


