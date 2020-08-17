import java.io.*;
import java.util.Arrays;
import java.util.BitSet;
import java.util.TreeMap;
public class App {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;

    /*
        BIT ->>>>>> O(log N) [0,ith] sum/XOR/MAX/MIN/
                    O(log N) [ith]     index update


    */


    int query(int[] bit,int i){
        int sum = 0;
        for(++i ; i>0 ; i-=i&-i ){
            sum^=bit[i];
        }
        return sum;
    }

    void update(int[] bit,int i,int v){
        int n = bit.length;
        for(++i ; i<n ; i+=i&-i){
            bit[i] ^= v;
        }
    }

    int pisano(int n){
        int a = 0;
        int b = 1;
        int p = 2;
        int m = n;
        while(true){
            int t = (a + b)%m;
            a = b;
            b = t;
            if(a==0&&b==1) break;
            p++;
        }
        return p-1;
    }
    TreeMap<Long,Long> dp;
    long f(long n,long mod){
        if(dp.containsKey(n)) return dp.get(n);
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 1;
        if(n==3) return 2;
        long a = n>>1;
        long b = (n&1) == 1 ? a+1:a;
        dp.put(n,((f(a-1,mod)*f(b,mod))%mod + (f(a,mod)*f(b+1,mod))%mod)%mod);
        return dp.get(n);
    }
    void run() throws IOException {
        dp = new TreeMap<>();
        long mod = 1_000_000_007;
        writer.println(f(1L<<60,mod));
        //System.out.println(dp);

    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        App obj = new App();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public App(){
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


