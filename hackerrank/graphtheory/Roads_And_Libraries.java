import java.io.*;
import java.util.*;

public class Roads_And_Libraries {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    
    long solve(int[][] q,int[] c){
        int[][] g = packU(q,c[0]);
        int[][] comp = comp1(g);

        long cost = 0;
        for(int e : comp[1]){
            long a = (long)c[2] + (long)(e-1)*(long)(c[3]);
            long b = (long)c[2] * (long)e;
            cost += Math.min(a,b);
        }
        return cost;
    }

    void run() throws IOException {
        int t = getInt();
        while(t-->0){
            int[] c = ints();
            int[][] q = new int[c[1]][];
            for(int i = 0,h=q.length;i<h;i++){
                q[i] = ints();
                q[i][0]--;
                q[i][1]--;
            }
            writer.println(solve(q,c));
        }

    }

    static int[][] comp1(int[][] g){
        int[] dp = new int[g.length];
        Arrays.fill(dp,-1);
        int[] s = new int[g.length];
        int color = -1;
        for(int i = 0,t,h=dp.length;i<h;i++){
            if(dp[i]==-1){
                ++color;
                t=-1;
                s[++t] = i;
                dp[i] = color;
                while(t!=-1){
                    for(int e : g[s[t--]]){
                        if(dp[e]==-1){
                            //Color it here itself to avoid pushing again.
                            dp[e] = color;
                            s[++t] = e;
                        }
                    }
                }
            }
        }
        
        int[] comp_count = new int[++color];
        for(int e : dp) comp_count[e]++;

        return new int[][]{dp,comp_count};
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
        Roads_And_Libraries obj = new Roads_And_Libraries();
        obj.run();
        obj.close();
    }

    public Roads_And_Libraries(){
        writer = new PrintWriter(System.out);
        bf = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
    }

    public int getInt() throws IOException {
        return Integer.parseInt(bf.readLine());
    }

    public int[] ints() throws IOException {
        String[] data = bf.readLine().split(" ");
        int[] send = new int[data.length];
        for (int i = 0, h = data.length; i < h; i++) send[i] = Integer.parseInt(data[i]);
        return send;
    }

    public void close() throws IOException{
        writer.flush();
        writer.close();
        bf.close();
    }
}