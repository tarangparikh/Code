import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class App {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;

    class Heap{
        int[] h;
        int n;
        Heap(){
            this.h = new int[1<<10];
            this.n = 0;
        }
        void up(int i){
            while(i > 0){
                int p = (i - 1) >> 1;
                if(h[p] >= h[i]) break;
                swap(p,i);
                i = p;
            }
        }
        void down(int i){
            while(true){
                int c = (i<<1) + 1;
                if(c >= n) break;
                if(h[i] > h[c]) c = i;
                if(c+1 < n && h[c + 1] > h[c]) c = c + 1;
                if(c == i) break;
                swap(c,i);
                i = c;
            }
        }

        void swap(int i,int j){
            int t = h[i];
            h[i] = h[j];
            h[j] = t;
        }
    }
    

    void run() throws IOException {
       double rate = 1.01;

       double degrade = 1.004;
       double current = rate / degrade;
       double prev = 1;
       double factor = 250000000;
       for(int i = 0;i<180;i++){
            writer.print(String.format("%.2f : %d ", factor * ((current - prev)/10) ,i+1));
            prev = current - (current - prev) / 10;
            writer.println("Priciple : "+prev * factor);
            current = prev * rate / degrade;
       }
        

    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        App obj = new App();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public App(){
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


