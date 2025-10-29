import java.io.*;
import java.util.TreeSet;

public class _2160A {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    void run() throws IOException {
        int t = getInt();
        while(t-->0){
            int n = getInt();
            int[] d = ints();
            TreeSet<Integer> set = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                set.add(d[i]);
            }
            int ex = 0;
            for(int e : set){
                if(e == ex)
                    ex++;
                else{
                   break;
                }
            }
            writer.println(ex);
        }
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        _2160A obj = new _2160A();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public _2160A(){
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


