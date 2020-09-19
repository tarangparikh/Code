import java.io.*;
import java.util.Arrays;

public class MovieFestival {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    int bs1(int[][] d,int i,int j,int v){
        int mid = (i+j) >> 1;
        while(i < j){
            mid = (i+j)>>1;
            if(v <= d[mid][0]) j=mid;
            else i = mid+1;
        }
        mid = (i + j) >> 1;
        return d[mid][0] == v ? mid : d[mid][0] < v ? -mid - 2 : -mid - 1;
    }

    void run() throws IOException {
        int n = i();
        int[][] d = new int[n][];
        for(int i = 0;i<n;i++) d[i] = ni();
        Arrays.sort(d,(a,b) -> a[0] - b[0]);
        int[] max_till = new int[n + 1]; 
        for(int i = n-1 ;i>=0;i--){
            int index = bs1(d,i + 1,n - 1,d[i][1]);
            if(index  < 0) index = -(index + 1);
            max_till[i] = Math.max(1 + max_till[index],max_till[i+1]);
        } 
        //writer.println(Arrays.toString(dp));
        writer.println(max_till[0]);
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        MovieFestival obj = new MovieFestival();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public MovieFestival(){
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


