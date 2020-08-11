import java.io.*;
import java.util.*;

public class Dijkstra_Shortest_Reach_2 {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    String solve(int[][] q,int[] c,long s){
        int[][][] g = packUW(q,c[0]);
            long[] d = new long[c[0]];
            Arrays.fill(d,Long.MAX_VALUE);
            PriorityQueue<long[]> que = new PriorityQueue<>((a,b) -> Long.compare(a[1],b[1]));
            que.add(new long[]{s,0});
            d[(int)s] = 0;
            while(!que.isEmpty()){
                long[] r = que.poll();
                for(int[] e : g[(int)r[0]]){
                    if(r[1] + (long)e[1] < d[e[0]]){
                        d[e[0]] = r[1] + (long)e[1];
                        que.add(new long[]{(long)e[0],d[e[0]]});
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for(long e : d){
                if(e!=0){
                    if(e==Long.MAX_VALUE) sb.append("-1").append(" ");
                    else sb.append(e).append(" ");
                }
            }
            return sb.toString();
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
            long s = getLong() - 1;
            sb.append(solve(q,c,s));
            sb.append("\n");
            
        }
        
        writer.println(sb.toString().trim());
        
    }



    int[][][] packUW(int[][] e,int n){
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
        Dijkstra_Shortest_Reach_2 obj = new Dijkstra_Shortest_Reach_2();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public Dijkstra_Shortest_Reach_2(){
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


