import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Cloudy_Day {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    long solve(int[] p,int[] x,int[] y,int[] r){
        int[][] data = new int[p.length][2];
        for(int i = 0,h=p.length;i<h;i++){
            data[i] = new int[]{p[i],x[i]};
        }
        Arrays.sort(data, Comparator.comparingInt(o -> o[1]));
        for(int i = 0,h=data.length;i<h;i++){
            p[i] = data[i][0];
            x[i] = data[i][1];
        }
        int[] dp = new int[x.length+1];

        //valid ranges
        ArrayList<int[]> validRanges= new ArrayList<>();
        for(int i = 0,h=y.length;i<h;i++){
            int x1 = Arrays.binarySearch(x, y[i] - r[i]);
            if(x1<0) x1 = -(x1+1);
            if(x1>=x.length) continue;
            int y1 = Arrays.binarySearch(x,y[i] + r[i]);
            if(y1<0) y1 = -(y1+1)-1;
            validRanges.add(new int[]{x1,y1});
        }
        int[][] ranges = validRanges.toArray(new int[0][]);

        //prepare difference Array
        for(int[] validRange : ranges){
            dp[validRange[0]]++;
            dp[validRange[1]+1]--;
        }

        //prefix of difference Array
        for(int i = 1,h=dp.length;i<h;i++) dp[i] += dp[i - 1];

        //prefix sum of 1 cloud cities and sum of all zero cloud cities
        long[] prefix = new long[x.length+1];
        long zeroCloud = 0;
        for(int i = 1,h=prefix.length;i<h;i++){
            if(dp[i-1]==0) zeroCloud+=p[i-1];
            if(dp[i-1]==1){
                prefix[i] = p[i-1] + prefix[i-1];
            }else{
                prefix[i] = prefix[i-1];
            }
        }

        long max = zeroCloud;
        for(int[] validRange : ranges){
            max = Math.max(max,prefix[validRange[1]+1] - prefix[validRange[0]] + zeroCloud);
        }
        return max;
    }

    void run() throws IOException {
        int n = getInt();
        int[] p = ints();
        int[] x = ints();
        int c = getInt();
        int[] y = ints();
        int[] r = ints();
        writer.print(solve(p,x,y,r));
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        Cloudy_Day obj = new Cloudy_Day();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public Cloudy_Day(){
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


