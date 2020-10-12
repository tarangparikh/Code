import java.io.*;
import java.util.Random;

public class BinarySum {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    long mod = 1_000_000_007;

    long p(long a,long b){
        long p = 1l;
        for(;b>0;a=a*a%mod,b>>=1)
            if((b&1) == 1) p=p*a%mod;
        return p;
    }
    
    long solve(long n){
        n++;
        long s=0,f=1l;
        for(int i=0;i<64;f=f*10l%mod,i++){
            long oc = (n>>i & 1) == 1 ? (n - (n>>i<<i) + (n>>i>>1<<i))%mod : (n>>i>>1<<i)%mod;
            s = (s+((oc * f) % mod))%mod;
        }
        return s;
    }
    
    long get(long n){
        long sum = 0;
        for(long f = 1l;n>0;f=f*10%mod,n>>=1)
            if((n&1) == 1) sum = (sum + f) % mod;
        return sum;
    }
    long range(long n){
        long sum = 0;
        while(n > 0){
            sum = ( sum  + get(n)) % mod;
            n--;
        }
        return sum;
    }

    void run() throws IOException {
        Random random = new Random();
        while(true){
            int n = random.nextInt(100000);
            long a = solve(n);
            long b = range(n);
            if(a!=b){
                System.out.println(n+" Unequal");
            }else{
                System.out.println(n+" Equal");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        BinarySum obj = new BinarySum();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public BinarySum(){
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


