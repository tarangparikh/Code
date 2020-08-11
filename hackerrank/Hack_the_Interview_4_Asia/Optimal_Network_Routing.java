import java.io.*;
import java.util.*;

public class Optimal_Network_Routing {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    void run() throws Exception {
        int[] c = ni();
        int[][] m = new int[c[0]][];
        for(int i = 0 , h = m.length ;i < h; i++) m[i] = ni();

        int[][] dp = new int[c[0]][c[1]];
        for(int[] e : dp) Arrays.fill(e,Integer.MAX_VALUE);
        dp[0][0] = 0;

        PriorityQueue<int[]> que = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));
        que.add(new int[]{0,0,0});
        while(!que.isEmpty()){
            int[] r = que.poll();
            int x = r[0];
            int y = r[1];

            if(x-1 >= 0){
                int v = Math.max(r[2],Math.abs(m[x][y] - m[x-1][y]));
                if(v < dp[x-1][y]) {
                    dp[x-1][y] = v;
                    que.add(new int[]{x-1,y,v});
                }
            }

            if(x+1 < m.length){
                int v = Math.max(r[2],Math.abs(m[x][y] - m[x+1][y]));
                if(v < dp[x+1][y]) {
                    dp[x+1][y] = v;
                    que.add(new int[]{x+1,y,v});
                }
            } 

            if(y-1 >= 0 ){
                int v = Math.max(r[2],Math.abs(m[x][y] - m[x][y-1]));
                if(v < dp[x][y-1]) {
                    dp[x][y-1] = v;
                    que.add(new int[]{x,y-1,v});
                }
            }

            if(y+1 < m[0].length){
                int v = Math.max(r[2],Math.abs(m[x][y] - m[x][y+1]));
                if(v < dp[x][y+1]) {
                    dp[x][y+1] = v;
                    que.add(new int[]{x,y+1,v});
                }
            }
        }

        writer.println(dp[dp.length - 1][dp[0].length - 1]);
        
    }

    public static void main(String[] args) throws Exception {
        long start_time = System.currentTimeMillis();
        Optimal_Network_Routing obj = new Optimal_Network_Routing();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public Optimal_Network_Routing(){
        writer = new PrintWriter(System.out);
        bf = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
    }

    public int i() throws Exception{
        return Integer.parseInt(bf.readLine().trim());
    }
    public int[] ni() throws Exception{
        String[] d = bf.readLine().trim().split(" ");
        int[] s = new int[d.length];
        for(int i = 0,h=s.length;i<h;i++)
            s[i] = Integer.parseInt(d[i].trim());
        return s;
    }
    public void close() throws Exception {
        writer.flush();
        writer.close();
        bf.close();
    }
}


