import java.io.*;
import java.util.Arrays;

public class _1391B {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    void run() throws IOException {
        int t = i();
        while(t-->0){
            int[] c = ni();
            char[][] m = new char[c[0]][];
            for(int i = 0,h=c[0];i<h;i++)
                m[i] = bf.readLine().trim().toCharArray();
            int co = 0;
            for(int i = 0,h=m.length,l=m[0].length - 1;i<h;i++)
                co = m[i][l] != 'C' && m[i][l] == 'R' ? co + 1 : co;
            
            for(int i = 0,h=m[0].length,l=m.length - 1;i<h;i++)
                co = m[l][i] != 'C' && m[l][i] == 'D' ? co + 1 : co;
            
            writer.println(co);

        }
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        _1391B obj = new _1391B();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public _1391B(){
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


