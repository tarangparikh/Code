import java.io.*;

public class _2160B {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    void run() throws IOException {
        int t = getInt();
        while(t-->0){
            int n = getInt();
            long[] d = longs();
            StringBuilder sb = new StringBuilder();
            sb.append(1).append(" ");
            long u = 1;
            long l = 1;
            for(int i = 1 ; i < n ; i++){
                long delta = d[i] - d[i-1];
//                System.out.println(delta);
                long next = u - delta + 1;
                if(next <= 0){
                    u++;
                    l = u;
                    sb.append(l).append(" ");
                }else{
                    l = next;
                    sb.append(l).append(" ");
                }
//                System.out.println("last : "+l+" u : "+u);
            }
            writer.println(sb.toString().trim());
        }
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        _2160B obj = new _2160B();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public _2160B(){
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


