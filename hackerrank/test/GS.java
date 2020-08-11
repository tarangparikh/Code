import java.io.*;
import java.util.Arrays;
import java.util.List;

public class GS {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    int[] convert(List<Integer> l){
        return l.stream().mapToInt(v->v).toArray();
    }

    int solve(List<Integer> data){
        return solve(convert(data));
    }

    int solve(int[] d){
        int[] p = new int[d.length+1];
        for(int i = 1,h=p.length;i<h;i++){
            p[i] = p[i-1] + (d[i-1] == 0 ? -1 : d[i-1]);
        }
        //System.out.println(Arrays.toString(p));
        if(p[p.length - 1] < 0) return 0;
        for(int i = 1,l = p[p.length - 1],h=p.length;i<h;i++){
            int a = p[i] - 0;
            int b = l - p[i];
            if(a>b) return i;
        }
        return -1;
    }

    void run() throws IOException {
        int[] d = ints();
        System.out.println(solve(d));
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        GS obj = new GS();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public GS(){
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


