import java.io.*;

public class SubarrayDivisibility {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    int mod(int n,int m){
        if(n > 0) return n%m;
        int f = -n % m == 0 ? -n / m  : -n / m + 1;
        f*=m;
        return f+=n;
    }

    void run() throws IOException {
        int n = i(); int[] d = ni();
        int[] hash = new int[n];
        hash[0] = 1;
        int p = 0;
        long c = 0l;
        for(int e : d){
            p = mod(p + e,n);
            c += hash[p];
            hash[p]++;
        }
        writer.println(c);
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        SubarrayDivisibility obj = new SubarrayDivisibility();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public SubarrayDivisibility(){
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


