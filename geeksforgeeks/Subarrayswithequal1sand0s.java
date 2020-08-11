import java.io.*;
import java.util.*;

public class Subarrayswithequal1sand0s {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;

    int solve1(int[] d){
        int n = d.length;
        int[] p = new int[n+1];
        HashMap<Integer,Integer> m = new HashMap<>();
        for(int i = 1;i<n+1;i++){
            p[i]= p[i-1] + (d[i-1] == 0 ? -1 : d[i-1]);
            m.put(p[i],m.getOrDefault(p[i],0) + 1);
        }
        int c = 0;
        for(int i = 0,t = 0;i<n;i++){
            c+=m.getOrDefault(p[i],0);
            if(m.containsKey(p[i+1])){
                m.put(p[i+1],m.get(p[i+1]) - 1);
            }
        }
        return c;    
    }

    int solve(int[] d){
        int[] prefix = new int[d.length+1];
        TreeMap<Integer,Integer> hash = new TreeMap<>();
        for(int i = 1,h=prefix.length;i<h;i++){
            prefix[i] = prefix[i-1] + (d[i-1] == 0 ? -1 : d[i-1]);
            if(!hash.containsKey(prefix[i])) hash.put(prefix[i],0);
            hash.put(prefix[i],hash.get(prefix[i]) + 1);
        }
        int count = 0;
        for(int i = 0,h=prefix.length-1;i<h;i++){
            if(hash.containsKey(prefix[i])){
                count+=hash.get(prefix[i]);
            }
            if(hash.containsKey(prefix[i+1])){
                hash.put(prefix[i+1],hash.get(prefix[i+1]) - 1);
            }
        }
        return count; 
    }

    void run() throws IOException {
        getInt();
        writer.println(solve1(ints()));
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        Subarrayswithequal1sand0s obj = new Subarrayswithequal1sand0s();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public Subarrayswithequal1sand0s(){
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

    public void close() {
        writer.flush();
        writer.close();
    }
}


