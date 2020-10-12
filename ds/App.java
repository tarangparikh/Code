import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Stack;
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
    
    void merge(int[] data,int a,int b,int c){
        int[] temp = new int[c - a + 1];
        int i = a;
        int j = b;
        int k = 0;
        while(i < b && j <= c)  temp[k++] = data[i] < data[j] ? data[i++] : data[j++];
        while(i < b) temp[k++] = data[i++];
        while(j <= c) temp[k++] = data[j++];
        while(k-->0) data[a + k] = temp[k];
    }
    void sort(int[] data,int i,int j){
        if(j - i + 1 <= 1) return;
        int mid = (i + j) >> 1;
        System.out.println(i+" "+j);
        sort(data,i,mid);
        sort(data,mid+1,j);
        merge(data, i, mid + 1, j);

    }
    void sort(int[] data){
        int i = 0;
        int j = data.length;
        Stack<int[]> s = new Stack<>();
        
    }

    
    void run() throws IOException {
       int[] data = new int[]{9,8,7,6};
       System.out.println(Arrays.toString(data));
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


