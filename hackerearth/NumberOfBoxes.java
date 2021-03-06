import java.io.*;
import java.util.Arrays;

public class NumberOfBoxes {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    public static long mod = 1_000_000_007;

    public static long[][] matrixUnit(int n) {
        long[][] res = new long[n][n];
        for (int i = 0; i < n; ++i) {
            res[i][i] = 1l;
        }
        return res;
    }

    public static long[][] matrixMul(long[][] a, long[][] b) {
        int n = a.length;
        int m = a[0].length;
        int k = b[0].length;
        long[][] res = new long[n][k];
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < k; j++) 
                for (int p = 0; p < m; p++) 
                    res[i][j] = (res[i][j] + (((a[i][p] * b[p][j] + mod)%mod)+mod)%mod)%mod;
        return res;
    }

    public static long[][] matrixPow(long[][] a, long p) {
        if (p == 0) 
            return matrixUnit(a.length);
         else if (p % 2 == 0) 
            return matrixPow(matrixMul(a, a), p / 2);
         else 
            return matrixMul(a, matrixPow(a, p - 1));
    }

    public static long compute(long n){
        long[][] base = new long[][]{{1,2,9}};
        long[][] fact = new long[][]{{0,0,-1},{1,0,3},{0,1,3}};
        long p = Math.max(n-3,0);
        long[][] matt =  matrixPow(fact, p);
        for(long[] e : matt){
            System.out.println(Arrays.toString(e));
        }
        long[][] mul = matrixMul(base, matrixPow(fact, p));
        for(long[] e : mul){
            System.out.println(Arrays.toString(e));
        }
        return n == 1l ? mul[0][0] : n == 2l ? mul[0][1] : mul[0][2];
    }

    public static long manual(long n){
        long a = 1,b=2,c=9;
        for(long i = 0,h=Math.max(n-3, 0);i<h;i++){
            long cc = 3*c%mod;
            long bb = 3*b%mod;
            long aa = (((cc + bb - a + mod)%mod)+mod)%mod;
            a = b;
            b = c;
            c = aa;
        }
        return n == 1 ? a : n == 2 ? b : c;
    }

    void run() throws IOException {
        long n = 18;
        //for(int i = 1;i<=n;i++){
            System.out.println(n+" "+manual(n));
        //}
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        NumberOfBoxes obj = new NumberOfBoxes();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public NumberOfBoxes(){
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


