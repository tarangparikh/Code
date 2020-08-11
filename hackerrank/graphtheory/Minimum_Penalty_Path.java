import java.io.*;
import java.util.*;

public class Minimum_Penalty_Path {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    void run() throws IOException {
        int[] c = ints();
        int[][] q = new int[c[1]][];
        for(int i = 0,h=q.length;i<h;i++){
             q[i] = ints();
             q[i][0]--;
             q[i][1]--;
        }
        int[][][] g = packUW(q,c[0]);
        int[] d = new int[c[0]];
        Arrays.fill(d,Integer.MAX_VALUE);
        PriorityQueue<int[]> que = 
            new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        int[] s = ints(); 
        s[0]--;
        s[1]--;
        que.add(new int[]{s[0],0});
        
        while(!que.isEmpty()){
            int[] r = que.poll();    
            for(int[] e : g[r[0]]){
                int v = r[1] | e[1];
                if(d[e[0]] > v){
                    d[e[0]] = v;
                    que.add(new int[]{e[0],v});
                }
            }
        }
        writer.println(d[s[1]] == Integer.MAX_VALUE ? -1 : d[s[1]]);
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

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        Minimum_Penalty_Path obj = new Minimum_Penalty_Path();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public Minimum_Penalty_Path(){
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


