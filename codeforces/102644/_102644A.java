import java.io.*;

public class _102644A {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    public static double[][] matrixMul(double[][] a, double[][] b) {
        int n = a.length;
        int m = a[0].length;
        int k = b[0].length;
        double[][] res = new double[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                for (int p = 0; p < m; p++) {
                    res[i][j] = res[i][j] + a[i][p] * b[p][j];
                }
            }
        }
        return res;
    }

    public static double[][] matrixPow(double[][] a, int p) {
        if (p == 0) {
            return matrixUnit(a.length);
        } else if (p % 2 == 0) {
            return matrixPow(matrixMul(a, a), p / 2);
        } else {
            return matrixMul(a, matrixPow(a, p - 1));
        }
    }

    public static double[][] matrixUnit(int n) {
        double[][] res = new double[n][n];
        for (int i = 0; i < n; ++i) {
            res[i][i] = 1d;
        }
        return res;
    }

    void run() throws IOException {

            String[] s = bf.readLine().split(" ");
            double p = Double.parseDouble(s[1]);
            int n = Integer.parseInt(s[0]);
            double[][] base = new double[][]{{p,1-p}};
            double[][] factor = new double[][]{{1-p,p},{p,1-p}};
            double[][] power = matrixPow(factor, n-1);
            double[][] ans = matrixMul(base,power);
            System.out.print(String.format("%.10f",ans[0][1]));

    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        _102644A obj = new _102644A();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public _102644A(){
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


