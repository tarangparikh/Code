import java.io.*;

public class _1409B {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    long solve(long a,long b,long x,long y,long n){
        long s = Math.min(Math.abs(a - x),n);
        a -= s;
        n -= s;
        s = Math.min(Math.abs(b - y),n);
        b -= s;
        return a*b;
    }

    void run() throws IOException {
        int t = i();
        while(t-->0){
            long[] c = nl();
            long a = c[0];
            long b = c[1];
            long x = c[2];
            long y = c[3];
            long n = c[4];

            writer.println(Math.min(solve(a,b,x,y,n),solve(b,a,y,x,n)));
        }
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        _1409B obj = new _1409B();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public _1409B(){
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


