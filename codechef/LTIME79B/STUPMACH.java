import java.io.*;
import java.util.Arrays;

class STUPMACH {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    long solve(int[] a){
        int[][] d = new int[a.length][];
        for(int i = 0,h=d.length;i<h;i++) d[i] = new int[]{a[i],i};
        Arrays.sort(d,(p,q) -> {
            if(p[0]!=q[0]) return Integer.compare(p[0],q[0]);
            else return Integer.compare(q[1],p[1]);
        });
        //System.out.println(Arrays.deepToString(d));
        int prev = d.length;
        long s = 0;
        for(int i = 0,h=d.length;i<h;i++){
            if(d[i][1] > prev) continue;
            s+= (long)d[i][0] * (long)(prev - d[i][1]);
            prev = d[i][1];        
        }
        return s;
    }
    long solve1(int[] a){
        long s = 0;
        int min = a[0];
        for(int i = 0,h=a.length;i<h;i++){
            s += min = Math.min(min,a[i]);
        }
        return s;
    }

    void run() throws IOException {
        int t = i();
        while(t-->0){
            i();
            int[] d = ni();
            sb.append(solve1(d)).append("\n");
        }
        writer.println(sb.toString().trim());
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        STUPMACH obj = new STUPMACH();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public STUPMACH(){
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

    public void close() throws IOException {
        writer.flush();
        writer.close();
        bf.close();
    }
}


