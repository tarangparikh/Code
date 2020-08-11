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
}