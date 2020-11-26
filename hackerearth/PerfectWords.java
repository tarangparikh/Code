import java.io.*;
import java.util.concurrent.ThreadLocalRandom;


public class PerfectWords {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;
    
    long mod = 1_000_000_007;
    
    long power(long a,long b){
    	long p = 1l;
    	for(;b>0;a=a*a%mod,b>>=1)
    		if((b&1) == 1) p=p*a%mod;
    	return p;
    }
    
    int solve(long n){
    long a = power(26,n);
    long b = power(21,n);
	long c = power(5,n);
	long ans = (a - b + mod) % mod;
	ans = (ans - c + mod) % mod;
	return (int)ans;
    }

    void run() throws IOException {
      	int t = i();
      	while(t-->0){
      		long ans = solve(l());
      		writer.println(ans);
        }
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        PerfectWords obj = new PerfectWords();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public PerfectWords(){
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


