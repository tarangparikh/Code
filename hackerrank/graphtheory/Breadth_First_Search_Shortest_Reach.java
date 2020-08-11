import java.io.*;
import java.util.*;

public class Breadth_First_Search_Shortest_Reach {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

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
            int[][] g = packU(q,c[0]);
            int s = getInt() - 1;
            int[] d = new int[c[0]];
            Arrays.fill(d,Integer.MAX_VALUE);
            PriorityQueue<int[]> que = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
            que.add(new int[]{s,0});
            d[s] = 0;
            while(!que.isEmpty()){
                int[] r = que.poll();
                for(int e : g[r[0]]){
                    if(r[1]+1 < d[e]){
                        d[e] = r[1] + 1;
                        que.add(new int[]{e,r[1]+1});
                    }
                }
            }
            for(int i = 0,h=d.length;i<h;i++){
                if(d[i] == Integer.MAX_VALUE) d[i] = -1;
                else d[i] *= 6;
            }
            StringBuilder sb = new StringBuilder();
            for(int e : d){
                if(e!=0) sb.append(e).append(" ");
            }
            writer.println(sb.toString().trim());
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
        Breadth_First_Search_Shortest_Reach obj = new Breadth_First_Search_Shortest_Reach();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public Breadth_First_Search_Shortest_Reach(){
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


