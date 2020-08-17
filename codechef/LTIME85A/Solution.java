import java.io.*;
import java.util.*;

class Solution {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    void solve(String[] d,int[] p,int[] w){
        System.out.println(Arrays.toString(d));

        HashMap<Integer,HashMap<Integer,HashSet<String>>> map = new HashMap<>();
        for(int i = 0,h=d.length;i<h;i++){
            if(!map.containsKey(p[i])){
                map.put(p[i],new HashMap<>());
            }
            HashMap<Integer,>map.get(p[i]);
        }
    }

    void run() throws IOException {
        int t = i();
        String[] d = new String[t];
        for(int i = 0,h=d.length;i<h;i++) d[i] = bf.readLine().trim();
        t = i();
        int[] p = new int[t];
        for(int i = 0;i<t;i++) p[i] = i();
        t = i();
        int[] w = new int[t];
        for(int i = 0;i<t;i++) w[i] = i();
        solve(d,p,w);

    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        Solution obj = new Solution();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public Solution(){
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

    public void close() {
        writer.flush();
        writer.close();
    }
}


