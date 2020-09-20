import java.io.*;
import java.util.Arrays;

public class ArrayDivision {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    
    /**
     * 1 2 3 1 8
     * 
     * 
     * @throws IOException
     */

    int count(int[] d,long m){
        long sum = 0;
        int count = 0;
        for(int e : d){
            if(sum + e > m){
                count++;
                sum = 0;
            }
            sum+=e;
        }
        return count + 1;
    }



    void run() throws IOException {
        int[] c = ni();
        
        int x = c[1];
        int[] d = ni();
        long l = d[0];  
        long r = 0;
        for(int e : d){
            r+=e;
            l=Math.max(e,l);
        }

        while(l < r){
            long mid = (l + r) >> 1;
            int count = count(d,mid);
            
            if( x >= count) r = mid;
            else l = mid + 1;
        }

        writer.println(l);
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        ArrayDivision obj = new ArrayDivision();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public ArrayDivision(){
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


