import java.io.*;

public class _106096C {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    void run() throws IOException {
        int[] d = ints();
        int[][] m = new int[d[0]][d[1]];
        for(int i = 0; i < d[0] ; i++)
            m[i] = ints();
        int max = m[0][0];
        for(int i = 0;i< m.length;i++)
        {
            for(int j = 0;j < m[i].length;j++){
                int t = m[i][j];
                t += i-1 >= 0 ? m[i-1][j] : 0;
                t += j-1 >= 0 ? m[i][j-1] : 0;
                t += i+1 < d[0] ? m[i+1][j] : 0;
                t += j+1 < d[1] ? m[i][j+1] : 0;
                max = Math.max(max, t);
            }
        }
        writer.println(max);
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        _106096C obj = new _106096C();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public _106096C(){
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


