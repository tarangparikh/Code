import java.io.*;

public class BinomialCoefficients {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;

    long mod = 1_000_000_007L;

    long pow(long a,long b){
        long p = 1L;
        for(;b>0;a=a*a%mod,b>>=1)
            if((b&1) == 1) p=p*a%mod;
        return p;
    }

    long[][] fif(int n){
        long[][] fif = new long[2][n+1];
        fif[1][0] = fif[0][0] = 1;
        for(int i = 1,h=fif[0].length;i<h;i++){
            fif[0][i] = i * fif[0][i-1] % mod;
            fif[1][i] = pow(fif[0][i],mod - 2);
        }
        return fif;
    }

    void run() throws IOException {
        long[][] fif = fif(1000001);
        int t = i();
        while(t-->0){
            int[] c = ni();
            long ans = (fif[0][c[0]] * ((fif[1][c[0] - c[1]]*fif[1][c[1]])%mod))%mod;
            sb.append(ans).append("\n");
        }
        writer.println(sb.toString().trim());
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        BinomialCoefficients obj = new BinomialCoefficients();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public BinomialCoefficients(){
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


