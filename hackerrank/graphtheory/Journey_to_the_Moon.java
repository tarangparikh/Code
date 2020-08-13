import java.io.*;
import java.util.*;

public class Journey_to_the_Moon {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    void run() throws IOException {
        int[] c = ints();
        int[][] q = new int[c[1]][];
        for(int i = 0,h=q.length;i<h;i++){
            q[i] = ints();
            // q[i][0]--;
            // q[i][1]--;
        }
        int[][] g = packU(q,c[0]);
        int[] dp = new int[c[0]];
        Arrays.fill(dp,-1);
        for(int i = 0,color=-1,h=dp.length;i<h;i++) 
            if(dp[i]==-1) 
                idfs(g,i,dp,++color);
        
        int[] hash = new int[100005];
        for(int e : dp) hash[e]++;

        //System.out.println(Arrays.toString(dp));

        long sum = 0;
        long left = c[0];
        for(int e : hash){
            if(e>0){
                sum += ((long)e*(left -= e)); 
            }
        }
        writer.println(sum);

    }

    void idfs(int[][] g,int c,int[] dp,int color){
        Stack<Integer> s = new Stack<>();
        s.push(c);
        dp[c] = color;
        while(!s.isEmpty()){
            int r = s.pop();
            for(int e : g[r]){
                if(dp[e]==-1){
                    dp[e] = color;
                    s.push(e);
                }
            }
            
        }
    }

    static int[][] packU(int[][] e,int n){
        int[] q = new int[n];
        int[][] g = new int[n][];
        for(int[] ed : e) {
            q[ed[0]]++;
            q[ed[1]]++;
        }
        for(int i = 0;i<n;i++)
            g[i] = new int[q[i]];
        for(int[] ed : e){
            g[ed[0]][--q[ed[0]]] = ed[1];
            g[ed[1]][--q[ed[1]]] = ed[0];
        }
        return g;
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        Journey_to_the_Moon obj = new Journey_to_the_Moon();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public Journey_to_the_Moon(){
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


