import java.util.Stack;

public class Graph{
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
    static int[][][] packUW(int[][] e,int n){
        int[] q = new int[n];
        int[][][] g = new int[n][][];
        for(int[] ed : e){
            q[ed[0]]++;
            q[ed[1]]++;
        }
        for(int i = 0;i<n;i++){
            g[i] = new int[q[i]][2];
        }
        for(int[] ed: e){
            g[ed[0]][--q[ed[0]]][0] = ed[1];
            g[ed[0]][q[ed[0]]][1] = ed[2];
            g[ed[1]][--q[ed[1]]][0] = ed[0];
            g[ed[1]][q[ed[1]]][1] = ed[2];
        }
        return g;
    }
    
    //Number of components and array stating component number of each node
    static int[][] comp1(int[][] g){
        int[] dp = new int[g.length];
        int[] s = new int[g.length];
        int color = -1;
        for(int i = 0,t,h=dp.length;i<h;i++){
            if(dp[i]==-1){
                ++color;
                t=-1;
                s[++t] = i;
                while(t!=-1){
                    int r = s[t--];
                    dp[r] = color;
                    for(int e : g[r]){
                        if(dp[e]!=-1)
                            s[++t] = e;
                    }
                }
            }
        }
        return new int[][]{{++color},dp};
    }
    
}