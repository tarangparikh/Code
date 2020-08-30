import java.io.*;

public class Xoring_Ninja {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    long mod = 1_000_000_007;

    long pow(long a,long b){
        long p = 1L;
        for(;b>0;a=a*a%mod,b>>=1)
            if((b&1) == 1) p=p*a%mod;
        return p;
    }

    long solve(int[] d){
        long n = pow(2,d.length - 1);
        long p = 1l;
        long or = 0;
        long sum = 0;
        for(int e : d) or|=e;
        while(or > 0){
            if((or & 1) == 1) sum = (sum + (p * n)%mod)%mod;
            or>>=1;
            p<<=1;
            p%=mod;
        }
        return sum;
    }

    long solve1(int[] d){
        long or = 0; for(int e : d) or|=e;
        return or * pow(2,d.length - 1) % mod;
    }

    void run() throws IOException {
        int t = i();
        while(t-->0){
            i(); int[] d = ni();
            writer.println(solve1(d)); 
        }
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        Xoring_Ninja obj = new Xoring_Ninja();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public Xoring_Ninja(){
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


