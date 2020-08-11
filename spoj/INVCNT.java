import java.io.*;
import java.util.*;

class Main {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    int query(int[] bit,int i){
        int s = 0; for(++i;i>0;s+=bit[i],i-=i&-i); return s;
    }
    void update(int[] bit,int i,int v){
        int n = bit.length; for(++i;i<n;bit[i]+=v,i+=i&-i);
    }

    void run() throws IOException {
        int t = i();
        int[] bit = new int[10000005];
        int limit = 10000000;
        while(t-->0){
            bf.readLine();
            int n = i();
            int[] d = new int[n];
            for(int i = 0,h=d.length;i<h;i++) d[i] = i();
            Arrays.fill(bit,0);
            long sum = 0;
            for(int i = 0;i<d.length;i++){
                if(d[i]>0){
                    sum += query(bit,limit) - query(bit,d[i] - 1);
                }
                update(bit,d[i],1);
            }
            writer.println(sum);
        }
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        Main obj = new Main();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public Main(){
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


