import java.io.*;

public class _1392B {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    /*
        1 2 3 4 5
        4 3 2 1 0
        0 1 2 3 4
    */

    void run() throws IOException {
        int t = i();
        while(t-->0){
            long[] c = nl();
            int[] d = ni();
            int min = d[0];
            int max = d[0];
            for(int e : d){
                max = Math.max(e,max);
                min = Math.min(e,min);
            }
            if((c[1]&1)==1)
                for(int i = 0,h=d.length;i<h;i++)
                    d[i] = max - d[i];
            else
                for(int i = 0,h=d.length;i<h;i++)
                    d[i] = d[i] - min;
                
        
            for(int e : d)
                sb.append(e).append(" ");
            sb.append("\n");
        }
        writer.println(sb.toString().trim());
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        _1392B obj = new _1392B();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public _1392B(){
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
