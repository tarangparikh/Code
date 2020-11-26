import java.io.*;

class GCDOPS {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    void run() throws IOException {
        int t = i();
        while(t-->0){
            int n = i(); int[] d = ni();
            boolean f = true;
            int i = 1; while(i<=n && (f = i % d[i++-1] == 0));
            writer.println(f ? "YES" : "NO");
        }
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        GCDOPS obj = new GCDOPS();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public GCDOPS(){
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

    public void close() throws IOException {
        writer.flush();
        writer.close();
        bf.close();
    }
}


