import java.io.*;
import java.util.Arrays;

public class Arrange_Students {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    boolean check(int[] a,int[] b){
        for(int i = 1,h=a.length;i<h;i++){
                if(!(a[i] >= b[i-1] && a[i] <= b[i])){
                    return false;
                   
                }
        }
        return true;
    }

    void run() throws IOException {
        int t = getInt();
        while(t-->0){
            getInt();
            int[] a = ints();
            int[] b = ints();

            Arrays.sort(a);
            Arrays.sort(b);

            boolean f = a[0] > b[0] ? 
            check(b,a) : a[0] < b[0] ? 
            check(a,b) : check(a,b) | check(b,a);

            sb.append(f ? "YES" : "NO").append("\n");

        }
        writer.println(sb.toString().trim());
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        Arrange_Students obj = new Arrange_Students();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public Arrange_Students(){
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

    public void close() throws IOException{
        writer.flush();
        writer.close();
        bf.close();
    }
}


