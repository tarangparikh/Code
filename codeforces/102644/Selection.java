import java.io.*;

public class Selection {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    public static long mod = 1_000_000_007;

    public static long[][] mu(long[][] a, long[][] b) {
        int n = a.length;
        int m = a[0].length;
        int k = b[0].length;
        long[][] res = new long[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                for (int p = 0; p < m; p++) {
                    res[i][j] = (res[i][j] + (a[i][p] * b[p][j])%mod)%mod;
                }
            }
        }
        return res;
    }

    public static long[][] mp(long[][] a, long p) {
        if (p == 0) {
            return mu(a.length);
        } else if (p % 2 == 0) {
            return mp(mu(a, a), p / 2);
        } else {
            return mu(a, mp(a, p - 1));
        }
    }

    public static long[][] mu(int n) {
        long[][] res = new long[n][n];
        for (int i = 0; i < n; ++i) {
            res[i][i] = 1L;
        }
        return res;
    }

    public static long so(int n){
        long[][] ba = new long[][]{{0,1}};
        long[][] fa = new long[][]{{0,1},{1,1}};
        long[][] po = mp(fa,n+2);
        long[][] an = mu(ba,po);
        return (an[0][0] - 1 + mod)%mod;
    }

    void run() throws IOException {
        int t = i();
        while (t-->0){
            writer.println(so(i()));
        }
    }

    public static void main(String[] args) throws IOException {
        Selection obj = new Selection();
        obj.run();
        obj.close();
    }

    public Selection(){
        writer = new PrintWriter(System.out);
        bf = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
    }

    public int i() throws IOException {
        return Integer.parseInt(bf.readLine());
    }

    public void close() {
        writer.flush();
        writer.close();
    }
}