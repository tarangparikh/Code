import java.io.*;
import java.util.*;

public class _0_1_Graph {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    void run() throws IOException {
        int[] c = ints();
        int[][] e = new int[c[1]][];
        for(int i = 0,h=e.length;i<h;i++) {
            e[i] = ints();
            e[i][0]--;
            e[i][1]--;
        }

        int[][] g = packU(e,c[0]);
        
        int[] d = new int[c[0]];
        Arrays.fill(d,Integer.MAX_VALUE);
        d[0] = 0;
        
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b) ->  Integer.compare(a[1],b[1]));
        que.add(new int[]{0,0});
        
        while(!que.isEmpty()){
            int[] r = que.poll();
            for(int ed : g[r[0]]){
                if(r[1] + 1 < d[ed]){
                    d[ed] = r[1] + 1;
                    que.add(new int[]{ed,r[1] + 1});
                }
            }
        }
       
        long sum = 0;
        for(int i = d.length - 1 ,min = d[d.length - 1] ;i>=0 ;i--){
            sum+= min = Math.min(min,d[i]);
        }

        writer.println(sum);
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
        _0_1_Graph obj = new _0_1_Graph();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public _0_1_Graph(){
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


