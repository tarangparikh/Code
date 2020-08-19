import java.io.*;
import java.util.Arrays;


public class _1398A {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    void run() throws IOException {
        int t = i();
        while(t-->0){
            i();
            int[] d = ni();
            int[][] data = new int[d.length][];
            for(int i = 0,h=data.length;i<h;i++)
                data[i] = new int[]{d[i],i};
            Arrays.sort(data,(a,b) -> Integer.compare(a[0],b[0]));
            if(data[0][0] + data[1][0] > data[d.length - 1][0]) sb.append("-1").append("\n");
            else sb.append((data[0][1]+1)+" "+(data[1][1]+1)+" "+(data[d.length-1][1]+1)).append("\n");
        }
        writer.println(sb.toString().trim());
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        _1398A obj = new _1398A();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public _1398A(){
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


