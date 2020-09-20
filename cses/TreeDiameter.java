import java.io.*;
import java.util.Stack;

public class TreeDiameter {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    void run() throws IOException {
        int n = i();
        int[][] q = new int[n - 1][];
        for(int i = 0,h=n-1;i<h;i++){
            q[i] = ni();
            q[i][0]--;
            q[i][1]--;
        }
        int[][] g = packU(q, n);
        int[] dp = new int[n];
        Stack<int[]> s = new Stack<>();
        s.push(new int[]{0,-1,0});
        int max_diameter = 0;
        while(!s.isEmpty()){
            int[] r = s.pop();
            if(r[2] == -1){
                int max1 = 0;
                int max2 = 0;
                for(int e : g[r[0]]){
                    if(e != r[1]){
                        if(dp[e] > max1){
                            max2 = max1;
                            max1 = dp[e];
                        }else if(dp[e] > max2){
                            max2 = dp[e];
                        }
                    }
                }
                max_diameter = Math.max(max_diameter, max1 + max2 + 1);
                dp[r[0]] = 1 + max1;
            }else{
                r[2] = -1;
                s.push(r);
                for(int e : g[r[0]]){
                    if(e != r[1]){
                        s.push(new int[]{e,r[0],0});
                    }
                }
            }
        }
        writer.println(max_diameter - 1);

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
        TreeDiameter obj = new TreeDiameter();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public TreeDiameter(){
        writer = new PrintWriter(System.out);
        bf = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
    }

    public int i() throws IOException {
        return Integer.parseInt(bf.readLine());
    }

    public long l() throws IOException {
        return Long.parseLong(bf.readLine());
    }

    public int[] ni() throws IOException {
        String[] data = bf.readLine().split(" ");
        int[] send = new int[data.length];
        for (int i = 0, h = data.length; i < h; i++) send[i] = Integer.parseInt(data[i]);
        return send;
    }

    public long[] nl() throws IOException {
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


