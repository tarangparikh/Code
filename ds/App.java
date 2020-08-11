import java.io.*;
import java.util.Arrays;
import java.util.BitSet;
public class App {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;

    /*
        BIT ->>>>>> O(log N) [0,ith] sum/XOR/MAX/MIN/
                    O(log N) [ith]     index update


    */


    int query(int[] bit,int i){
        int sum = 0;
        for(++i ; i>0 ; i-=i&-i ){
            sum^=bit[i];
        }
        return sum;
    }

    void update(int[] bit,int i,int v){
        int n = bit.length;
        for(++i ; i<n ; i+=i&-i){
            bit[i] ^= v;
        }
    }

    void run() throws IOException {
        int[] bit = new int[11];
        /**
         *   {1,2,3,4,5}
         */
        for(int i = 1;i<=5;i++){
            update(bit,i-1,i);
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


