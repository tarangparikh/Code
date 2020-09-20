import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class CountingRooms {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    void idfs(char[][] d,int[][] dp,int start,int end,int c){
        Stack<int[]> s = new Stack<>();
        s.push(new int[]{start,end});
        while(!s.isEmpty()){
            int[] r = s.pop();
            int i = r[0];
            int j = r[1];
            if( i < 0 || j < 0 || i >= d.length || j >= d[0].length || d[i][j] == '#' || dp[i][j] != 0) continue;
            dp[i][j] = c;
            s.push(new int[]{i + 1 ,j});
            s.push(new int[]{i - 1 ,j});
            s.push(new int[]{i , j + 1});
            s.push(new int[]{i , j - 1});
        }
    }

    void run() throws IOException {
        int[] c = ni();
        char[][] d = new char[c[0]][];
        for(int i = 0;i<c[0];i++) d[i] = bf.readLine().trim().toCharArray();
        int[][] dp = new int[d.length][d[0].length];

        int cc = 0;
        for(int i = 0,h=dp.length;i<h;i++){
            for(int j = 0,l=dp[0].length;j<l;j++){
                if(d[i][j] == '.' && dp[i][j] == 0) idfs(d,dp,i,j,++cc);
            }
        }
        
        writer.println(cc);
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        CountingRooms obj = new CountingRooms();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public CountingRooms(){
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


