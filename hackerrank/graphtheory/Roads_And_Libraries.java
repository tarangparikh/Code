import java.io.*;
import java.util.*;

public class Roads_And_Libraries {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    
    long solve(int[][] q,int[] c){
        int[] dp = new int[c[0]];
        int[][] g = packU(q,c[0]);
        Arrays.fill(dp,-1);
        int color = -1;
        
        for(int i = 0,h=dp.length;i<h;i++) 
            if(dp[i] == -1) idfs(g,i,dp,++color);
        
        int[] hash = new int[++color];
        
        for(int e : dp) hash[e]++;
        
        long cost = 0;
        for(int e : hash){
            long a = (long)c[2] + (long)(e-1)*(long)(c[3]);
            long b = (long)c[2] * (long)e;
            cost += Math.min(a,b);
        }
        return cost;
    }

    void dfs(int[][] g,int c,int[] dp,int color){
        if(dp[c]!=-1) return;
        dp[c] = color;
        for(int e : g[c]){
            dfs(g,e,dp,color);
        }
    }

    void idfs(int[][] g,int c,int[] dp,int color){
        Stack<Integer> s = new Stack<>();
        s.push(c);
        while(!s.isEmpty()){
            int r = s.pop();
            dp[r] = color;
            for(int e : g[r])
                if(dp[e]==-1)
                    s.push(e);
            }
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

    static int[][] packU(int[][] e,int n){
       
       
















































       +++++
       +++++++++++
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