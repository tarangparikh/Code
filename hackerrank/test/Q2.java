import java.io.*;

public class Q2 {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    int solve(int[] d){
        int min = d[0];
        int max = Integer.MIN_VALUE;
        for(int i = 1,h=d.length;i<h;i++){
            max = Math.max(d[i] - min,max);
            min = Math.min(d[i],min);
        }
        return max;
    }

    void run() throws IOException {
        int t = getInt();
        int[] d = new int[t];
        for(int i = 0;i<t;i++) d[i] = getInt();
        writer.println(solve(d));
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        Q2 obj = new Q2();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public Q2(){
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


