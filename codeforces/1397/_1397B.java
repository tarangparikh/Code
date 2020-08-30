import java.io.*;
import java.util.Arrays;


public class _1397B {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    static long mod = (1L<<61) - 1;

    long pow(long a,long b){
        long p = 1L;
        for(;b>0;a=a*a%mod,b>>=1)
            if((b&1) == 1) p=p*a%mod;
        return p;
    }

    long sum(int[] d,int min){
        long sum = 0;
        int i = 0;
        for(int e : d){
            long aa  = pow(min,i);
            //writer.println(aa+" "+i);
            long bb = e;
            sum += Math.abs(aa - bb);
            i++;
        }
        return sum;
    }

    void run() throws IOException {
        int n = i(); int[] d = ni();
        Arrays.sort(d);
        int a = (int)Math.ceil(Math.pow(d[d.length - 1],(1d/((double)n-1))));
        int b = a-1;
        writer.println(Math.min(sum(d,a),sum(d,b)));
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        _1397B obj = new _1397B();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public _1397B(){
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


